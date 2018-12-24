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

import com.wipro.srs.bean.ProfileBean;
import com.wipro.srs.bean.ShipBean;
import com.wipro.srs.service.Administrator;
import com.wipro.srs.serviceimpl.AdministratorImpl;
import com.wipro.srs.util.User;
import com.wipro.srs.util.impl.UserImpl;




@Controller
public class ShipController 
{
	private List <ShipBean> sv=new ArrayList<ShipBean>();
	private List <String> list=new ArrayList<String>();
	 
	public List<ShipBean> getSv() {
		return sv;
	}

	public void setSv(List<ShipBean> sv) {
		this.sv = sv;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	@RequestMapping(value = "/addShip", method = RequestMethod.GET)
	   public ModelAndView addShip() 
	 {
	   
		 return new ModelAndView("addShip", "command", new ShipBean());
	     
	   }
	   
	   @RequestMapping(value = "/addShip", method = RequestMethod.POST)
	   public String addShip(@ModelAttribute ShipBean sb,ModelMap model,@RequestParam("shipName") String shipName,@RequestParam("seatingCapacity") int seatingCapacity,@RequestParam("reservationCapacity") int reservationCapacity) 
	   {
		   String retVal=null;
		   Administrator as=new AdministratorImpl();
		   retVal=as.addShip(sb,shipName,seatingCapacity,reservationCapacity);
		   return retVal;
	   }
	   
	   @RequestMapping(value = "/admin")
	   public ModelAndView admin() 
	 {
	     
		 return new ModelAndView("admin", "command", new ShipBean());
	     
	   }
	   
	   
	   
	   @RequestMapping(value = "/view", method = RequestMethod.GET)
	   public String viewById() 
	 {
	
		 return "display";
	     
	   }
	   
	   @RequestMapping(value = "/viewById", method = RequestMethod.POST)
	   public String viewById(@ModelAttribute("shipID") ShipBean sb,ModelMap model,@RequestParam("shipID") String shipID) 
	   {
		   //String retVal=null;
		   
		   	Administrator av=new AdministratorImpl();
			ShipBean sbvw=new ShipBean();
			sbvw=av.viewById(shipID);
            model.addObject("s",sbvw);
			//return retVal;
			return "viewresult";
	   }
	   
	   
	   
	   @RequestMapping(value = "/editcontr", method = RequestMethod.GET)
	   public ModelAndView edit(@ModelAttribute ShipBean sb,@RequestParam("id") String sid,ModelMap model) 
	 {
	    
	      Administrator adet=new AdministratorImpl();
	      ShipBean shipdet=new ShipBean();
	      shipdet=adet.getDetails(sid);
	     return new ModelAndView("edit","command",shipdet);
	     
	   }
	  
	   
	   @RequestMapping(value = "/modify", method = RequestMethod.POST)
	   public String modifyShip(@ModelAttribute ShipBean smb,ModelMap model,@RequestParam("shipName") String shipName,@RequestParam("seatingCapacity") int seatingCapacity,@RequestParam("reservationCapacity") int reservationCapacity) 
	   {
		   //String retVal=null;
		   boolean che;
		  
		   Administrator ms=new AdministratorImpl();
		   che=ms.modifyShip(smb);
		   //return retVal;
		 if(che=true)
		 {
			 return "msuccess";
		 }
		 else
		 {
			 return "error";
		 }
		 
		   
	   }
	   
	   @RequestMapping(value = "/viewAllcontr", method = RequestMethod.GET)
	   public ModelAndView viewByAllShips(@ModelAttribute ShipBean sb,ModelMap model) 
	 {
	     
	     Administrator av=new AdministratorImpl();
	 
	     sv=av.viewByAllShips(sb);
	     model.addObject("c",sv);
	     return new ModelAndView("viewAll","command","c");
	     
	   }
	  
	   
	   @RequestMapping(value = "delete_ship")
	     public  String delete(@RequestParam("id") String g, ModelMap model)
		 {

			 list.add(g);
		Iterator itr= sv.iterator();
		while(itr.hasNext())
		{
		  ShipBean sb=(ShipBean) itr.next();
		  if(sb.getShipID().equals(g))
		  {
			  itr.remove();
		  }
		}
			
			return "divert";
			 
		 }
		 
		 @RequestMapping(value = "renew")
	     public String renew(@ModelAttribute("aaa")ShipBean sb,
				   ModelMap model)
		 {
			 model.addObject("c",sv);
			    return "viewAll";
			 
		 }
		 @RequestMapping(value = "confirm", method=RequestMethod.POST)
	     public String confirm(@ModelAttribute("aaa")ShipBean sb,
				   ModelMap model)
		 {  
			Administrator ad=new AdministratorImpl();
		    ad.removeShip(list);
			return "deletesuccess";
			 
			 
		 }

}
