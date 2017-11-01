package com.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.Dao.ProductDAO;
import com.DaoImpl.ProductDAOImpl;
import com.hibernateConfig.hiberConfig;
import com.model.Product;




public class ProductDAOTest 
{
	static ProductDAO productDao;
	

	@BeforeClass
	public static void initialize()
	{
	AnnotationConfigApplicationContext configApplnContext=new AnnotationConfigApplicationContext (hiberConfig.class,ProductDAOImpl.class);
	configApplnContext.scan("com");
	configApplnContext.refresh();
	//SessionFactory sessionFactory=(SessionFactory)configApplnContext.getBean("hiberConfig.class");
	
	productDao =(ProductDAO)configApplnContext.getBean("productDAO");
	}
	@Ignore
	@Transactional
	@Test
	public void addProductTest() {
		Product product=new Product();
		product.setProductId(778);
		product.setProductName("cushion");
		product.setProductDesc("eazzeeee");
		product.setStock(5);
		product.setPrice(15000);
		product.setCatId(778);
		product.setSupplierId(779);
		assertTrue("Problem in Insertion",productDao.addProduct(product));
	}
	@Ignore
	@Transactional
	@Test
	public void retrieveProductTest()
	{
		List<Product> listProducts=productDao.retrieveProducts();
		assertTrue("List is Empty",listProducts.size()>0);
		for(Product product:listProducts)
		{
			System.out.println("Product ID:"+product.getProductId());
			System.out.println("Product Name:"+product.getProductName());
			System.out.println("Product Desc:"+product.getProductDesc());
		}
		
	}
}


