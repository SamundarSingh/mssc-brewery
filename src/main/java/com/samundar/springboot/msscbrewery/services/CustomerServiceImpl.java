package com.samundar.springboot.msscbrewery.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.samundar.springboot.msscbrewery.web.model.CustomerDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

	@Override
	public CustomerDto getCustomerById(UUID customerId) {
		return CustomerDto.builder().id(UUID.randomUUID()).customerName("Joe Buck").build();
	}

	@Override
	public CustomerDto saveNewCustomer(CustomerDto customerDto) {

		return CustomerDto.builder().id(UUID.randomUUID()).build();
	}

	@Override
	public void updateCustomer(UUID customerId, CustomerDto customerDto) {
		log.debug("updated customer...");
	}

	@Override
	public void deleteById(UUID customerId) {
		log.debug("deleted customer details...");
	}

}
