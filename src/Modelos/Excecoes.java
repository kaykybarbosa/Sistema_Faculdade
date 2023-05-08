package Controler;

public class Excecoes {

	static public Exception OpcaoIncorreta() {
		throw new IllegalArgumentException("OPÇÃO INCORRETA!");
	}

	static public Exception AlunoExiste() {
		throw new IllegalArgumentException("ALUNO JÁ ESTÁ CADASTRADO!");
	}

	static public Exception AlunoNaoEncontrado() {
		throw new IllegalArgumentException("ALUNO NÃO ENCONTRADO!");
	}

	static public Exception LonginInvalido() {
		throw new IllegalArgumentException("LONGIN OU SENHA INCORRETO!");
	}

	static public Exception ErroAcessoAluno() {
		throw new IllegalArgumentException("MATRÍCULA INCORRETA!");
	}

	static public Exception ErroAcessoProfessor() {
		throw new IllegalArgumentException("CÓDIGO INCORRETO!");
	}

	static 	public Exception ProfessorExiste() {
		throw new IllegalArgumentException("PROFESSOR JÁ ESTÁ CADASTRADO!");
	}

	static public Exception ProfessorNaoExiste() {
		throw new IllegalArgumentException("PROFESSOR NÃO ENCONTRADO!");
	}

	static public Exception NomeVazio() {
		throw new IllegalArgumentException("PREENCHA O NOME!");
	}

	static 	public Exception MatriculaVazia() {
		throw new IllegalArgumentException("PREENCHA A MATRÍCULA!");
	}
	
	static public Exception CursoVazio() {
		throw new IllegalArgumentException("PREENCHA O CURSO!");
	}
	
	static public Exception CodigoVazio() {
		throw new IllegalArgumentException("PREENCHA O CÓDIGO!");
	}
	
	static public Exception MateriaVazio() {
		throw new IllegalArgumentException("PREENCHA A MATÉRIA!");
	}

	static public Exception NotasInvalidas() {
		throw new IllegalArgumentException("TIPO DE VALOR INVÁLIDO.");
	}
	
	static public Exception AlunoNaoTemMateria() {
		throw new IllegalArgumentException("ALUNO NÃO POSSUI ESSA MATÉRIA!");
	}
}