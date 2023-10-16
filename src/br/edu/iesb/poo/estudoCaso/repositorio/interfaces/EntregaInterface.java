package br.edu.iesb.poo.estudoCaso.repositorio.interfaces;

import java.util.List;

import br.edu.iesb.poo.estudoCaso.entidade.Aluno;
import br.edu.iesb.poo.estudoCaso.entidade.Entrega;
import br.edu.iesb.poo.estudoCaso.entidade.Orientador;

public interface EntregaInterface {
	
	public void cadastro(Entrega entrega, StringBuilder stado);
	
	public void alterar(Integer id, Entrega entrega, StringBuilder stado);
	
	public void mostrar(Integer id, StringBuilder stado);

	public void deletar(Integer id, List<Aluno> alunos, Orientador orientador, StringBuilder stado);
	
}
