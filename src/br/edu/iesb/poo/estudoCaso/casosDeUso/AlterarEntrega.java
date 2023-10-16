package br.edu.iesb.poo.estudoCaso.casosDeUso;

import br.edu.iesb.poo.estudoCaso.entidade.Entrega;
import br.edu.iesb.poo.estudoCaso.repositorio.interfaces.EntregaInterface;

public class AlterarEntrega {
	private EntregaInterface repositorio;
	
	public AlterarEntrega(EntregaInterface repositorio) {
		this.repositorio = repositorio;
	}
	
	public void executar(Integer id, Entrega entrega){
		StringBuilder status = new StringBuilder();
		
		this.repositorio.alterar(id, entrega, status);
		
		System.out.println(status.toString());
	}
}
