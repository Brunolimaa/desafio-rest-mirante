package com.desafio.dto;

import java.io.Serializable;

import com.desafio.domain.Usuario;


public class UsuarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String login;
	private String senha;
	
	public UsuarioDTO(Usuario usuario) {
		super();
		this.id = usuario.getId();
		this.login = usuario.getLogin();
		this.senha = usuario.getSenha();

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
		
}
