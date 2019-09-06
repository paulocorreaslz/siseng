package com.paulocorreaslz.tjma.service.imp;
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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paulocorreaslz.tjma.model.Contrato;
import com.paulocorreaslz.tjma.model.ItemDeContrato;
import com.paulocorreaslz.tjma.model.ItemDeContratoComposto;
import com.paulocorreaslz.tjma.repository.imp.ContratoRepositoryImp;
import com.paulocorreaslz.tjma.repository.imp.InsumoRepositoryImp;

import com.paulocorreaslz.tjma.service.ContratoService;

@Service
public class ContratoServiceImp implements ContratoService {
	
	@Autowired
	private ContratoRepositoryImp contratoRepository;
	
	private BigDecimal totalGeral = new java.math.BigDecimal(0);

	public void calcularItemsContratoComposto() {
		Contrato contrato = null;
		Iterator<Entry<ItemDeContratoComposto, Integer>> hashIterator = contrato.getItemsCompostos().entrySet().iterator(); 
        while (hashIterator.hasNext()) { 
            @SuppressWarnings("rawtypes")
			Map.Entry mapElement = (Map.Entry) hashIterator.next(); 
            int index = ((int) mapElement.getValue());
            ItemDeContratoComposto item = (ItemDeContratoComposto) mapElement.getKey();
            
            if(item.getItems().isEmpty()) {
            	System.out.println("nenhum item de contrato composto dentro");
            } else {
            	calcularValorItemContratoComposto(item);
            }
        } 
	}
	public void calcularValorItemContratoComposto(ItemDeContratoComposto composto) {
		calcularValorItemContrato(composto.getItems());
	}
	
	public void calcularValorItemContrato(HashMap<ItemDeContrato, Integer> hashMap) {
		Iterator<Entry<ItemDeContrato, Integer>>  hashIterator = hashMap.entrySet().iterator();
		BigDecimal valorTotal = new java.math.BigDecimal(0);
		BigDecimal subTotal = new java.math.BigDecimal(0);
		
        while (hashIterator.hasNext()) { 
            @SuppressWarnings("rawtypes")
        	Map.Entry mapElement = (Map.Entry) hashIterator.next(); 
            int index = ((int) mapElement.getValue());
            ItemDeContrato item = (ItemDeContrato) mapElement.getKey();
            subTotal = (BigDecimal) item.getInsumo().getPreco().multiply(new java.math.BigDecimal(item.getQuantidade()));
            System.out.println(item.toString() + " * "+ item.getQuantidade() + " : " + subTotal);
            valorTotal = valorTotal.add(subTotal);
        }  
        totalGeral = totalGeral.add(valorTotal);
        System.out.println("Valor Total dos items:" + valorTotal);
	}
	@Override
	public List<Contrato> findAll() {
		return contratoRepository.findAll();
	}
	
	

}
