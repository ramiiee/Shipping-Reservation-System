package com.wipro.srs.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.Iterator;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Transaction;

import com.wipro.srs.bean.PassengerBean;
import com.wipro.srs.bean.PaymentBean;
import com.wipro.srs.bean.ReservationBean;
import com.wipro.srs.bean.RouteBean;
import com.wipro.srs.bean.ScheduleBean;
import com.wipro.srs.bean.ShipBean;
import com.wipro.srs.controller.AdministratorController;
import com.wipro.srs.dao.CustomerDAO;
import com.wipro.srs.util.impl.HibernateUtil;

public class CustomerDaoImpl implements CustomerDAO {
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

	public double f,bal;
	public static double tf;
	static Logger log=Logger.getLogger(AdministratorController.class.getName());	

	@Override
	public ArrayList<ScheduleBean> viewScheduleByRoute(String src,String dest, Date date)
	{
		tx=session.beginTransaction();
		org.hibernate.Session session=HibernateUtil.getSessionFactory().openSession();
		ArrayList<ScheduleBean> lst=new ArrayList<ScheduleBean>();
		String q="from ScheduleBean where routeID IN(select routeID from RouteBean where source= '"+src+"' AND destination='"+dest+"')";
	
		Query query=session.createQuery(q);
	
		List<ScheduleBean>l1=query.list();
		ArrayList<ScheduleBean>list=new ArrayList<ScheduleBean>();
		Iterator itr=l1.iterator();
		while(itr.hasNext())
		{
			ScheduleBean sb=(ScheduleBean)itr.next();
	
			int z=date.getYear();
			int x=sb.getStartDate().getYear();
			if(z==x)
			{
				int a=date.getMonth();
				int b=sb.getStartDate().getMonth();
				if(a==b)
				{
					int c=date.getDate();
					int d=sb.getStartDate().getDate();
					if(c==d)
					{
						list.add(sb);

					}
					else
					{
						log.info("Date wrong");
				
					}
					
				}
				else
				{
					log.info("Month wrong");
				    
				}
			}
			else
			{
				log.info("Year wrong");
			    
			}
		}
		return list;
			
   }

	@Override
	public RouteBean fetchRB(String rid) {
		tx=session.beginTransaction();
		RouteBean rb=(RouteBean) session.get(RouteBean.class,new String(rid));
        tx.commit();
		return rb;
	}

	@Override
	public ShipBean fetchSB(String sid) {
		
		tx=session.beginTransaction();
		ShipBean sb=(ShipBean) session.get(ShipBean.class,new String(sid));
        tx.commit();
		return sb;
	
	}

	
	public String rSeqGen()
	{ 	
		BigDecimal i=null	;
		Query query = session.createSQLQuery("select srs_seq_reservId.nextval from dual");
		List<BigDecimal> l= query.list();
		for(BigDecimal a:l)
		{
			i=a;		
		}
        return i.toString();
	}
	
	
	@Override
	public String reserveTicket(ReservationBean rb, List<PassengerBean> list3)
	{
		tx=session.beginTransaction();
		
		String id=rSeqGen();
		String rcomp=rb.getScheduleID();
		String rid=rcomp.substring(0,4)+id;

		rb.setReservationID(rid);
	
	    ScheduleBean scb=(ScheduleBean) session.get(ScheduleBean.class,new String(rcomp));
	    String routeid=scb.getRouteID();
		Date journeyDate=scb.getStartDate();
		String shipID=scb.getShipID();

		ShipBean sbr=(ShipBean) session.get(ShipBean.class,new String(shipID));
		int scap=sbr.getReservationCapacity();

	    rb.setJourneyDate(journeyDate);

	  
	    RouteBean rcb=(RouteBean) session.get(RouteBean.class,new String(routeid));
	    double rate=rcb.getFare();
	
	    int noofseats=rb.getNoOfSeats();
	    System.out.println("No.of passengers travelling "+noofseats);
	    double totalfare=rate*noofseats;
	    f=totalfare;
	    System.out.println("The entire ticket cost to be paid is "+f);
	
	    rb.setTotalFare(f);
        tf=rb.getTotalFare();
	    String schedid=rb.getScheduleID();
	  
	    int reservcap=scap-noofseats;

	    sbr.setReservationCapacity(reservcap);
	
	    rb.setBookingStatus("booked");
	    session.update(sbr);
	    session.save(rb);
	    
	    
	    //System.out.println("Remaining seats available "+sbr.getReservationCapacity());
        
	    
/*	    if(noofseats<scap)
	    { 
	        System.out.println("Seats remaining = "+reservcap);
	    	sbr.setReservationCapacity(reservcap);
	    	System.out.println("ShipBean Reservation Capacity Updated");
	        rb.setBookingStatus("booked");
	        session.saveOrUpdate(sbr);
	        session.save(rb);
		 
	        
	        
	    }
	    else
	    {
	    	rb.setBookingStatus("not booked");
	    	session.saveOrUpdate(sbr);
	    	   session.save(rb);
	   	  
	    }
	    
	    
	    
	    System.out.println("no.of passengers booked "+list3.size());*/
	    Iterator itr=list3.iterator();
		while(itr.hasNext())
		{
			PassengerBean pb=(PassengerBean) itr.next();
			pb.setReservationID(rid);
			pb.setScheduleID(schedid);
			session.save(pb);
	    }
	    
	   tx.commit();
	   return "success";
	    
	 
	}

