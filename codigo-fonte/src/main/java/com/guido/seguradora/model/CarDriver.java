package com.guido.seguradora.model;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "car_drivers")
public class CarDriver implements Serializable {

	private static final long serialVersionUID = 62214941431215267L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_car_driver", unique = true, nullable = false, precision = 11)
	private BigInteger idCarDriver;

	@Column(name = "is_main_driver", nullable = false, length = 1)
	private Boolean isMainDriver;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_driver", nullable = false)
	private Driver driver;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_car", nullable = false)
	private Car car;

	/**
	 * Compares this instance with another Drivers.
	 *
	 * @param other The object to compare to
	 * @return True if the objects are the same
	 */
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof CarDriver))
			return false;
		return this.equalKeys(other) && ((CarDriver) other).equalKeys(this);
	}

	/**
	 * Returns a hash code for this instance.
	 *
	 * @return Hash code
	 */
	@Override
	public int hashCode() {
		int i;
		int result = 17;
		if (getIdCarDriver() == null) {
			i = 0;
		} else {
			i = getIdCarDriver().hashCode();
		}
		result = 37 * result + i;
		return result;
	}

	/**
	 * Compares the key for this instance with another Drivers.
	 *
	 * @param other The object to compare to
	 * @return True if other object is instance of class Drivers and the key objects
	 *         are equal
	 */
	private boolean equalKeys(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof Driver)) {
			return false;
		}
		Driver that = (Driver) other;
		Object myIdDriver = this.getIdCarDriver();
		Object yourIdDriver = that.getIdDriver();
		if (myIdDriver == null ? yourIdDriver != null : !myIdDriver.equals(yourIdDriver)) {
			return false;
		}
		return true;
	}
}
