package com.guido.seguradora.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guido.seguradora.dto.ClaimDTO;
import com.guido.seguradora.model.Car;
import com.guido.seguradora.model.Claim;
import com.guido.seguradora.model.Driver;
import com.guido.seguradora.repository.ClaimRepository;

/**
 * Classe de serviços relacionados aos Sinistros
 */
@Service
public class ClaimService {

	@Autowired
	private CarDriverService carDriverService;

	@Autowired
	private ClaimRepository repository;

	/**
	 * Incluir um novo Sinistro
	 */
	public Claim save(Claim claim) throws Exception {
		return repository.save(claim);
	}

	/**
	 * Incluir os Sinistro para o carro de acordo com o Documento do Motorista
	 * informado no payload
	 */
	public void saveClaims(Car car, List<ClaimDTO> claims) {
		for (ClaimDTO claimDTO : claims) {

			Driver driver = carDriverService.findByCarAndDocument(claimDTO.getDocument(), car);

			Claim claim = new Claim();
			claim.setCar(car);
			claim.setDriver(driver);
			claim.setDtEvent(claimDTO.getDtEvent());

			repository.save(claim);
		}
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
	 * O motorista possui sinitro ?
	 */
	public Boolean isDriverHaveClaim(Driver driver) {
		List<Claim> list = repository.findByDriver(driver);
		return list.size() > 0;
	}

	/**
	 * O veículo possui sinitro ?
	 */
	public Boolean isCarHaveClaim(Car car) {
		List<Claim> list = repository.findByCar(car);
		return list.size() > 0;
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
