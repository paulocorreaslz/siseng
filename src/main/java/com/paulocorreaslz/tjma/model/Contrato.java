package com.paulocorreaslz.tjma.model;

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
		
		public void mostrarItems() {
			Iterator hashIterator = items.entrySet().iterator(); 
	        while (hashIterator.hasNext()) { 
	            Map.Entry mapElement = (Map.Entry) hashIterator.next(); 
	            int marks = ((int)mapElement.getValue());
	            System.out.println(mapElement.getKey() + " : " + marks); 
	        } 
		}
		
		public void adicionarItem(int quantidade, ItemDeContrato item) {
			this.items.put(item, quantidade); 
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
