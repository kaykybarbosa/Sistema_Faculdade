package Modelos;

import java.util.List;
import java.util.Scanner;

import IPrograma.Tela;

public class Metodos {

	static Scanner input = new Scanner(System.in);

	public static int LerValorInteiro(int min, int max) {
		int numero = 0;

		try {
			String valor = input.nextLine().trim();
			numero = Integer.parseInt(valor);

			if (numero < min || numero > max) {
				Excecoes.OpcaoIncorreta();
			}

		} catch (Exception e) {
			Excecoes.OpcaoIncorreta();
		}
		return numero;
	}
	
	public static void ListarAlunos(List<Aluno> alunos, Professor professor) {

		if (alunos.size() == 0) {
			Tela.MensagensCenter("NENHUM ALUNO NA TURMA!");
		}

		for (Aluno aluno : alunos) {
			for (Materia materia : aluno.getMaterias()) {

				if (materia.getIdMateria() == professor.getIdMateria()) {

					System.out.println(aluno.toStringCarteiraEstudante());
					Tela.Linha();
				}
			}
		}
	}
	
	public static void ListarAlunos(List<Aluno> alunos, Professor professor, boolean mostrarSituacao) {

		if (alunos.size() == 0) {
			Tela.MensagensCenter("NENHUM ALUNO NA TURMA!");
		}

		for (Aluno aluno : alunos) {
			for (Materia materia : aluno.getMaterias()) {

				if (materia.getIdMateria() == professor.getIdMateria()) {
					String nome = aluno.getCarteiraEstudante().getNome();
					String descricao = String.format("%s%s\n\n%s", " NOME............: ", nome, materia.toString());

					System.out.println(descricao);
					Tela.Linha();
				}
			}
		}
	}
	
	public static boolean VerificarSeTemMateria(List<Materia> materias, Professor professor) {

		for (Materia materia : materias) {

			if (materia.getIdMateria() == professor.getIdMateria()) {
				return true;
			}
		}
		return false;
	}
}