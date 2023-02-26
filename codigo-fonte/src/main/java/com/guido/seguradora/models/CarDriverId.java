package com.guido.seguradora.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class CarDriverId implements Serializable {

	private static final long serialVersionUID = 607475753999760071L;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_driver", nullable = false, insertable = false, updatable = false)
	private Driver driver;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_car", nullable = false, insertable = false, updatable = false)
	private Car car;

	public CarDriverId(Car car, Driver driver) {
		setCar(car);
		setDriver(driver);
	}

	public CarDriverId() {
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		CarDriverId that = (CarDriverId) o;
		return Objects.equals(getCar().getIdCar(), that.getCar().getIdCar())
				&& Objects.equals(getDriver().getIdDriver(), that.getDriver().getIdDriver());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getCar().getIdCar(), getDriver().getIdDriver());
	}
}