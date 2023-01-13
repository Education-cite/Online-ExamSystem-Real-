package com.exam.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="teacher")
public class Teacher {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Long tid;
	
	private String name;
	
	private String degissnation;
	
	private String email;
	
	private String address;

	
	public Teacher() {

	}


	public Teacher(Long tid, String name, String degissnation, String email, String address) {
		super();
		this.tid = tid;
		this.name = name;
		this.degissnation = degissnation;
		this.email = email;
		this.address = address;
	}


	public Long getTid() {
		return tid;
	}


	public void setTid(Long tid) {
		this.tid = tid;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDegissnation() {
		return degissnation;
	}


	public void setDegissnation(String degissnation) {
		this.degissnation = degissnation;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}

	
	
	
	
	
}
