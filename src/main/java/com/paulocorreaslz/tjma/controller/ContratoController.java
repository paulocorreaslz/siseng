package com.paulocorreaslz.tjma.controller;
/**
 * @author Paulo Correa <pauloyaco@gmail.com> - 2019
 *
 */
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
import com.paulocorreaslz.tjma.response.GenericResponse;
import com.paulocorreaslz.tjma.service.imp.ContratoServiceImp;
import com.paulocorreaslz.tjma.service.imp.InsumoServiceImp;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class ContratoController {

	@Autowired
	private InsumoServiceImp insumoService;
	
	@Autowired
	private ContratoServiceImp contratoService;
	
	@ApiOperation(value = "Método testar aplicação", response = String.class, tags = "Testar aplicação")
	@GetMapping("/online")
	public String getContratos() {
		return "online";
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
	
	@ApiOperation(value = "Método para carregar todos contratos", response = Iterable.class, tags = "Carregar contratos")
	@GetMapping("/contratos")
	public List<Contrato> contratos() {
		return contratoService.findAll();
	}
	
	@ApiOperation(value = "Método para buscar contrato por id", response = Iterable.class, tags = "listar insumos por tipo")
	@GetMapping("/contrato/{id}")
	public Contrato getContratosId(@PathVariable("id") long id) {
		return contratoService.findById(id);
	}
}
