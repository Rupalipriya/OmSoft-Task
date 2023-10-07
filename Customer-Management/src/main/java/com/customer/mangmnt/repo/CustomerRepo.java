package com.customer.mangmnt.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customer.mangmnt.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

}
