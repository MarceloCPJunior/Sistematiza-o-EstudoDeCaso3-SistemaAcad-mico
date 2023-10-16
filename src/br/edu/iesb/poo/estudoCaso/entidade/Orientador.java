package br.edu.iesb.poo.estudoCaso.entidade;

import java.util.ArrayList;
import java.util.List;

public class Orientador {
	private Matricula matricula;
	private String nome;
	private String eMail;
	private String telefone;
	private List<Aluno> alunos = new ArrayList<Aluno>();
	private List<Entrega> entregas = new ArrayList<>();
	
	public Orientador() {
		super();
	}
	
	public Orientador(String nome, String eMail, String telefone) {
		super();
		this.nome = nome;
		this.eMail = eMail;
		this.telefone = telefone;
	}
	
	public Matricula getMatricula() {
		return matricula;
	}
	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public List<Aluno> getAlunos() {
		return alunos;
	}
	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	public List<Entrega> getEntregas() {
		return entregas;
	}
	public void setEntregas(List<Entrega> entregas) {
		this.entregas = entregas;
	}
}
