package com.model;

import javax.persistence.*;


@Entity
@Table

public class Category
{
	
	@Id
	@GeneratedValue
 int catId;
	 String  catName,catDesc;
	public int getCatId() {
		return catId;
	}
	public void setCatId(int catId) {
		this.catId = catId;
	}
	public String getCatName() {
		return catName;
	}
	public   void setCatName(String catName) {
		this.catName = catName;
	} 
	public String getCatDesc() {
		return catDesc;
	}
	public void setCatDesc(String catDesc) {
		this.catDesc = catDesc;
	} 
	
}

