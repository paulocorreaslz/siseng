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

import com.paulocorreaslz.tjma.model.Contrato;
import com.paulocorreaslz.tjma.model.Insumo;
import com.paulocorreaslz.tjma.model.ItemDeContrato;
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

	
	@ApiOperation(value = "Método para carregar informacoes iniciais", response = Iterable.class, tags = "Carregar dados iniciais")
	@GetMapping("/carregardados")
	public Contrato carregarDados() {
		
		ItemDeContrato item1 = new ItemDeContrato(1, insumoService.findById(102), 3);
		ItemDeContrato item2 = new ItemDeContrato(2, insumoService.findById(101), 2);
		ItemDeContrato item3 = new ItemDeContrato(3, insumoService.findById(103), 4);
		ItemDeContrato item4 = new ItemDeContrato(4, insumoService.findById(104), 1);
		ItemDeContrato item5 = new ItemDeContrato(5, insumoService.findById(105), 5);
				
				
		Contrato con = new Contrato(1,"Contrato de Manutenção 01");
		con.adicionarItem(1, item1);
		con.adicionarItem(2, item2);
		con.adicionarItem(3, item3);
		con.adicionarItem(4, item4);
		con.adicionarItem(5, item5);
		
		con.mostrarItems();
		
		return con;
	}
}
