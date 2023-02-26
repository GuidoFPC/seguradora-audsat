package com.guido.seguradora.dto;

import java.math.BigInteger;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BudgetDTO {

	private BigInteger idInsurance;

	private Boolean active; // Flag se o orçamento está ativo

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime dtCreation; // Data da solicitação do orçamento

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime dtUpdated; // Data da atualização do orçamento

	private CarDTO car;

	private CustomerDTO customer;

	private Double vrOrcamento;

}
