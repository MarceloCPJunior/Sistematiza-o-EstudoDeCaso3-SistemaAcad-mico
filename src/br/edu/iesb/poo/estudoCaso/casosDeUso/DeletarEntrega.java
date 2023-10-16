package br.edu.iesb.poo.estudoCaso.casosDeUso;

import java.util.List;

import br.edu.iesb.poo.estudoCaso.entidade.Aluno;
import br.edu.iesb.poo.estudoCaso.entidade.Orientador;
import br.edu.iesb.poo.estudoCaso.repositorio.interfaces.EntregaInterface;

public class DeletarEntrega {
	private EntregaInterface repositorio;
	
	public DeletarEntrega(EntregaInterface repositorio) {
		this.repositorio = repositorio;
	}
	
	public void executar(Integer id, List<Aluno> alunos, Orientador orientador){
		StringBuilder status = new StringBuilder();
		
		this.repositorio.deletar(id, alunos, orientador, status);
		
		System.out.println(status.toString());
	}
}
