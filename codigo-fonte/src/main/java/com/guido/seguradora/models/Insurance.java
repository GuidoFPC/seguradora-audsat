package com.guido.seguradora.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity(name = "insurances")
public class Insurance implements Serializable {

	private static final long serialVersionUID = -3433711569825109856L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_insurance", unique = true, nullable = false, precision = 11)
	private BigDecimal idInsurance;

	@Column(name = "dt_creation", nullable = false)
	private LocalDateTime dtCreation;

	@Column(name = "dt_updated")
	private LocalDateTime dtUpdated;

	@Column(name = "is_active", nullable = false, length = 1)
	private boolean isActive;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_car", nullable = false)
	private Car cars;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_customer", nullable = false)
	private Customer customer;

	public BigDecimal getIdInsurance() {
		return idInsurance;
	}

	public void setIdInsurance(BigDecimal idInsurance) {
		this.idInsurance = idInsurance;
	}

	public LocalDateTime getDtCreation() {
		return dtCreation;
	}

	public void setDtCreation(LocalDateTime dtCreation) {
		this.dtCreation = dtCreation;
	}

	public LocalDateTime getDtUpdated() {
		return dtUpdated;
	}

	public void setDtUpdated(LocalDateTime dtUpdated) {
		this.dtUpdated = dtUpdated;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Car getCars() {
		return cars;
	}

	public void setCars(Car cars) {
		this.cars = cars;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * Compares this instance with another Insurances.
	 *
	 * @param other The object to compare to
	 * @return True if the objects are the same
	 */
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof Insurance))
			return false;
		return this.equalKeys(other) && ((Insurance) other).equalKeys(this);
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
		if (getIdInsurance() == null) {
			i = 0;
		} else {
			i = getIdInsurance().hashCode();
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
		StringBuffer sb = new StringBuffer("[Insurances |");
		sb.append(" idInsurance=").append(getIdInsurance());
		sb.append("]");
		return sb.toString();
	}

	/**
	 * Compares the key for this instance with another Insurances.
	 *
	 * @param other The object to compare to
	 * @return True if other object is instance of class Insurances and the key
	 *         objects are equal
	 */
	private boolean equalKeys(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof Insurance)) {
			return false;
		}
		Insurance that = (Insurance) other;
		Object myIdInsurance = this.getIdInsurance();
		Object yourIdInsurance = that.getIdInsurance();
		if (myIdInsurance == null ? yourIdInsurance != null : !myIdInsurance.equals(yourIdInsurance)) {
			return false;
		}
		return true;
	}
}
