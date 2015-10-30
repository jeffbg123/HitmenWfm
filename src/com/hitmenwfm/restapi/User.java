package com.hitmenwfm.restapi;

import java.io.Serializable;
import java.util.Date;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

public class User implements Serializable  {
	public String userName;
	public String email;
	public String password;
	public String firstName;
	public String lastName;
	public String middleName;
	public String streetAddressLine1;
	public String streetAddressLine2;
	public String streetAddressLine3;
	public String city;
	public String state;
	public String zip;
	public String cellPhone;
	public String homePhone;
	public Date birthDate;
	
	@JsonSerialize(using=DateSerializer.class)
	public Date getBirthDate() {
		return birthDate;
	}
	
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	public String getuserName() {
		return userName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getMiddleName() {
		return middleName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getStreetAddressLine1() {
		return streetAddressLine1;
	}
	
	public String getStreetAddressLine2() {
		return streetAddressLine2;
	}
	
	public String getStreetAddressLine3() {
		return streetAddressLine3;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getState() {
		return state;
	}
	
	public String getZip() {
		return zip;
	}
	
	public String getHomePhone() {
		return homePhone;
	}
	
	public String getCellPhone() {
		return cellPhone;
	}
}
