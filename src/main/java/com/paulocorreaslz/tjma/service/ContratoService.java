package com.paulocorreaslz.tjma.service;

import java.util.HashMap;
import java.util.List;

import com.paulocorreaslz.tjma.model.ItemDeContrato;
import com.paulocorreaslz.tjma.model.ItemDeContratoComposto;
import com.paulocorreaslz.tjma.model.*;

/**
 * @author Paulo Correa <pauloyaco@gmail.com> - 2019
 *
 */

public interface ContratoService {
	
	public void calcularItemsContratoComposto();
	
	public void calcularValorItemContratoComposto(ItemDeContratoComposto composto);
	
	public void calcularValorItemContrato(HashMap<ItemDeContrato, Integer> hashMap);

	public List<Contrato> findAll();
	
}
