package com.roalibiten.chatWebSocket.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@CrossOrigin
public class ChatController {

	@Autowired
	private SimpMessagingTemplate messagingTemplate;
	
	@MessageMapping("chat/{username}")
	//@SendTo("/topic")
	//@SendToUsers()
	public void sendToUser(@Payload Message message) {
		System.out.println("ozell"+message+"/chat/"+message.getSendTo());
		messagingTemplate.convertAndSend("/chat/"+message.getSendTo(),message);	
	}
	
	@MessageMapping("toEmployee")
	//@SendTo("/topic")
	//@SendToUsers()
	public void sendToEmployee(@Payload Message message) {
		System.out.println(message);
		messagingTemplate.convertAndSend("/topic",message);	
	}
	
}
