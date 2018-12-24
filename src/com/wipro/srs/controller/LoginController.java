package com.wipro.srs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wipro.srs.bean.CredentialsBean;
import com.wipro.srs.bean.ProfileBean;
import com.wipro.srs.util.User;
import com.wipro.srs.util.impl.UserImpl;
@Controller 
public class LoginController 
{

	static String s;
	
	@RequestMapping(value = "/uipage", method = RequestMethod.GET)
	public ModelAndView uipage()
	{
	      return new ModelAndView("Home");
	}
	@RequestMapping(value = "/login_page", method = RequestMethod.GET)
	public ModelAndView login_page() 
	{
   		 return new ModelAndView("Login", "command", new CredentialsBean());
 	}
	@RequestMapping(value = "/head1", method = RequestMethod.GET)
	public ModelAndView head1() 
	{
   		 return new ModelAndView("top1");
 	}
	@RequestMapping(value = "/head", method = RequestMethod.GET)
	public ModelAndView head() 
	{
   		 return new ModelAndView("top");
 	}
	@RequestMapping(value = "/middle1", method = RequestMethod.GET)
	public ModelAndView middle1() 
	{
   		 return new ModelAndView("middle");
 	}
	@RequestMapping(value = "/au", method = RequestMethod.GET)
	public ModelAndView au() 
	{
   		 return new ModelAndView("aboutus");
 	}
	@RequestMapping(value = "/cu", method = RequestMethod.GET)
	public ModelAndView cu() 
	{
   		 return new ModelAndView("contactus");
 	}
	@RequestMapping(value = "/bottom1", method = RequestMethod.GET)
	public ModelAndView bottom1() 
	{
   		 return new ModelAndView("bottom");
 	}
	
	
//////////////////////////////////////////////Login////////////////////////////////////////////	
	 @RequestMapping(value = "/login1", method = RequestMethod.POST)
	  public ModelAndView login(@ModelAttribute("log")CredentialsBean cb, 
	   ModelMap model) 
	{
		s=cb.getUserID();
	 	System.out.println("User logged in is "+s);
		User u=new UserImpl();
	 	String a=u.login(cb);
	 	if(a.equals("A"))
	 	{
		 return  new ModelAndView("admin");
	    }
	 	else if(a.equals("C"))
		 {
		 return  new ModelAndView("customer");
		 }
	 	else
	 	{
	 		 model.addAttribute("id", "User name or Password Invalid");
		 return new ModelAndView("Login","command",new CredentialsBean());
		 
	 	}
	}
	 @RequestMapping(value="/logout",method=RequestMethod.POST)
	   public ModelAndView logout(@ModelAttribute("Logout")CredentialsBean cb,ModelMap model)
	   {

		  User u1=new UserImpl();
		  u1.logout(s);
		  return new ModelAndView("Login", "command", new CredentialsBean());
	   }
	 @RequestMapping(value = "/forgot", method = RequestMethod.GET)
		public ModelAndView forgot() 
		{
	   		 return new ModelAndView("forgot", "command", new ProfileBean());
	 	}
	 @RequestMapping(value="/forgot")
	   public ModelAndView forgot(@ModelAttribute ProfileBean pbf,ModelMap model,@RequestParam("userID") String userID,@RequestParam("mobileNo") String mobileNo,@RequestParam("newPassword") String newPassword )
	   {
	
		  User uf=new UserImpl();
		  uf.forgot(pbf,userID,mobileNo,newPassword);
		  return new ModelAndView("Login", "command", new ProfileBean());
	   }
	 @RequestMapping(value = "/change", method = RequestMethod.GET)
		public ModelAndView changePassword() 
		{
	   		 return new ModelAndView("change", "command", new ProfileBean());
	 	}
	 @RequestMapping(value="/changePassword")
	   public ModelAndView changePassword(@ModelAttribute ProfileBean pbc,ModelMap model,@RequestParam("userID") String userID,@RequestParam("newPassword") String newPassword )
	   {
	
		  User uc=new UserImpl();
		  uc.changePassword(pbc,userID,newPassword);
		  return new ModelAndView("Login", "command", new ProfileBean());
	   }


}
