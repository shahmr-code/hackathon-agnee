from flask import Flask,request,render_template,session,g 
import speech_recognition as sr # recognise speech
import playsound # to play an audio file
from gtts import gTTS # google text to speech
import random
from time import ctime # get time details
import time
import os # to remove created audio files
import threading
from bs4 import BeautifulSoup
from requests_html import HTMLSession
from urllib.parse import urljoin
from form_extractor import get_all_forms, get_form_details, session, get_all_b
import requests
import webbrowser
from selenium import webdriver
from selenium.webdriver.common.keys import Keys


app = Flask(__name__)
app.secret_key = "iufh4857o3yfhh3"
disability = ""
driver = ""

class person:
    name = ''
    def setName(self, name):
        self.name = name


def there_exists(terms):
    for term in terms:
        if term in voice_data:
            return True


r = sr.Recognizer()
# initialize an HTTP session
session = HTMLSession()


def play_file(name=''):
    if name:
        time.sleep(10)
        playsound.playsound(name)
        os.remove(name)

def welcome():
    global disability
    if disability == "":
        pari_speak("Hello, Welcome to Bank. You are at login page.")
        pari_speak("Are you a person with disability.")
        voice_data = record_audio()
        if voice_data in ["Yes", "yes"]:
            pari_speak("What disability you have.")
            voice_data = record_audio()
            if voice_data in ["Blind","blind","blindness","Blindness","Visual","visual"]:
                disability = "Blindness"
                pari_speak("We have noted that. Thank you")
            else:
                disability = voice_data
        else:
            pari_speak("Ok. Thank you")

        if disability == "Blindness":
            parse_welcome("http://127.0.0.1:5000/")


def parse_welcome(url):
    all_b = get_all_b(url)
    for b in all_b:
        try:
            time.sleep(2)
            txt = b.attrs["title"]
            pari_speak(txt)
        except:
            pass
    
    voice_data = record_audio()
    pari_speak("Ok. Sure.")
    for b in all_b:
        print("Button value: " + b.text)
        if voice_data == b.text:
            webbrowser.open("http://127.0.0.1:5000/login", new = 0)
            #driver = webdriver.Chrome()
            #driver.get("http://127.0.0.1:5000/login")
            #global driver
            #driver = webdriver.Chrome(r"C:\Users\VISHAL\Desktop\DB Hackathon\chromedriver_win32\chromedriver.exe")
            #driver.get("http://127.0.0.1:5000/")
            #button = driver.find_element_by_name("login")
            #button.click()
            
        

def parse_page(url):
    # get the first form
    first_form = get_all_forms(url)[0]
    # extract all form details
    form_details = get_form_details(first_form)
    #pprint(form_details)
    # the data body we want to submit
    data = {}
    for input_tag in form_details["inputs"]:
        if input_tag["type"] == "hidden":
            # if it's hidden, use the default value
            data[input_tag["name"]] = input_tag["value"]
        elif input_tag["type"] != "submit":
            # all others except submit, prompt the user to set it
            txt = "Please tell me your " + input_tag['name']
            pari_speak(txt)
            value = record_audio()
            txt = value + " noted."
            pari_speak(txt)
            data[input_tag["name"]] = value

    # join the url with the action (form request URL)
    url = urljoin(url, form_details["action"])

    if form_details["method"] == "post":
        res = session.post(url, data=data)
    elif form_details["method"] == "get":
        res = session.get(url, params=data)


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
    #time.sleep(5)
    tts = gTTS(text=audio_string, lang='en') # text to speech(voice)
    r = random.randint(1,20000000)
    audio_file = 'audio' + str(r) + '.mp3'
    tts.save(audio_file) # save as mp3
    playsound.playsound(audio_file) # play the audio file
    print(f"Pari: {audio_string}") # print what app said
    os.remove(audio_file) # remove audio file
    return audio_file


def respond(voice_data):
    # 1: greeting
    if there_exists(['hey','hi','hello']):
        greetings = [f"hey, how can I help you {person_obj.name}", f"hey, what's up? {person_obj.name}", f"I'm listening {person_obj.name}", f"how can I help you? {person_obj.name}", f"hello {person_obj.name}"]
        greet = greetings[random.randint(0,len(greetings)-1)]
        pari_speak(greet)

    
@app.route('/')
def hello_world():
    x = threading.Thread(target=welcome)
    #pari_speak("Hello, Welcome to Deutsche Bank. You are at login page.")
    x.start()
    return render_template("welcome.html") #, dest=audio_file, f_name=play_file)
    
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


@app.route('/login')
def login_1():
    return render_template("login.html")


def start():
    global driver
    time.sleep(1)
    driver = webdriver.Chrome(r"C:\Users\VISHAL\Desktop\DB Hackathon\chromedriver_win32\chromedriver.exe")
    driver.get("http://127.0.0.1:5000/")
    driver.find_element_by_tag_name('body').send_keys(Keys.COMMAND + 't')


if __name__ == '__main__':
    time.sleep(1)
    #y = threading.Thread(target=welcome)
    #y.start()
    app.run()
    
    

