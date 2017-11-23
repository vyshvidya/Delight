package com.Dao;

import java.util.List;

import com.model.Cart;
import com.model.CustomerOrder;
import com.model.ShippingAddress;

public interface CustomerOrderDao
{
	CustomerOrder Createorder(Cart cart,ShippingAddress s);
	 List<ShippingAddress> getshippingbyid(String id);
	 ShippingAddress getshipping(int id);
	 void saveshipping(ShippingAddress shipping);
	

}
