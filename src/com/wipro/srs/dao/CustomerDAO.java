package com.wipro.srs.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.wipro.srs.bean.PassengerBean;
import com.wipro.srs.bean.PaymentBean;
import com.wipro.srs.bean.ReservationBean;
import com.wipro.srs.bean.RouteBean;
import com.wipro.srs.bean.ScheduleBean;
import com.wipro.srs.bean.ShipBean;

public interface CustomerDAO 
{
	 ArrayList<ScheduleBean> viewScheduleByRoute (String src, String dest, Date date);

	 RouteBean fetchRB(String rid);

	 ShipBean fetchSB(String sid);

	 String reserveTicket(ReservationBean rb, List<PassengerBean> list3);

	 boolean cancelTicket(String g);

	 Map<ReservationBean, PassengerBean> viewTicket(String reservationID);

	 boolean findByCardNumber(String urid, String creditCardNumber);

	 String process(PaymentBean pb);

}
