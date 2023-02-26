package com.guido.seguradora.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.guido.seguradora.model.CarDriver;
import com.guido.seguradora.model.Driver;

public interface CarDriverRepository extends JpaRepository<CarDriver, BigInteger> {

	@Query(value = " select cd from CarDriver cd where cd.car.idCar = :idCar ")
	List<CarDriver> findByCar(@Param("idCar") BigInteger idCar);

	@Query(value = " select cd.driver from CarDriver cd where cd.car.idCar = :idCar and cd.driver.nuDocument = :nuDocument ")
	Driver findByCarAndDocument(@Param("nuDocument") BigInteger document, @Param("idCar") BigInteger idCar);

}
