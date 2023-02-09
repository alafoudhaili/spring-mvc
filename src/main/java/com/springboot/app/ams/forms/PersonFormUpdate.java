package com.springboot.app.ams.forms;

public class PersonFormUpdate {
	private String firstName ;
	  private String lastName ;
		public String getFirstName(){
			return firstName ;
		}
		public void UpdateFirstName(String firstName) {
			this.firstName=firstName;
		}
		public String getLastName() {
			return lastName ;
		}
		public void UpdateLastName(String lastName) {
			this.lastName=lastName ;
		}
}
