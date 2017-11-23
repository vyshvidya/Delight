package com.Dao;



import com.model.*;
public interface UserDao {
	public void insertUser(Customer user);

	public Customer customerbyemail(String email);

}
