package com.exam.helper;

public class UserNotFoundException extends Exception{

	
	public UserNotFoundException() {
		super("User With this Username Not Found in Database !!");
	}
	
	public  UserNotFoundException(String msg) {
		super(msg);
	}
}
