from flask import Flask,request,render_template
import speech_recognition as sr # recognise speech
import playsound # to play an audio file
from gtts import gTTS # google text to speech
import random
from time import ctime # get time details
import time
import os # to remove created audio files

app = Flask(__name__)

class person:
    name = ''
    def setName(self, name):
        self.name = name


def there_exists(terms):
    for term in terms:
        if term in voice_data:
            return True


r = sr.Recognizer()

# listen for audio and convert it to text:
def record_audio(ask=False):
    with sr.Microphone() as source: # microphone as source
        if ask:
            pari_speak(ask)
        audio = r.listen(source)  # listen for the audio via source
        voice_data = ''
        try:
            voice_data = r.recognize_google(audio)  # convert audio to text
        except sr.UnknownValueError: # error: recognizer does not understand
            pari_speak('I did not get that')
        except sr.RequestError:
            pari_speak('Sorry, the service is down') # error: recognizer is not connected
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

    # 4: time
    if there_exists(["what's the time","tell me the time","what time is it"]):
        pari_speak(ctime())

    if there_exists(["exit", "quit", "goodbye"]):
        pari_speak("going offline")
        exit()

@app.route('/')
def hello_world():
    return render_template("login.html")
    
database={'vishal':'123','james':'aac','karthik':'asdsf'}

@app.route('/form_login',methods=['POST','GET'])
def login():
    name1=request.form['username']
    pwd=request.form['password']
    if name1 not in database:
	    return render_template('login.html',info='Invalid User')
    else:
        if database[name1]!=pwd:
            return render_template('login.html',info='Invalid Password')
        else:
	         return render_template('home.html',name=name1)




if __name__ == '__main__':
    time.sleep(1)
    app.run()