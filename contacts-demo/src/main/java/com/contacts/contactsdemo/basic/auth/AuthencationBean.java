package com.contacts.contactsdemo.basic.auth;

public class AuthencationBean {

	private String message;
	
	public AuthencationBean(String message) {
		// TODO Auto-generated constructor stub
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return String.format("HelloWorldBean [message=%s]", message);
	}
}
