package com.desafio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.domain.Usuario;
import com.desafio.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repo;
	
	public List<Usuario> findAll() {
		return repo.findAll();
	}
	
	public Usuario findById(Integer id) {
		Optional<Usuario> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	public Usuario save(Usuario entity) {
		entity.setId(null);
		return repo.save(entity);
	}
	
	public Usuario update(Usuario entity) {
		return repo.save(entity);
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
}
