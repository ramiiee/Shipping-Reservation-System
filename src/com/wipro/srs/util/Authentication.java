package com.wipro.srs.util;

import com.wipro.srs.bean.CredentialsBean;

public interface Authentication {
	
	public boolean authenticate(CredentialsBean cb);
	public String authorize(String userID);
	boolean changeLoginStatus(CredentialsBean cb,int loginStatus);

}
