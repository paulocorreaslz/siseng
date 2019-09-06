package com.paulocorreaslz.tjma.service.imp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paulocorreaslz.tjma.model.Contrato;
import com.paulocorreaslz.tjma.repository.imp.ContratoRepositoryImp;
import com.paulocorreaslz.tjma.service.ContratoService;

@Service
public class ContratoServiceImp implements ContratoService {
	
	@Autowired
	private ContratoRepositoryImp contratoRepository;
	
	@Override
	public List<Contrato> findAll() {
		return contratoRepository.findAll();
	}
	@Override
	public Contrato findById(long id) {
		return contratoRepository.findById(id);

	}
	
}
