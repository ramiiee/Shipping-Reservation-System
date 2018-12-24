package com.wipro.srs.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import com.wipro.srs.controller.AdministratorController;

public class ScheduleBean
{
	static Logger log=Logger.getLogger(AdministratorController.class.getName());	
	
	private String scheduleID;
	private String shipID;
	private String routeID;
	private Date startDate;
	
	/**
	 * @param null
	 */
	public ScheduleBean() 
	{
		super();
		
	}
	/**
	 * 
	 * @param scheduleID scheduleID
	 * @param shipID shipID
	 * @param routeID routeID
	 * @param startDate startDate
	 */
	public ScheduleBean(String scheduleID, String shipID, String routeID,Date startDate) 
	{
		super();
		this.scheduleID = scheduleID;
		this.shipID = shipID;
		this.routeID = routeID;
		this.startDate = startDate;
	}
	
/**
 * 
 * @return scheduleID
 */
	public String getScheduleID() 
	{
		return scheduleID;
	}
/**
 * 	
 * @param scheduleID scheduleID
 */
	public void setScheduleID(String scheduleID) 
	{
		this.scheduleID = scheduleID;
	}
/**
 * 	
 * @return shipID
 */
	public String getShipID()
	{
		return shipID;
	}
/**
 * 	
 * @param shipID shipID
 */
	public void setShipID(String shipID) 
	{
		this.shipID = shipID;
	}
/**
 * 	
 * @return routeID
 */
	public String getRouteID() 
	{
		return routeID;
	}
/**
 * 	
 * @param routeID routeID
 */
	public void setRouteID(String routeID)
	{
		this.routeID = routeID;
	}
/**
 * 	
 * @return startDate
 */
	public Date getStartDate() 
	{	return startDate;
	}
/**
 * 	
 * @param startDate startDate
 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
/**
 * 	
 * @param startDate startDate
 */
	public void setStartDate(String startDate) 
	{
		try
		{
		Date d=new Date();
		SimpleDateFormat sf=new SimpleDateFormat("dd/MM/yyyy");
		d=sf.parse(startDate);
		this.startDate =d;
		}
		catch(Exception e)
		{
			log.info("Date Error"+e);
			
		}
	}
	
		
	
	
	
}
