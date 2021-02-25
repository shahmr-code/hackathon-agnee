package com.db.hackathon.onlineBanking.config;

import java.io.FileInputStream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@Service
public class FireBaseConfig {

	@Value("${firebase.db.accessPath}")
	private String aceessPath;
	
	@Value("${firebase.db.url}")
	private String dbUrl;
	
	@PostConstruct
	public void initialize() {  
		 try {  
			 FileInputStream serviceAccount =  new FileInputStream(aceessPath);  
			 FirebaseOptions options = new FirebaseOptions.Builder()  
			 .setCredentials(GoogleCredentials.fromStream(serviceAccount))  
			 .setDatabaseUrl(dbUrl)
			 .build();  
			 FirebaseApp.initializeApp(options);  
		 } catch (Exception e) {  
			 e.printStackTrace();  
		 }
	}
}
