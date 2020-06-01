package com.hcl.redhat.soe.customer.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.redhat.soe.customer.entity.Customer;
import com.hcl.redhat.soe.customer.entity.Product;
import com.hcl.redhat.soe.customer.model.CustomerModel;
import com.hcl.redhat.soe.customer.repository.CustomerRepository;
import com.hcl.redhat.soe.customer.repository.ProductRepository;
import com.hcl.redhat.soe.customer.transformer.CustomerTransformer;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	ProductRepository productRepository;

	@Autowired
	CustomerTransformer customerTransformer;

	Logger logger = LoggerFactory.getLogger(CustomerService.class);

	public CustomerModel getCustomer(String customerId) {
		CustomerModel customer = null;
		Optional<Customer> customerEntity = null;
		
		if (null != customerId)
			customerEntity = customerRepository.findById(customerId);

		if (null != customerEntity) {
			customer = customerTransformer.transform(customerEntity.get());
		}

		return customer;
	}

	public String addCustomer(CustomerModel customer) {
		System.out.println("In service");
		Customer customerEntity = customerTransformer.transform(customer);
		List<Product> products = customerEntity.getProducts();
		customerEntity.setProducts(null);
		customerRepository.save(customerEntity);
		for (Product product : products) {
			product.setCustomer(customerEntity);
			productRepository.save(product);
		}		
		
		return "Customer Added";
	}

	public String updateCustomers(CustomerModel customer) {
		Customer customerEntity = customerTransformer.transform(customer);
		customerRepository.save(customerEntity);
		return "Customer Updated";
	}

	public String deleteContents(String customerId) {
		customerRepository.delete(customerRepository.findById(customerId).get());
		return "Customer Deleted";
	}
}