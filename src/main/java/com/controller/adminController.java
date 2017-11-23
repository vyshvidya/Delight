package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
@RequestMapping("/admin")
public class adminController
{
	@RequestMapping("/adding")
	public ModelAndView adding()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("adding");
		return mv;
	}

	@RequestMapping("/admin/adding")
	public String add()
	{
		return "adding";
	}
	
	
}

