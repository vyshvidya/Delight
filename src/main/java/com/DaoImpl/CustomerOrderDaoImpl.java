package com.DaoImpl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Dao.CustomerOrderDao;
import com.model.Cart;
import com.model.CartItem;
import com.model.Customer;
import com.model.CustomerOrder;
import com.model.ShippingAddress;

@Repository
@Transactional
public class CustomerOrderDaoImpl implements CustomerOrderDao
{
	@Autowired
	private SessionFactory sessionFactory;
	public CustomerOrder Createorder(Cart cart,ShippingAddress s) {
		Session session=sessionFactory.getCurrentSession();
		List<CartItem> cartitems=cart.getCartitems();
		double grandtotal=0;
		for(CartItem cartitem: cartitems)
			grandtotal=cartitem.getTotalprice()+grandtotal;
		cart.setGrandtotal(grandtotal);
		Customer customer= cart.getUser();
		CustomerOrder customerorder= new CustomerOrder();
		customerorder.setDate(new Date());
		customerorder.setCart(cart);
		customerorder.setUser(customer);
		customerorder.setBillingaddress(customer.getBillingaddress());
		customerorder.setShippingaddress(s);
		session.save(customerorder);
		return customerorder;
	}
	
	public List<ShippingAddress> getshippingbyid(String id) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from ShippingAddress where user.email=?");
		query.setString(0, id);
		List<ShippingAddress> shipping= query.list();
		return shipping;
		
	}
	public ShippingAddress getshipping(int id) {
		Session session=sessionFactory.getCurrentSession();
		ShippingAddress shipping=(ShippingAddress) session.get(ShippingAddress.class, id);
		return shipping;
	}
	public void saveshipping(ShippingAddress shipping) {
		Session session=sessionFactory.getCurrentSession();
		session.save(shipping);
		
	}
	

}


