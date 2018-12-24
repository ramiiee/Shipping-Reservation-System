package com.wipro.srs.serviceimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.wipro.srs.bean.PassengerBean;
import com.wipro.srs.bean.RouteBean;
import com.wipro.srs.bean.ScheduleBean;
import com.wipro.srs.bean.ShipBean;
import com.wipro.srs.dao.CustomerDAO;
import com.wipro.srs.dao.PassengerDAO;
import com.wipro.srs.dao.RouteDAO;
import com.wipro.srs.dao.ScheduleDAO;
import com.wipro.srs.dao.ShipDAO;
import com.wipro.srs.dao.impl.CustomerDaoImpl;
import com.wipro.srs.dao.impl.PassengerDaoImpl;
import com.wipro.srs.dao.impl.RouteDaoImpl;
import com.wipro.srs.dao.impl.ScheduleDaoImpl;
import com.wipro.srs.dao.impl.ShipDaoImpl;
import com.wipro.srs.service.Administrator;

public class AdministratorImpl implements Administrator
{
	


	
	public String addShip(ShipBean sb, String shipName, int seatingCapacity,int reservationCapacity)
	{
		ShipDAO sd=new ShipDaoImpl();
		sd.addShip(sb, shipName, reservationCapacity, reservationCapacity);

	   String retVal=null;
		if(sd.getFlag()==1)
	   {
		
			retVal="added";  
	   }
		else if(sd.getFlag()==0)
		{
			retVal= "notadded";
		}
		else
		{
			retVal= "adderror";
		}
		return retVal;

	}

	@Override
	public ShipBean viewById(String shipID) {
		ShipDAO sd=new ShipDaoImpl();
		return sd.viewById(shipID);
	}

	@Override
	public boolean modifyShip(ShipBean smb)
	{
		//String retval="";
		ShipDAO smd=new ShipDaoImpl();
		smd.modifyShip(smb);
		//return retval;
		return true;
	}

	@Override
	public ShipBean getDetails(String sid) 
	{
		ShipDAO sdet=new ShipDaoImpl();
		return sdet.getDetails(sid);
		
	}

	@Override
	public List<ShipBean> viewByAllShips(ShipBean sb)
	{
	ShipDAO sv= new ShipDaoImpl();
	return sv.viewByAllShips(sb);
		
	}

	@Override
	public String addRoute(RouteBean rb, String source, String destination,String travelDuration, double fare)
	{
		RouteDAO rd=new RouteDaoImpl();
		rd.addRoute(rb, source,destination,travelDuration,fare);
		String retVal=null;
		if(rd.getFlag()==1)
			{
		   
			retVal="routeadd";  
			}
		else if(rd.getFlag()==0)
			{
			retVal= "routenotadd";
			}
		else
			{
			retVal= "adderror";
			}
		return retVal;
				
	}

	@Override
	public RouteBean viewByRouteID(String routeID) 
	{
		RouteDAO rdv=new RouteDaoImpl();
		return rdv.viewByRouteID(routeID);
		
	}

	@Override
	public RouteBean getRDetails(String rid)
	{
	    RouteDAO rdet=new RouteDaoImpl();
		return rdet.getRDetails(rid);
	}

	
	@Override
	public boolean modifyRoute(RouteBean rmb) 
	{
		
		RouteDAO rmd=new RouteDaoImpl();
		rmd.modifyRoute(rmb);
		return true;
	}

	@Override
	public List<RouteBean> viewByAllRoute(RouteBean rb)
	{
		RouteDAO rv= new RouteDaoImpl();
		return rv.viewByAllRoute(rb);
		
	}
	
	public String addSchedule(ScheduleBean scb, String routeID, String shipID,
			String startDate)
	{

		ScheduleDAO scd=new ScheduleDaoImpl();
		scd.addSchedule(scb, routeID, shipID, startDate);
		
	   String retVal=null;
		if(scd.getFlag()==1)
	   {
	
			retVal="added1";  
	   }
		else if(scd.getFlag()==0)
		{
			retVal= "notadded";
		}
		else
		{
			retVal= "adderror";
		}
		return retVal;

	}
	
	public ScheduleBean viewByScheduleId(String scheduleID)
	{
		ScheduleDAO sdv=new ScheduleDaoImpl();
		return sdv.viewByScheduleId(scheduleID);
	}
	
	public ScheduleBean getMDetails(String sid)
	{
		ScheduleDAO sda=new ScheduleDaoImpl();
		return sda.getMDetails(sid);
	}

	
	public boolean modifySchedule(ScheduleBean smb)
	{
		ScheduleDAO smd=new ScheduleDaoImpl();
		smd.modifySchedule(smb);
		return true;
	}
	
	public List<ScheduleBean> viewByAllSchedule(ScheduleBean sb1)
	{
		ScheduleDAO sdv= new ScheduleDaoImpl();
		return sdv.viewByAllSchedule(sb1);
	}

	@Override
	public int removeShip(List<String> list) 
	{
		ShipDAO sr=new ShipDaoImpl();
		return sr.removeShip(list);
	}

	@Override
	public int removeRoute(List<String> list)
	{
		RouteDAO rdao=new RouteDaoImpl(); 
		return rdao.removeRoute(list);
	}

	@Override
	public int removeSchedule(List<String> list) 
	{
		
		ScheduleDAO scdao=new ScheduleDaoImpl(); 
		return scdao.removeSchedule(list);
	}

	@Override
	public ArrayList<PassengerBean> viewPassengersByShip(String scheduleID) 
	{
		PassengerDAO sdv= new PassengerDaoImpl();
		return sdv.viewPassengersByShip(scheduleID);
	}

	
	

}
