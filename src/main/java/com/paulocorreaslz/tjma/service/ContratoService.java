package com.paulocorreaslz.tjma.service;
/**
 * @author Paulo Correa <pauloyaco@gmail.com> - 2019
 *
 */
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.paulocorreaslz.tjma.model.Contrato;
import com.paulocorreaslz.tjma.response.GenericResponse;

public interface ContratoService {
	
	public ResponseEntity<GenericResponse<List<Contrato>>> findAll();
	
	ResponseEntity<GenericResponse<Contrato>> findById(long id);

}
