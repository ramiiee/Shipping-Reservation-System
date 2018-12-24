package com.wipro.srs.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.wipro.srs.bean.CredentialsBean;
import com.wipro.srs.bean.ProfileBean;
import com.wipro.srs.util.User;
import com.wipro.srs.util.impl.UserImpl;

@Controller
public class AdministratorController 
{
	static Logger log=Logger.getLogger(AdministratorController.class.getName());	
	 @RequestMapping(value = "/registration", method = RequestMethod.GET)
	   public ModelAndView registration() 
	 {
	     log.info("IN GET!!!!!!!!!"); 
		 return new ModelAndView("registration", "command", new ProfileBean());
	     
	   }
	   
	   @RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
	   public ModelAndView addCustomer(@ModelAttribute("registration")ProfileBean pb,BindingResult result,
	   ModelMap model) 
	   {
		   System.out.println(result.getErrorCount());
		   if(result.hasErrors())
		   {
			   return new ModelAndView("registration", "command", new ProfileBean());
		   }
		   else
		   {
		   model.addAttribute("firstName",pb.getFirstName());
		     	log.info("IN post!!!!!!!!!"); 
		     	User user = new UserImpl();
		       System.out.println("before passing to register from controller");
		     	user.register(pb);
		       System.out.println("registration success back to controller");
		        model.addAttribute("s",pb.getUserID());
		        return  new ModelAndView("result");
	   }
	   }
	  

}
