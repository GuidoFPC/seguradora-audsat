package com.guido.seguradora.service;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guido.seguradora.dto.InsuranceDTO;
import com.guido.seguradora.model.Car;
import com.guido.seguradora.model.Customer;
import com.guido.seguradora.model.Insurance;
import com.guido.seguradora.repository.InsuranceRepository;

/**
 * Classe de serviços relacionados à precificação de seguros
 */
@Service
public class InsuranceService {

	@Autowired
	private CarService carService;

	@Autowired
	private CarDriverService carDriverService;

	@Autowired
	private ClaimService claimService;

	@Autowired
	private InsuranceRepository repository;

	/**
	 * Cadastra um novo Orçamento de Seguros
	 */
	public Insurance save(InsuranceDTO dto) throws Exception {

		Car car = carService.save(dto.getCar());

		Customer customer = carDriverService.saveCarDrivers(car, dto.getDrivers());

		claimService.saveClaims(car, dto.getClaims());

		Insurance insurance = dto.toInsurance();
		insurance.setActive(Boolean.TRUE);
		insurance.setDtCreation(LocalDateTime.now());
		insurance.setCar(car);
		insurance.setCustomer(customer);

		return repository.save(insurance);
	}

	/**
	 * Atualiza os dados do Precificação de Seguros
	 */
	public Insurance update(BigInteger id, Insurance insurance) {
		Optional<Insurance> optional = repository.findById(id);
		Insurance objectBD = null;
		if (optional.isPresent()) {
			objectBD = optional.get();
			objectBD.setActive(insurance.isActive());
			objectBD.setCar(insurance.getCar());
			objectBD.setCustomer(insurance.getCustomer());
			objectBD.setDtUpdated(LocalDateTime.now());
			objectBD = repository.save(objectBD);
		}
		return objectBD;
	}

	/**
	 * Retorna todos as precificações cadastradas
	 */
	public List<Insurance> findAll() {
		List<Insurance> list = new ArrayList<Insurance>();
		repository.findAll().forEach(list::add);
		return list;
	}

	/**
	 * Retorna um Precificação de Seguros pelo id informado
	 * 
	 * ----------------------------------------------------------------------------------------
	 * TODO: ATENCAO: NESTA CONSULTA DEVE-SE RETORNAR OS DADOS DO ORÇAMENTO E O VALOR CALCULADO
	 * ----------------------------------------------------------------------------------------
	 */
	public Optional<Insurance> findById(BigInteger id) {
		return repository.findById(id);
	}

	/**
	 * Apaga um determinado Precificação de Seguros
	 */
	public void delete(BigInteger id) {
		repository.deleteById(id);
	}

}
