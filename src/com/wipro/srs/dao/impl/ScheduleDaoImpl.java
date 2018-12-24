package com.wipro.srs.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Transaction;

import com.wipro.srs.bean.RouteBean;
import com.wipro.srs.bean.ScheduleBean;
import com.wipro.srs.dao.ScheduleDAO;
import com.wipro.srs.util.impl.HibernateUtil;

public class ScheduleDaoImpl implements ScheduleDAO 
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
		List<BigDecimal> l= query.list();
		for(BigDecimal a:l)
		{
			i=a;		
		}

	    return i.toString();
	}
public String addSchedule(ScheduleBean scb, String routeID, String shipID,String startDate) 
{
	
	
	tx=session.beginTransaction();
	
	String id_num=seqGen();
    ScheduleBean sb1=new ScheduleBean();
    String source= routeID;

    String id=source.substring(0,4)+id_num;
 
	
	scb.setScheduleID(id);

	
	scb.setRouteID(routeID);
	scb.setShipID(shipID);
	scb.setStartDate(startDate);
	session.save(scb);
	
	setFlag(1);
	tx.commit();
	return "";

}

public ScheduleBean viewByScheduleId(String scheduleID)
{
	tx=session.beginTransaction();

    ScheduleBean sdb=(ScheduleBean)session.load(ScheduleBean.class,new String(scheduleID));

	tx.commit();
	return sdb;
}


public ScheduleBean getMDetails(String sid)
{
	tx=session.beginTransaction();
	ScheduleBean sdb=(ScheduleBean) session.get(ScheduleBean.class,new String(sid));
	tx.commit();
	return sdb;
}

@Override
public boolean modifySchedule(ScheduleBean smb)
{
	tx=session.beginTransaction();
	String id=smb.getScheduleID();
 
    ScheduleBean sb=(ScheduleBean) session.get(ScheduleBean.class,new String(id));
    sb.setScheduleID(smb.getScheduleID());
	sb.setRouteID(smb.getRouteID());
	sb.setShipID(smb.getShipID());
	sb.setStartDate(smb.getStartDate());
	session.update(sb);

    tx.commit();
	return true;
}

public List<ScheduleBean> viewByAllSchedule(ScheduleBean sb1)
{
	tx=session.beginTransaction();
	org.hibernate.Session session=HibernateUtil.getSessionFactory().openSession();
	List<ScheduleBean> lst=new ArrayList<ScheduleBean>();
	Query query = session.createQuery("from ScheduleBean");
	lst=query.list();
	return lst;
}

@Override
public int removeSchedule(List<String> list) 
{
	session=HibernateUtil.getSessionFactory().openSession();
	Transaction tx=null;
	tx=session.beginTransaction();

	for(int i=0;i<list.size();i++)
	{
		String a=list.get(i);

		ScheduleBean scb=(ScheduleBean) session.get(ScheduleBean.class,new String(a));
		String ScID= scb.getScheduleID();

		session.delete(scb);
		list.remove(i);
	}
	
	tx.commit();
	return 0;
	
}

}



