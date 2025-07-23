package com.oracle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.exceptions.CustomerExistsException;
import com.oracle.model.Customer;
import com.oracle.service.CustomerService;

@RestController
@RequestMapping(path = "/customer-api")
public class CustomerRestController {
	
	@Autowired
	private CustomerService service ;

	@PostMapping("/add")
	public ResponseEntity<String> addCustomer(@RequestBody Customer cust) {
		service.addCustomer(cust);
		ResponseEntity<String> res = new ResponseEntity ("done" , HttpStatus.CREATED);
		return res;
	}
	
	@PostMapping("/find")
public Customer getCustomerByEmail( @RequestBody String email) {
		 return service.findCustomerByEmail(email);
		
	}
	@GetMapping("/find-all")
	public List<Customer> getCustomers() {
			return service.findAllCustomers();
			
		}
	
	@PostMapping("/delete")
	public void deleteCustomers(@RequestBody String email) {
			service.deleteCustomers(email);
			
		}
	
	@PutMapping("/update")
	public void updateCustomers(@RequestBody Customer cust) {
			service.updateCustomers(cust);
			
		}
	@ExceptionHandler(CustomerExistsException.class)
	public ResponseEntity<String> handleUnique (CustomerExistsException ex){
		ResponseEntity<String> res = new ResponseEntity<String>(ex.getMessage() , HttpStatus.INTERNAL_SERVER_ERROR);
		return res;
	}
	
}
