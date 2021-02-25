import speech_recognition as sr # recognise speech
import playsound # to play an audio file
from gtts import gTTS # google text to speech
import random
from time import ctime # get time details
#import webbrowser # open browser
#import yfinance as yf # to fetch financial data
#import ssl
#import certifi
import time
import os # to remove created audio files

class person:
    name = ''
    def setName(self, name):
        self.name = name

def there_exists(terms):
    for term in terms:
        if term in voice_data:
            return True

r = sr.Recognizer() # initialise a recogniser
# listen for audio and convert it to text:
def record_audio(ask=False):
    with sr.Microphone() as source: # microphone as source
        sr.SAMPLE_RATE = 48000
        if ask:
            pari_speak(ask)

        voice_data = ''    
        try:
            audio = r.listen(source)  # listen for the audio via source
            
            voice_data = r.recognize_google(audio)  # convert audio to text
        except sr.UnknownValueError: # error: recognizer does not understand
            pari_speak('I did not get that')
        except sr.RequestError:
            pari_speak('Sorry, the service is down') # error: recognizer is not connected
        except:
            pari_speak('Sorry, I did not get that')    
        print(f"{voice_data.lower()}") # print what user said
        return voice_data.lower()

# get string and make a audio file to be played
def pari_speak(audio_string):
    tts = gTTS(text=audio_string, lang='en') # text to speech(voice)
    r = random.randint(1,20000000)
    audio_file = 'audio' + str(r) + '.mp3'
    tts.save(audio_file) # save as mp3
    playsound.playsound(audio_file) # play the audio file
    print(f"Pari: {audio_string}") # print what app said
    os.remove(audio_file) # remove audio file

def respond(voice_data):
    # 1: greeting
    if there_exists(['hey','hi','hello']):
        greetings = [f"hey, how can I help you {person_obj.name}", f"hey, what's up? {person_obj.name}", f"I'm listening {person_obj.name}", f"how can I help you? {person_obj.name}", f"hello {person_obj.name}"]
        greet = greetings[random.randint(0,len(greetings)-1)]
        pari_speak(greet)

    # 2: name
    if there_exists(["what is your name","what's your name","tell me your name"]):
        if person_obj.name:
            pari_speak("my name is Pari")
        else:
            pari_speak("my name is Pari. what's your name?")

    if there_exists(["my name is"]):
        person_name = voice_data.split("is")[-1].strip().upper()
        pari_speak("okay, i will remember that " + person_name)
        person_obj.setName(person_name) # remember name in person object

    # 3: greeting
    if there_exists(["how are you","how are you doing"]):
        pari_speak("I'm very well, thanks for asking")

    if there_exists(["i want to open an account","open account","new account"]):
        pari_speak("Sure, I can help you to open account with us.")

    # 4: time
    if there_exists(["what's the time","tell me the time","what time is it"]):
        pari_speak(ctime())

    # 5: search google
    if there_exists(["search for"]) and 'youtube' not in voice_data:
        search_term = voice_data.split("for")[-1]
        url = f"https://google.com/search?q={search_term}"
        webbrowser.get().open(url)
        pari_speak(f'Here is what I found for {search_term} on google')

    # 6: search youtube
    if there_exists(["youtube"]):
        search_term = voice_data.split("for")[-1]
        url = f"https://www.youtube.com/results?search_query={search_term}"
        webbrowser.get().open(url)
        pari_speak(f'Here is what I found for {search_term} on youtube')

    # 7: get stock price
    if there_exists(["price of"]):
        search_term = voice_data.lower().split(" of ")[-1].strip() #strip removes whitespace after/before a term in string
        stocks = {
            "apple":"AAPL",
            "microsoft":"MSFT",
            "facebook":"FB",
            "tesla":"TSLA",
            "bitcoin":"BTC-USD"
        }
        try:
            stock = stocks[search_term]
            stock = yf.Ticker(stock)
            price = stock.info["regularMarketPrice"]

            pari_speak(f'price of {search_term} is {price} {stock.info["currency"]} {person_obj.name}')
        except:
            pari_speak('oops, something went wrong')
    if there_exists(["exit", "quit", "goodbye"]):
        pari_speak("going offline")
        exit()


time.sleep(1)

person_obj = person()
pari_speak('Hello, Welcome to Deutsche Bank. How can I help you today.')
while(1):
    print('>>')
    voice_data = record_audio() # get the voice input
    #time.sleep(1)
    respond(voice_data) # respond