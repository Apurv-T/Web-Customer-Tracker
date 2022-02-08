package com.luv2code.springdemo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Customer;
@Repository
public class CustomerDAOImpl implements CustomerDAO {

	//need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		// get the current hibernate session
		Session current=sessionFactory.getCurrentSession();
		//create a query...sort by last name
		Query<Customer> theQuery =
				current.createQuery("from Customer order by lastName", Customer.class);
		//exectue the query and get the result list
		List<Customer> customers=theQuery.getResultList();
		//return the results
		
		return customers;
	}

	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		
		//get current hibernate session
		Session currentSession =sessionFactory.getCurrentSession();
		//sve the customer finally lol
		currentSession.saveOrUpdate(theCustomer);
		}

	@Override
	public Customer getCustomer(int theId) {
		// TODO Auto-generated method stub
		Session currentSession =sessionFactory.getCurrentSession();
		//save the customer finally
		Customer theCustomer=currentSession.get(Customer.class, theId);
		return theCustomer;
	}

	@Override
	
	public void deleteCustomer(int theId) {
		Session currentSession =sessionFactory.getCurrentSession();
		Query theQuery=currentSession.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", theId);
		theQuery.executeUpdate();
	}
	
	
	
	
	
	
	
	
	
	
	

}
