package com.roalibiten.chatWebSocket.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mongodb.DBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

import database.DatabaseConnection;

import java.awt.Cursor;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.bson.Document;
import org.json.JSONObject;


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
		
		Document sampleDoc = new Document().append("sendTo", message.getSendTo()).append("message", message.getMessage()).append("sender", message.getSender());
		
		col.insertOne(sampleDoc);
		
	   
	

	}
	
	
	   @GetMapping(value = "/getMessages", produces = MediaType.TEXT_HTML_VALUE)
	    @ResponseBody
	    public String welcomeAsHTML() {
		   
		   ArrayList<String> colls = new ArrayList<String>();
		   ArrayList<String> messages = new ArrayList<String>();
	       
		   DatabaseConnection aConnection=new DatabaseConnection();
			
			
			
			MongoIterable<String> collsNames = aConnection.db.listCollectionNames();

			for (String s : collsNames) {
				ArrayList<String> dialogs = new ArrayList<String>();
				
				colls.add(s);
				
				MongoCollection col = aConnection.db.getCollection(s);

			    MongoCursor<Document> cursor = col.find().iterator();
			    
		        while (cursor.hasNext()) {
		        	

		        	
		        	dialogs.add(cursor.next().toJson());

		        }
		        dialogs.add("SAAAAA");
	        	messages.addAll(dialogs);

			}
			
	        return messages.toString();
	    }


	
}
