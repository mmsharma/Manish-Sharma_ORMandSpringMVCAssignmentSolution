package com.greatlearning.dao;

import java.util.List;

import com.greatlearning.entity.CustomerEntity;

public interface CustomerDAO {

	public List<CustomerEntity> fetchAllCustomers();

	public void saveCustomer(CustomerEntity customer);

	public CustomerEntity getCustomer(int custId);

	public void deleteCustomer(int custId);
	
}
