package com.hcl.redhat.soe.customer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.redhat.soe.customer.model.CustomerModel;
import com.hcl.redhat.soe.customer.service.CustomerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/customer", produces = "application/json")
@Api(value = "/customer")
public class CustomerController {

	Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private CustomerService customerService;

	@ApiOperation(value = "getCustomer", notes = "", response = CustomerModel.class)
	@ApiResponses({
			@ApiResponse(code = 200, message = "Successfully searched for Results", response = CustomerModel.class),
			@ApiResponse(code = 400, message = "Invalid Request", response = Exception.class) })
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<CustomerModel> getCustomer(@ApiParam(value = "customer id") @RequestParam(name = "customerId") String customerId) {

		CustomerModel customer = null;
		customer = customerService.getCustomer(customerId);
		return new ResponseEntity<CustomerModel>(customer, HttpStatus.OK);
	}
	
	@ApiOperation(value = "addCustomers", notes = "Add customer to SOR", response = String.class)
	@ApiResponses({
			@ApiResponse(code = 200, message = "Successfully added customer", response = String.class),
			@ApiResponse(code = 400, message = "Invalid Request", response = Exception.class) })
	@RequestMapping(value = "/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> addCustomers(@RequestBody CustomerModel customer) {
		String response = customerService.addCustomer(customer);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
	
	@ApiOperation(value = "updateCustomer", notes = "Update customer to SOR", response = String.class)
	@ApiResponses({
			@ApiResponse(code = 200, message = "Successfully updated customer", response = String.class),
			@ApiResponse(code = 400, message = "Invalid Request", response = Exception.class) })
	@RequestMapping(value = "/", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> updateCustomer(@RequestBody CustomerModel customer) {
		String response = customerService.updateCustomers(customer);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
	
	@ApiOperation(value = "deleteCustomer", notes = "Customer deleted from SOR", response =
			String.class)
	@ApiResponses({
			@ApiResponse(code = 200, message = "Successfully deleted customer", response = String.class),
			@ApiResponse(code = 400, message = "Invalid Request", response = Exception.class) })
	@RequestMapping(value = "/", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> deleteCustomer(@ApiParam(value = "customer id") @RequestParam(name = "customerId") String customerId) {
		String response = customerService.deleteContents(customerId);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
}