package br.edu.iesb.poo.estudoCaso.entidade;

public class Curso {
	private Integer codigo;
	private String nome;
	
	public Curso() {
		super();
	}
	
	public Curso(Integer codigo, String nome) {
		super();
		this.nome = nome;
		this.codigo = codigo;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
}
