package com.paulocorreaslz.tjma.repository.imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.paulocorreaslz.tjma.model.Contrato;
import com.paulocorreaslz.tjma.model.Insumo;
import com.paulocorreaslz.tjma.model.ItemDeContrato;
import com.paulocorreaslz.tjma.model.ItemDeContratoComposto;
import com.paulocorreaslz.tjma.repository.ContratoRepository;
import com.paulocorreaslz.tjma.service.imp.InsumoServiceImp;
import com.paulocorreaslz.tjma.util.TipoInsumo;

@Repository
public class ContratoRepositoryImp implements ContratoRepository {

	List<Contrato> contratosGerais;

	@Autowired
	private InsumoServiceImp insumoService;

	@Override
	public List<Contrato> findAll() {
		List<Contrato> contratos = new ArrayList<Contrato>();
		// criação de insumo especial composto - valor a calcular
		Insumo insumo1 = new Insumo(210,"Rebocar Parede","M2", new java.math.BigDecimal(0.00), TipoInsumo.COMPOSTO);

		// items do insumo composto especial
		ItemDeContrato item01 = new ItemDeContrato(1, insumo1, 1);
		ItemDeContrato item11 = new ItemDeContrato(2, insumoService.findById(102), 3);
		ItemDeContrato item21 = new ItemDeContrato(3, insumoService.findById(101), 2);
		ItemDeContrato item31 = new ItemDeContrato(4, insumoService.findById(103), 4);

		//adição de items ao item de contrato composto
		HashMap<ItemDeContrato, Integer> items = new HashMap<>();

		items.put(item01,1);
		items.put(item11,2);
		items.put(item21,3);
		items.put(item31,4);

		//inserção dos items no modelo de item composto
		ItemDeContratoComposto itemComposto = new ItemDeContratoComposto(1, items, 1);

		//itens de contrato normais
		ItemDeContrato item1 = new ItemDeContrato(1, insumoService.findById(102), 3);
		ItemDeContrato item2 = new ItemDeContrato(2, insumoService.findById(101), 2);
		ItemDeContrato item3 = new ItemDeContrato(3, insumoService.findById(103), 4);
		ItemDeContrato item4 = new ItemDeContrato(4, insumoService.findById(104), 1);
		ItemDeContrato item5 = new ItemDeContrato(5, insumoService.findById(105), 5);


		///criação de um contrato para teste
		Contrato con = new Contrato(1,"Contrato de Manutenção 01");
		con.adicionarItem(1, item1);
		con.adicionarItem(2, item2);
		con.adicionarItem(3, item3);
		con.adicionarItem(4, item4);
		con.adicionarItem(5, item5);

		con.adicionarItemComposto(1, itemComposto);
		contratos.add(con);

		return contratos;
	}

	@Override
	public void Add(Contrato contrato) {
		findAll().add(contrato);
	}

	@Override
	public void Remove(Contrato contrato) {
		findAll().remove(contrato);
	}

	@Override
	public Contrato findById(long id) {
		for (Iterator iterator = findAll().iterator(); iterator.hasNext();) {
			Contrato contrato = (Contrato) iterator.next();
			if (contrato.getId() == id)
				return contrato;
		}
		return null;
	}

}
