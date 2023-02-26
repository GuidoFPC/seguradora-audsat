package com.guido.seguradora.services;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guido.seguradora.models.Claim;
import com.guido.seguradora.repositories.ClaimRepository;

/**
 * Classe de serviços relacionados aos Sinistros
 */
@Service
public class ClaimService {

	@Autowired
	private ClaimRepository repository;

	/**
	 * Incluir um novo Sinistro
	 */
	public Claim save(Claim driver) throws Exception {
		return repository.save(driver);
	}

	/**
	 * Atualiza os dados do Sinistro
	 */
	public Claim update(BigInteger id, Claim claim) {
		Optional<Claim> optional = repository.findById(id);
		Claim objectBD = null;
		if (optional.isPresent()) {
			objectBD = optional.get();
			objectBD.setCar(claim.getCar());
			objectBD.setDriver(claim.getDriver());
			objectBD.setDtEvent(claim.getDtEvent());
			objectBD = repository.save(objectBD);
		}
		return objectBD;
	}

	/**
	 * Retorna todos os Sinistros cadastrados
	 */
	public List<Claim> findAll() {
		List<Claim> list = new ArrayList<Claim>();
		repository.findAll().forEach(list::add);
		return list;
	}

	/**
	 * Retorna um Sinistro pelo id informado
	 */
	public Optional<Claim> findById(BigInteger id) {
		return repository.findById(id);
	}

	/**
	 * Apaga um determinado Sinistro
	 */
	public void delete(BigInteger id) {
		repository.deleteById(id);
	}
}
