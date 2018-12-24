package com.wipro.srs.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.wipro.srs.bean.PassengerBean;
import com.wipro.srs.bean.ScheduleBean;
import com.wipro.srs.dao.PassengerDAO;
import com.wipro.srs.dao.impl.PassengerDaoImpl;
import com.wipro.srs.service.Administrator;
import com.wipro.srs.serviceimpl.AdministratorImpl;

@Controller
public class PassengerController 
{
	public ArrayList<PassengerBean> pbl=new ArrayList<PassengerBean>();
	
	@RequestMapping(value = "/viewPF")
	   public ModelAndView viewPF() {
	      return new ModelAndView("viewPassengersBySched", "command", new ScheduleBean());
	   }
	 
	 @RequestMapping(value = "/viewdPF", method = RequestMethod.POST)
	   public ModelAndView viewPassengersByShip(@ModelAttribute("hii") ScheduleBean schedule, 
			   ModelMap model) { 
			 PassengerDAO pdo=new PassengerDaoImpl();
			 
		
			 String sid=schedule.getScheduleID();
	
		     pbl=pdo.viewPassengersByShip(sid);
		     model.addObject("pblist", pbl);
		     return new ModelAndView("viewPassengers", "command", new PassengerBean());
		
	 }
	
	
}
