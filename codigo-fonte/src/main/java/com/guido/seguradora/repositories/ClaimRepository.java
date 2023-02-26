package com.guido.seguradora.repositories;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guido.seguradora.models.Claim;

public interface ClaimRepository extends JpaRepository<Claim, BigInteger> {

}
