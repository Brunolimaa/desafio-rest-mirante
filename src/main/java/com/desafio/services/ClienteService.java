package com.desafio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.desafio.domain.Cliente;
import com.desafio.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public List<Cliente> findAll() {
		return repo.findAll();
	}
	
	public Cliente findById(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	public Cliente save(Cliente entity) {
		entity.setId(null);
		return repo.save(entity);
	}
	
	public Cliente update(Cliente entity) {
		return repo.save(entity);
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
}
