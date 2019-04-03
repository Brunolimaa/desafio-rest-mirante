package com.desafio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.desafio.domain.Usuario;
import com.desafio.repositories.UsuarioRepository;
import com.desafio.security.UserSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository repo;

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Usuario usuario = repo.findByLogin(login);
		if(usuario == null) {
			throw new UsernameNotFoundException(login);
		}
		return new UserSS(usuario.getId(), usuario.getLogin(), usuario.getSenha(), usuario.getPerfis());
	}

}
