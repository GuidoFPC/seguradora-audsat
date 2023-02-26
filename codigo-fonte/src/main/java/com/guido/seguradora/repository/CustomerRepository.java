package com.guido.seguradora.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guido.seguradora.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, BigInteger> {

}
