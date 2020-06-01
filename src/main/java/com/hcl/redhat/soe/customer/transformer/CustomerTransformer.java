package com.hcl.redhat.soe.customer.transformer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.hcl.redhat.soe.customer.entity.Product;
import com.hcl.redhat.soe.customer.model.ProductModel;
import org.springframework.stereotype.Component;

import com.hcl.redhat.soe.customer.entity.Customer;
import com.hcl.redhat.soe.customer.model.CustomerModel;

@Component
public class CustomerTransformer {
	
	public CustomerModel transform(Customer customerEntity) {
		CustomerModel customer = new CustomerModel();
		List<ProductModel> products = new ArrayList<>();
		if (null != customerEntity) {
			if (null != customerEntity.getProducts()) {
				for (Product productEntity : customerEntity.getProducts())
					products.add(new ProductModel(productEntity.getId(), productEntity.getName(),
							productEntity.getSku(), productEntity.getCategoty()));
			
				customer = new CustomerModel(customerEntity.getId(), customerEntity.getName(),
						customerEntity.getNumber(), customerEntity.getEmail(),
						customerEntity.getAddress(), products);
			}
		}
		return customer;
	}

	public Customer transform(CustomerModel customer) {
		List<ProductModel> products = customer.getProducts();
		Customer customerEntity = new Customer(customer.getCustomerId(), customer.getCustomerName(), customer.getCustomerNumber(), customer.getCustomerEmail(), customer.getCustomerAddress());
		
		List<Product> productEntites = new ArrayList<>();
		for (ProductModel product : products) {
			Product productEntity = new Product(product.getProductId(), product.getProductName(), product.getProductSKU(), product.getProductCategory());
			productEntity.setCustomer(customerEntity);
			productEntites.add(productEntity);		
		}
				
		customerEntity.setProducts(productEntites/* .stream().collect(Collectors.toSet()) */);
		return customerEntity;
	}
}
