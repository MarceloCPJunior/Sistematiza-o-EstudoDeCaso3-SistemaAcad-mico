package br.edu.iesb.poo.estudoCaso.entidade;

import java.util.Date;

public class MatriculaAluno extends Matricula {
	private Curso curso;
	
	public MatriculaAluno() {
		super();
	}

	public MatriculaAluno(String matricula, Date dataMatricula, Curso curso) {
		super(matricula, dataMatricula);
		this.curso = curso;
	}

	public MatriculaAluno(Curso curso) {
		super();
		this.curso = curso;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	
}
