package com.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;

import org.springframework.stereotype.Component;

@Component
@Entity

public class Customer implements Serializable
{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String email;
	private String name;
	private String phone;
	private String password;
	private String role;
	private boolean enabled;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "billingaddress_id")
	
	private BillingAddress billingaddress;
	@OneToMany(mappedBy="user",cascade = CascadeType.ALL)
	private List<ShippingAddress> shippingaddress;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cart_id")
	private Cart cart;

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public BillingAddress getBillingaddress() {
		return billingaddress;
	}
	public void setBillingaddress(BillingAddress billingaddress) {
		this.billingaddress = billingaddress;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public boolean Enabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public List<ShippingAddress> getShippingaddress() {
		return shippingaddress;
	}
	public void setShippingaddress(List<ShippingAddress> shippingaddress) {
		this.shippingaddress = shippingaddress;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public boolean isEnabled() {
		return enabled;
	}
	

	
	

}
