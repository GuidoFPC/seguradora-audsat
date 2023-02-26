package com.guido.seguradora.dto;

import java.math.BigInteger;

import com.guido.seguradora.model.Customer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDTO {

	private BigInteger idDriver;
	private String name;

	public CustomerDTO() {
	}

	public CustomerDTO(Customer customer) {
		setIdDriver(customer.getDriver().getIdDriver());
		setName(customer.getDeName());
	}




}
