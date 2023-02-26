package com.guido.seguradora;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.guido.seguradora.dto.CarDTO;
import com.guido.seguradora.dto.ClaimDTO;
import com.guido.seguradora.dto.DriverDTO;
import com.guido.seguradora.dto.InsuranceDTO;
import com.guido.seguradora.model.Insurance;
import com.guido.seguradora.service.InsuranceService;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class SeguradoraApplicationTests {

	@Autowired
	private InsuranceService insuranceService;

	/**
	 * Teste de inclusão de um Orçamento
	 */
	@DisplayName("Single test save")
	@Test
	void saveInsurance() throws Exception {
		
		CarDTO car = new CarDTO();
		DriverDTO driver = new DriverDTO();
		ClaimDTO claim = new ClaimDTO();
		BigInteger documentNumber = BigInteger.valueOf(1234567890);

		car.setModel("Corolla Cross");
		car.setManufacturer("Toyota");
		car.setYear(2022);
		car.setFipeValue(BigDecimal.valueOf(270000.00));

		driver.setDocument(documentNumber);
		driver.setName("John Ciclans Silva");
		driver.setBirthdate(LocalDate.parse("2000-11-25"));
		driver.setMain(true);

		claim.setDocument(documentNumber);
		claim.setDtEvent(LocalDateTime.parse("2023-01-01T10:45"));

		InsuranceDTO insuranceDTO = new InsuranceDTO();
		insuranceDTO.setCar(car);
		insuranceDTO.setDrivers(new ArrayList<>());
		insuranceDTO.getDrivers().add(driver);
		insuranceDTO.setClaims(new ArrayList<>());
		insuranceDTO.getClaims().add(claim);

		Insurance _insurance = insuranceService.save(insuranceDTO);

		log.info("idInsurance: " + _insurance.getIdInsurance());
		
		assertTrue(_insurance != null && _insurance.getIdInsurance() != null);
	}

}
