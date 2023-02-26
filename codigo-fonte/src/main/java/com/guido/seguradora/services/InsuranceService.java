package com.guido.seguradora.services;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guido.seguradora.models.Insurance;
import com.guido.seguradora.repositories.InsuranceRepository;

/**
 * Classe de serviços relacionados à precificação de seguros
 */
@Service
public class InsuranceService {

	@Autowired
	private InsuranceRepository repository;

	/**
	 * Incluir um novo Precificação de Seguros
	 */
	public Insurance save(Insurance insurance) throws Exception {
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
			objectBD.setDtUpdated(new Date());
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
