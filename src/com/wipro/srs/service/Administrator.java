package com.wipro.srs.service;

import java.util.Date;
import java.util.List;

import com.wipro.srs.bean.PassengerBean;
import com.wipro.srs.bean.RouteBean;
import com.wipro.srs.bean.ScheduleBean;
import com.wipro.srs.bean.ShipBean;

public interface Administrator 
{
	

	 String addShip(ShipBean sb, String shipName, int seatingCapacity,int reservationCapacity);

	 ShipBean viewById(String shipID);

	 boolean modifyShip(ShipBean smb);

	 ShipBean getDetails(String sid);

	 List<ShipBean> viewByAllShips(ShipBean sb);

	 String addRoute(RouteBean rb, String source, String destination,String travelDuration, double fare);
	
	 RouteBean viewByRouteID(String routeID);

	 boolean modifyRoute(RouteBean rmb);	
	
	 RouteBean getRDetails(String rid);

	 List<RouteBean> viewByAllRoute(RouteBean rb);

	 String addSchedule(ScheduleBean scb, String routeID, String shipID,String startDate);

	 ScheduleBean viewByScheduleId(String scheduleID);

	 ScheduleBean getMDetails(String sid);

	 boolean modifySchedule(ScheduleBean smb);

	 List<ScheduleBean> viewByAllSchedule(ScheduleBean sb1);

	 int removeShip(List<String> list);

	 int removeRoute(List<String> list);

	 int removeSchedule(List<String> list);
	
	 List<PassengerBean> viewPassengersByShip(String scheduleID);
}
