package com.controller;

import java.io.BufferedOutputStream;


import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.Dao.CategoryDAO;
import com.Dao.ProductDAO;
import com.Dao.SupplierDAO;
import com.Exception.ProductNotFoundException;
import com.model.Category;
import com.model.Product;
import com.model.Supplier;

@Controller
public class ProductController 

{
	@Autowired
	ProductDAO productDAO;
	@Autowired
	CategoryDAO categoryDAO;
	@Autowired
	SupplierDAO supplierDAO;
	
	@RequestMapping(value="/product",method=RequestMethod.GET)
	public String showProduct(Model m)
	{
		Product product=new Product();
		m.addAttribute(product );
        m.addAttribute("categoryList",this.getCategories());
        m.addAttribute("supplierList",this.getsupplier());
        List<Product> listproduct=productDAO.retrieveProducts();
		 m.addAttribute("productList",listproduct);
		 
	return "Product";
	}
	 @RequestMapping(value="/admin/updateProduct/{productId}",method=RequestMethod.GET)
	 public String updateProduct(@PathVariable("productId")int productid,Model m)
     {
		 Product product=productDAO.getProduct(productid);
		 m.addAttribute("product",product);
		 List<Product> listproduct=productDAO.retrieveProducts();
		 m.addAttribute("productList",listproduct);
		 m.addAttribute("categoryList",this.getCategories());
		 m.addAttribute("supplierList",this.getsupplier());
	        
	        	return "UpdateProduct";
	 	 
	     }
	
	public LinkedHashMap<Integer,String> getCategories()
	{
		List<Category> listCategories=categoryDAO.retrieveCategory();
		LinkedHashMap<Integer,String> categoriesList=new LinkedHashMap<Integer,String>();
		for(Category category:listCategories)
		{
			categoriesList.put(category.getCatId(),category.getCatName());
		}
	
		return categoriesList;
	}
		public LinkedHashMap<Integer,String> getsupplier()
		{
			List<Supplier> listSupplier=supplierDAO.retrieveSupplier();
			LinkedHashMap<Integer,String> supplierList=new LinkedHashMap<Integer,String>();
			for(Supplier category:listSupplier)
			{
				supplierList.put(category.getSupplierId(),category.getSupplierName());
			}
		
			return supplierList;
	}


	@RequestMapping(value="/admin/InsertProduct",method=RequestMethod.POST)
	public String insertProduct(@ModelAttribute("product")Product product,@RequestParam("pimage")MultipartFile fileDetail,Model m)
	{
		productDAO.addProduct(product);
		String path="F:\\Delight\\Delight\\src\\main\\webapp\\WEB-INF\\resources\\productimages\\";
		String totalFileWithPath=path+String.valueOf(product.getProductId())+".jpg";
		File productImage=new File(totalFileWithPath);
		if(!fileDetail.isEmpty())
		{
			try
			{
				byte fileBuffer[]=fileDetail.getBytes();
				FileOutputStream fos=new FileOutputStream(productImage);
				BufferedOutputStream bs=new BufferedOutputStream(fos);
				bs.write(fileBuffer);
				bs.close();
			}
			catch(Exception e)
			{
				m.addAttribute("error",e.getMessage());
			}
		}
		else
		{
			m.addAttribute("error","Problem in File Uploading");
		}
		Product product1=new Product();
		m.addAttribute(product1);
		 m.addAttribute("categoryList",this.getCategories());
		 m.addAttribute("supplierList",this.getsupplier());
	        
	        List<Product> listproduct=productDAO.retrieveProducts();
			 m.addAttribute("productList",listproduct);
			 
		return "Product";
		
		
			}
	@RequestMapping(value="userHome")
	public String showProducts(Model m)
	{
		List<Product> listProducts=productDAO.retrieveProducts();
		m.addAttribute("productList",listProducts);
		m.addAttribute("supplierList",this.getsupplier());
		m.addAttribute("categoryList",this.getCategories());
		return "UserHome";
	}
	@RequestMapping(value="/admin/updateProduct",method=RequestMethod.POST)
	 public String updateProduct(@ModelAttribute("product")Product product,@RequestParam("pimage")MultipartFile fileDetail,Model m)
		
    {
		productDAO.updateProduct(product);
		String path="F:\\Delight\\Delight\\src\\main\\webapp\\WEB-INF\\resources\\productimages\\";
		String totalFileWithPath=path+String.valueOf(product.getProductId())+".jpg";
		File productImage=new File(totalFileWithPath);
		if(!fileDetail.isEmpty())
		{
			try
			{
				byte fileBuffer[]=fileDetail.getBytes();
				FileOutputStream fos=new FileOutputStream(productImage);
				BufferedOutputStream bs=new BufferedOutputStream(fos);
				bs.write(fileBuffer);
				bs.close();
			}
			catch(Exception e)
			{
				m.addAttribute("error",e.getMessage());
			}
		}
		else
		{
			m.addAttribute("error","Problem in File Uploading");
		}
		
		Product product1=new Product();
			m.addAttribute(product1);
			List<Product> listProduct=productDAO.retrieveProducts();
			m.addAttribute("productList",listProduct);
			m.addAttribute("supplierList",this.getsupplier());
			m.addAttribute("categoryList",this.getCategories());
			return "Product";
}
	

    @RequestMapping(value="/admin/deleteProduct/{productId}",method=RequestMethod.GET)
    public String deleteProduct(@PathVariable("productId")int productId,Model m)
    {
    	Product product=productDAO.getProduct(productId);
    	productDAO.deleteProduct(product);
    	Product product1=new Product();
			m.addAttribute(product1);
			List<Product> listProduct=productDAO.retrieveProducts();
			m.addAttribute("productList",listProduct);
			m.addAttribute("supplierList",this.getsupplier());
			m.addAttribute("categoryList",this.getCategories());
			return "Product";
	 
    }
   
    @RequestMapping(value="/viewProduct/{productId}",method=RequestMethod.GET)
    public String getProduct(@PathVariable("productId")int getproductId,Model m) throws ProductNotFoundException
    {
    	Product product=productDAO.getProduct(getproductId);
    	m.addAttribute("product",product);
    	if(product==null) throw new ProductNotFoundException();
    	return "viewproduct";
			
}
}


