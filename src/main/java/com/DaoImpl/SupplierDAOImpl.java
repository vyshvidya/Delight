package com.DaoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Dao.SupplierDAO;
import com.model.Product;
import com.model.Supplier;
@Repository("SupplierDAO")
public class SupplierDAOImpl implements SupplierDAO
{
	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public boolean addSupplier(Supplier supplier) 
	{
try
	    
		{
		sessionFactory.getCurrentSession().save(supplier);

	
		return true;
	    }
	     catch(Exception e)
	    {

		// TODO Auto-generated method stub
		return false;
	}
	}
	@Transactional
	public List<Supplier> retrieveSupplier()
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Supplier");
		List<Supplier>listSupplier=query.list();
		session.close();
			
			// TODO Auto-generated method stub
			return listSupplier;
		}
		// TODO Auto-generated method stub
		
	
	@Transactional
	public boolean deletesupplier(Supplier supplier) 
	{
try
	    
		{
		sessionFactory.getCurrentSession().delete(supplier);

	
		return true;
	    }
	     catch(Exception e)
	    {

		// TODO Auto-generated method stub
		return false;
	}
	}
	@Transactional
	public Supplier getSupplier(int SupplierId) 
	{
		Session session=sessionFactory.openSession();
		Supplier supplier=(Supplier)session.get( Supplier.class,SupplierId);
		session.close();
		
			// TODO Auto-generated method stub
			return supplier;
		}
		// TODO Auto-generated method stub
		
	
	@Transactional
	public boolean updateSupplier(Supplier supplier) 
	{
		try
	    
		{
		sessionFactory.getCurrentSession().saveOrUpdate(supplier);
		return true;
		}
		 catch(Exception e)
		{
			 System.out.println("Exception Arised:"+e);
			return false;
		}
	}
		// TODO Auto-generated method stub
		
	@Transactional
	public boolean deleteSupplier(Supplier supplier) 
	{
try
	    
		{
		sessionFactory.getCurrentSession().delete(supplier);

	
		return true;
	    }
	     catch(Exception e)
	    {
			return false;
		}
	}
}

