package com.wipro.srs.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * 
 * @author Administrator
 *
 */
public class CredentialsBean {
	

	private String userID;

	private String password;

	private String userType;

	private int loginStatus;
	
	
/**
 * 	 
 * @param userID userID
 * @param password password
 * @param userType userType
 * @param loginStatus loginStatus
 */
	public CredentialsBean(String userID, String password, String userType,
			int loginStatus) {
		super();
		this.userID = userID;
		this.password = password;
		this.userType = userType;
		this.loginStatus = loginStatus;
	}
	/**
	 * @param null
	 */
	public CredentialsBean() {
		super();
		
	}
/**
 * 
 * @return userID
 */
	public String getUserID() 
	{
		return userID;
	}
/**
 * 	
 * @param userID userID
 */
	public void setUserID(String userID) 
	{
		this.userID = userID;
	}
/**
 * 	
 * @return password
 */
	public String getPassword() 
	{
		return password;
	}
/**
 * 	
 * @return userType
 */
	public String getUserType() {
		return userType;
	}
/**
 * 	
 * @param userType userType
 */
	public void setUserType(String userType) {
		this.userType = userType;
	}
/**
 * 	
 * @return loginStatus
 */
	public int getLoginStatus() {
		return loginStatus;
	}
/**
 * 	
 * @param loginStatus loginStatus
 */
	public void setLoginStatus(int loginStatus) {
		this.loginStatus = loginStatus;
	}
/**
 * 	
 * @param password password
 */
	public void setPassword(String password) 
	{
		this.password = password;
	}
	


}
