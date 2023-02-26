package com.guido.seguradora.models;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class CarDriverId implements Serializable {

	private static final long serialVersionUID = 607475753999760071L;



	public CarDriverId(Car car, Driver driver) {
	}

	public CarDriverId() {
	}


}