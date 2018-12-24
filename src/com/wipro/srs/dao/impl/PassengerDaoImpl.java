package com.wipro.srs.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Transaction;


import com.wipro.srs.bean.PassengerBean;
import com.wipro.srs.bean.ReservationBean;
import com.wipro.srs.bean.RouteBean;
import com.wipro.srs.controller.AdministratorController;
import com.wipro.srs.dao.PassengerDAO;
import com.wipro.srs.util.impl.HibernateUtil;

public class PassengerDaoImpl implements PassengerDAO 
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
	public ArrayList<PassengerBean> viewPassengersByShip(String scheduleID)
	{
		 tx=session.beginTransaction();
		 ArrayList<PassengerBean> pbl=new ArrayList<PassengerBean>();
				 
		 List<PassengerBean> lst=new ArrayList<PassengerBean>();
		 String hq=" from PassengerBean where scheduleID='"+scheduleID+"'";	
		 Query query = session.createQuery(hq);
			lst=query.list();
		 
		 
		
		/* Query q=session.createQuery(SQL_QUERY);
		 List<ReservationBean> list=q.list();*/
		 log.info("No.of passengers travelling= "+lst.size());
		/* String rid=lst.get(0).getReservationID();
		  System.out.println(lst.get(0).getReservationID());
		 String SQL_QUERY1="from PassengerBean where reservationID='"+rid+"'";
		  Query q1=session.createQuery(SQL_QUERY1);*/
		  Iterator i = lst.iterator();
		  while(i.hasNext())
		  {
			  PassengerBean p= (PassengerBean)i.next();
			  pbl.add(p);
			  
		  }
		  tx.commit();
		return pbl;
	}
}