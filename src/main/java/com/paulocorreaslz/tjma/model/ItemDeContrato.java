package com.paulocorreaslz.tjma.model;

public class ItemDeContrato {
	
	private long id;
	
	private Insumo insumo;
	
	private int quantidade;
	
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
	
	@Override
	public String toString() {
		
		return "[ Item: "+this.getInsumo().getDescricao() + " - " + this.getInsumo().getTipoInsumo().toString() + " - " + this.getInsumo().getUnidade() + " - " + this.getInsumo().getPreco().toString() + " - quantidade: " + this.getQuantidade()  +"]";
	}
}
