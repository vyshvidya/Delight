package com.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Dao.ProductDAO;


@Controller
public class pageController
{
	@Autowired
	ProductDAO productDAO;
	
	
	@RequestMapping(value="/login")
	public String showLoginPage(@RequestParam(value = "error", required = false) String error, 
			@RequestParam(value = "logout", required = false) String logout,Model m)
	{
		if(error != null) {
			m.addAttribute("error", "Username or Password Incorrect");
			}
		
		if(logout != null) {
			m.addAttribute("logout", "Logged out Successfully");
			}
		return "login";
	}

	/*@RequestMapping(value="login_success")
	public String loginSuccess(Model m,HttpSession session)
	{
		String page_Url=null;
		String role_name=null;
		boolean loggedIn=false;
		
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
	
		String logged_UserName=authentication.getName();
		session.setAttribute("username",logged_UserName);
		Collection<GrantedAuthority> authorities=(Collection<GrantedAuthority>)authentication.getAuthorities();
		
		for(GrantedAuthority role:authorities)
		{
			if(role.getAuthority().equals("ROLE_ADMIN"))
			{
				loggedIn=true;
				page_Url="AdminHome";
				role_name="ROLE_ADMIN";
			}
			else
			{
				m.addAttribute("productList",productDAO.retrieveProducts());
				loggedIn=true;
				page_Url="UserHome";
				role_name="ROLE_USER";
			}
		}
		
		session.setAttribute("loggedIn",loggedIn);
		session.setAttribute("role",role_name);
		return page_Url;
	}
	*/
	/*@RequestMapping("/error")
	
	public String errorPage()
	{
		return "/error";
	}
	
	@RequestMapping("/userLogged")
	
	public String userLogged()
	{
		return "redirect:/index";
	}*/
	
	


}
