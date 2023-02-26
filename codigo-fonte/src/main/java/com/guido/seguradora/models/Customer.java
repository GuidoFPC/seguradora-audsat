package com.guido.seguradora.models;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name = "customer")
public class Customer implements Serializable {

	private static final long serialVersionUID = 2184721103530048525L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_customer", unique = true, nullable = false, precision = 11)
	private BigInteger idCustomer;

	@Column(name = "de_name", nullable = false, length = 200)
	private String deName;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_driver", nullable = false)
	private Driver drivers;

	@OneToMany(mappedBy = "customer")
	private Set<Insurance> insurances;

	public BigInteger getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(BigInteger idCustomer) {
		this.idCustomer = idCustomer;
	}

	public String getDeName() {
		return deName;
	}

	public void setDeName(String deName) {
		this.deName = deName;
	}

	public Driver getDrivers() {
		return drivers;
	}

	public void setDrivers(Driver drivers) {
		this.drivers = drivers;
	}

	public Set<Insurance> getInsurances() {
		return insurances;
	}

	public void setInsurances(Set<Insurance> insurances) {
		this.insurances = insurances;
	}

	/**
	 * Compares this instance with another Customer.
	 *
	 * @param other The object to compare to
	 * @return True if the objects are the same
	 */
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof Customer))
			return false;
		return this.equalKeys(other) && ((Customer) other).equalKeys(this);
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
		if (getIdCustomer() == null) {
			i = 0;
		} else {
			i = getIdCustomer().hashCode();
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
		StringBuffer sb = new StringBuffer("[Customer |");
		sb.append(" idCustomer=").append(getIdCustomer());
		sb.append("]");
		return sb.toString();
	}

	/**
	 * Compares the key for this instance with another Customer.
	 *
	 * @param other The object to compare to
	 * @return True if other object is instance of class Customer and the key
	 *         objects are equal
	 */
	private boolean equalKeys(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof Customer)) {
			return false;
		}
		Customer that = (Customer) other;
		Object myIdCustomer = this.getIdCustomer();
		Object yourIdCustomer = that.getIdCustomer();
		if (myIdCustomer == null ? yourIdCustomer != null : !myIdCustomer.equals(yourIdCustomer)) {
			return false;
		}
		return true;
	}
}
