package com.wipro.srs.dao.impl;

import java.math.BigDecimal;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Transaction;

import com.wipro.srs.bean.CredentialsBean;
import com.wipro.srs.bean.ProfileBean;
import com.wipro.srs.controller.AdministratorController;
import com.wipro.srs.dao.UserDAO;
import com.wipro.srs.util.impl.HibernateUtil;

public class UserDaoImpl implements UserDAO 
{

	private Transaction tx=null;
	private org.hibernate.Session session=HibernateUtil.getSessionFactory().openSession();
	public Transaction getTx() {
		return tx;
	}
	public void setTx(Transaction tx) {
		this.tx = tx;
	}
	public org.hibernate.Session getSession() {
		return session;
	}
	public void setSession(org.hibernate.Session session) {
		this.session = session;
	}

	static Logger log=Logger.getLogger(AdministratorController.class.getName());	

	public String seqGen()
	{ 	
		BigDecimal i=null	;
	
		Query query = session.createSQLQuery("select srs_seq_userId.nextval from dual");
		List<BigDecimal> l=  query.list();
		for(BigDecimal a:l)
		{
			i=a;		
		}
	
	    return i.toString();
	}
	public String register(ProfileBean pb)
	{
		tx=session.beginTransaction();
	
		String id_num=seqGen();
		String id=pb.getFirstName().substring(0, 2)+id_num;
	
		System.out.println("The entered date of birth is "+pb.getDateOfBirth());
		pb.setUserID(id);

	
		CredentialsBean cb=new CredentialsBean();
      
		cb.setLoginStatus(0);
	
		cb.setUserID(pb.getUserID());
		String uid=cb.getUserID();
		

		cb.setPassword(pb.getPassword());
		cb.setUserType("C");
		session.save(pb);
		System.out.println("Values successfully set to Profile bean");
		session.save(cb);
		System.out.println("Values set in Credential bean");
		tx.commit();
		return pb.getUserID();
		}
	public CredentialsBean login(CredentialsBean cb)
	{
		String str=cb.getUserID();
		tx=session.beginTransaction();

		CredentialsBean p=(CredentialsBean) session.get(CredentialsBean.class,new String(str));
		tx.commit();
		return p;	
		
	}
	public boolean logout(String b)
	{
	
		tx=session.beginTransaction();
		CredentialsBean cb1=(CredentialsBean) session.get(CredentialsBean.class, new String(b));
		if(cb1.getLoginStatus()==1)
	 		{
				cb1.setLoginStatus(0);
				tx.commit();
			
	 		}
		else
	 		{
				log.info("Already Logged Out");
	 		}
	return true;
	
	}

	public void changeLoginStatus(CredentialsBean cb, int i) 
	{
		tx=session.beginTransaction();
		cb.setLoginStatus(i);
		session.update(cb);
		tx.commit();
	
	}
	public String forgot(ProfileBean pbf,String userID,String mobileNo,String newPassword)
	{
		
		ProfileBean pb1=new ProfileBean();
	
		tx=session.beginTransaction();
		pb1=(ProfileBean) session.get(ProfileBean.class, new String(userID));
	
		if(userID.equalsIgnoreCase(pb1.getUserID()))
		{
	
			
				if(mobileNo.equalsIgnoreCase(pb1.getMobileNo()))
				{
				
					pb1.setPassword(newPassword);
				
					CredentialsBean cb2=new CredentialsBean();
					cb2=(CredentialsBean) session.get(CredentialsBean.class, new String(userID));
					String id=cb2.getUserID();
					
					cb2.setPassword(newPassword);
					
				    tx.commit();
					
				    return "login";
				}
				else
				{
					log.info("Enter the correct mobile no.");
				    return "error";
				}
			
		}
		else
		{
			log.info("UserID not found Password not changed");
		    return "error";
		}
	}
	
	public String changePassword(ProfileBean pbc,String userID,String newPassword)
	{
		
		ProfileBean pb3=new ProfileBean();
		
		tx=session.beginTransaction();
		pb3=(ProfileBean) session.get(ProfileBean.class, new String(userID));
	
		if(userID.equalsIgnoreCase(pb3.getUserID()))
		{
			    
			        pb3.setPassword(newPassword);
					
					CredentialsBean cb3=new CredentialsBean();
					cb3=(CredentialsBean) session.get(CredentialsBean.class, new String(userID));
					String id=cb3.getUserID();
				
					cb3.setPassword(newPassword);
				    tx.commit();
					
				    return "login";

        }
		else
		{
			log.info("UserID wrong");
			return "reenter";
		}
	}
}
