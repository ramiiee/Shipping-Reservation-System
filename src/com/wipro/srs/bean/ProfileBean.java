package com.wipro.srs.bean;

import java.text.SimpleDateFormat;

import java.util.Date;

import javax.persistence.*;

import org.apache.log4j.Logger;
import org.hibernate.validator.constraints.NotEmpty;

import com.wipro.srs.controller.AdministratorController;




/**
 * 
 * @author Administrator
 *
 */
public class ProfileBean 
{
	 private static Logger log=Logger.getLogger(AdministratorController.class.getName());	
	
	 /**
	  * 
	  * @return log
	  */
	public static Logger getLog() {
		return log;
	}
	/**
	 * 
	 * @param log log
	 */
	public static void setLog(Logger log) {
		ProfileBean.log = log;
	}
	private String userID;
	 
	@NotEmpty
	private String firstName;
	@NotEmpty
	private String lastName;
	
	@NotEmpty
	private Date dateOfBirth;
	@NotEmpty
	private String gender;
	@NotEmpty
	private String street;
	@NotEmpty
	private String location;
	@NotEmpty
	private String city;
	@NotEmpty
	private String state;
	@NotEmpty
	private String pincode;
	@NotEmpty
	private String mobileNo;
	@NotEmpty
	private String emailID;
	@NotEmpty
	private String password;
	
	/**
	 * @param null
	 */
	public ProfileBean() 
	{
		super();
		
	}
/**
 * 	
 * @return userID
 */
	public String getUserID() {
		return userID;
	}
/**
 * 	
 * @param userID userID
 */ 
	public void setUserID(String userID) {
		this.userID = userID;
	}
/**
 * 	
 * @return firstName
 */
	public String getFirstName() {
		return firstName;
	}
/**
 * 	
 * @param firstName firstName
 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
/**
 * 	
 * @return lastName
 */
	public String getLastName() {
		return lastName;
	}
/**
 * 	
 * @param lastName lastName
 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
/**
 * 	
 * @return dateOfBirth
 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
/**
 * 	
 * @param dateOfBirth dateOfBirth
 */
	public void setDateOfBirth(Date dateOfBirth) {
		try{
		Date d=new Date();
		SimpleDateFormat sf=new SimpleDateFormat("mm/dd/yyyy");
		this.dateOfBirth =dateOfBirth;
				
		}
		catch(Exception e)
		{
		log.info("Date error"+e);
		}
		/*this.dateOfBirth=dateOfBirth;*/
	}
/**
 * 	
 * @return gender
 */
	public String getGender() {
		return gender;
	}
/**
 * 	
 * @param gender gender
 */
	

	public void setGender(String gender) {
		this.gender = gender;
	}
/**
 * 	
 * @return street
 */
	
	public String getStreet() {
		return street;
	}
/**
 * 	 
 * @param street street
 */
	public void setStreet(String street) {
		this.street = street;
	}
/**
 * 	
 * @return location
 */
	public String getLocation() {
		return location;
	}
/**
 * 	
 * @param location location
 */
	public void setLocation(String location) {
		this.location = location;
	}
/**
 * 	
 * @return city
 */
	public String getCity() {
		return city;
	}
/**
 * 	
 * @param city city
 */
	public void setCity(String city) {
		this.city = city;
	}
/**
 * 	
 * @return state
 */
	public String getState() {
		return state;
	}
/**
 * 	
 * @param state state
 */
	public void setState(String state) {
		this.state = state;
	}
/**
 * 	
 * @return pincode
 */
	public String getPincode() {
		return pincode;
	}
/**
 * 	
 * @param pincode pincode
 */
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
/**
 * 	
 * @return mobileNo
 */
	public String getMobileNo() {
		return mobileNo;
	}
/**
 * 	
 * @param mobileNo mobileNo
 */
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
/**
 * 	
 * @return emailID
 */
	public String getEmailID() {
		return emailID;
	}
/**
 * 	
 * @param emailID emailID
 */
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
/**
 * 	
 * @return password
 */
	public String getPassword() {
		return password;
	}
/**
 * 	
 * @param password password
 */
	public void setPassword(String password) {
		this.password = password;
	}

}
