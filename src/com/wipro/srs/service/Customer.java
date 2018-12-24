package com.wipro.srs.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.wipro.srs.bean.PassengerBean;
import com.wipro.srs.bean.ReservationBean;
import com.wipro.srs.bean.RouteBean;
import com.wipro.srs.bean.ScheduleBean;
import com.wipro.srs.bean.ShipBean;

public interface Customer {

	public ArrayList<ScheduleBean> viewScheduleByRoute (String src, String dest, Date date);

	public RouteBean fetchRB(String rid);

	public ShipBean fetchSB(String sid);

	public String reserveTicket(ReservationBean rb, List<PassengerBean> list3);

	public boolean cancelTicket(String g);

	public Map<ReservationBean, PassengerBean> viewTicket(String reservationID);



}
