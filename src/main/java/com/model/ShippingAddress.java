package com.model;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class ShippingAddress
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String doorno;
	
	private String streetname;
	
	private String city;
	
	private String state;
	
	private String country;
	
	private String zipcode;
	@ManyToOne
	@JoinColumn(name="cid")
	private Customer user;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDoorno() {
		return doorno;
	}
	public void setDoorno(String doorno) {
		this.doorno = doorno;
	}
	public String getStreetname() {
		return streetname;
	}
	public void setStreetname(String streetname) {
		this.streetname = streetname;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public Customer getUser() {
		return user;
	}
	public void setUser(Customer user) {
		this.user = user;
	}
	
}
