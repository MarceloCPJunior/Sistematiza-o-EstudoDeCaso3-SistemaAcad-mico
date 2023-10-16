package br.edu.iesb.poo.estudoCaso.casosDeUso;

import br.edu.iesb.poo.estudoCaso.entidade.Entrega;
import br.edu.iesb.poo.estudoCaso.repositorio.interfaces.EntregaInterface;

public class CadastrarEntrega {
	private static Integer idEntrega = 1;
	
	private EntregaInterface repositorio;
	
	public CadastrarEntrega(EntregaInterface repositorio) {
		this.repositorio = repositorio;
	}
	
	public void executar(Entrega entrega){
		StringBuilder status = new StringBuilder();
		entrega.setId(idEntrega);
		idEntrega++;
		
		this.repositorio.cadastro(entrega, status);
		
		System.out.println(status.toString());
	}
}
