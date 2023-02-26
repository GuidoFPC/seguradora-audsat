package com.guido.seguradora.repositories;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guido.seguradora.models.Driver;

public interface DriverRepository extends JpaRepository<Driver, BigInteger> {

}
