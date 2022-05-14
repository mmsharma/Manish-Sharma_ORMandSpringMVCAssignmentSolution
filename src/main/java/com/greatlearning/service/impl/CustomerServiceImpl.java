package com.greatlearning.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.greatlearning.dao.CustomerDAO;
import com.greatlearning.entity.CustomerEntity;
import com.greatlearning.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional
	public List<CustomerEntity> findAllCustomers() {
		return this.customerDAO.fetchAllCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(CustomerEntity customer) {

		this.customerDAO.saveCustomer(customer);
	}

	@Override
	@Transactional
	public CustomerEntity getCustomer(int custId) {
		
		return this.customerDAO.getCustomer(custId);
	}

	@Override
	@Transactional
	public void deleteCustomer(int custId) {
		
		this.customerDAO.deleteCustomer(custId);
	}
}





