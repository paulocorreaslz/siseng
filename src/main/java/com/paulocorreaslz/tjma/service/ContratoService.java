package com.paulocorreaslz.tjma.service;

import java.util.List;

import com.paulocorreaslz.tjma.model.Contrato;

/**
 * @author Paulo Correa <pauloyaco@gmail.com> - 2019
 *
 */

public interface ContratoService {
	
	public List<Contrato> findAll();
	
	Contrato findById(long id);

}
