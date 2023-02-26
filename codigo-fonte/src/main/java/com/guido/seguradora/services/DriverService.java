package com.guido.seguradora.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guido.seguradora.models.Driver;
import com.guido.seguradora.repositories.DriverRepository;

@Service
public class DriverService {

	@Autowired
	private DriverRepository repository;

	@Transactional
	public Driver save(Driver driver) throws Exception {
		return repository.save(driver);
	}

}
