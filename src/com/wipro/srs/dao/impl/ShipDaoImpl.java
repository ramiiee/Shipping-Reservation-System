package com.wipro.srs.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Transaction;


import com.wipro.srs.bean.CredentialsBean;
import com.wipro.srs.bean.ProfileBean;
import com.wipro.srs.bean.ShipBean;
import com.wipro.srs.dao.ShipDAO;
import com.wipro.srs.util.impl.HibernateUtil;

public class ShipDaoImpl implements ShipDAO
{
  private int flag=0;
  public int getFlag() 
  	{
		return flag;
	}

	public void setFlag(int flag) 
	{
		this.flag = flag;
	}

	
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
	
	public String addShip(ShipBean sb, String shipName, int seatingCapacity,int reservationCapacity)
	{
		
		
			tx=session.beginTransaction();
			
			String id_num=seqGen();
			String id=shipName.substring(0, 2)+id_num;
		
			sb.setShipID(id);
			
	
			sb.setShipName(shipName);
			
			sb.setSeatingCapacity(seatingCapacity);
			
			sb.setReservationCapacity(reservationCapacity);
			
			session.save(sb);
		
			setFlag(1);
			
			tx.commit();
			return "";
		}

	@Override
	public ShipBean viewById(String shipID) {
		tx=session.beginTransaction();
		ShipBean sb=(ShipBean) session.get(ShipBean.class,new String(shipID));
		tx.commit();
		return sb;
	}

	public boolean modifyShip(ShipBean smb) 
	{
		//String retval="";
		tx=session.beginTransaction();
		
	    String id=smb.getShipID();

	    ShipBean sb=(ShipBean) session.get(ShipBean.class,new String(id));
	    sb.setShipName(smb.getShipName());

		sb.setSeatingCapacity(smb.getSeatingCapacity());
		
		sb.setReservationCapacity(smb.getReservationCapacity());
		
		session.update(sb);

	    //retval="msuccess";
	    //System.out.println("String"+retval);
		tx.commit();
		
		//return retval;
		return true;
	
		
		
	}
	
	public ShipBean getDetails(String sid)
	{
		tx=session.beginTransaction();
		ShipBean sdet=(ShipBean) session.get(ShipBean.class,new String(sid));
		tx.commit();
		return sdet;
		
	}

	@Override
	public List<ShipBean> viewByAllShips(ShipBean sb) {
		tx=session.beginTransaction();
		org.hibernate.Session session=HibernateUtil.getSessionFactory().openSession();
		List<ShipBean> l=new ArrayList<ShipBean>();
		Query query = session.createQuery("from ShipBean");
		l=query.list();
		return l;
	}

	@Override
	public int removeShip(List<String> list) {
		session=HibernateUtil.getSessionFactory().openSession();
		Transaction tx=null;
		tx=session.beginTransaction();

		for(int i=0;i<list.size();i++)
		{
			String a=list.get(i);
	
			ShipBean sb=(ShipBean) session.get(ShipBean.class,new String(a));
			String ShID= sb.getShipID();
			
			session.delete(sb);
			list.remove(i);
		
		}
		tx.commit();
		return 0;
		
	}

	
		
	}

	
