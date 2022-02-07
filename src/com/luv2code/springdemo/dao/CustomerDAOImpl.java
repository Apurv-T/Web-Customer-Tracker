package com.luv2code.springdemo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.luv2code.springdemo.entity.Customer;

public class CustomerDAOImpl implements CustomerDAO {

	//need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		// get the current hibernate session
		Session current=sessionFactory.getCurrentSession();
		//create a query
		Query<Customer> theQuery =
				current.createQuery("from Customer", Customer.class);
		//exectue the query and get the result list
		List<Customer> customers=theQuery.getResultList();
		//return the results
		
		return customers;
	}
	
	
	
	
	
	
	
	
	
	
	

}
