package com.DaoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Dao.ProductDAO;
import com.model.Category;
import com.model.Product;
@Repository("ProductDAO")
public class ProductDAOImpl implements ProductDAO
{
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public boolean addProduct(Product product) 
	{
try
	    
		{
		sessionFactory.getCurrentSession().save(product);

	
		return true;
	    }
	     catch(Exception e)
	    {
			return false;
		}

		
		// TODO Auto-generated method stub
	
	}
@Transactional
	public boolean deleteProduct(Product product) 
	{
try
	    
		{
		sessionFactory.getCurrentSession().delete(product);

	
		return true;
	    }
	     catch(Exception e)
	    {
			return false;
		}

		// TODO Auto-generated method stub
		
	}
@Transactional
	public List<Product> retrieveProducts() 
{
	Session session=sessionFactory.openSession();
	Query query=session.createQuery("from Product");
	List<Product>listProducts=query.list();
	session.close();
		
		// TODO Auto-generated method stub
		return listProducts;
	}
@Transactional
	public Product getProduct(int productId)
{
	Session session=sessionFactory.openSession();
	Product product=(Product)session.get( Product.class,productId);
	session.close();
	
		// TODO Auto-generated method stub
		return product;
	}
@Transactional
	public boolean updateProduct(Product Product) 
{
	try
    
{
sessionFactory.getCurrentSession().saveOrUpdate(Product);
return true;
}
 catch(Exception e)
{
	 System.out.println("Exception Arised:"+e);
	return false;
}

		// TODO Auto-generated method stub
	}

}
