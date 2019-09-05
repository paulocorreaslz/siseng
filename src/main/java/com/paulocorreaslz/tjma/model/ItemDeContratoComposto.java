package com.paulocorreaslz.tjma.model;
/**
 * @author Paulo Correa <pauloyaco@gmail.com> - 2019
 *
 */
import java.util.List;

public class ItemDeContratoComposto {
	
	private long id;
	
	List<ItemDeContrato> items;
	
	private int quantidade;

	public ItemDeContratoComposto(long id, List<ItemDeContrato> items, int quantidade) {
		this.id = id;
		this.items = items;
		this.quantidade = quantidade;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<ItemDeContrato> getItems() {
		return items;
	}

	public void setItems(List<ItemDeContrato> items) {
		this.items = items;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
}
