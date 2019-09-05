package com.paulocorreaslz.tjma.repository;
/**
 * @author Paulo Correa <pauloyaco@gmail.com> - 2019
 *
 */
import java.util.List;

import com.paulocorreaslz.tjma.model.Insumo;

public interface InsumoRepository {

		List<Insumo> findAll();

		List<Insumo> findByTipoInsumo(String tipo);
	
		Insumo findById(long id);
}
