package com.wipro.srs.dao;

import java.util.List;

import com.wipro.srs.bean.ShipBean;

public interface ShipDAO 
{
	 String addShip(ShipBean sb, String shipName, int seatingCapacity,int reservationCapacity);
	 int getFlag();
	 ShipBean viewById(String shipID);
	 boolean modifyShip(ShipBean smb);
	 ShipBean getDetails(String sid);
     List<ShipBean> viewByAllShips(ShipBean sb);
	 int removeShip(List<String> list);
	
}
