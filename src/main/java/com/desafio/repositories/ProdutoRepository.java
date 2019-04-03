package com.desafio.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.desafio.domain.Usuario;
import com.desafio.domain.Historico;

@Repository
public interface ProdutoRepository extends JpaRepository<Historico, Integer> {
	
	@Query(value = "SELECT * FROM produto prod INNER JOIN loja l ON prod.id = l.id", nativeQuery = true)
	List<Historico> findLojas();
	
	@Query(value = "SELECT id FROM produto WHERE nome = :nome AND marca = :marca GROUP BY nome, marca ", nativeQuery = true)
	Integer verificaProdutoCadastro(String nome, String marca);
}
                                                               