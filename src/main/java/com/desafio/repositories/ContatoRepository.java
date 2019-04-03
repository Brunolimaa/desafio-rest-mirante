package com.desafio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafio.domain.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Integer>{

}
