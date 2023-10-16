package br.edu.iesb.poo.estudoCaso.entidade;

import java.util.Date;
import java.util.List;

public class MatriculaOrientador extends Matricula {
	private List<Curso> cursos;

	public MatriculaOrientador() {
		super();
	}

	public MatriculaOrientador(String matricula, Date dataMatricula, List<Curso> cursos) {
		super(matricula, dataMatricula);
		this.cursos = cursos;
	}

	public MatriculaOrientador(List<Curso> cursos) {
		super();
		this.cursos = cursos;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
}
