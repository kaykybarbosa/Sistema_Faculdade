package InterfaceP;

import java.util.Scanner;

public class Tela {

	public static void TituloDoSistema() {
		System.out.println("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println(String.format("%-22s%s", " ", "FACULDADE KBULOSA"));
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n");
	}

	public static void OpcoesPrincipais() {
		String opcao1 = " < 1 >  ACESSO ALUNO";
		String opcao2 = " < 2 >  ACESSO PROFESSOR";
		String opcao3 = " < 3 >  ACESSO COORDENADOR";
		String opcao4 = " < 4 >  SAIR DO SISTEMA";

		System.out.println(String.format("%-30s%s", opcao1, opcao2));
		System.out.println(String.format("%-30s%s", opcao3, opcao4));
		System.out.print("\n  >> ");
	}

	public static void OpcoesAluno() {
		String opcao1 = " < 1 > PERFIL";
		String opcao2 = " < 2 > SUAS MATÉRIAS";

		System.out.println(String.format("\n%-30s%s", opcao1, opcao2));
		System.out.print("\n  >> ");
	}

	public static void OpcoesProfessor() {
		String opcao1 = " < 1 > ADICIONAR NOTAS";
		String opcao2 = " < 2 > TODOS OS SEUS ALUNOS";
		String opcao3 = " < 3 > SITUAÇÃO DOS ALUNOS";
		String opcao4 = " < 4 > SAIR DO LONGIN";

		System.out.println(String.format("\n%-30s%s", opcao1, opcao2));
		System.out.println(String.format("%-30s%s", opcao3, opcao4));
		System.out.print("\n  >> ");
	}

	public static void OpcoesNotas() {
		String opcao1 = " < 1 > ADICIONAR NOTA MENSAL ";
		String opcao2 = " < 2 > ADICIONAR NOTA BIMESTRAL";

		System.out.println(String.format("\n%-30s%s", opcao1, opcao2));
		System.out.print("\n  >> ");
	}

	public static void OpcoesCoordenador() {
		String opcao1 = " < 1 > TODOS DOS ALUNOS";
		String opcao2 = " < 2 > TODOS DOS PROFESSORES";
		String opcao3 = " < 3 > ADICIONAR ALUNO";
		String opcao4 = " < 4 > ADICIONAR PROFESSOR";
		String opcao5 = " < 5 > REMOVER ALUNO";
		String opcao6 = " < 6 > REMOVER PROFESSOR";
		String opcao7 = " < 7 > ADICIONAR MATÉRIAS";
		String opcao8 = " < 8 > SAIR DO LOGIN";

		System.out.println(String.format("\n%-30s%s", opcao1, opcao2));
		System.out.println(String.format("%-30s%s", opcao3, opcao4));
		System.out.println(String.format("%-30s%s", opcao5, opcao6));
		System.out.println(String.format("%-30s%s", opcao7, opcao8));
		System.out.print("\n  >> ");
	}

	public static void OpcoesSimNao(String titulo) {
		String opcao1 = " < 1 > SIM";
		String opcao2 = " < 2 > NÃO";

		System.out.println(String.format("\n%s", titulo));
		System.out.println(String.format("%-14s%s", opcao1, opcao2));
		System.out.print("\n  >> ");
	}

	public static void LimparTela() {
		for (int i = 0; i < 200; i++) {
			LinhaVazia();
		}
	}

	private static final int Line_Total = 60;

	public static void TitulosCenter(String titulo, String caracter) {
		int diferenca = Line_Total - titulo.length();
		int metade = diferenca / 2;

		System.out.println();

		if (diferenca % 2 == 1) {

			LinhaDoTitulo(metade + 1, caracter);
			System.out.print(" " + titulo.toUpperCase() + " ");
		} else {

			LinhaDoTitulo(metade, caracter);
			System.out.print(" " + titulo + " ");
		}

		LinhaDoTitulo(metade - 2, caracter);
		Linha();
	}

	private static void LinhaDoTitulo(int size, String character) {
		for (int i = 0; i < size; i++) {
			System.out.print(character);
		}
	}

	public static void LinhaVazia() {
		System.out.println();
	}

	public static void MensagensCenter(String texto) {
		int len = (Line_Total - texto.length()) / 2;

		System.out.print(String.format("\n%-"+len+"s%s", " ", texto));
		Tela.Linha();
	}

	public static void Linha() {
		System.out.println("\n------------------------------------------------------------");
	}

	private static final Scanner input = new Scanner(System.in);

	public static void LimparBuffer() {
		input.nextLine();
	}

	public static void MensagemSaida() {
		TitulosCenter("SAINDO...", " ");
		TitulosCenter("OBRIGADO!", ">");
	}
}