package com.springboot.backend.GP.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.backend.GP.dto.CustomerDto;
import com.springboot.backend.GP.model.Customer;
import com.springboot.backend.GP.repository.CustomerRepository;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@PostMapping("/customer") //Function used to insert a new customer into the database
	public void postAccount(@RequestBody Customer customer) {
		customerRepository.save(customer);
	}

	@GetMapping("/customer") //Function used to return a list of all customers
	public List<CustomerDto> getAllAccounts() {
		List<Customer> list =  customerRepository.findAll();
		List<CustomerDto> listDto = new ArrayList<>(); 
		list.stream().forEach(c->{
			CustomerDto dto = new CustomerDto(); 
			dto.setId(c.getId());
			dto.setCustomerName(c.getCustomerName());
			dto.setCustomerNumber(c.getCustomerPhone());
			dto.setCustomerEmail(c.getCustomerEmail());
			dto.setCustomerBalance(c.getCustomerBalance());
		
			listDto.add(dto);
		});
		return listDto;
	}

	@GetMapping("/customer/{cid}") //Function used to return  a specific customer based on their ID
	public Customer getAccountById(@PathVariable("cid") Long cid) {
		Optional<Customer> optional = customerRepository.findById(cid);
		if (optional.isPresent())
			return optional.get();
		throw new RuntimeException("ID is invalid");
	}

	@DeleteMapping("/customer/{cid}") //Function used to delete a customer based on customer ID
	public void deleteAccount(@PathVariable("cid") Long cid) {
		customerRepository.deleteById(cid);
	}

	@PutMapping("/customer/{cid}") //Function used to Adjust a customers Name, Username, and Password
	public Customer updateAccount(@PathVariable("cid") Long cid, @RequestBody Customer newCustomer) {
		Optional<Customer> optional = customerRepository.findById(cid);
		if (optional.isPresent()) {
			Customer existingCustomer = optional.get();
			existingCustomer.setCustomerName(newCustomer.getCustomerName());
			existingCustomer.setUserInfo(newCustomer.getUserInfo());
			
			return customerRepository.save(existingCustomer);
		}
		throw new RuntimeException("ID is Invalid");
	}
	
	@PutMapping("/customer/balance/{cid}") //Function to change A Customers Balance only
	public Customer adjustCustomerBalace(@PathVariable("cid") Long cid, @RequestBody Customer newCustomer) {
		Optional<Customer> optional = customerRepository.findById(cid);
		if (optional.isPresent()) {
			Customer existingCustomer = optional.get();
			existingCustomer.setCustomerBalance(newCustomer.getCustomerBalance());
			
			return customerRepository.save(existingCustomer);
		}
		throw new RuntimeException("ID is Invalid");
	}

}
