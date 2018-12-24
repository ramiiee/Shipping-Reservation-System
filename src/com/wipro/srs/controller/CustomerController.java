package com.wipro.srs.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wipro.srs.bean.PassengerBean;
import com.wipro.srs.bean.PaymentBean;
import com.wipro.srs.bean.ProfileBean;
import com.wipro.srs.bean.ReservationBean;
import com.wipro.srs.bean.RouteBean;
import com.wipro.srs.bean.ScheduleBean;
import com.wipro.srs.bean.ShipBean;

import com.wipro.srs.service.Customer;

import com.wipro.srs.serviceimpl.CustomerImpl;
import com.wipro.srs.util.Payment;
import com.wipro.srs.util.impl.PaymentImpl;

@Controller
public class CustomerController 
{
	String sdid;
	private List<PassengerBean> list3=new ArrayList<>();
	private List<ScheduleBean> list=new ArrayList<>();
	private List<RouteBean> list1=new ArrayList<>();
	private List<ShipBean> list2=new ArrayList<>();
	public List<PassengerBean> getList3() {
		return list3;
	}
	public void setList3(List<PassengerBean> list3) {
		this.list3 = list3;
	}
	public List<ScheduleBean> getList() {
		return list;
	}
	public void setList(List<ScheduleBean> list) {
		this.list = list;
	}
	public List<RouteBean> getList1() {
		return list1;
	}
	public void setList1(List<RouteBean> list1) {
		this.list1 = list1;
	}
	public List<ShipBean> getList2() {
		return list2;
	}
	public void setList2(List<ShipBean> list2) {
		this.list2 = list2;
	}
	private Customer customer=new CustomerImpl();
	public Customer getCustomer() 
	{
		return customer;
	}
	public void setCustomer(Customer customer) 
	{
		this.customer = customer;
	}
	
	
	@RequestMapping(value = "/chome", method = RequestMethod.GET)
	   public ModelAndView chome() 
	 	{
	    
		 return new ModelAndView("customer");
	     
	 	}
	
	
	
	@RequestMapping(value = "/Viewby", method = RequestMethod.GET)
	   public ModelAndView Viewby() 
	 	{
	    
		 return new ModelAndView("custviewBySched", "command", new RouteBean());
	     
	 	}
	
	@RequestMapping(value = "check", method = RequestMethod.POST)
	public String check(@RequestParam("source") String src,@RequestParam("destination")String dest,@RequestParam("date") Date date,@ModelAttribute RouteBean rb,ModelMap model) {

		/*String src=rb.getSource();
		String dest=rb.getDestination();*/
	
		list.clear();
		list1.clear();
		list2.clear();
		list=customer.viewScheduleByRoute(src,dest,date);
	
		Iterator itr=list.iterator();
		while(itr.hasNext())
		{
		
			ScheduleBean rbv=(ScheduleBean) itr.next();
		  
			String rid=rbv.getRouteID();
			String sid=rbv.getShipID();
		 
		   Customer c=new CustomerImpl();
		   RouteBean rbv1=new RouteBean();
		   rbv1=c.fetchRB(rid);
		   ShipBean  sbv1=c.fetchSB(sid);
		   list1.add(rbv1);
		   list2.add(sbv1);
		}
		if(list.size()==0)
		{
			return "noships";
		}
		else
		{
        model.addObject("j", list);
		model.addObject("k",list1);
		model.addObject("l",list2);
		return "ships";
		}
}   
	
	
	@RequestMapping(value = "/reserve", method = RequestMethod.GET)
	   public ModelAndView reserve(@RequestParam("id") String scid) 
	 	{
		 
	
	     sdid=scid;

	     list3.clear();
	     return new ModelAndView("booking", "command", new PassengerBean());
	 	}
	

	@RequestMapping(value = "/book", method = RequestMethod.POST)
	   public ModelAndView book(@ModelAttribute PassengerBean pb) 
	{
	

		list3.add(pb);
	
	    return new ModelAndView("booking", "command", new PassengerBean());
		
	}
	
	
	@RequestMapping(value = "/confirmbooking", method = RequestMethod.POST)
	   public ModelAndView book(@ModelAttribute ReservationBean rb,ModelMap model) 
	{
		
		rb.setUserID(LoginController.s);
		rb.setNoOfSeats(list3.size());
		rb.setBookingDate(new Date());
		rb.setScheduleID(sdid);
		String a=rb.getUserID();
		int b=rb.getNoOfSeats();
	
		
        String retvala=customer.reserveTicket(rb,list3);
	    if(retvala.equalsIgnoreCase("success"))
	    {
	    	model.addAttribute("s",rb.getReservationID());
	    	model.addAttribute("i", rb.getUserID());
	    	return new ModelAndView("payment","command", new PaymentBean());
	    	
	    }
	    else
	    {
	    	return new ModelAndView("fail", "command", new PassengerBean());
	    }
		
	}
	

	@RequestMapping(value = "/canceltkt", method = RequestMethod.GET)
	public ModelAndView canceltkt(ModelMap model) 
	{
	    return new ModelAndView("cancelticket","command",new ReservationBean());
	 }
	@RequestMapping(value = "/cancel", method = RequestMethod.POST)
	public ModelAndView cancel(@RequestParam("reservationID") String g,ModelMap model) 
	{
		boolean j=customer.cancelTicket(g);
		if(j)
		{
			
			model.addAttribute("id","Ticket Cancelled");
			return new ModelAndView("customer");
		}
		return  new ModelAndView("customer");
	
	}
	
	@RequestMapping(value = "/pay", method = RequestMethod.POST)
	public ModelAndView pay(@ModelAttribute PaymentBean pb,ModelMap model) {
	
	
		String a;
		pb.setUserID(LoginController.s);
		Payment payment=new PaymentImpl();
		
		String urid=LoginController.s;
		System.out.println("User who is making the payment is "+urid);
		boolean b=payment.findByCardNumber(urid,pb.getCreditCardNumber());
		if(b)
		{ 
			
			
			String j=payment.process(pb);
			
			if(j.equalsIgnoreCase("success"))
				
			{     
	  
				  model.addObject("id","TicketBooked");
				  return new ModelAndView("customer");
			}
		}
		
		else
		{
			model.addObject("id","credit card invalid");
			return new ModelAndView("payment","command", new PaymentBean());
		}
		
		
	   return new ModelAndView();
	}
	
	
	@RequestMapping(value = "/viewtkt", method = RequestMethod.GET)
	public ModelAndView view(ModelMap model) 
	{
	    return new ModelAndView("viewticket","command",new ReservationBean());
	}
	@RequestMapping(value = "/viewTicket", method = RequestMethod.POST)
	public String viewTicket(@RequestParam("reservationID") String g,ModelMap model)
	{
		
		Map<ReservationBean, PassengerBean> j=customer.viewTicket(g);
		
		model.addAttribute("rb",j);
	
		return  "viewticketdetails";
	
	}
	
	
	
	
	
	
	

}
