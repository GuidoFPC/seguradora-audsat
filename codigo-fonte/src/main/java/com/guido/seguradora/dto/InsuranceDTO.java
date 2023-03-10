package com.guido.seguradora.dto;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.guido.seguradora.model.Insurance;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InsuranceDTO {

	private BigInteger idInsurance;

	private Boolean active; // Flag se o orçamento está ativo

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime dtCreation; // Data da solicitação do orçamento

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime dtUpdated; // Data da atualização do orçamento

	private CarDTO car;

	private List<DriverDTO> drivers;

	private List<ClaimDTO> claims;

	private CustomerDTO customer;

	private Double vrOrcamento;

	public Insurance toInsurance() {
		Insurance insurance = new Insurance();
		if (active != null) {
			insurance.setActive(active);
		}
		return insurance;
	}



}
