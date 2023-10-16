package br.edu.iesb.poo.estudoCaso.servico;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.edu.iesb.poo.estudoCaso.entidade.Aluno;
import br.edu.iesb.poo.estudoCaso.entidade.Curso;
import br.edu.iesb.poo.estudoCaso.entidade.MatriculaAluno;
import br.edu.iesb.poo.estudoCaso.entidade.MatriculaOrientador;
import br.edu.iesb.poo.estudoCaso.entidade.Orientador;
import br.edu.iesb.poo.estudoCaso.entidade.StatusTCC;
import br.edu.iesb.poo.estudoCaso.entidade.TCC;

public class Cadastro {
	
	public static Aluno cadastrarAluno(Integer cod, String nome, String eMail, Orientador orientador, Curso curso, String descricao, String titulo) {
		Calendar data = Calendar.getInstance();
		TCC tcc = new TCC(titulo, descricao, data.getTime(), StatusTCC.EMANDAMENTO);
		
		Aluno aluno = new Aluno(nome, eMail, orientador, curso);
		
		data.add(Calendar.YEAR, 1);
		tcc.setDataEstimadaFim(data.getTime());
		tcc.setAluno(aluno);
		
		aluno.setTcc(tcc);
		aluno.setMatricula((MatriculaAluno)definirMatricula(aluno, cod, curso));
		return aluno;
	}
	
	public static Orientador cadastrarOrientador(Integer cod, String nome, String eMail, String telefone, List<Curso> cursos) {
		Orientador orientador = new Orientador(nome, eMail, telefone);
		orientador.setMatricula((MatriculaOrientador)definirMatricula(orientador, cod, cursos));
		return orientador;
	}
	
	public static Object definirMatricula(Object obj, Integer cod, Curso curso) {
		List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(curso);
		return definirMatricula(obj, cod, cursos);
	}
	
	public static Object definirMatricula(Object obj, Integer cod, List<Curso> cursos) {
		StringBuilder codMatricula = new StringBuilder("");
		Calendar data = Calendar.getInstance();
		Integer ano = data.get(Calendar.YEAR);
		ano = ano%100;
		
		if(obj instanceof Orientador) {
			MatriculaOrientador matricula = new MatriculaOrientador();
			matricula.setData(data.getTime());
			matricula.setCursos(cursos);
			codMatricula.append(ano.toString()).append(cod.toString());
			matricula.setMatricula(codMatricula.toString());
			return matricula;
		} else if (obj instanceof Aluno) {
			MatriculaAluno matricula = new MatriculaAluno();
			matricula.setData(data.getTime());
			matricula.setCurso(cursos.get(0));
			codMatricula.append(ano.toString()).append(matricula.getCurso().getCodigo().toString()).append(cod.toString());
			matricula.setMatricula(codMatricula.toString());
			return matricula;
		} else {
			return null;
		}
	}
}
