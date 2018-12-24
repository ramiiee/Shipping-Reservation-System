package com.wipro.srs.util.impl;

import com.wipro.srs.bean.CredentialsBean;
import com.wipro.srs.dao.UserDAO;
import com.wipro.srs.dao.impl.UserDaoImpl;
import com.wipro.srs.util.Authentication;

public class AuthenticationImpl implements Authentication {
	private UserDAO dao=new UserDaoImpl();

	public UserDAO getDao() {
		return dao;
	}

	public void setDao(UserDAO dao) {
		this.dao = dao;
	}

	public boolean authenticate(CredentialsBean cb) {
		
		boolean a;
		if(cb!=null)
		{
			if(cb.getUserID().equalsIgnoreCase(UserImpl.getCb1().getUserID())&&cb.getPassword().equalsIgnoreCase(UserImpl.getCb1().getPassword()))
			{
				a= true;
				
			}
			else 
			{
				a= false;
			
			}
		}
		else
		{
			a= false;
			
		}
		return a;
	}

	public String authorize(String a) 
	{
		String retval;
		if(a.equals("A"))
			{
				retval="A";
			}
		else
			{
				retval="C";
			}
		return retval;
	}

	
	public boolean changeLoginStatus(CredentialsBean cb, int loginStatus) 
	{

		dao.changeLoginStatus(cb,1);
		return true;
	}
	
	

}
