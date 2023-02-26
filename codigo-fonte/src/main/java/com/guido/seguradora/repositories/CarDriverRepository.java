package com.guido.seguradora.repositories;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.guido.seguradora.models.CarDriver;

public interface CarDriverRepository extends JpaRepository<CarDriver, BigInteger> {

	@Query(value = " select cd from car_drivers cd where cd.car.idCar = :idCar ")
	List<CarDriver> findByCar(@Param("idCar") BigInteger idCar);

}
