package com.hcl.redhat.soe.customer.model;

public class ProductModel {
	private String productId;
	private String productName;
	private String productSKU;
	private String productCategory;

	public ProductModel() {
		super();
	}

	public ProductModel(String productId, String productName, String productSKU, String productCategory) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productSKU = productSKU;
		this.productCategory = productCategory;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductSKU() {
		return productSKU;
	}

	public void setProductSKU(String productSKU) {
		this.productSKU = productSKU;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
}
