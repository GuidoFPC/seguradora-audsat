package com.guido.seguradora.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "cars")
public class Car implements Serializable {

	private static final long serialVersionUID = -3330256145176200484L;

	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_car", unique = true, nullable = false, precision = 11)
	private BigInteger idCar;

	@Column(name = "de_model", nullable = false, length = 100)
	private String deModel;

	@Column(name = "de_manufacturer", nullable = false, length = 200)
	private String deManufacturer;

	@Column(name = "de_year", nullable = false, length = 4)
	private String deYear;

	@Column(name = "vr_fipe_value", nullable = false, precision = 11, scale = 2)
	private BigDecimal vrFipeValue;

	@Override
	public boolean equals(Object other) {
		if (!(other instanceof Car))
			return false;
		return this.equalKeys(other) && ((Car) other).equalKeys(this);
	}

	@Override
	public int hashCode() {
		int i;
		int result = 17;
		if (getIdCar() == null) {
			i = 0;
		} else {
			i = getIdCar().hashCode();
		}
		result = 37 * result + i;
		return result;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("[Cars |");
		sb.append(" idCar=").append(getIdCar());
		sb.append("]");
		return sb.toString();
	}

	private boolean equalKeys(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof Car)) {
			return false;
		}
		Car that = (Car) other;
		Object myIdCar = this.getIdCar();
		Object yourIdCar = that.getIdCar();
		if (myIdCar == null ? yourIdCar != null : !myIdCar.equals(yourIdCar)) {
			return false;
		}
		return true;
	}
}
