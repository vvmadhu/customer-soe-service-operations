package com.hcl.redhat.soe.customer.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity(name="Customer")
public class Customer implements Serializable {

	@Id
	@Column(name="customerId", unique=true, nullable=false)
	private String id;
	
	@Column(name="customerName")
	private String name;
	
	@Column(name="customerNumber")
	private String number;
	
	@Column(name="customerEmail")
	private String email;
	
	@Column(name="customerAddress")
	private String address;
	
	@OneToMany(mappedBy = "customer")
	private List<Product> products;
	
	public Customer() {
		
	}

	public Customer(String customerId, String customerName, String customerNumber, String customerEmail, String customerAddress) {
		this.id = customerId;
		this.name = customerName;
		this.number = customerNumber;
		this.email = customerEmail;
		this.address = customerAddress;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}