package com.desafio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafio.domain.Historico;

@Repository
public interface HistoricoRepository extends JpaRepository<Historico, Integer>{

}
