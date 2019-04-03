package com.desafio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.domain.Contato;
import com.desafio.domain.Historico;
import com.desafio.repositories.ContatoRepository;
import com.desafio.repositories.ProdutoRepository;

@Service
public class ContatoService {
	
	@Autowired
	private ContatoRepository repo;
	
	public List<Contato> findAll(){
		return repo.findAll();
	}
	
	public Contato findById(Integer id) {
		Optional<Contato> produto = repo.findById(id);
		return produto.orElse(null);
	}
	
	public Contato save(Contato produto) {
		produto.setId(null);
		return repo.save(produto);
	}
	
	public Contato update(Contato produto) {
		return repo.save(produto);
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
	
//	public Integer verificaProdutoCadastro(Historico produto) {
//		return repo.verificaProdutoCadastro(produto.getNome(), produto.getMarca()) == null ? 0 : repo.verificaProdutoCadastro(produto.getNome(), produto.getMarca());
//	}
}
