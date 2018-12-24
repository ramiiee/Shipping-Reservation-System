package com.wipro.srs.bean;

import java.util.ArrayList;
import java.util.List;

public class ShipBean 
{
	private String shipID;
	
	private String shipName;
	
	private int seatingCapacity;
	
	private int reservationCapacity;
	
	private List<ShipBean> list=new ArrayList<ShipBean>();

	/**
	 * 
	 * @return list
	 */
	public List<ShipBean> getList() {
		return list;
	}

	/**
	 * 
	 * @param list list
	 */
	public void setList(List<ShipBean> list) {
		this.list = list;
	}

	/**
	 * @param null
	 */
	public ShipBean() 
	{
		super();
		
	}

	/**
	 * 
	 * @param shipID shipID
	 * @param shipName shipName
	 * @param seatingCapacity seatingCapacity
	 * @param reservationCapacity reservationCapacity
	 */
	public ShipBean(String shipID, String shipName, int seatingCapacity,
			int reservationCapacity) 
	{
		super();
		this.shipID = shipID;
		this.shipName = shipName;
		this.seatingCapacity = seatingCapacity;
		this.reservationCapacity = reservationCapacity;
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
 * @return shipName
 */
	public String getShipName() 
	{
		return shipName;
	}
/**
 * 
 * @param shipName shipName
 */
	public void setShipName(String shipName) 
	{
		this.shipName = shipName;
	}
/**
 * 
 * @return seatingCapacity
 */
	public int getSeatingCapacity() {
		return seatingCapacity;
	}
/**
 * 
 * @param seatingCapacity seatingCapacity
 */
	public void setSeatingCapacity(int seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}
/**
 * 
 * @return reservationCapacity
 */
	public int getReservationCapacity() {
		return reservationCapacity;
	}
/**
 * 
 * @param reservationCapacity reservationCapacity
 */
	public void setReservationCapacity(int reservationCapacity) {
		this.reservationCapacity = reservationCapacity;
	}
	
}
