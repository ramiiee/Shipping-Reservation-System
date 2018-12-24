package com.wipro.srs.dao;

import java.util.ArrayList;
import java.util.List;

import com.wipro.srs.bean.PassengerBean;

public interface PassengerDAO 
{
	 ArrayList<PassengerBean> viewPassengersByShip(String scheduleID);
}
