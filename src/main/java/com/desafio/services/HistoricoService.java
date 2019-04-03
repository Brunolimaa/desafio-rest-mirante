package com.desafio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.domain.Historico;
import com.desafio.repositories.HistoricoRepository;

@Service
public class HistoricoService {
	
	@Autowired
	private HistoricoRepository repo;
	
	public List<Historico> findAll(){
		return repo.findAll();
	}
	
	public Historico findById(Integer id) {
		Optional<Historico> Historico = repo.findById(id);
		return Historico.orElse(null);
	}
		
	public Historico save(Historico Historico) {
		Historico.setId(null);
		return repo.save(Historico);
	}
	
	public Historico update(Historico Historico) {
		return repo.save(Historico);
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}

}