	public boolean cancelTicket(String g) {
	
		 Transaction tx=null;
		 tx=session.beginTransaction();
		 ReservationBean rbc=(ReservationBean) session.get(ReservationBean.class,new String(g));
		 String uid=rbc.getUserID();
		 
	

		 ScheduleBean sbc=(ScheduleBean) session.get(ScheduleBean.class,new String(rbc.getScheduleID()));
		 ShipBean shb=(ShipBean) session.get(ShipBean.class,new String(sbc.getShipID()));
		 PaymentBean pb=(PaymentBean) session.get(PaymentBean.class,new String(uid));
		 System.out.println("The balance in"+uid+"is "+pb.getBalance());
		 double refund=rbc.getTotalFare()+pb.getBalance();
		 System.out.println("amount to be refunded "+rbc.getTotalFare());
		 System.out.println("balance after refund "+refund);
		 pb.setBalance(refund);
		 int capacity=shb.getReservationCapacity()+rbc.getNoOfSeats();
		 shb.setReservationCapacity(capacity);
		 session.update(pb);
		 session.update(shb);
		 String q=" delete from PassengerBean where reservationID='"+g+"'";

		 org.hibernate.Query qu=session.createQuery(q);
		 qu.executeUpdate();
		 session.delete(rbc);
		 tx.commit();
		 return true;
	}
	
	public Map<ReservationBean, PassengerBean> viewTicket(String reservationID)
	{
		Map<ReservationBean, PassengerBean> map=new HashMap<ReservationBean, PassengerBean>();
		/*session=HibernateUtil.getSessionFactory().openSession();*/
		tx=session.beginTransaction();
		String q="from ReservationBean WHERE reservationID='"+reservationID+"'";

		Query query=session.createQuery(q);
		ArrayList<ReservationBean>reserveList=new ArrayList<ReservationBean>();
		reserveList=(ArrayList<ReservationBean>)query.list();
	
		String r="from PassengerBean WHERE reservationID='"+reservationID+"'";
		Query quer=session.createQuery(r);
		ArrayList<PassengerBean>passList=new ArrayList<PassengerBean>();
		passList=(ArrayList<PassengerBean>)quer.list();
		Iterator it=reserveList.iterator();
		Iterator itr=passList.iterator();
		while(it.hasNext()||(itr.hasNext()))
		{
			ReservationBean rb=null;
			PassengerBean pb=null;
			if(it.hasNext())
			{
				rb=(ReservationBean)it.next();
			}
			if(itr.hasNext())
			{
				
				pb=(PassengerBean)itr.next();
				
			}
			map.put(rb,pb);
		
			}
	
		return map;
	}

	@Override
	public boolean findByCardNumber(String urid, String creditCardNumber) {
	
		Transaction tx=null;
		tx=session.beginTransaction();
		boolean a;
		PaymentBean pb=(PaymentBean) session.get(PaymentBean.class,new String(urid));
        bal=pb.getBalance();
	     
		
        if(pb.getUserID().equalsIgnoreCase(urid))
		{
		 
        	a=true;
		    System.out.println("Card details fetched"); 
		}
		else
		{
		a=false;
		}
         return a;
	}

	@Override
	public String process(PaymentBean pb) 
	{
	   
	String usrid=pb.getUserID();
		tx=session.beginTransaction();
	    String cno=pb.getCreditCardNumber();
	    System.out.println("entered process and userID is "+usrid);
	    PaymentBean pay=(PaymentBean) session.get(PaymentBean.class,new String(usrid));
		double amount=pay.getBalance();
		
		String t=pay.getUserID();
		
		String hql=" from ReservationBean where userID='"+t+"'";
		Query q=session.createQuery(hql); 
        List<ReservationBean> d=q.list();
       /* double fare=d.get(0).getTotalFare();
		System.out.println("The entire ticket cost is "+fare);*/
        System.out.println("Fare correctly passed to Payment process and it is "+tf);
		double g=amount-tf;
		pay.setBalance(g);

		   try
		   {
		   session.save(pb);
		   }
		   catch(Exception e)
		   {
			  log.info("Error in saving session"+e);
		   }
			tx.commit();
		
		return "success";
					
	}
	
		
			
		
	

}
