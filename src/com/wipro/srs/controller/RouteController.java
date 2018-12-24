package com.wipro.srs.controller;

import java.util.ArrayList;
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
import com.wipro.srs.bean.ShipBean;
import com.wipro.srs.service.Administrator;
import com.wipro.srs.serviceimpl.AdministratorImpl;

@Controller
public class RouteController 
{
	private List <RouteBean> rv=new ArrayList<RouteBean>();
	private List <String> list=new ArrayList<String>();
	
		
		 public List<RouteBean> getRv() {
		return rv;
	}

	public void setRv(List<RouteBean> rv) {
		this.rv = rv;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

		@RequestMapping(value = "/addRoute", method = RequestMethod.GET)
		   public ModelAndView addRoute() 
		 	{
	
			 return new ModelAndView("addroute", "command", new RouteBean());
		     
		 	}
		   
		   @RequestMapping(value = "/addRoute", method = RequestMethod.POST)
		   public String addRoute(@ModelAttribute RouteBean rb,ModelMap model,@RequestParam("source") String source,@RequestParam("destination") String destination,@RequestParam("travelDuration") String travelDuration,@RequestParam("fare") double fare) 
		   {
			   String retVal=null;
		
			   Administrator as=new AdministratorImpl();
			   retVal=as.addRoute(rb,source,destination,travelDuration,fare);
			   return retVal;
		   }
		   
		   @RequestMapping(value = "/viewRoute", method = RequestMethod.GET)
		   public String view() 
		   {
		   
			 return "searchroute";
		     
		   }
		   
		   @RequestMapping(value = "/viewByRouteId", method = RequestMethod.POST)
		   public String viewByRouteId(@ModelAttribute("routeID") RouteBean sb,ModelMap model,@RequestParam("routeID") String routeID) 
		   {
			   //String retVal=null;
			  
			   	Administrator av=new AdministratorImpl();
				RouteBean rbvw=new RouteBean();
				rbvw=av.viewByRouteID(routeID);
	            model.addObject("r",rbvw);
				//return retVal;
				return "routes";
		   }
		   
		   
		   
		   @RequestMapping(value = "/editrcontr", method = RequestMethod.GET)
		   public ModelAndView edit(@ModelAttribute RouteBean sb,@RequestParam("id") String rid,ModelMap model) 
		   {
		     
		      Administrator rdet=new AdministratorImpl();
		      RouteBean routedet=new RouteBean();
		      routedet=rdet.getRDetails(rid);
		     return new ModelAndView("editroute","command",routedet);
		     
		   }
		  
		   
		   @RequestMapping(value = "/modifyr", method = RequestMethod.POST)
		   public String modifyRoute(@ModelAttribute RouteBean rmb,ModelMap model,@RequestParam("source") String source,@RequestParam("destination") String destination,@RequestParam("travelDuration") String travelDuration,@RequestParam("fare") double fare) 
		   {
			   
			   boolean ru;
			
			   Administrator ms=new AdministratorImpl();
			   ru=ms.modifyRoute(rmb);
			   
			   if(ru=true)
			   	{
				 return "msuccess";
			   	}
			   else
			   {
				 return "error";
			   }
			 
			   
		   }
		   
		   
		   @RequestMapping(value = "/viewAllRcontr", method = RequestMethod.GET)
		   public ModelAndView viewByAllRoute(@ModelAttribute RouteBean rb,ModelMap model) 
		 {
		   
		     Administrator arv=new AdministratorImpl();
		     rv=arv.viewByAllRoute(rb);
		     model.addObject("c",rv);
		     return new ModelAndView("viewAllRoute","command","c");
		     
		   }
		  
		   
		   @RequestMapping(value = "delete_route")
		     public  String delete_route(@RequestParam("id") String g, ModelMap model)
			 {
				 
				 list.add(g);
				 Iterator itr= rv.iterator();
					while(itr.hasNext())
					{
					  RouteBean sb=(RouteBean) itr.next();
					  if(sb.getRouteID().equals(g))
					  {
						  itr.remove();
					  }
					}
						 
						return "divert1";
			 }
			 @RequestMapping(value = "renew1")
		     public String renew1(@ModelAttribute("aaa")RouteBean sb,
					   ModelMap model)
			 {
				 model.addObject("c",rv);
				  return "viewAllRoute";
				 
			 }
			 @RequestMapping(value = "confirm1", method=RequestMethod.POST)
		     public String confirm1(@ModelAttribute("aaa")RouteBean rb,
					   ModelMap model)
			 {  
				
				Administrator ad=new AdministratorImpl();
				ad.removeRoute(list);
				return "deletesuccess";
				 
			 }
			
		   
	
	
	
}
