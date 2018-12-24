package com.wipro.srs.dao;

import java.util.Date;
import java.util.List;

import com.wipro.srs.bean.ScheduleBean;

public interface ScheduleDAO {
	 String addSchedule(ScheduleBean sdb, String shipid, String routeid,String startDate);

	 int getFlag();

	 ScheduleBean viewByScheduleId(String scheduleID);

	 ScheduleBean getMDetails(String sid);

	 boolean modifySchedule(ScheduleBean smb);

	 List<ScheduleBean> viewByAllSchedule(ScheduleBean sb1);
	
	 int removeSchedule(List<String> list);



}
