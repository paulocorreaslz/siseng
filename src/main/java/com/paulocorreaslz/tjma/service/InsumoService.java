package com.paulocorreaslz.tjma.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.paulocorreaslz.tjma.response.GenericResponse;
import com.paulocorreaslz.tjma.model.*;

public interface InsumoService {
	
	ResponseEntity<GenericResponse<List<Insumo>>> findAll();

	ResponseEntity<GenericResponse<List<Insumo>>> findByTipoInsumo(String tipo);
	
}
