package com.guido.seguradora.rest;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

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

import com.guido.seguradora.models.CarDriver;
import com.guido.seguradora.services.CarDriverService;

/**
 * Disponibilidade das funções rest para Motoristas dos Veículos.
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/cardriver")
public class CarDriverRest {

	@Autowired
	private CarDriverService service;

	/**
	 * Incluir um motorista de veículo
	 */
	@PostMapping
	public ResponseEntity<CarDriver> save(@RequestBody CarDriver driver) {
		try {
			CarDriver _driver = service.save(driver);

			return new ResponseEntity<>(_driver, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Lista todos os motoristas de veículo
	 */
	@GetMapping
	public ResponseEntity<List<CarDriver>> all() {
		try {
			List<CarDriver> drivers = service.findAll();

			if (drivers.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(drivers, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Retorna um motorista de veículo pelo ID
	 */
	@GetMapping("/{id}")
	public ResponseEntity<CarDriver> findById(@PathVariable("id") BigInteger id) {
		Optional<CarDriver> data = service.findById(id);

		if (data.isPresent()) {
			return new ResponseEntity<>(data.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Atualiza os dados de um motorista de veículo
	 */
	@PutMapping("/{id}")
	public ResponseEntity<CarDriver> update(@PathVariable(value = "id") BigInteger id, @RequestBody CarDriver driver) {
		CarDriver _driverBD = service.update(id, driver);

		if (_driverBD != null) {
			return new ResponseEntity<>(_driverBD, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Apaga um determinado motorista de veículo por ID.
	 * 
	 * @param id
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") BigInteger id) {
		try {
			service.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
