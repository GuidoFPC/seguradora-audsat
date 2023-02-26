package com.guido.seguradora.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guido.seguradora.models.Driver;
import com.guido.seguradora.services.DriverService;

// https://www.bezkoder.com/spring-boot-jpa-h2-example/

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/driver")
public class DriverRest {

	@Autowired
	private DriverService service;

	@PostMapping
	public ResponseEntity<Driver> createTutorial(@RequestBody Driver driver) {
		try {

			Driver _driver = service.save(driver);
			return new ResponseEntity<>(_driver, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping
	public ResponseEntity<String> getMethod() {
		return ResponseEntity.status(HttpStatus.OK).body("OK");
	}
}
