package com.guido.seguradora.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guido.seguradora.dto.DriverDTO;
import com.guido.seguradora.model.Car;
import com.guido.seguradora.model.CarDriver;
import com.guido.seguradora.model.Customer;
import com.guido.seguradora.model.Driver;
import com.guido.seguradora.repository.CarDriverRepository;

/**
 * Classe de serviços relacionados aos Motoristas dos Veículos
 */
@Service
public class CarDriverService {

	@Autowired
	private DriverService driverService;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private CarDriverRepository repository;

	/**
	 * Incluir um novo Motorista do Veículo
	 */
	public CarDriver save(CarDriver driver) throws Exception {
		return repository.save(driver);
	}

	/**
	 * 1. Salva os mostoristas do veículo<br/> 
	 * 2. Salva os Objetos CarDriver<br/>
	 * 3. Caso encontre o Motorista Principal o inclui também<br/> 
	 * 4. Ao cadastrar cadastrar o motorista principal (CarDriver) o assumimos 
	 * como Cliente do Orçamento. ( Essa regra não foi definida, todavia, dessa 
	 * forma, o payload fica mais claro, permitindo o cadastro de vários motoristas 
	 * do veículo. Também poderia haver um campo para definir quem é o Cliente de 
	 * cadastro do Orçamento, todavia, pelo modelo proposto, considerei a solução 
	 * mais plausível ).
	 * 
	 * @param car
	 * @param drivers Motoristas do veículo
	 * 
	 * @return Customer - Motorista Principal
	 */
	public Customer saveCarDrivers(Car car, List<DriverDTO> drivers) throws Exception {
		Customer customer = null;

		for (DriverDTO driverDTO : drivers) {
			// carDriverService.save(car, driverDTO);

			// Salva o Driver
			Driver driver = new Driver();
			driver.setNuDocument(driverDTO.getDocument());
			driver.setDtBirthdate(driverDTO.getBirthdate());
			driver = driverService.save(driver);

			// Salva CarDriver
			CarDriver carDriver = new CarDriver();
			carDriver.setCar(car);
			carDriver.setDriver(driver);
			carDriver.setIsMainDriver(driverDTO.getMain() != null ? driverDTO.getMain() : Boolean.FALSE);
			carDriver = save(carDriver);

			// Se este for o Motorista principal, ele é tido como o Cliente do Orçamento
			if (carDriver.getIsMainDriver()) {
				customer = customerService.save(driver, driverDTO.getName());
			}
		}

		return customer;
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
	 * Apaga um determinado Motorista do Veículo
	 */
	public void delete(BigInteger id) {
		repository.deleteById(id);
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

	public Driver findByCarAndDocument(BigInteger document, Car car) {
		return repository.findByCarAndDocument(document, car.getIdCar());
	}
}
