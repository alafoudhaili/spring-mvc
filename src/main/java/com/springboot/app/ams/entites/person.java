package com.springboot.app.ams.entites;

public class person {
 private String firstName ;
 private String lastName ;
 
 public person() {
	 
 }
 
 public person( String firstName,String lastName) {
	 this.firstName=firstName ;
	 this.lastName=lastName ;
 }
 
public String getFirstName() {
	return firstName ;
} 
public void setFirstName(String firstName) {
	this.firstName=firstName;
}
public String getLastName() {
	return lastName ;
}
public void setLastName(String lastName) {
	this.lastName=lastName ;
}
}
