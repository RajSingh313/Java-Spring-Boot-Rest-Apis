package com.raj.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.raj.main.entity.Customer;
import com.raj.main.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping
	public Customer createCustomer(@RequestBody Customer customer){
		return customerService.createCustomer(customer);
		
	}
	
	@GetMapping("/{id}")
	public Customer getCustomerById(@PathVariable long id) {
		return customerService.getCustomerById(id);
	}
//	
	
	//Get All Customers without Pagination
//	@GetMapping
//	public List<Customer> getAllCustomer(Customer customer){
//		return customerService.getAllCustomer(customer);
//	}
//	
	
	
	//Get All Customer with Pagination and Sortting
	@GetMapping
	public Page<Customer>  getAllCustomer(
			@RequestParam(value = "pageNo", defaultValue = "0") int pageNo,
			@RequestParam(value = "pageSize", defaultValue = "5") int pageSize,
			@RequestParam(value = "sortBy", defaultValue = "address") String sortBy)
	{
		return  customerService.getCustomerWithPagination(pageNo, pageSize, sortBy);
	}
			
			
			
	
	
	@PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable long id, @RequestBody Customer customer) {
		return customerService.updateCustomer(id, customer);
	}
	
	@DeleteMapping("/{id}")
	public String deleteCustomer(@PathVariable long id) {
		customerService.deleteCustomer(id);
		return "Customer with id  " + id  +  "  deleted Successfully";
	}
	

}
