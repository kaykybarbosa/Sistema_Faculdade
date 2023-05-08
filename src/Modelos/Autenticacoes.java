package Modelos;

import java.util.Scanner;

import IPrograma.Tela;

public class Autenticacoes {

	static Scanner input = new Scanner(System.in);

	public static void LoginCoordenador(Coordenador coordenador) {
		System.out.print(" LOGIN\n  > ");
		String login = input.nextLine().trim();

		System.out.print(" SENHA\n  > ");
		String senha = input.nextLine().trim();

		if (!coordenador.getLongin().equals(login)) {
			Excecoes.LonginInvalido();
		}

		if (!coordenador.getSenha().equals(senha)) {
			Excecoes.LonginInvalido();
		}

		String nomeCoord = coordenador.getNome().toUpperCase();
		Tela.MensagensCenter("BEM - VINDO, " + nomeCoord);
	}

	public static void CadastroAluno(String nome, String matricula, String curso) {
		if (nome.length() == 0) {
			Excecoes.NomeVazio();
		}

		if (matricula.length() == 0) {
			Excecoes.MatriculaVazia();
		}

		if (curso.length() == 0) {
			Excecoes.CursoVazio();
		}

	}

	public static void CadastroProfessor(String nome, String codigo, String materia) {
		if (nome.length() == 0) {
			Excecoes.NomeVazio();
		}

		if (codigo.length() == 0) {
			Excecoes.CodigoVazio();
		}

		if (materia.length() == 0) {
			Excecoes.MateriaVazio();
		}
	}
	
	public static void CadastroDeMateria(String nome) {
		if (nome.length() == 0) {
			Excecoes.MateriaVazio();
		}
	}
}