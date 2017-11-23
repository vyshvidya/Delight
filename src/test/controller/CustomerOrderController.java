package com.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Dao.CartItemDao;
import com.Dao.CustomerOrderDao;
import com.Dao.UserDao;
import com.model.Cart;
import com.model.Customer;
import com.model.CustomerOrder;
import com.model.ShippingAddress;

@Controller
public class CustomerOrderController 
{
	@Autowired
	private CartItemDao cartitemDao;

	@Autowired
	private UserDao userDao;

	@Autowired
	private CustomerOrderDao customerorderDao;

	@RequestMapping("/cart/shippingaddressform")
	public String getShippingform(Model model) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = user.getUsername();
		Customer customer = userDao.customerbyemail(username);
		String emailId = customer.getEmail();
		System.out.println(emailId);
		List<ShippingAddress> shipping= customerorderDao.getshippingbyid(emailId);
		System.out.println(shipping.size());
		model.addAttribute("shipping", shipping);
		model.addAttribute("shippingaddress", new ShippingAddress());
		return "shippingaddress";

	}

	@RequestMapping("/cart/order/{id}")
	public String createorder(@ModelAttribute ShippingAddress shippingaddress,HttpSession session, Model model,@PathVariable int id) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = user.getUsername();
		Customer customer = userDao.customerbyemail(username);
		Cart cart = customer.getCart();
		ShippingAddress s=customerorderDao.getshipping(id);
		cart.setUser(customer);
		CustomerOrder customerorder = customerorderDao.Createorder(cart,s);
		String pattern = "dd-MM-yyyy";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Date date = new Date();
		Random rand = new Random();
		int i = 2 + rand.nextInt(3);
		System.out.println(i);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, i);
		String d = sdf.format(c.getTime());
		System.out.println(d);
		int dd = c.get(Calendar.DATE);
		long yy = c.get(Calendar.YEAR);
		String mm = new SimpleDateFormat("MMM").format(c.getTime());
		String day = new SimpleDateFormat("EE").format(c.getTime());
		String delivery=day + ", " + mm + " " + dd + " " + yy;
		session.setAttribute("delivery",delivery);
		session.setAttribute("username",username);
		model.addAttribute("order", customerorder);
		model.addAttribute("Cartid", cart.getId());
		return "orderdetails";
	}

	@RequestMapping("/cart/confirm")
	public String confirm() {
		return "payment";
	}

	@RequestMapping("/cart/thankyou")
	public String cash(Model model) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = user.getUsername();
		Customer customer = userDao.customerbyemail(username);
		Cart cart = customer.getCart();
		cartitemDao.aftercheckout(cart.getId());
		return "thankyou";
	}

}


