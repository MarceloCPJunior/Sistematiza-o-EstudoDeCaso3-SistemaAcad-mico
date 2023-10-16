package br.edu.iesb.poo.estudoCaso.entidade;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
	private String nome;
	private Matricula matricula;
	private String eMail;
	private Orientador orientador;
	private Curso curso;
	private TCC tcc;
	private List<Entrega> entregas = new ArrayList<Entrega>();
	
	public Aluno() {
		super();
	}
	
	public Aluno(String nome, String eMail, Orientador orientador, Curso curso) {
		super();
		this.nome = nome;
		this.eMail = eMail;
		this.orientador = orientador;
		this.curso = curso;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Matricula getMatricula() {
		return matricula;
	}
	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public Orientador getOrientador() {
		return orientador;
	}
	public void setOrientador(Orientador orientador) {
		this.orientador = orientador;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public TCC getTcc() {
		return tcc;
	}
	public void setTcc(TCC tcc) {
		this.tcc = tcc;
	}
	public List<Entrega> getEntregas() {
		return entregas;
	}
	public void setEntregas(List<Entrega> entregas) {
		this.entregas = entregas;
	}
}
