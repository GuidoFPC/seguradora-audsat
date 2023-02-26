package com.guido.seguradora.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guido.seguradora.model.Car;

public interface CarRepository extends JpaRepository<Car, BigInteger> {

}
