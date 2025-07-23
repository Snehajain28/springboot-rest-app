package com.oracle.service;

import java.util.List;

import com.oracle.model.Customer;

public interface CustomerService {
	public void addCustomer(Customer cust);
	public Customer findCustomerByEmail(String email);
	public List<Customer> findAllCustomers();
	public void deleteCustomers(String email);
	public void updateCustomers(Customer cust);
}
