package com.paulocorreaslz.tjma.model;
/**
 * @author Paulo Correa <pauloyaco@gmail.com> - 2019
 *
 */
import java.time.LocalDate;

public class Medicao {
	
	private long id;
	
	private Predio predio;
	
	private LocalDate dataMedicao;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Predio getPredio() {
		return predio;
	}

	public void setPredio(Predio predio) {
		this.predio = predio;
	}

	public LocalDate getDataMedicao() {
		return dataMedicao;
	}

	public void setDataMedicao(LocalDate dataMedicao) {
		this.dataMedicao = dataMedicao;
	}
	
}
