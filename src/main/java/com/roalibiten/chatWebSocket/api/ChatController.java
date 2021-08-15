package com.roalibiten.chatWebSocket.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import database.DatabaseConnection;
import org.bson.Document;


@Controller
@CrossOrigin
public class ChatController {

	@Autowired
	private SimpMessagingTemplate messagingTemplate;
	
	@MessageMapping("chat")
	//@SendTo("/topic")
	//@SendToUsers()
	public void sendToUser(@Payload Message message) {
		System.out.println("ozell"+message+messagingTemplate.getUserDestinationPrefix()+message.getSendTo());
		messagingTemplate.convertAndSendToUser(message.getSendTo(),"/queue",message);
		
		DatabaseConnection aConnection=new DatabaseConnection();

		MongoCollection col = aConnection.db.getCollection(message.getMail());
		
		Document sampleDoc = new Document().append("message", message.getMessage()).append("sender", message.getSender());
		
		col.insertOne(sampleDoc);
	}
	
	@MessageMapping("toEmployee")
	//@SendTo("/topic")
	//@SendToUsers()
	public void sendToEmployee(@Payload Message message) {
		System.out.println(message);
		messagingTemplate.convertAndSend("/topic",message);	
		
		
		
		DatabaseConnection aConnection=new DatabaseConnection();

		MongoCollection col = aConnection.db.getCollection(message.getMail());
		
		Document sampleDoc = new Document().append("message", message.getMessage()).append("sender", message.getSender());
		
		col.insertOne(sampleDoc);

	}
	
}
