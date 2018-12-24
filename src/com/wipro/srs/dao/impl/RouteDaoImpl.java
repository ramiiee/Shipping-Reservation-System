package com.wipro.srs.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;



import org.hibernate.Query;
import org.hibernate.Transaction;

import com.wipro.srs.bean.RouteBean;
import com.wipro.srs.dao.RouteDAO;
import com.wipro.srs.util.impl.HibernateUtil;

public class RouteDaoImpl implements RouteDAO 
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
	public String addRoute(RouteBean rb, String source, String destination,String travelDuration, double fare) 
	{
		
		tx=session.beginTransaction();
	
		String id_num=seqGen();
		String id=source.substring(0, 2)+destination.substring(0, 2)+id_num;
	
		rb.setRouteID(id);
	
		
		rb.setSource(source);
		rb.setDestination(destination);
		rb.setTravelDuration(travelDuration);
		rb.setFare(fare);
		session.save(rb);
	
		setFlag(1);
		tx.commit();
		return "";

	}

	@Override
	public RouteBean viewByRouteID(String routeID) 
	{
		tx=session.beginTransaction();
		RouteBean rb=(RouteBean) session.get(RouteBean.class,new String(routeID));
		tx.commit();
		return rb;
		
	}
	
	public boolean modifyRoute(RouteBean rmb) 
	{
		
		tx=session.beginTransaction();
		
	    String id=rmb.getRouteID();
	    
	    RouteBean rb=(RouteBean) session.get(RouteBean.class,new String(id));
	    rb.setSource(rmb.getSource());
		rb.setDestination(rmb.getDestination());
		rb.setTravelDuration(rmb.getTravelDuration());
		rb.setFare(rmb.getFare());
		session.update(rb);
	
	    tx.commit();
		return true;
				
	}
	
	
	public RouteBean getRDetails(String rid)
	{
		tx=session.beginTransaction();
		RouteBean rdet=(RouteBean) session.get(RouteBean.class,new String(rid));
		tx.commit();
		return rdet;
	}

	@Override
	public List<RouteBean> viewByAllRoute(RouteBean rb) 
	{
		tx=session.beginTransaction();
		org.hibernate.Session session=HibernateUtil.getSessionFactory().openSession();
		List<RouteBean> lst=new ArrayList<RouteBean>();
		Query query = session.createQuery("from RouteBean");
		lst=query.list();
		return lst;
	}

	@Override
	public int removeRoute(List<String> list)
	{
		
		session=HibernateUtil.getSessionFactory().openSession();
		Transaction tx=null;
		tx=session.beginTransaction();

		for(int i=0;i<list.size();i++)
		{
			String a=list.get(i);

			RouteBean rb=(RouteBean) session.get(RouteBean.class,new String(a));
			String RoID= rb.getRouteID();

			session.delete(rb);
			list.remove(i);
		
		}
		tx.commit();
		return 0;
	}

	
	
	
}
