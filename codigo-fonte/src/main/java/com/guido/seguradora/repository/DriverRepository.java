package com.guido.seguradora.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guido.seguradora.model.Driver;

public interface DriverRepository extends JpaRepository<Driver, BigInteger> {

}
