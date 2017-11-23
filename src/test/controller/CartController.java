package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Dao.CartItemDao;
import com.Dao.ProductDAO;
import com.Dao.UserDao;

import com.model.Cart;
import com.model.CartItem;
import com.model.Customer;
import com.model.Product;

@Controller
public class CartController
{
	@Autowired
	UserDao userDaoImpl;
	
	@Autowired
	ProductDAO productDao;
	
	@Autowired
	CartItemDao cartitemDao;
	
	@RequestMapping("/cart/minus/{id}")
	public String minus(@PathVariable int id, Model model)
	{
		Product product = productDao.getProduct(id);
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = user.getUsername();
		Customer customer = userDaoImpl.customerbyemail(username);
		Cart cart = customer.getCart();
		List<CartItem> cartitems = cart.getCartitems();
		System.out.println(cart.getCartitems().size());
		
			for (CartItem cartitem : cartitems)
			{
				if (cartitem.getProducts().getProductId() == id)
				{
					if (cartitem.getQuantity() > 1) {
					cartitem.setQuantity(cartitem.getQuantity() - 1);
					cartitem.setTotalprice(cartitem.getProducts().getPrice() * cartitem.getQuantity());
					product.setStock(product.getStock() + 1);
					productDao.addProduct(product);
					cartitemDao.addtocart(cartitem);
					
				}
			}
		} 
			return "redirect:/cart/getcart";
	}

	@RequestMapping("/cart/plus/{id}")
	public String plus(@PathVariable int id, Model model) {
		Product product = productDao.getProduct(id);
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = user.getUsername();
		System.out.println(username);
		Customer customer = userDaoImpl.customerbyemail(username);
		Cart cart = customer.getCart();
		List<CartItem> cartitems = cart.getCartitems();
		System.out.println(cart.getCartitems().size());
		for (CartItem cartitem : cartitems) {
			if (product.getStock() > 0) {
				if (cartitem.getProducts().getProductId() == id) {
					cartitem.setQuantity(cartitem.getQuantity() + 1);
					cartitem.setTotalprice(cartitem.getProducts().getPrice() * cartitem.getQuantity());
					product.setStock(product.getStock() - 1);
					productDao.addProduct(product);
					cartitemDao.addtocart(cartitem);
					}
			}
		}
		return "redirect:/cart/getcart";
	}

@RequestMapping("/cart/addtocart/{id}")
public String addtocart(@PathVariable int id, @RequestParam int units, Model model) {
	Product product = productDao.getProduct(id);
	User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	String username = user.getUsername();
	Customer customer = userDaoImpl.customerbyemail(username);
	Cart cart = customer.getCart();
	System.out.println(cart.getCartitems().size());
	List<CartItem> cartitems = cart.getCartitems();
	for (CartItem cartitem : cartitems) {
		if(cartitem.getProducts().getCatId()==id){
			cartitem.setQuantity(cartitem.getQuantity()+1);
			cartitem.setTotalprice(product.getPrice()*cartitem.getQuantity());
			product.setStock(product.getStock()-1);
			productDao.addProduct(product);
			cartitemDao.addtocart(cartitem);
			model.addAttribute("units", cartitem.getQuantity());
			if (product.getStock() > 0) 
				return "redirect:/cart/getcart";
			else
				return "redirect:/all/products/viewproduct/{id}";
		}
		
	}
	CartItem cartitem = new CartItem();
	cartitem.setQuantity(1);
	cartitem.setProducts(product);
	cartitem.setCart(cart);
	cartitem.setTotalprice(product.getPrice());
	product.setStock(product.getStock() - units);
	productDao.addProduct(product);
	cartitemDao.addtocart(cartitem);
	model.addAttribute("units", cartitem.getQuantity());
	if (product.getStock() > 0) 
		return "redirect:/cart/getcart";
	else 
		return "redirect:/all/products/viewproduct/{id}";
}
@RequestMapping("/cart/getcart")
public String getcart(HttpSession session,Model model) {
	User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	String username = user.getUsername();
	System.out.println(username);
	Customer customer = userDaoImpl.customerbyemail(username);
	System.out.println(customer.getEmail());
	Cart cart = customer.getCart();
	System.out.println(cart.getCartitems().size());
	model.addAttribute("i", cart);
	session.setAttribute("count", cart.getCartitems().size());
	return "cart";
}

@RequestMapping("/cart/removecartitem/{cartitemid}")
public String removecartitem(@PathVariable int cartitemid,Model model) {

	cartitemDao.removecartitem(cartitemid);
	return "redirect:/cart/getcart";
}

@RequestMapping("/cart/removecart/{cartid}")
public String removecart(@PathVariable("cartid") int cartid,Model model) {

	cartitemDao.removeallcartitem(cartid);
	return "redirect:/cart/getcart";
}

}
