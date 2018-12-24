package com.wipro.srs.dao;

import com.wipro.srs.bean.CredentialsBean;
import com.wipro.srs.bean.ProfileBean;

public interface UserDAO 
{
	String register(ProfileBean pb);
     CredentialsBean login(CredentialsBean cb);
	 boolean logout(String b);
	 void changeLoginStatus(CredentialsBean cb, int i);
	 String forgot(ProfileBean pbf,String userID,String mobileNo,String newPassword);
	 String changePassword(ProfileBean pbc, String userID, String newPassword);

	
}
