package com.guido.seguradora.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.guido.seguradora.model.Customer;
import com.guido.seguradora.model.Insurance;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InsuranceDTO {

	private BigDecimal idInsurance;

	private Boolean isActive; // Flag se o orçamento está ativo

	private Date dtCreation; // Data da solicitação do orçamento

	private Date dtUpdated; // Data da atualização do orçamento

	private CarDTO car;

	private List<DriverDTO> drivers;

	private List<ClaimDTO> claims;

	private Customer customer;

	public Insurance toInsurance() {
		Insurance insurance = new Insurance();
		if (isActive != null) {
			insurance.setActive(isActive);
		}
		return insurance;
	}



}
