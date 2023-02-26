package com.guido.seguradora.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guido.seguradora.model.Car;
import com.guido.seguradora.model.Claim;
import com.guido.seguradora.model.Driver;

public interface ClaimRepository extends JpaRepository<Claim, BigInteger> {

	List<Claim> findByDriver(Driver driver);

	List<Claim> findByCar(Car car);

}
