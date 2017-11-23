
 package com.hibernateConfig;

import java.util.Properties;


import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.Dao.UserDao;
import com.DaoImpl.UserDaoImpl;
import com.model.BillingAddress;
import com.model.Cart;
import com.model.CartItem;
import com.model.Category;
import com.model.Customer;
import com.model.CustomerOrder;
import com.model.Product;
import com.model.ShippingAddress;
import com.model.Supplier;




@Configuration
@EnableTransactionManagement
@ComponentScan("com")
public class hiberConfig 
{
	@Autowired 
	@Bean(name="datasource")
	public DataSource getH2data()
	{
		System.out.println("Hiberanate initiated....");
		DriverManagerDataSource dsource=new DriverManagerDataSource();
		dsource.setDriverClassName("org.h2.Driver");
		dsource.setUrl("jdbc:h2:tcp://localhost/~/Delight");
		dsource.setUsername("sa");
		dsource.setPassword("");
		System.out.println("H2 Connected...");
		return dsource;
	}

private Properties getHiberProps()
{
	Properties p = new Properties();
	p.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
	p.put("hibernate.hbm2ddl.auto", "update");
	p.put("hibernate.show_sql", "true");
	
	System.out.println("Data table created in H2");
	return p;
}
@Autowired
@Bean(name= "sessionFactory")
public SessionFactory getSession(DataSource datasource)
{
		LocalSessionFactoryBuilder sb = new LocalSessionFactoryBuilder(datasource);
		sb.addProperties(getHiberProps());
		sb.addAnnotatedClass(Customer.class);
		sb.addAnnotatedClass(Category.class);
		sb.addAnnotatedClass(Product.class);
		sb.addAnnotatedClass(Supplier.class);
		sb.addAnnotatedClass(Cart.class);
		sb.addAnnotatedClass(CartItem.class);
		sb.addAnnotatedClass(CustomerOrder.class);
		sb.addAnnotatedClass(ShippingAddress.class);
		sb.addAnnotatedClass(BillingAddress.class);
		
		SessionFactory sessionFactory=sb.buildSessionFactory();
		System.out.println("session Factory is started");
		return sessionFactory;
}


@Autowired
@Bean(name="userDaoImpl")
public UserDao getUserData(SessionFactory sessionFac)
{
	return new UserDaoImpl(sessionFac);
}


@Autowired
@Bean
public HibernateTransactionManager getTransaction(SessionFactory sessionFactory)
{
	HibernateTransactionManager tm = new HibernateTransactionManager(sessionFactory);
	return tm;
}


}