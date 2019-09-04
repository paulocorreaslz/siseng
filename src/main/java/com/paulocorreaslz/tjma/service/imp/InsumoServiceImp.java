package com.paulocorreaslz.tjma.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.paulocorreaslz.tjma.model.Insumo;
import com.paulocorreaslz.tjma.repository.imp.InsumoRepositoryImp;
import com.paulocorreaslz.tjma.response.GenericResponse;
import com.paulocorreaslz.tjma.service.InsumoService;
import com.paulocorreaslz.tjma.util.TipoInsumo;

@Service
public class InsumoServiceImp implements InsumoService {

	@Autowired
	private InsumoRepositoryImp insumoRepository;
	

	@Override
	public ResponseEntity<GenericResponse<List<Insumo>>> findAll() {
		
		GenericResponse<List<Insumo>> response = new GenericResponse<>();

        List<Insumo> insumos = this.insumoRepository.findAll();
        if (insumos.isEmpty()) {
            response.getErrors().add("Nenhum insumo encontrado.");
            return ResponseEntity.badRequest().body(response);
        }

        response.setData(insumos);
        return ResponseEntity.ok(response);
	}


	@Override
	public ResponseEntity<GenericResponse<List<Insumo>>> findByTipoInsumo(String tipo) {
		// TODO Auto-generated method stub
		return null;
	}

}
