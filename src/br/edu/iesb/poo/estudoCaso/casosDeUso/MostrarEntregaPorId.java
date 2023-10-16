package br.edu.iesb.poo.estudoCaso.casosDeUso;

import br.edu.iesb.poo.estudoCaso.repositorio.interfaces.EntregaInterface;

public class MostrarEntregaPorId {
	private EntregaInterface repositorio;
	
	public MostrarEntregaPorId(EntregaInterface repositorio) {
		this.repositorio = repositorio;
	}
	
	public void executar(Integer id){
		StringBuilder status = new StringBuilder();
		
		this.repositorio.mostrar(id, status);
		
		System.out.println(status.toString());
	}
}
