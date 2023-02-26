package com.guido.seguradora.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guido.seguradora.model.Claim;

public interface ClaimRepository extends JpaRepository<Claim, BigInteger> {

}
