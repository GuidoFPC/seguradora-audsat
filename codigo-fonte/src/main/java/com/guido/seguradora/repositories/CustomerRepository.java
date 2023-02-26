package com.guido.seguradora.repositories;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guido.seguradora.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, BigInteger> {

}
