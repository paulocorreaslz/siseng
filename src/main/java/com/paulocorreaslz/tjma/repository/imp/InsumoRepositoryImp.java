package com.paulocorreaslz.tjma.repository.imp;


import java.io.BufferedReader;
/**
 * @author Paulo Correa <pauloyaco@gmail.com> - 2019
 *
 */
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.paulocorreaslz.tjma.model.Insumo;
import com.paulocorreaslz.tjma.repository.InsumoRepository;

@Repository
public class InsumoRepositoryImp implements InsumoRepository {

	 private final String RESOURCES_PATH = System.getProperty("user.dir") + "/src/main/resources/";
     private static final Logger LOG = LoggerFactory.getLogger(InsumoRepositoryImp.class);

	@Override
	public List<Insumo> findAll() {
		 try {
	            BufferedReader insumosJson = new BufferedReader(new FileReader(RESOURCES_PATH + "/insumos.json"));
	            
	            List<Insumo> listInsumos = new Gson().fromJson(insumosJson, new TypeToken<List<Insumo>>() {}.getType());
	            
	            return listInsumos;
	        } catch (FileNotFoundException e) {
	            LOG.error(e.getMessage());
	            return new ArrayList<>();
	        }
	}
	
	@Override
	public List<Insumo> findByTipoInsumo(String tipo) {
		List<Insumo> listInsumos = this.findAll();
        List<Insumo> listInsumosFiltrada = new ArrayList<>(); 
        
		listInsumos.forEach( 
				insumo -> {
					System.out.println(insumo.getTipoInsumo().toString());
					if (insumo.getTipoInsumo().toString().equalsIgnoreCase(tipo))
						listInsumosFiltrada.add(insumo);
					}
				);

		return listInsumosFiltrada;
	}

	@Override
	public Insumo findById(long id) {
		List<Insumo> listInsumos = this.findAll();
        Insumo insumoLocalizado = null;
		for (Insumo insumo : listInsumos) {
			if (insumo.getId() == id)
				insumoLocalizado = insumo;
		}
		return insumoLocalizado;
	}
	
}




