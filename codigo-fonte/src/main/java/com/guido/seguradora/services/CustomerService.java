package com.guido.seguradora.services;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guido.seguradora.models.Customer;
import com.guido.seguradora.repositories.CustomerRepository;

/**
 * Classe de serviços relacionados aos Clientes
 */
@Service
public class CustomerService {

	@Autowired
	private CustomerRepository repository;

	/**
	 * Incluir um novo Cliente
	 */
	public Customer save(Customer driver) throws Exception {
		return repository.save(driver);
	}

	/**
	 * Atualiza os dados do Cliente
	 */
	public Customer update(BigInteger id, Customer customer) {
		Optional<Customer> optional = repository.findById(id);
		Customer objectBD = null;
		if (optional.isPresent()) {
			objectBD = optional.get();
			objectBD.setDeName(customer.getDeName());
			objectBD.setDriver(customer.getDriver());
			objectBD = repository.save(objectBD);
		}
		return objectBD;
	}

	/**
	 * Retorna todos os Clientes cadastrados
	 */
	public List<Customer> findAll() {
		List<Customer> list = new ArrayList<Customer>();
		repository.findAll().forEach(list::add);
		return list;
	}

	/**
	 * Retorna um Cliente pelo id informado
	 */
	public Optional<Customer> findById(BigInteger id) {
		return repository.findById(id);
	}

	/**
	 * Apaga um determinado Cliente
	 */
	public void delete(BigInteger id) {
		repository.deleteById(id);
	}

}
