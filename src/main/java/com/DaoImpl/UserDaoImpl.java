package com.DaoImpl;
import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Dao.UserDao;
import com.model.Cart;
import com.model.Customer;
import com.model.ShippingAddress;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	   SessionFactory sessionFac;
	
	 @Autowired
	   public UserDaoImpl(SessionFactory sessionFactory)
	   {
		   super();
		   sessionFac=sessionFactory;
	   }
	   public void insertUser(Customer user)
	   {
		  Session session=sessionFac.openSession();
		  Cart cart=new Cart();
			cart.setUser(user);
			user.setCart(cart); 
			ShippingAddress s= new ShippingAddress();
			s.setDoorno(user.getBillingaddress().getDoorno());
			s.setStreetname(user.getBillingaddress().getStreetname());
			s.setCity(user.getBillingaddress().getCity());
			s.setState(user.getBillingaddress().getState());
			s.setCountry(user.getBillingaddress().getCountry());
			s.setZipcode(user.getBillingaddress().getZipcode());
			s.setUser(user);
			user.setEnabled(true);
		  session.beginTransaction();
		  session.persist(s);
		  session.persist(user);
		  session.getTransaction().commit();
		   
		   
	   }
	  
	   
	   @Transactional
		public Customer customerbyemail(String email) {
			Session session=sessionFac.getCurrentSession();
			Customer customer=(Customer)session.get( Customer.class,email);
			return customer;
			
		}
	
	}



