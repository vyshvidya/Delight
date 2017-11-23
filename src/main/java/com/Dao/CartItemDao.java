package com.Dao;

import com.model.Cart;

import com.model.CartItem;

public interface CartItemDao {
	void addtocart(CartItem cartitem);
	void removecartitem(int cartitemid);
	void removeallcartitem(int cartid);
	void aftercheckout(int cartid);
	Cart getCart(int id);
	int getcartcount(int id);
}


