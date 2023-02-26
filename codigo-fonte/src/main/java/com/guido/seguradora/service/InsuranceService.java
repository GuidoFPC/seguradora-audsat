package com.guido.seguradora.service;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guido.seguradora.dto.BudgetDTO;
import com.guido.seguradora.dto.CarDTO;
import com.guido.seguradora.dto.CustomerDTO;
import com.guido.seguradora.dto.InsuranceDTO;
import com.guido.seguradora.model.Car;
import com.guido.seguradora.model.Customer;
import com.guido.seguradora.model.Driver;
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

	public Optional<Insurance> findById(BigInteger id) {
		return repository.findById(id);
	}

	/**
	 * Retorna um Precificação de Seguros pelo id informado
	 */
	public BudgetDTO findByIdToDto(BigInteger id) {
		Optional<Insurance> optional = repository.findById(id);
		BudgetDTO dto = null;
		if (optional.isPresent()) {
			Insurance insurance = optional.get();
			dto = new BudgetDTO();
			dto.setActive(insurance.isActive());
			dto.setIdInsurance(insurance.getIdInsurance());
			dto.setDtCreation(insurance.getDtCreation());
			dto.setDtUpdated(insurance.getDtUpdated());
			dto.setCar(new CarDTO(insurance.getCar()));
			dto.setCustomer(new CustomerDTO(insurance.getCustomer()));

			double taxa = 6.0; // O valor base de cálculo do orçamento é de 6% com base no valor da tabela fipe do veículo

			// O motorista principal se encontra na faixa etária de 18 a 25 anos
			Driver driver = insurance.getCustomer().getDriver();
			int years = Period.between(driver.getDtBirthdate(), LocalDate.now()).getYears();
			if (years > 18 && years < 25) {
				taxa += 2.0;
			}
			
			// O motorista principal possui sinistro em seu nome
			Boolean isDriverHaveClaim = claimService.isDriverHaveClaim(driver);
			if (isDriverHaveClaim) {
				taxa += 2.0;
			}

			// O veículo ao qual será segurado possui sinistro
			Boolean isCarHaveClaim = claimService.isCarHaveClaim(insurance.getCar());
			if (isCarHaveClaim) {
				taxa += 2.0;
			}

			// Valor do veículo x a taxa
			Double value = (insurance.getCar().getVrFipeValue().doubleValue() / 100) * taxa;
			dto.setVrOrcamento(Double.valueOf(value));
		}
		return dto;
	}

	/**
	 * Apaga um determinado Precificação de Seguros
	 */
	public void delete(BigInteger id) {
		repository.deleteById(id);
	}

}
