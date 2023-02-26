package com.guido.seguradora.dto;

import java.math.BigDecimal;
import java.math.BigInteger;

import com.guido.seguradora.model.Car;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarDTO {

	private BigInteger idCar;

	private String model;

	private String manufacturer;

	private Integer year;

	private BigDecimal fipeValue;

	public CarDTO() {
	}

	public CarDTO(Car car) {
		setIdCar(car.getIdCar());
		setModel(car.getDeModel());
		setManufacturer(car.getDeManufacturer());
		setYear(car.getNuYear());
		setFipeValue(car.getVrFipeValue());
	}

	public Car toCar() {
		Car car = new Car();
		car.setDeModel(model);
		car.setDeManufacturer(manufacturer);
		car.setNuYear(year);
		car.setVrFipeValue(fipeValue);
		return car;
	}
}
