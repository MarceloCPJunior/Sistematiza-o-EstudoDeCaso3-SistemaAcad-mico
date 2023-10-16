package br.edu.iesb.poo.estudoCaso.entidade;

import java.util.Date;

public class TCC {
	private int id;
	private String titulo;
	private String descricao;
	private Date dataInicio;
	private Date dataEstimadaFim;
	private Aluno aluno;
	private StatusTCC status;
	
	public TCC() {
		super();
	}
	
	public TCC(String titulo, String descricao, Date dataInicio, StatusTCC status) {
		super();
		this.titulo = titulo;
		this.descricao = descricao;
		this.dataInicio = dataInicio;
		this.status = status;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Date getDataEstimadaFim() {
		return dataEstimadaFim;
	}
	public void setDataEstimadaFim(Date dataEstimadaFim) {
		this.dataEstimadaFim = dataEstimadaFim;
	}
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	public StatusTCC getStatus() {
		return status;
	}
	public void setStatus(StatusTCC status) {
		this.status = status;
	}
}
