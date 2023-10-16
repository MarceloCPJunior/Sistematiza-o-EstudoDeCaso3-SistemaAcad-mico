package br.edu.iesb.poo.estudoCaso.entidade;

import java.util.Date;

public class Matricula {
	private String matricula;
	private Date data;
	
	public Matricula() {
		super();
	}

	public Matricula(String matricula, Date data) {
		super();
		this.matricula = matricula;
		this.data = data;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
}
