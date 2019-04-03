package com.desafio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.domain.Endereco;
import com.desafio.repositories.EnderecoRepository;

@Service
public class EnderecoService {
	
	@Autowired
	private EnderecoRepository repo;
	
	public Endereco save(Endereco endereco) {
		endereco.setId(null);
		return repo.save(endereco);
	}
	
	public Endereco update(Endereco endereco) {
		return repo.save(endereco);
	}
	
	public List<Endereco> findAll(){
		return repo.findAll();
	}
	
	public Endereco find(Integer id) {
		Optional<Endereco> endereco = repo.findById(id);
		return endereco.orElse(null);
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
}
