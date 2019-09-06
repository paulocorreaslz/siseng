package com.paulocorreaslz.tjma.model;
/**
 * @author Paulo Correa <pauloyaco@gmail.com> - 2019
 *
 */
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.paulocorreaslz.tjma.util.TipoInsumo;

import io.swagger.annotations.ApiModelProperty;

public class Contrato {
	@ApiModelProperty(notes = "Id do contrato",name="id",required=true,value="id")
	private long id;
	@ApiModelProperty(notes = "Nome do contrato",name="contrato",required=true,value="contrato")
	private String contrato;
	@ApiModelProperty(notes = "Itens do contrato",name="items",required=true,value="items")
	private HashMap<ItemDeContrato, Integer> items = new HashMap<>();
	@ApiModelProperty(notes = "Itens Compostos do contrato",name="itemsCompostos",required=true,value="itemsCompostos")
	private HashMap<ItemDeContratoComposto, Integer> itemsCompostos = new HashMap<>();
	@ApiModelProperty(notes = "Valor total do contrato",name="totalGeral",required=true,value="totalGeral")
	private BigDecimal totalGeral = new java.math.BigDecimal(0);
		
	private BigDecimal totalItem = new java.math.BigDecimal(0);
	private BigDecimal totalComposto = new java.math.BigDecimal(0);
	
	public Contrato(long id, String contrato) {
		this.id = id;
		this.contrato = contrato;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContrato() {
		return contrato;
	}

	public void setContrato(String contrato) {
		this.contrato = contrato;
	}

	public HashMap<ItemDeContrato, Integer> getItems() {
		return items;
	}

	public void setItems(HashMap<ItemDeContrato, Integer> items) {
		this.items = items;
	}
	
	public HashMap<ItemDeContratoComposto, Integer> getItemsCompostos() {
		return itemsCompostos;
	}

	public void setItemsCompostos(HashMap<ItemDeContratoComposto, Integer> itemsCompostos) {
		this.itemsCompostos = itemsCompostos;
	}

	public BigDecimal getTotal() {
		
		totalItem = totalItem.add(this.calcularValorItemContrato(this.getItems()));
		totalComposto = totalComposto.add(this.calcularItemsContratoComposto());
		totalGeral = totalGeral.add(totalItem);
		totalGeral = totalGeral.add(totalComposto);
		return totalGeral;
	}

	public void setTotal(BigDecimal total) {
		totalGeral = total;
	}

	public void adicionarItem(int index, ItemDeContrato item) {
		this.items.put(item, index); 
	}

	public void removerItem(ItemDeContrato item) {
		this.items.remove(item);
	}

	public void adicionarItemComposto(int index, ItemDeContratoComposto item) {
		this.itemsCompostos.put(item, index); 
	}

	public void removerItemComposto(ItemDeContratoComposto item) {
		this.itemsCompostos.remove(item);
	}
	
	public BigDecimal calcularItemsContratoComposto() {
	
		BigDecimal Valor = new java.math.BigDecimal(0);
		Iterator<Entry<ItemDeContratoComposto, Integer>> hashIterator = this.getItemsCompostos().entrySet().iterator(); 
        while (hashIterator.hasNext()) { 
            @SuppressWarnings("rawtypes")
			Map.Entry mapElement = (Map.Entry) hashIterator.next(); 
            ItemDeContratoComposto item = (ItemDeContratoComposto) mapElement.getKey();
            
            if(item.getItems().isEmpty()) {
            	System.out.println("nenhum item de contrato composto dentro");
            	return new java.math.BigDecimal(0);
            } else {
            	Valor = Valor.add(calcularValorItemContratoComposto(item));
            }
        } 
        return Valor;
	}
	
	public BigDecimal calcularValorItemContratoComposto(ItemDeContratoComposto composto) {
		BigDecimal valor = new java.math.BigDecimal(0);
		return valor.add(calcularValorItemContrato(composto.getItems()));
	}
	
	public BigDecimal calcularValorItemContrato(HashMap<ItemDeContrato, Integer> hashMap) {
		Iterator<Entry<ItemDeContrato, Integer>>  hashIterator = hashMap.entrySet().iterator();
		BigDecimal valorTotal = new java.math.BigDecimal(0);
		BigDecimal subTotal = new java.math.BigDecimal(0);
		
        while (hashIterator.hasNext()) { 	
        	@SuppressWarnings("rawtypes")
        	Map.Entry mapElement = (Map.Entry) hashIterator.next(); 
            ItemDeContrato item = (ItemDeContrato) mapElement.getKey();
            subTotal = (BigDecimal) item.getInsumo().getPreco().multiply(new java.math.BigDecimal(item.getQuantidade()));
            System.out.println(item.toString());
            valorTotal = valorTotal.add(subTotal);
        }  
        System.out.println("Valor Total dos items:" + valorTotal);
        return valorTotal;
	}
	
	public void mostrarItemsContratoComposto() {
		List<ItemDeContrato> listItemCompostoRetorno = new ArrayList<>();
		Iterator<Entry<ItemDeContrato, Integer>>  hashIterator = this.getItems().entrySet().iterator();
		BigDecimal valorTotal = new java.math.BigDecimal(0);
		BigDecimal subTotal = new java.math.BigDecimal(0);
        ItemDeContrato itemComposto = null;
	    while (hashIterator.hasNext()) { 
            @SuppressWarnings("rawtypes")
        	Map.Entry mapElement = (Map.Entry) hashIterator.next(); 
            //int index = ((int) mapElement.getValue());
            ItemDeContrato item = (ItemDeContrato) mapElement.getKey();
            subTotal = (BigDecimal) item.getInsumo().getPreco().multiply(new java.math.BigDecimal(item.getQuantidade()));         
            if (item.getInsumo().getTipoInsumo().equals(TipoInsumo.COMPOSTO)) {
                itemComposto = item;
            }
            valorTotal = valorTotal.add(subTotal);
        }
        itemComposto.getInsumo().setPreco(valorTotal);
        listItemCompostoRetorno.add(itemComposto);
        System.out.println("lista: "+listItemCompostoRetorno);
		//return listItemCompostoRetorno;
	}
}
