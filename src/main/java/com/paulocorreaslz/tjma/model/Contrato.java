package com.paulocorreaslz.tjma.model;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Contrato {

		private long id;
		private String contrato;
		HashMap<ItemDeContrato, Integer> items = new HashMap<>();
		
		public Contrato(long id, String contrato) {
			this.id = id;
			this.contrato = contrato;
		}
		
		public void mostrarItemsContrato() {
			Iterator hashIterator = getItems().entrySet().iterator(); 
	        while (hashIterator.hasNext()) { 
	            Map.Entry mapElement = (Map.Entry) hashIterator.next(); 
	            int index = ((int) mapElement.getValue());
	            ItemDeContrato item = (ItemDeContrato) mapElement.getKey();
	            System.out.println(item.toString() + " : " + index); 
	        } 
		}
		
		public void calcularValorItemContrato() {
			Iterator hashIterator = getItems().entrySet().iterator();
			BigDecimal Total = null;
	        while (hashIterator.hasNext()) { 
	            BigDecimal subTotal = null;
	        	Map.Entry mapElement = (Map.Entry) hashIterator.next(); 
	            int index = ((int) mapElement.getValue());
	            ItemDeContrato item = (ItemDeContrato) mapElement.getKey();
	            subTotal = (BigDecimal) item.getInsumo().getPreco().multiply(new java.math.BigDecimal(index));
	            System.out.println(item.toString() + " * "+ index + " : " + subTotal); 
	        }  
		}
		
		public void adicionarItem(int index, ItemDeContrato item) {
			this.items.put(item, index); 
		}
		
		public void removerItem(ItemDeContrato item) {
			this.items.remove(item);
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
		
}
