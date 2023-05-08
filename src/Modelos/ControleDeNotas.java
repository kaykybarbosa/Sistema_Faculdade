package Modelos;

import java.util.Scanner;

public class ControleDeNotas {
	static Scanner input = new Scanner(System.in);
	
	public static double[] CadastroDeNotas() {

		double prova;
		double trabalhos;
		double[] notas = new double[2];

		try {

			input.nextLine();
			System.out.print(" PROVA\n   > ");
			prova = input.nextDouble();

			System.out.print(" TRABALHO\n   > ");
			trabalhos = input.nextDouble();

			notas[0] = prova;
			notas[1] = trabalhos;

			return notas;

		} catch (Exception e) {
			Excecoes.NotasInvalidas();
		}
		return null;
	}

	public static String VerificarSituacao(double mensal, double bimestral) {
		double situacao = (mensal + bimestral) / 2;

		if (situacao >= 7) {
			return "APROVADO";

		} else if (situacao >= 4) {
			return "RECUPERAÇÂO";

		} else {
			return "REPROVADO";
		}
	}
}