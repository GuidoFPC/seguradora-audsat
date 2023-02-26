package com.guido.seguradora.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guido.seguradora.model.Insurance;

public interface InsuranceRepository extends JpaRepository<Insurance, BigInteger> {

}
