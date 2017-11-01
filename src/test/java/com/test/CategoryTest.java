package com.test;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.SessionFactory;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Dao.CategoryDAO;
import com.DaoImpl.CategoryDAOImpl;
import com.hibernateConfig.hiberConfig;
import com.model.Category;

import jdk.nashorn.internal.ir.annotations.Ignore;

public class CategoryTest {
	static 	CategoryDAO categoryDao;
	
	@BeforeClass
	public static void initialize()
	{
	AnnotationConfigApplicationContext configApplnContext=new AnnotationConfigApplicationContext (hiberConfig.class,CategoryDAOImpl.class);
	configApplnContext.scan("com");
	configApplnContext.refresh();
	//SessionFactory sessionFactory=(SessionFactory)configApplnContext.getBean("hiberConfig.class");
	
	categoryDao =(CategoryDAO)configApplnContext.getBean("categoryDAO");
	}
		@Test
		public void addCategoryTest() {
			Category category=new Category();
			category.setCatId(778);
			category.setCatName("riyan");
			category.setCatDesc("riyan cots with double mattress");
			assertTrue(categoryDao.addCategory(category));
		}
	@Ignore
		@Test
		public void updateCategoryTest() {
			Category category=new Category();
			category.setCatId(778);
			category.setCatName("riyan");
			category.setCatDesc("riyan cots with double mattress with pillows");
			assertTrue(categoryDao.updateCategory(category));
		}
		@Test
		public void deleteCategoryTest() {
			Category category=new Category();
			category.setCatId(778);
			assertTrue(categoryDao.deleteCategory(category));
		}
		@Test
		public void retrieveCategoryTest() {
			List<Category> listCategory=categoryDao.retrieveCategory();
			assertNotNull("Problem in Retrieving",listCategory);
			this.show(listCategory);

}

		public void show(List<Category> listCategory)
		{
			for(Category category:listCategory)
			{
				System.out.println("Category  ID:"+category.getCatId());
				System.out.println("Category  Name:"+category.getCatName());
			}
		}
		@Test
		public void getCategoryTest() {
			Category category=categoryDao.getCategory(778);
			assertNotNull("Problem in Getting",category);
			System.out.println("Category  ID:"+category.getCatId());
			System.out.println("Category  Name:"+category.getCatName());
	
		}
		
	

}