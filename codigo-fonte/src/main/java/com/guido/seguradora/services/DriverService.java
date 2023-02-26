package com.guido.seguradora.services;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guido.seguradora.models.Driver;
import com.guido.seguradora.repositories.DriverRepository;

/**
 * Classe de serviços relacionados aos Motoristas
 */
@Service
public class DriverService {

	@Autowired
	private DriverRepository repository;

	/**
	 * Incluir um novo Motorista
	 */
	public Driver save(Driver driver) throws Exception {
		return repository.save(driver);
	}

	/**
	 * Atualiza os dados do Motorista
	 */
	public Driver update(BigInteger id, Driver driver) {
		Optional<Driver> optional = repository.findById(id);
		Driver objectBD = null;
		if (optional.isPresent()) {
			objectBD = optional.get();
			objectBD.setDtBirthdate(driver.getDtBirthdate());
			objectBD.setNuDocument(driver.getNuDocument());
			objectBD = repository.save(objectBD);
		}
		return objectBD;
	}

	/**
	 * Retorna todos os Motoristas cadastrados
	 */
	public List<Driver> findAll() {
		List<Driver> list = new ArrayList<Driver>();
		repository.findAll().forEach(list::add);
		return list;
	}

	/**
	 * Retorna um Motorista pelo id informado
	 */
	public Optional<Driver> findById(BigInteger id) {
		return repository.findById(id);
	}

	/**
	 * Apaga um determinado Motorista
	 */
	public void delete(BigInteger id) {
		repository.deleteById(id);
	}

}
