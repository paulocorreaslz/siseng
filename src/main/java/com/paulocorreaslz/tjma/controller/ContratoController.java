package com.paulocorreaslz.tjma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class ContratoController {

	@Autowired
	//private ContratoServiceImp contratoService;
	
	@ApiOperation(value = "Método para buscar contratos disponiveis", response = String.class, tags = "listar contratos")
	@GetMapping("/contratos")
	public String getContratos() {
		
		return "retorno";
	}
}
