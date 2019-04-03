package com.desafio.dto;

import java.util.Date;

import com.desafio.domain.Historico;

public class HistoricoDTO {
	
	private Integer id;
	private String nome;
	private Date dataOperacao;
	private String tipoOperacao;
	
	public HistoricoDTO(Historico historico) {
		super();
		this.id = historico.getId();
		this.nome = historico.getUsuario().getLogin();
		this.dataOperacao = historico.getDataOperacao();
		this.tipoOperacao = historico.getTipoOperacao();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataOperacao() {
		return dataOperacao;
	}

	public void setDataOperacao(Date dataOperacao) {
		this.dataOperacao = dataOperacao;
	}

	public String getTipoOperacao() {
		return tipoOperacao;
	}

	public void setTipoOperacao(String tipoOperacao) {
		this.tipoOperacao = tipoOperacao;
	}	
		
}
