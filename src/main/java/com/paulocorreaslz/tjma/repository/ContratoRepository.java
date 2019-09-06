package com.paulocorreaslz.tjma.repository;

import java.util.List;

import com.paulocorreaslz.tjma.model.Contrato;

public interface ContratoRepository {
	
	List<Contrato> findAll();

	void Add(Contrato contrato);
	
	void Remove(Contrato contrato);
	
	Contrato findById(long id);
}
