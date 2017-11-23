package com.controller;

import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.Dao.UserDao;
import com.model.Customer;


@Controller
public class indexController {
	@Autowired
	UserDao userDao;
	

	@RequestMapping({"/","/userLogged"})
	public String home() {
		return "index";
	}
	/*@RequestMapping("/register")
	public String goToregister()
	{
		return "register";
	}*/
	@RequestMapping(value="register", method=RequestMethod.GET)
	   public ModelAndView goToRegister()
	   {
		   ModelAndView mv=new ModelAndView(); 
	       mv.addObject("user",new Customer());
	       mv.setViewName("register");
	       return mv;
		   }
	   
	   @RequestMapping(value="saveregister", method=RequestMethod.POST)
	   public ModelAndView saveUser(@ModelAttribute("user")Customer user)
	   {
	       ModelAndView mv=new ModelAndView();
		   user.setRole("ROLE_USER");
		   userDao.insertUser(user);
		   mv.setViewName("index");
		   return mv;
		   
		   
		   
	   }
	   @RequestMapping(value="aboutus", method=RequestMethod.GET)
	   public ModelAndView goToaboutus()
	   {
		   ModelAndView mv=new ModelAndView(); 
	      
	       mv.setViewName("aboutus");
	       return mv;
		   }
	   
	}
