package com.model;

import java.util.List;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Cart
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private double grandtotal;
	@OneToOne
	@JoinColumn(name="customer_id")
	private Customer user;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getGrandtotal() {
		return grandtotal;
	}
	public void setGrandtotal(double grandtotal) {
		this.grandtotal = grandtotal;
	}
	public Customer getUser() {
		return user;
	}
	public void setUser(Customer user) {
		this.user = user;
	}
	public List<CartItem> getCartitems() {
		return cartitems;
	}
	public void setCartitems(List<CartItem> cartitems) {
		this.cartitems = cartitems;
	}
	@OneToMany(mappedBy="cart",fetch=FetchType.EAGER)
	private List<CartItem> cartitems;

}
