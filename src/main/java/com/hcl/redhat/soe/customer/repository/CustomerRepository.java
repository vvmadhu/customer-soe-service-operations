package com.hcl.redhat.soe.customer.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hcl.redhat.soe.customer.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
	Optional<Customer> findById(String customerId);
}