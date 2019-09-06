package com.paulocorreaslz.tjma.model;
/**
 * @author Paulo Correa <pauloyaco@gmail.com> - 2019
 *
 */
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Contrato {

		private long id;
		private String contrato;
		private HashMap<ItemDeContrato, Integer> items = new HashMap<>();
		private HashMap<ItemDeContratoComposto, Integer> itemsCompostos = new HashMap<>();
		private BigDecimal totalGeral = new java.math.BigDecimal(0);
		
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
		
		public void mostrarItemsContrato(HashMap<ItemDeContrato, Integer> hashMap) {
			Iterator<Entry<ItemDeContrato, Integer>> hashIterator = hashMap.entrySet().iterator(); 
	        while (hashIterator.hasNext()) { 
	            @SuppressWarnings("rawtypes")
				Map.Entry mapElement = (Map.Entry) hashIterator.next(); 
	            int index = ((int) mapElement.getValue());
	            ItemDeContrato item = (ItemDeContrato) mapElement.getKey();
	            System.out.println(item.toString() + " : " + index); 
	        } 
		}
}
