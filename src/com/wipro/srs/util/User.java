package com.wipro.srs.util;

import com.wipro.srs.bean.CredentialsBean;
import com.wipro.srs.bean.ProfileBean;

public interface User 
{
	String register(ProfileBean pb);
	public String login(CredentialsBean cb);
	public boolean logout(String b);
	
	public String forgot(ProfileBean pbf, String userID, String mobileNo,
			String newPassword);
	public String changePassword(ProfileBean pbc, String userID, String newPassword);
	
}
