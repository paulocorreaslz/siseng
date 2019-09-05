package com.paulocorreaslz.tjma.model;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
/**
 * @author Paulo Correa <pauloyaco@gmail.com> - 2019
 *
 */
import java.util.Map;
import java.util.Map.Entry;

import com.paulocorreaslz.tjma.util.TipoInsumo;

public class ItemDeContratoComposto {
	
	private long id;
	
	private HashMap<ItemDeContrato, Integer> items = new HashMap<>();
	
	private int quantidade;

	public ItemDeContratoComposto(long id, HashMap<ItemDeContrato, Integer> items, int quantidade) {
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

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public HashMap<ItemDeContrato, Integer> getItems() {
		return items;
	}

	public void setItems(HashMap<ItemDeContrato, Integer> items) {
		this.items = items;
	}
	@Override
	public String toString() {
		Iterator<Entry<ItemDeContrato, Integer>>  hashIterator = this.getItems().entrySet().iterator();
		BigDecimal valorTotal = new java.math.BigDecimal(0);
		BigDecimal subTotal = new java.math.BigDecimal(0);
		String resposta = "";
		String descricaoItemComposto = "";
        while (hashIterator.hasNext()) { 
            @SuppressWarnings("rawtypes")
        	Map.Entry mapElement = (Map.Entry) hashIterator.next(); 
            int index = ((int) mapElement.getValue());
            ItemDeContrato item = (ItemDeContrato) mapElement.getKey();
            subTotal = (BigDecimal) item.getInsumo().getPreco().multiply(new java.math.BigDecimal(item.getQuantidade()));
            //resposta = resposta + (item.toString() + " * "+ item.getQuantidade() + " : " + subTotal);
            if (item.getInsumo().getTipoInsumo().equals(TipoInsumo.COMPOSTO))
            	descricaoItemComposto = item.getInsumo().getId() + " - "+ item.getInsumo().getDescricao();
            valorTotal = valorTotal.add(subTotal);
        }
        resposta = resposta + (descricaoItemComposto + " - " + valorTotal);
		return resposta;
	}
}
