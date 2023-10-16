package br.edu.iesb.poo.estudoCaso.repositorio;

import java.util.ArrayList;
import java.util.List;

import br.edu.iesb.poo.estudoCaso.entidade.Aluno;
import br.edu.iesb.poo.estudoCaso.entidade.Entrega;
import br.edu.iesb.poo.estudoCaso.entidade.Orientador;
import br.edu.iesb.poo.estudoCaso.entidade.StatusEntrega;
import br.edu.iesb.poo.estudoCaso.repositorio.interfaces.EntregaInterface;

public class EmMemoriaEntregaRepositorio implements EntregaInterface{
	public static List<Entrega> entregas = new ArrayList<Entrega>();
	
	@Override
	public void cadastro(Entrega entrega, StringBuilder status) {
		try {
			entregas.add(entrega);
			status.append("Entrega cadastrada com sucesso!");
		} catch (Exception e) {
			status.append("Erro ao entregar!");
			e.printStackTrace();
		}
	}

	@Override
	public void alterar(Integer id, Entrega entrega, StringBuilder status) {
		boolean encontrou = false;
		
		try {
			for (Entrega ent : entregas) {
				if(ent.getId().equals(id)) {
					ent.setDocumento(entrega.getDocumento());
					if(ent.getDataEntrega().compareTo(entrega.getDataEnvio()) < 0) {
						ent.setStatus(StatusEntrega.ENTREGUE_COM_ATRASO);
					} else {
						ent.setStatus(StatusEntrega.ENTREGUE);
					}
					
					ent.setDataEnvio(entrega.getDataEnvio());
					
					encontrou = true;
				}
			}
			
			if(!encontrou) {
				status.append("Entrega não encontrada");
			}
			
			status.append("Alteração salva com sucesso!");
			
		} catch (Exception e) {
			status.append("Erro ao entregar!");
			e.printStackTrace();
		}
		
	}

	@Override
	public void mostrar(Integer id, StringBuilder status) {
		Entrega entregaEncontrada = null;
		StringBuilder infos = new StringBuilder("");
		
		try {
			for (Entrega ent : entregas) {
				if(ent.getId().equals(id)) {
					entregaEncontrada = ent;
				}
			}
			
			if(entregaEncontrada != null) {
				infos.append("\nAluno           : " + entregaEncontrada.getAluno().getNome());
				infos.append("\nOrientador      : " + entregaEncontrada.getOrientador().getNome());
				infos.append("\nData de Entrega : " + entregaEncontrada.getDataEntrega());
				if(entregaEncontrada.getDataEnvio() == null)
					infos.append("\nData do Envio   : Pendente");
				else
					infos.append("\nData do Envio   : " + entregaEncontrada.getDataEnvio());
				
				infos.append("\nStatus          : " + entregaEncontrada.getStatus());
				
				if(entregaEncontrada.getDocumento() == null) {
					infos.append("\nDocumento       : Pendente");
				} else {
					infos.append("\nStatus TCC      : " + entregaEncontrada.getAluno().getTcc().getStatus());
					infos.append("\nDocumento       :");
					infos.append("\n       " + entregaEncontrada.getAluno().getTcc().getTitulo());
					infos.append("\n" + entregaEncontrada.getAluno().getTcc().getDescricao());
				}
				
				
				System.out.println(infos.toString());
			} else {
				status.append("Entrega não encontrada");
			}
		} catch (Exception e) {
			status.append("Erro ao procurar a entrega!");
			e.printStackTrace();
		}
	}

	@Override
	public void deletar(Integer id, List<Aluno> alunos, Orientador orientador, StringBuilder status) {
		Entrega entregaEncontrada = null;
		
		try {
			for (Entrega ent : entregas) {
				if(ent.getId().equals(id)) {
					entregaEncontrada = ent;
				}
			}
			
			if(entregaEncontrada != null) {
				for (Aluno aluno : alunos) {
					if(aluno.getEntregas().contains(entregaEncontrada)) {
						aluno.getEntregas().remove(entregaEncontrada);
						break;
					}
				}
				
				if(orientador.getEntregas().contains(entregaEncontrada))
					orientador.getEntregas().remove(entregaEncontrada);
			
				if(entregas.contains(entregaEncontrada))
					entregas.remove(entregaEncontrada);
			} else {
				status.append("Entrega não encontrada");
			}
			
			status.append("Entrega apagada com sucesso!");
		} catch (Exception e) {
			status.append("Erro ao tentar remover!");
			e.printStackTrace();
		}
	}
	
	
}
