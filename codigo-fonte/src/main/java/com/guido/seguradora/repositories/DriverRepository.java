package com.guido.seguradora.repositories;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.guido.seguradora.models.Driver;

@Repository
public interface DriverRepository extends JpaRepository<Driver, BigInteger> {

}
