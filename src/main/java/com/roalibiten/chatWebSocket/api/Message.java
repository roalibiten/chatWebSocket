package com.roalibiten.chatWebSocket.api;

public class Message {
	
	private String sender;
	
	private String message;
	private String sendTo;
	private String ip;
	private String device;
	
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	private String mail;

	
	
	
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getDevice() {
		return device;
	}
	public void setDevice(String device) {
		this.device = device;
	}
	public String getSendTo() {
		return sendTo;
	}
	public void setSendTo(String sendTo) {
		this.sendTo = sendTo;
	}
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
		return "Message [sender=" + sender + ", message=" + message + ", sendTo=" + sendTo + ", ip=" + ip + ", device="
				+ device + "]";
	}
	
	
}
