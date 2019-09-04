package com.paulocorreaslz.tjma.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paulocorreaslz.tjma.model.Insumo;
import com.paulocorreaslz.tjma.response.GenericResponse;
import com.paulocorreaslz.tjma.service.imp.InsumoServiceImp;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class ContratoController {

	@Autowired
	private InsumoServiceImp insumoService;
	
	@ApiOperation(value = "Método para buscar contratos disponiveis", response = String.class, tags = "listar contratos")
	@GetMapping("/contratos")
	public String getContratos() {
		
		return "retorno";
	}
	
	
	@ApiOperation(value = "Método para buscar insumos disponiveis", response = Iterable.class, tags = "listar insumos")
	@GetMapping("/insumos")
	public ResponseEntity<GenericResponse<List<Insumo>>> getInsumos() {
		
		return insumoService.findAll();
	}
	
	@ApiOperation(value = "Método para buscar insumos disponiveis por tipo", response = Iterable.class, tags = "listar insumos por tipo")
	@GetMapping("/insumo/{tipo}")
	public ResponseEntity<GenericResponse<List<Insumo>>> getInsumosPorTipo(@PathVariable("tipo") String tipo) {
		
		return insumoService.findByTipoInsumo(tipo);
	}
}
