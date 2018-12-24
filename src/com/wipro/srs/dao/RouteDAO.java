package com.wipro.srs.dao;

import java.util.List;

import com.wipro.srs.bean.RouteBean;
import com.wipro.srs.bean.ShipBean;

public interface RouteDAO 
{
	 String addRoute(RouteBean rb, String source, String destination,String travelDuration, double fare);
	 int getFlag();
	 RouteBean viewByRouteID(String routeID);
	 boolean modifyRoute(RouteBean rmb);
	 RouteBean getRDetails(String rid);
	 List<RouteBean> viewByAllRoute(RouteBean rb);
	 int removeRoute(List<String> list);
	
}
