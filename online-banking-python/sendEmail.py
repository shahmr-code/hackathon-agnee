# Python code to illustrate Sending mail from 
# your Gmail account 
import smtplib 

# creates SMTP session 
s = smtplib.SMTP('smtp.gmail.com', 587) 

# start TLS for security 
s.starttls() 

# Authentication 
s.login("hitkju1@gmail.com", "hitkju1st") 

# message to be sent 
message = "Customer Id =123456789 and password =qwerty"

# sending the mail 
s.sendmail("hitkju1@gmail.com", "vgjadhav0718@gmail.com", message) 

# terminating the session 
s.quit() 