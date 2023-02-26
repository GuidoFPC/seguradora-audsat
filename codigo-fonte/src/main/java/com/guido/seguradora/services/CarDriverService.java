package com.guido.seguradora.services;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guido.seguradora.models.CarDriver;
import com.guido.seguradora.repositories.CarDriverRepository;

/**
 * Classe de serviços relacionados aos Motoristas dos Veículos
 */
@Service
public class CarDriverService {

	@Autowired
	private CarDriverRepository repository;

	/**
	 * Incluir um novo Motorista do Veículo
	 */
	public CarDriver save(CarDriver driver) throws Exception {
		return repository.save(driver);
	}

	/**
	 * Atualiza os dados do Motorista do Veículo
	 */
	public CarDriver update(BigInteger id, CarDriver carDriver) {
		Optional<CarDriver> optional = repository.findById(id);
		CarDriver objectBD = null;
		if (optional.isPresent()) {
			objectBD = optional.get();
			objectBD.setCar(carDriver.getCar());
			objectBD.setDriver(carDriver.getDriver());
			objectBD.setIsMainDriver(carDriver.getIsMainDriver());
			objectBD = repository.save(objectBD);
		}
		return objectBD;
	}

	/**
	 * Retorna todos os Motoristas cadastrados
	 */
	public List<CarDriver> findAll() {
		List<CarDriver> list = new ArrayList<CarDriver>();
		repository.findAll().forEach(list::add);
		return list;
	}

	/**
	 * Retorna um Motorista do Veículo pelo id informado
	 */
	public Optional<CarDriver> findById(BigInteger id) {
		return repository.findById(id);
	}

	/**
	 * Retorna um Motorista do Veículo pelo id do Veículo
	 */
	public List<CarDriver> findByCar(BigInteger idCar) {
		return repository.findByCar(idCar);
	}

	/**
	 * Apaga um determinado Motorista do Veículo
	 */
	public void delete(BigInteger id) {
		repository.deleteById(id);
	}
}
