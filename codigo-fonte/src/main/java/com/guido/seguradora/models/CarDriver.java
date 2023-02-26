package com.guido.seguradora.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity(name = "car_drivers")
public class CarDriver implements Serializable {

	private static final long serialVersionUID = 62214941431215267L;

	@EmbeddedId
	private CarDriverId id;

	@Column(name = "is_main_driver", nullable = false, length = 1)
	private Boolean isMainDriver;

}
