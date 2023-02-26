package com.guido.seguradora.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guido.seguradora.dto.CarDTO;
import com.guido.seguradora.model.Car;
import com.guido.seguradora.repository.CarRepository;

/**
 * Classe de serviços relacionados aos Veículos
 */
@Service
public class CarService {

	@Autowired
	private CarRepository repository;

	/**
	 * Incluir um novo Veiculo
	 */
	public Car save(CarDTO dto) throws Exception {
		Car car = dto.toCar();
		return repository.save(car);
	}

	/**
	 * Atualiza os dados do Veiculo
	 */
	public Car update(BigInteger id, Car car) {
		Optional<Car> optional = repository.findById(id);
		Car objectBD = null;
		if (optional.isPresent()) {
			objectBD = optional.get();
			objectBD.setDeManufacturer(car.getDeManufacturer());
			objectBD.setDeModel(car.getDeModel());
			objectBD.setNuYear(car.getNuYear());
			objectBD.setVrFipeValue(car.getVrFipeValue());
			objectBD = repository.save(objectBD);
		}
		return objectBD;
	}

	/**
	 * Retorna todos os Veículos cadastrados
	 */
	public List<Car> findAll() {
		List<Car> list = new ArrayList<Car>();
		repository.findAll().forEach(list::add);
		return list;
	}

	/**
	 * Retorna um Veiculo pelo id informado
	 */
	public Optional<Car> findById(BigInteger id) {
		return repository.findById(id);
	}

	/**
	 * Apaga um determinado Veiculo
	 */
	public void delete(BigInteger id) {
		repository.deleteById(id);
	}
}
