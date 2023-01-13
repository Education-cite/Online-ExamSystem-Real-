package com.exam.helper;

public class UserFoundException extends Exception{


	public UserFoundException() {
		super("User With this Username Allready in Database!! Try Another Again");
	}
	
	public  UserFoundException(String msg) {
		super(msg);
	}
	
	
}
