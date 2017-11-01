package com.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.Dao.ProductDAO;
import com.Dao.SupplierDAO;
import com.DaoImpl.ProductDAOImpl;
import com.DaoImpl.SupplierDAOImpl;
import com.hibernateConfig.hiberConfig;
import com.model.Product;
import com.model.Supplier;

public class SupplierDAOTest 
{
	static SupplierDAO supplierDao;

		@BeforeClass
		public static void initialize()
		{
		AnnotationConfigApplicationContext configApplnContext=new AnnotationConfigApplicationContext (hiberConfig.class,SupplierDAOImpl.class);
		configApplnContext.scan("com");
		configApplnContext.refresh();
		//SessionFactory sessionFactory=(SessionFactory)configApplnContext.getBean("hiberConfig.class");
		
		supplierDao =(SupplierDAO)configApplnContext.getBean("supplierDAO");
		}
		
	
@Transactional
	@Test
	public void addSupplierTest() 
	{
		Supplier supplier=new Supplier();
		supplier.setSupplierId(778);
		supplier.setSupplierName("krish");
		supplier.setSupplierAddress("abc");
		assertTrue("Problem in Insertion",supplierDao.addSupplier(supplier));
			}

}
