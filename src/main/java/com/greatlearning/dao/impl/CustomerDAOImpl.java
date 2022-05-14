package com.greatlearning.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.greatlearning.dao.CustomerDAO;
import com.greatlearning.entity.CustomerEntity;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	public List<CustomerEntity> fetchAllCustomers() {
		
		return sessionFactory.getCurrentSession()
				.createQuery("from Customer order by lastName",
						CustomerEntity.class)
				.getResultList();
	}

	@Override
	public void saveCustomer(CustomerEntity customer) {

		sessionFactory.getCurrentSession().saveOrUpdate(customer);
		
	}

	@Override
	public CustomerEntity getCustomer(int custId) {

		return sessionFactory.getCurrentSession().get(CustomerEntity.class, custId);
	}

	@Override
	public void deleteCustomer(int custId) {

		sessionFactory.getCurrentSession()
				.createQuery("delete from Customer where id=:customerId")
				.setParameter("customerId", custId)
				.executeUpdate();		
	}

}