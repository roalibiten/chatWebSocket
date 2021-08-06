package com.roalibiten.chatWebSocket.api;

public class Message {
	
	private String sender;
	public String getSendTo() {
		return sendTo;
	}
	public void setSendTo(String sendTo) {
		this.sendTo = sendTo;
	}
	private String message;
	private String sendTo;

	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "Message [sender=" + sender + ", message=" + message + ", sendTo=" + sendTo + "]";
	}
	
	
}
