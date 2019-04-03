package com.desafio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.desafio.domain.Cliente;
import com.desafio.domain.Usuario;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
