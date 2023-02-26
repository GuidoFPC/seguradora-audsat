package com.guido.seguradora.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;

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
@Table(name = "claims")
public class Claim implements Serializable {

	private static final long serialVersionUID = 1909798621475948943L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_claim", unique = true, nullable = false, precision = 11)
	private BigInteger idClaim;

	@Column(name = "dt_event", nullable = false)
	private LocalDateTime dtEvent;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_car", nullable = false)
	private Car car;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_driver", nullable = false)
	private Driver driver;

	@Override
	public boolean equals(Object other) {
		if (!(other instanceof Claim))
			return false;
		return this.equalKeys(other) && ((Claim) other).equalKeys(this);
	}

	@Override
	public int hashCode() {
		int i;
		int result = 17;
		if (getIdClaim() == null) {
			i = 0;
		} else {
			i = getIdClaim().hashCode();
		}
		result = 37 * result + i;
		return result;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("[Claims |");
		sb.append(" idClaim=").append(getIdClaim());
		sb.append("]");
		return sb.toString();
	}

	private boolean equalKeys(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof Claim)) {
			return false;
		}
		Claim that = (Claim) other;
		Object myIdClaim = this.getIdClaim();
		Object yourIdClaim = that.getIdClaim();
		if (myIdClaim == null ? yourIdClaim != null : !myIdClaim.equals(yourIdClaim)) {
			return false;
		}
		return true;
	}
}
