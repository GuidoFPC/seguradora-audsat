package com.guido.seguradora.models;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "drivers")
public class Driver implements Serializable {

	private static final long serialVersionUID = -826124721603823589L;

	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_driver", unique = true, nullable = false, precision = 11)
	private BigInteger idDriver;

	@Column(name = "nu_document", nullable = false, precision = 11)
	private BigInteger nuDocument;

	@Column(name = "dt_birthdate", nullable = false)
	private LocalDate dtBirthdate;

	/**
	 * Compares this instance with another Drivers.
	 *
	 * @param other The object to compare to
	 * @return True if the objects are the same
	 */
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof Driver))
			return false;
		return this.equalKeys(other) && ((Driver) other).equalKeys(this);
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
		if (getIdDriver() == null) {
			i = 0;
		} else {
			i = getIdDriver().hashCode();
		}
		result = 37 * result + i;
		return result;
	}

	/**
	 * Returns a debug-friendly String representation of this instance.
	 *
	 * @return String representation of this instance
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("[Drivers |");
		sb.append(" idDriver=").append(getIdDriver());
		sb.append("]");
		return sb.toString();
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
		Object myIdDriver = this.getIdDriver();
		Object yourIdDriver = that.getIdDriver();
		if (myIdDriver == null ? yourIdDriver != null : !myIdDriver.equals(yourIdDriver)) {
			return false;
		}
		return true;
	}
}
