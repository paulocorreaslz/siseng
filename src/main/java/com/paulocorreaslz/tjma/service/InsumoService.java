package com.paulocorreaslz.tjma.service;
/**
 * @author Paulo Correa <pauloyaco@gmail.com> - 2019
 *
 */
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.paulocorreaslz.tjma.response.GenericResponse;
import com.paulocorreaslz.tjma.model.*;

public interface InsumoService {
	
	ResponseEntity<GenericResponse<List<Insumo>>> findAll();

	ResponseEntity<GenericResponse<List<Insumo>>> findByTipoInsumo(String tipo);

	Insumo findById(long id);

	void Add(Insumo insumo);
}
