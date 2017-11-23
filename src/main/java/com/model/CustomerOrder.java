package com.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CustomerOrder
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private Date date;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cartid")
	private Cart cart;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="customerid")
	private Customer user;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="bid")
	private BillingAddress billingaddress;
	@ManyToOne(cascade=CascadeType.ALL)
	
	@JoinColumn(name="sid")
	private ShippingAddress shippingaddress;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public BillingAddress getBillingaddress() {
		return billingaddress;
	}
	public void setBillingaddress(BillingAddress billingaddress) {
		this.billingaddress = billingaddress;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public Customer getUser() {
		return user;
	}
	public void setUser(Customer user) {
		this.user = user;
	}
	public ShippingAddress getShippingaddress() {
		return shippingaddress;
	}
	public void setShippingaddress(ShippingAddress shippingaddress) {
		this.shippingaddress = shippingaddress;
	}

}
