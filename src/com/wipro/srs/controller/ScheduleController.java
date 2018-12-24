package com.wipro.srs.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wipro.srs.bean.RouteBean;
import com.wipro.srs.bean.ScheduleBean;
import com.wipro.srs.bean.ShipBean;
import com.wipro.srs.service.Administrator;
import com.wipro.srs.serviceimpl.AdministratorImpl;


	@Controller
	public class ScheduleController 
	{
		private List <ScheduleBean> sv=new ArrayList<ScheduleBean>();
		private List <String> list=new ArrayList<String>();
		 public List<ScheduleBean> getSv() {
			return sv;
		}

		public void setSv(List<ScheduleBean> sv) {
			this.sv = sv;
		}

		public List<String> getList() {
			return list;
		}

		public void setList(List<String> list) {
			this.list = list;
		}
		String a;
		 @RequestMapping(value = "/scheduleAdd", method = RequestMethod.GET)
		   public ModelAndView addSchedule() 
		 {
		     
			 return new ModelAndView("schedule", "command", new ShipBean());
		     
		   }
		   
		   @RequestMapping(value = "/addSchedule", method = RequestMethod.POST)
		   public String addSchedule(@ModelAttribute ScheduleBean scb,ModelMap model,@RequestParam("routeID") String routeID,@RequestParam("shipID") String shipID,@RequestParam("startDate") String startDate) 
		   {
			   String retVal=null;
			   Administrator as=new AdministratorImpl();
			   retVal=as.addSchedule(scb,routeID,shipID,startDate);
			   return retVal;
		   }
		   
		   @RequestMapping(value = "/viewSchedule", method = RequestMethod.GET)
		   public String view() 
		 {
		    
			 return "searchschedule";
		     
		   }
		   
		   @RequestMapping(value = "/viewByScheduleId", method = RequestMethod.POST)
		   public String viewByScheduleId(@ModelAttribute("scheduleID") ScheduleBean sdb,ModelMap model,@RequestParam("scheduleID") String scheduleID) 
		   {
			   //String retVal=null;
			 
			   	Administrator a1=new AdministratorImpl();
				ScheduleBean sbvw=new ScheduleBean();
				sbvw=a1.viewByScheduleId(scheduleID);
				model.addAttribute("date",sbvw.getStartDate().toString() );
				model.addAttribute("d",sbvw);
				//return retVal;
				return "schedules";
		   }
	
		   @RequestMapping(value = "/modiContr", method = RequestMethod.GET)
		   public ModelAndView edit(@ModelAttribute RouteBean sb,@RequestParam("id") String sid,ModelMap model) 
		 {
		     
		      Administrator a2=new AdministratorImpl();
		      ScheduleBean shb=new ScheduleBean();
		      a=sid;
		      shb=a2.getMDetails(sid);
		     return new ModelAndView("modify","command",shb);
		     
		   }
		  
		   
		   @RequestMapping(value = "/modifyscv", method = RequestMethod.POST)
		   public String modifySchedule(@ModelAttribute ("AAA") ScheduleBean smb,ModelMap model) 
		   {
			   
			   boolean ru;
			
			   Administrator ms=new AdministratorImpl();
			   smb.setScheduleID(a);
			   ru=ms.modifySchedule(smb);
			   
			  if(ru=true)
			  {
				 return "msuccess";
			  }
			  else
			  {
				 return "error";
			  }
			 
			   
		   }
		   
		   @RequestMapping(value = "/viewAllScontr", method = RequestMethod.GET)
		   public ModelAndView viewByAllSchedule(@ModelAttribute ScheduleBean sb1,ModelMap model) 
		 {
		
		     Administrator asv=new AdministratorImpl();
		    
		     sv=asv.viewByAllSchedule(sb1);
		     model.addAttribute("i",sv);
		     return new ModelAndView("viewAllSchedule","command","new ScheduleBean()");
		     
		   }
		   
		   
		   @RequestMapping(value = "delete_schedule")
		     public  String delete_schedule(@RequestParam("id") String g, ModelMap model)
			 {
				
				 list.add(g);
				 Iterator itr= sv.iterator();
					while(itr.hasNext())
					{
					  ScheduleBean sb=(ScheduleBean) itr.next();
					  if(sb.getScheduleID().equals(g))
					  {
						  itr.remove();
					  }
					}
						 
						return "divert2";
			 }
			 @RequestMapping(value = "renew2")
		     public String renew1(@ModelAttribute("aaa")ScheduleBean sb,
					   ModelMap model)
			 {
				 model.addObject("i",sv);
				    return "viewAllSchedule";
				 
			 }
			 @RequestMapping(value = "confirm2", method=RequestMethod.POST)
		     public String confirm1(@ModelAttribute("aaa")ScheduleBean rb,
					   ModelMap model)
			 {  
				
				Administrator ad=new AdministratorImpl();
				ad.removeSchedule(list);
				return "deletesuccess";
				 
			 }
		}
	
		
	

