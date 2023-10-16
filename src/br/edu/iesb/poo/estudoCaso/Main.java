package br.edu.iesb.poo.estudoCaso;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.edu.iesb.poo.estudoCaso.casosDeUso.AlterarEntrega;
import br.edu.iesb.poo.estudoCaso.casosDeUso.CadastrarEntrega;
import br.edu.iesb.poo.estudoCaso.casosDeUso.DeletarEntrega;
import br.edu.iesb.poo.estudoCaso.casosDeUso.MostrarEntregaPorId;
import br.edu.iesb.poo.estudoCaso.entidade.Aluno;
import br.edu.iesb.poo.estudoCaso.entidade.Curso;
import br.edu.iesb.poo.estudoCaso.entidade.Entrega;
import br.edu.iesb.poo.estudoCaso.entidade.Orientador;
import br.edu.iesb.poo.estudoCaso.entidade.StatusEntrega;
import br.edu.iesb.poo.estudoCaso.repositorio.EmMemoriaEntregaRepositorio;
import br.edu.iesb.poo.estudoCaso.servico.Cadastro;
/*
 *
 Instituição: IESB
 Disciplina:  Programação Orientada a Objetos (POO)
 Objetivo:    Fornecer conhecimentos e prática em desenvolvimento POO.
 Professor:   Bruno Miranda [bruno.marcos@iesb.edu.br]
 Data:        Oct2023

 # Prática: Implementação do Lab1
*/

public class Main {
	private static Integer codAlunos = 1000;
	private static Integer codOrientadores = 100;
	private static Integer codCurso = 100;
	
	private static List<Aluno> alunos = new ArrayList<Aluno>();
	private static List<Orientador> orientadores = new ArrayList<Orientador>();
	private static EmMemoriaEntregaRepositorio repositorio = new EmMemoriaEntregaRepositorio();
	private static CadastrarEntrega cadastrarEntrega = new CadastrarEntrega(repositorio);
	private static MostrarEntregaPorId mostrarEntregaPorId = new MostrarEntregaPorId(repositorio);
	private static AlterarEntrega alterarEntrega = new AlterarEntrega(repositorio);
	private static DeletarEntrega deletarEntrega = new DeletarEntrega(repositorio);
	
	public static void main(String[] args) {
		//Carrega as informações iniciais
		carregarInformacoes();
		
		//Cria uma nova entrega
		Calendar data = Calendar.getInstance();
		data.add(Calendar.MONTH, 1);
		Entrega entrega = new Entrega(data.getTime(), alunos.get(0), orientadores.get(0), StatusEntrega.ATRIBUIDO);
		
		//Cadastra a entrega no banco
		cadastrarEntrega.executar(entrega);
		
		//Adiciona a entrega aos relacionados
		orientadores.get(0).getEntregas().add(entrega);
		alunos.get(0).getEntregas().add(entrega);
		
		mostrarEntregaPorId.executar(alunos.get(0).getEntregas().get(0).getId());
		
		alterarEntrega(entrega, alunos.get(0));
		
		mostrarEntregaPorId.executar(alunos.get(0).getEntregas().get(0).getId());
		
		deletarEntrega.executar(entrega.getId(), alunos, orientadores.get(0));
	}
	
	public static void alterarEntrega(Entrega entrega, Aluno aluno) {
		Entrega novaEntrega = new Entrega(entrega.getId(), aluno.getTcc(), Calendar.getInstance().getTime());
		
		alterarEntrega.executar(alunos.get(0).getEntregas().get(0).getId(), novaEntrega);
	}
	
	public static void carregarInformacoes() {
		List<Curso> cursosProf = new ArrayList<>();
		Orientador orientador = new Orientador();
		Aluno aluno1 = new Aluno();
		Aluno aluno2 = new Aluno();
		
		Curso ciencia = new Curso(codCurso, "Ciência da Computação");
		codCurso++;
		Curso engenharia = new Curso(codCurso, "Engenharia da Computação");
		codCurso++;
		
		cursosProf.add(ciencia);
		cursosProf.add(engenharia);
		
		orientador = Cadastro.cadastrarOrientador(codOrientadores, "Bruno Marcos da Silva Miranda", "emailProf", "(61)99926-3574", cursosProf);
		orientadores.add(orientador);
		
		aluno1 = Cadastro.cadastrarAluno(codAlunos, "Marcelo de Castro Pereia Junior", "marcelo.casto@iesb.edu.br", orientador, ciencia, "Criação de um sistema de comunicação baseado em um modelo de linguagem de inteligência artificial, como o GPT (Generative Pre-trained Transformer), para permitir interações naturais e significativas entre usuários humanos e a IA.", "Chat GPT");
		aluno2 = Cadastro.cadastrarAluno(codAlunos, "Djalma Farias Bastos Neto", "djalma.farias@iesb.edu.br", orientador, ciencia, "Programa de recrutamento para geração de lucros financeiros elevados.", "Mago da Renda Variável");
		alunos.add(aluno1);
		alunos.add(aluno2);
	}
}
