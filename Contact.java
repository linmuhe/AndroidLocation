package com.example.domain;

public class Contact {
private String name;
private String phonenum;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPhonenum() {
	return phonenum;
}
public void setPhonenum(String phonenum) {
	this.phonenum = phonenum;
}
public Contact(String name, String phonenum) {
	
	this.name = name;
	this.phonenum = phonenum;
}
public Contact() {
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Contact [name=" + name + ", phonenum=" + phonenum + "]";
}
}
