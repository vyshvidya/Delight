package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Dao.CustomerOrderDao;
import com.Dao.UserDao;
import com.model.Customer;
import com.model.ShippingAddress;

@Controller
public class ShippingController
{
	@Autowired
	private CustomerOrderDao customerorderDao;
	
	@Autowired
	private UserDao userDao;
	
	@RequestMapping("/cart/add/shipping")
	public String addShipping(@ModelAttribute (name="shippingaddress") ShippingAddress shipping){
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = user.getUsername();
		Customer customer = userDao.customerbyemail(username);
		shipping.setUser(customer);
		customerorderDao.saveshipping(shipping);
		return "redirect:/cart/shippingaddressform";
	}

}


