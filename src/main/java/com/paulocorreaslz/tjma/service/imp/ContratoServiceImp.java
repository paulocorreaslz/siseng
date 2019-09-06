package com.paulocorreaslz.tjma.service.imp;
/**
 * @author Paulo Correa <pauloyaco@gmail.com> - 2019
 *
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.paulocorreaslz.tjma.model.Contrato;
import com.paulocorreaslz.tjma.repository.imp.ContratoRepositoryImp;
import com.paulocorreaslz.tjma.response.GenericResponse;
import com.paulocorreaslz.tjma.service.ContratoService;

@Service
public class ContratoServiceImp implements ContratoService {
	
	@Autowired
	private ContratoRepositoryImp contratoRepository;
	
	@Override
	public ResponseEntity<GenericResponse<List<Contrato>>> findAll() {
		GenericResponse<List<Contrato>> response = new GenericResponse<>();

        List<Contrato> contratos = this.contratoRepository.findAll();
        if (contratos.isEmpty()) {
            response.getErrors().add("Nenhum contrato encontrado.");
            return ResponseEntity.badRequest().body(response);
        }
        response.setData(contratos);
        return ResponseEntity.ok(response);	
	}
	
	@Override
	public ResponseEntity<GenericResponse<Contrato>>  findById(long id) {
		
		GenericResponse<Contrato> response = new GenericResponse<>();

        Contrato contrato = this.contratoRepository.findById(id);
        if (contrato.equals(null)) {
            response.getErrors().add("Nenhum contrato encontrado.");
            return ResponseEntity.badRequest().body(response);
        }
        response.setData(contrato);
        return ResponseEntity.ok(response);	
	
	}
	
}
