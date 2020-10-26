package com.samundar.springboot.msscbrewery.web.controller;

import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.samundar.springboot.msscbrewery.services.CustomerService;
import com.samundar.springboot.msscbrewery.web.model.CustomerDto;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {

	private final CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@GetMapping({ "/{customerId}" })
	public ResponseEntity<CustomerDto> getCustomerById(@PathVariable("customerId") UUID customerId) {
		return new ResponseEntity<CustomerDto>(customerService.getCustomerById(customerId), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<CustomerDto> handlePost(@RequestBody CustomerDto customerDto) {

		CustomerDto savedDto = customerService.saveNewCustomer(customerDto);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", "/api/v1/customer/" + savedDto.getId().toString());
		return new ResponseEntity<CustomerDto>(headers, HttpStatus.CREATED);

	}

	@PutMapping({ "/{customerId}" })
	@ResponseStatus(HttpStatus.OK)
	public void handleUpdate(@PathVariable("customerId") UUID customerId, @RequestBody CustomerDto customerDto) {
		customerService.updateCustomer(customerId, customerDto);
	}

	@DeleteMapping({ "/{customerId}" })
	@ResponseStatus(HttpStatus.OK)
	public void handleDelete(@PathVariable("customerId") UUID customerId) {
		customerService.deleteById(customerId);
	}

}
