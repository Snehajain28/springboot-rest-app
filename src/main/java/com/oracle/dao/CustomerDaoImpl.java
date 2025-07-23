package com.oracle.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.oracle.exceptions.CustomerExistsException;
import com.oracle.exceptions.NoSuchCustomerException;
import com.oracle.model.Customer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public void createCustomer(Customer cust) {
		
	Customer customer = readCustomerByEmail(cust.getEmail());
	if(customer != null) {
		 throw new CustomerExistsException("customer already exists" + cust.getEmail());
	}
	entityManager.persist(cust);
	}

	@Override
	public Customer readCustomerByEmail(String email) {
		
	Customer customer = entityManager.find(Customer.class, email);
	 if(customer == null) {
		 throw new NoSuchCustomerException("customer not found" + email);
	 }
	 return customer;
	}

	@Override
	public List<Customer> readAllCustomers() {
		String jpql = "SELECT c FROM Customer c ";
		return  entityManager.createQuery(jpql,Customer.class).getResultList();
		 
	}

	@Override
	public void deleteCustomers(String email) {
		
		Customer cust = readCustomerByEmail(email);
		entityManager.remove(cust);
		
	}

	@Override
	public void updateCustomers(Customer cust) {
		String jpql = "UPDATE table_name SET firstName = cust.firstName, lastName = cust.lastName WHERE condition email = cust.email" ;
	  entityManager.createQuery(jpql,Customer.class);
			
	}
	

}
