package com.hcl.redhat.soe.customer.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity(name="product")
public class Product implements Serializable {

	@Id
	@Column(name="productId")
	private String id;
	
	@Column(name="productName")
	private String name;
	
	@Column(name="productSKU")
	private String sku;
	
	@Column(name="productCategoty")
	private String categoty;
	
	@ManyToOne /* (fetch = FetchType.LAZY) */
	@JoinColumn(name = "customerId",  referencedColumnName = "customerId")
	private Customer customer;
	
	public Product() {
	}

	public Product(String productId, String productName, String productSKU, String productCategoty) {
		this.id = productId;
		this.name = productName;
		this.sku = productSKU;
		this.categoty = productCategoty;
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

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getCategoty() {
		return categoty;
	}

	public void setCategoty(String categoty) {
		this.categoty = categoty;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}