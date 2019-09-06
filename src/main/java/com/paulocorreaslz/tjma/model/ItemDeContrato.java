package com.paulocorreaslz.tjma.model;

import java.math.BigDecimal;

/**
 * @author Paulo Correa <pauloyaco@gmail.com> - 2019
 *
 */
public class ItemDeContrato {
	
	private long id;
	
	private Insumo insumo;
	
	private int quantidade;
	
	private BigDecimal valor;
	
	public ItemDeContrato(long id, Insumo insumo, int quantidade) {
		this.id = id;
		this.insumo = insumo;
		this.quantidade = quantidade;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Insumo getInsumo() {
		return insumo;
	}

	public void setInsumo(Insumo insumo) {
		this.insumo = insumo;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
		
	public BigDecimal getValor() {
		return this.getInsumo().getPreco().multiply(new java.math.BigDecimal(this.getQuantidade()));
	}

	@Override
	public String toString() {
		return "[ Insumo: "+ this.getInsumo().getId() + " - "+this.getInsumo().getDescricao() + " - " + this.getInsumo().getTipoInsumo().toString() + " - " + this.getInsumo().getUnidade() + " - " + this.getInsumo().getPreco().toString()  +"]";
	}
}
