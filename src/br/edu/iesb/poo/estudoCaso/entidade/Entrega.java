package br.edu.iesb.poo.estudoCaso.entidade;

import java.util.Date;

public class Entrega {
	private Integer id;
	private TCC documento;
	private Date dataEntrega;
	private Date dataEnvio;
	private Aluno aluno;
	private Orientador orientador;
	private StatusEntrega status;
	
	public Entrega() {
		super();
	}
	
	public Entrega(Date dataEntrega, Aluno aluno,
			Orientador orientador, StatusEntrega status) {
		super();
		this.dataEntrega = dataEntrega;
		this.aluno = aluno;
		this.orientador = orientador;
		this.status = status;
	}
	
	public Entrega(Integer id, TCC documento, Date dataEnvio) {
		this.id = id;
		this.documento = documento;
		this.dataEnvio = dataEnvio;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public TCC getDocumento() {
		return documento;
	}
	public void setDocumento(TCC documento) {
		this.documento = documento;
	}
	public Date getDataEntrega() {
		return dataEntrega;
	}
	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}
	public Date getDataEnvio() {
		return dataEnvio;
	}
	public void setDataEnvio(Date dataEnvio) {
		this.dataEnvio = dataEnvio;
	}
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	public Orientador getOrientador() {
		return orientador;
	}
	public void setOrientador(Orientador orientador) {
		this.orientador = orientador;
	}
	public StatusEntrega getStatus() {
		return status;
	}
	public void setStatus(StatusEntrega status) {
		this.status = status;
	}
}
