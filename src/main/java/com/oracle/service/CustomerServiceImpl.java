package com.oracle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.dao.CustomerDao;
import com.oracle.model.Customer;

@Service
public class CustomerServiceImpl  implements CustomerService{

	@Autowired
	private CustomerDao dao ;
	
	@Override
	public void addCustomer(Customer cust) {
		dao.createCustomer(cust);
	}

	@Override
	public Customer findCustomerByEmail(String email) {

	return dao.readCustomerByEmail(email);
	}

	@Override
	public List<Customer> findAllCustomers() {
		
		return dao.readAllCustomers();
	}

	@Override
	public void deleteCustomers(String email) {
		dao.deleteCustomers(email);
	}

	@Override
	public void updateCustomers(Customer cust) {
		dao.updateCustomers(cust);
		
	}

}
