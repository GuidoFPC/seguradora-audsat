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

	private String year;

	private BigDecimal fipeValue;

	public Car toCar() {
		Car car = new Car();
		car.setDeModel(model);
		car.setDeManufacturer(manufacturer);
		car.setDeYear(year);
		car.setVrFipeValue(fipeValue);
		return car;
	}
}
