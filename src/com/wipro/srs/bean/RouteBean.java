package com.wipro.srs.bean;

public class RouteBean 
{
	private String routeID;
	private String source;
	private String destination;
	private String travelDuration;
	private double fare;
	/**
	 * @param null
	 */
	public RouteBean()
	{
		super();
		
	}
	/**
	 * 
	 * @param routeID routeID
	 * @param source source
	 * @param destination destination
	 * @param travelDuration travelDuration
	 * @param fare fare
	 */
	public RouteBean(String routeID, String source, String destination,
			String travelDuration, double fare) {
		super();
		this.routeID = routeID;
		this.source = source;
		this.destination = destination;
		this.travelDuration = travelDuration;
		this.fare = fare;
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
 * @return routeID
 */
	public String getSource() 
	{
		return source;
	}
/**
 * 	
 * @param source routeID
 */
	public void setSource(String source) 
	{
		this.source = source;
	}
/**
 * 	
 * @return destination
 */ 
	public String getDestination() 
	{
		return destination;
	}
/**
 * 	
 * @param destination destination
 */
	public void setDestination(String destination)
	{
		this.destination = destination;
	}
/**
 * 	
 * @return travelDuration
 */
	public String getTravelDuration()
	{
		return travelDuration;
	}
/**
 * 	
 * @param travelDuration travelDuration
 */
	public void setTravelDuration(String travelDuration)
	{
		this.travelDuration = travelDuration;
	}
/**
 * 	
 * @return fare
 */
	public double getFare()
	{
		return fare;
	}
/**
 * 	
 * @param fare fare
 */
	public void setFare(double fare) 
	{
		this.fare = fare;
	}
	
	
	
	
	
	
	
}
