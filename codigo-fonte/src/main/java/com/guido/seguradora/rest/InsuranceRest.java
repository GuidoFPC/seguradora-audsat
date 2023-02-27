package com.guido.seguradora.rest;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guido.seguradora.dto.BudgetDTO;
import com.guido.seguradora.dto.InsuranceDTO;
import com.guido.seguradora.model.Insurance;
import com.guido.seguradora.service.InsuranceService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Disponibilidade das funções rest para Orçamento de Seguro.
 */
@RestController
@RequestMapping("/insurance/budget")
@Api(value = "Rest API Insurances")
@CrossOrigin(origins = "*", maxAge = 3600)
public class InsuranceRest {

	@Autowired
	private InsuranceService service;

	@PostMapping
	@ApiOperation(value = "Cadastro de Orçamento")
	public ResponseEntity<Object> saveInsurance(@RequestBody InsuranceDTO dto) {
		try {
			Insurance _insurance = service.save(dto);

			return new ResponseEntity<>(_insurance, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Consulta de Orçamento")
	public ResponseEntity<BudgetDTO> findInsuranceById(@PathVariable("id") BigInteger id) {
		BudgetDTO dto = service.findByIdToDto(id);

		if (dto != null) {
			return new ResponseEntity<>(dto, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "Atualização de Orçamento")
	public ResponseEntity<Insurance> updateInsurance(@PathVariable(value = "id") BigInteger id, @RequestBody Insurance insurance) {
		Insurance _insuranceBD = service.update(id, insurance);

		if (_insuranceBD != null) {
			return new ResponseEntity<>(_insuranceBD, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Remoção de Orçamento")
	public ResponseEntity<HttpStatus> deleteInsurance(@PathVariable("id") BigInteger id) {
		try {
			service.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
