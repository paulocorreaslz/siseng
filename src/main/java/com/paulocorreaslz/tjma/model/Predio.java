package com.paulocorreaslz.tjma.model;

public class Predio {
	private long id;
	private String descricao;
	private String localizacao;
	
	public Predio(long id, String descricao, String localizacao) {
		this.id = id;
		this.descricao = descricao;
		this.localizacao = localizacao;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	
	
}
