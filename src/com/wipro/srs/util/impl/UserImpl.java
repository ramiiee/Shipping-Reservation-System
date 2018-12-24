package com.wipro.srs.util.impl;

import com.wipro.srs.bean.CredentialsBean;
import com.wipro.srs.bean.ProfileBean;
import com.wipro.srs.dao.UserDAO;
import com.wipro.srs.dao.impl.UserDaoImpl;
import com.wipro.srs.util.Authentication;
import com.wipro.srs.util.User;

public class UserImpl implements User
{
	
	private UserDAO userdao=new UserDaoImpl();
	public UserDAO getUserdao() {
		return userdao;
	}

	public void setUserdao(UserDAO userdao) {
		this.userdao = userdao;
	}


	private static CredentialsBean cb1;
	public static CredentialsBean getCb1() 
	{
		return cb1;
	}

	public static void setCb1(CredentialsBean cb1) 
	{
		UserImpl.cb1 = cb1;
	}

	public String register(ProfileBean pb) 
	{
		UserDaoImpl ud=new UserDaoImpl();
		String b=ud.register(pb);
		
	/*	return ud.register(pb);*/
		return b;
	
	}
	public String login(CredentialsBean credentialsbean) 
	{
	
		CredentialsBean cb=userdao.login(credentialsbean);
		cb1=credentialsbean;
		Authentication au=new AuthenticationImpl();
		boolean a=au.authenticate(cb);
		String s;
		if(a)
		{
			s=au.authorize(cb.getUserType());
			au.changeLoginStatus(cb, 1);
	
		}
		else
		{
			s="invalid";
		}
		return s;
	}
	
	public boolean logout(String b) 
	{
		
		UserDAO ud3=new UserDaoImpl();
		ud3.logout(b);
		return true;
	}
	public String forgot(ProfileBean pbf, String userID, String mobileNo,String newPassword)
	{
		UserDAO udf=new UserDaoImpl();
		udf.forgot(pbf,userID,mobileNo,newPassword);
		
		return"";
	}

	
	public String changePassword(ProfileBean pbc, String userID,String newPassword) 
	{
        UserDAO udc=new UserDaoImpl();
        udc.changePassword(pbc,userID,newPassword);
		
		
        return "";
	}
	


}
