package com.raj.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.raj.main.entity.Customer;
import com.raj.main.repository.CustomerRepository;

@Service
public class CustomerService {
	
	
	@Autowired
	private CustomerRepository customerRepository;

	
//Pagination With Sorting	
public Page<Customer> getCustomerWithPagination(int pageNo, int pageSize, String sortBy){
	return customerRepository.findAll(PageRequest.of(pageNo, pageSize, Sort.by(sortBy).ascending()));
	
}

//Pagination Without Sorting
public Page<Customer> getCustomerWithSorting(int pageNo, int pageSize){
	return customerRepository.findAll(PageRequest.of(pageNo, pageSize));
}


	//to Create Customer
	public Customer createCustomer(Customer customer) {
		return customerRepository.save(customer);
		}
	
	
	//to get Single Customer
	public Customer getCustomerById(long customerId) {
		return customerRepository.findById(customerId)
	   .orElseThrow(() -> new RuntimeException("Customer not found with id " + customerId));
		 
	}
	
	
	
	
	
	//Update Customer
	public Customer updateCustomer(long id, Customer customer) {
	Customer existingCustomer=	 customerRepository.findById(id)
				   .orElseThrow(() -> new RuntimeException("Customer not found with id " + id));
		
		existingCustomer.setFirstName(customer.getFirstName());
		existingCustomer.setLastName(customer.getLastName());
		existingCustomer.setEmail(customer.getEmail());
		existingCustomer.setAddress(customer.getAddress());
		
		return customerRepository.save(existingCustomer);

	}
	
	public void deleteCustomer(long id) {
		customerRepository.deleteById(id);
	}
	
	

}
