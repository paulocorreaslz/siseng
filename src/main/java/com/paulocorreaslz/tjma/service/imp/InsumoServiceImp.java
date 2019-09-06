package com.paulocorreaslz.tjma.service.imp;
/**
 * @author Paulo Correa <pauloyaco@gmail.com> - 2019
 *
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.paulocorreaslz.tjma.model.Insumo;
import com.paulocorreaslz.tjma.repository.InsumoRepository;
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
		GenericResponse<List<Insumo>> response = new GenericResponse<>();

        List<Insumo> insumos = this.insumoRepository.findByTipoInsumo(tipo);
        if (insumos.isEmpty()) {
            response.getErrors().add("Nenhum insumo encontrado.");
            return ResponseEntity.badRequest().body(response);
        }

        response.setData(insumos);
        return ResponseEntity.ok(response);
	}

	@Override
	public Insumo findById(long id) {
		return insumoRepository.findById(id);
	}

	@Override
	public void Add(Insumo insumo) {
		insumoRepository.Add(insumo);		
	}

}
