package com.greatlearning.service;

import java.util.List;

import com.greatlearning.entity.CustomerEntity;

public interface CustomerService {

	public List<CustomerEntity> findAllCustomers();

	public void saveCustomer(CustomerEntity customer);

	public CustomerEntity getCustomer(int custId);

	public void deleteCustomer(int custId);
	
}
