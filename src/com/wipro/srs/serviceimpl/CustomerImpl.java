package com.wipro.srs.serviceimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.wipro.srs.bean.PassengerBean;
import com.wipro.srs.bean.ReservationBean;
import com.wipro.srs.bean.RouteBean;
import com.wipro.srs.bean.ScheduleBean;
import com.wipro.srs.bean.ShipBean;
import com.wipro.srs.dao.CustomerDAO;
import com.wipro.srs.dao.impl.CustomerDaoImpl;
import com.wipro.srs.service.Customer;

public class CustomerImpl implements Customer {

	@Override
	public ArrayList<ScheduleBean> viewScheduleByRoute(String src,String dest, Date date) 
    {
		CustomerDAO cds=new CustomerDaoImpl();
		return cds.viewScheduleByRoute(src, dest, date);
		
	}

	@Override
	public RouteBean fetchRB(String rid) 
	{
		CustomerDAO cd=new CustomerDaoImpl();
		return cd.fetchRB(rid);
	
	}

	@Override
	public ShipBean fetchSB(String sid) {
	CustomerDAO cd1=new CustomerDaoImpl();
	return cd1.fetchSB(sid);
	}

	@Override
	public String reserveTicket(ReservationBean rb, List<PassengerBean> list3) {
		CustomerDAO cdr=new CustomerDaoImpl();
		return cdr.reserveTicket(rb,list3);
		 
	}

	@Override
	public boolean cancelTicket(String g) {
		CustomerDAO cc=new CustomerDaoImpl();
		return cc.cancelTicket(g);
		
		
	}

	@Override
	public Map<ReservationBean, PassengerBean> viewTicket(String reservationID) {
		CustomerDAO vt=new CustomerDaoImpl();
		return vt.viewTicket(reservationID);
		
	}

}
