package com.guido.seguradora.models;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "customer")
public class Customer implements Serializable {

	private static final long serialVersionUID = 2184721103530048525L;

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_customer", unique = true, nullable = false, precision = 11)
	private BigInteger idCustomer;

	@Column(name = "de_name", nullable = false, length = 200)
	private String deName;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_driver", nullable = false)
	private Driver driver;

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
