package com.roalibiten.chatWebSocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import database.DatabaseConnection;


@SpringBootApplication

public class ChatWebSocketApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatWebSocketApplication.class, args);
		DatabaseConnection aConnection=new DatabaseConnection();

		
	}

		
	
}
