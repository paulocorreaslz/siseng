package com.paulocorreaslz.tjma.model;
/**
 * @author Paulo Correa <pauloyaco@gmail.com> - 2019
 *
 */
import java.io.Serializable;
import java.math.BigDecimal;

import com.paulocorreaslz.tjma.util.TipoInsumo;

import io.swagger.annotations.ApiModelProperty;

public class Insumo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(notes = "Id do insumo",name="id",required=true,value="id")
	private long id;
	@ApiModelProperty(notes = "descricao do insumo",name="descricao",required=true,value="descricao")
	private String descricao;
	@ApiModelProperty(notes = "unidade do insumo",name="unidade",required=true,value="unidade")
	private String unidade;
	@ApiModelProperty(notes = "preco do insumo",name="preco",required=true,value="preco")
	private BigDecimal preco;
	@ApiModelProperty(notes = "tipoInsumo do insumo",name="tipoInsumo",required=true,value="tipoInsumo")
	private TipoInsumo tipoInsumo;
	
	public Insumo() {
	}
	
	public Insumo(String descricao, String unidade, BigDecimal preco, TipoInsumo tipoInsumo) {
		this.descricao = descricao;
		this.unidade = unidade;
		this.preco = preco;
		this.tipoInsumo = tipoInsumo;
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
	public String getUnidade() {
		return unidade;
	}
	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	public TipoInsumo getTipoInsumo() {
		return tipoInsumo;
	}
	public void setTipoInsumo(TipoInsumo tipoInsumo) {
		this.tipoInsumo = tipoInsumo;
	}
	
	
	
}
