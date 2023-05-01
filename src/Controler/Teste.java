package Controler;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import InterfaceP.Tela;
import Modelos.Aluno;
import Modelos.Autenticacoes;
import Modelos.Avaliacao;
import Modelos.CarteiraDoEstudante;
import Modelos.Materia;
import Modelos.Professor;
import Controler.Cadastros;

public class Teste {

	static public class AlunoTeste {

		private CarteiraDoEstudante carteira;
		private List<Materia> materias;

		public AlunoTeste(String nome, String matricula, String curso) {
			super();
			this.carteira = new CarteiraDoEstudante(nome, matricula, curso);
			this.materias = new ArrayList<Materia>();
		}

		public CarteiraDoEstudante getCarteira() {
			return carteira;
		}

		public void setCarteira(CarteiraDoEstudante carteira) {
			this.carteira = carteira;
		}

		public List<Materia> getMaterias() {
			return materias;
		}

		public void setMaterias(List<Materia> materias) {
			this.materias = materias;
		}

		@Override
		public String toString() {
			return "AlunoTeste [carteira=" + carteira.toString() + ",\n materias=" + materias.toString() + "]";
		}
	}

	static public class CadastrosTeste {

		private List<AlunoTeste> alunos;
		private List<Materia> materias = new ArrayList<Materia>();

		public CadastrosTeste() {
			this.alunos = new ArrayList<AlunoTeste>();
		}

		public List<AlunoTeste> getAlunos() {
			return alunos;
		}

		public void setAlunos(List<AlunoTeste> alunos) {
			this.alunos = alunos;
		}

		public List<Materia> getMaterias() {
			return materias;
		}

		public boolean AddAluno(AlunoTeste aluno) {
			alunos.add(aluno);
			return true;
		}

		public boolean AddMateriaDoAluno(List<Materia> materias, String matricula) {

			for (int i = 0; i < alunos.size(); i++) {

				if (alunos.get(i).getCarteira().getMatricula().equals(matricula)) {
					alunos.get(i).setMaterias(materias);
					return true;
				}
			}
			return false;

		}

		public AlunoTeste getAluno(String matricula) {

			for (int i = 0; i < alunos.size(); i++) {

				if (alunos.get(i).getCarteira().getMatricula().equals(matricula)) {
					return alunos.get(i);
				}
			}
			return null;
		}
	}

	// PROGRAMA PRINCIPAL
	static Scanner input = new Scanner(System.in);
	static private List<Materia> materias = new ArrayList<Materia>();
	static public Cadastros cadastro = new Cadastros();

	public static void main(String[] args) {

	cadastro.AddAluno(new Aluno("Mia", "123", "ADS"));
	cadastro.AddAluno(new Aluno("Maria", "1123", "ENG"));
	
	cadastro.AddProfessor(new Professor("Luiz Carlos", "99", 1, "LP1"));
	cadastro.AddProfessor(new Professor("Luiz Carlos", "9", 2, "LP1"));

	cadastro.AddMateria(new Materia(1, "CONSTRUCAO I"));
	cadastro.AddMateria(new Materia(2, "CONSTRUCAO II"));
	cadastro.AddMateria(new Materia(3, "CONSTRUCAO III"));
	
//	aluno.setMaterias(cadastro.getListaMaterias());
	Aluno aluno = cadastro.getAluno("123");
	
	Professor professor = cadastro.getProfessor("9");
	
	
	double[] notas = {5, 5};
	
	for (int i =0; i < 5; i++) {

		System.out.println(cadastro.getListaAlunos().get(i).getMaterias().get(i).getIdMateria());
		Tela.Linha();
		
		if (aluno.getMaterias().get(i).getIdMateria() == professor.getIdMateria()) {
			aluno.getMaterias().get(i).setMensal(new Avaliacao(notas[0], notas[1]));
		}
		
		/*
		 * System.out.println(cadastro.getListaAlunos().get(i).toStringCarteiraEstudante
		 * ()); Tela.LinhaVazia();
		 * System.out.println(cadastro.getListaAlunos().get(i).toStringMaterias());
		 * Tela.Linha();
		 */
	}
		
		
	}
}
/*
 * public static void MensagemCenter(String texto) {
 * 
 * int tamanho = (60 - texto.length()) / 2;
 * 
 * System.out.println(tamanho);
 * System.out.print(String.format("%"+tamanho+"s%s", " ", texto)); Tela.Linha();
 * }
 */
/*
 * public static String tosString() {
 * 
 * return " NOME............: " + 89 + "\n NOTA MENSAL.....: " + "Kaio" +
 * "\n NOTA BIMESTRAL..: " + "MAria" + "\n SITUAÇÃO........: " + "JOAO"; }
 */
/*
 * String linha =
 * "------------------------------------------------------------";
 * 
 * System.out.println(linha.length());
 * TituloAcessos("Ssssjhgjj sdsd sd sds d fy tftgjh jk8gs sd s");
 * 
 * }
 * 
 * public static void TituloAcessos(String titulo) {
 * 
 * int linhaTotal = 60; int diferenca = linhaTotal - titulo.length(); int
 * metade;
 * 
 * if (diferenca % 2 == 1) {
 * 
 * metade = ((diferenca + 1) / 4);
 * 
 * LinhaTitulo(metade); System.out.print(" " + titulo + " "); LinhaTitulo(metade
 * - 1); Linha();
 * 
 * } else {
 * 
 * metade = (diferenca / 4);
 * 
 * LinhaTitulo(metade); System.out.print(" " + titulo + " ");
 * LinhaTitulo(metade); Linha(); } } public static void LinhaTitulo(int tamanho)
 * { for (int i = 1; i < tamanho; i++) { System.out.print("---"); } }
 * 
 * public static void Linha() { System.out.println(
 * "\n------------------------------------------------------------");
 * 
 * }
 */
/*
 * String linha =
 * "------------------------------------------------------------"; String titulo
 * = "S"; String teste =
 * "----------------------- ACESSO ALUNO -----------------------";
 * 
 * System.out.println(linha.length()); System.out.println(titulo.length());
 * System.out.println(teste.length());
 * 
 * Titulo(titulo);
 * 
 * }
 * 
 * public static void Titulo(String titulo) {
 * 
 * int diferenca = 60 - titulo.length(); int frente = diferenca / 2;
 * 
 * if (diferenca % 2 == 1) { diferenca += 1;
 * 
 * frente = diferenca / 2;
 * 
 * PrimeiraLinha(frente);
 * 
 * PrimeiraLinha(frente - 1);
 * 
 * System.out.println(
 * "\n------------------------------------------------------------"); } else {
 * 
 * PrimeiraLinha(frente);
 * 
 * System.out.print(" " + titulo + " ");
 * 
 * PrimeiraLinha(frente); System.out.println(
 * "\n------------------------------------------------------------");
 * 
 * }
 * 
 * System.out.
 * println("----------------------- ACESSO ALUNO -----------------------");
 * System.out.println(
 * "------------------------------------------------------------");
 * 
 * }
 * 
 * public static void PrimeiraLinha(int linha) {
 * 
 * for (int i = 1; i < linha; i++) { System.out.print("-"); } }
 */
/*
 * ArrayList<Integer> list = new ArrayList<Integer>();
 * 
 * list.add(5); list.add(15); list.add(25); list.add(35); list.add(45);
 * 
 * list.remove(2); list.remove(0);
 * 
 * 
 * for(int i = 0; i < list.size(); i++) { System.out.println(list.get(i)); }
 */
/*
 * System.out.println("   TESTE CONNECTION"); System.out.print("NAME: "); String
 * name = input.nextLine().toUpperCase();
 * 
 * System.out.print("MATRÍCULA: "); String matricula =
 * input.nextLine().toUpperCase();
 * 
 * System.out.print("CURSO: "); String curso = input.nextLine().toUpperCase();
 * 
 * try { Connection con = new ConnectionFactory().getConnection();
 * PreparedStatement smt =
 * con.prepareStatement("INSERT INTO Alunos (Nome, Matricula, Curso) VALUES("
 * +name+","+matricula+","+curso+")"); ResultSet rs = smt.executeQuery();
 * 
 * cadastro.AddAluno(new Aluno(name,matricula,curso));
 * 
 * con.close(); smt.close(); rs.close();
 * 
 * } catch (SQLException e) { throw new RuntimeException(e); }
 */
/*
 * Avaliacao av = new Avaliacao();
 * 
 * System.out.println(av.getProva()); System.out.println(av.getTrabalhos());
 * 
 * System.out.print("NOME: "); String nome =
 * input.nextLine().toUpperCase().strip();
 * 
 * System.out.print("NOME = " + nome.length());
 */
/*
 * Aluno aluno1 = new Aluno("Maria", "2023", "ADS"); Aluno aluno2 = new
 * Aluno("João", "2023", "ADS");
 * 
 * while(true) {
 * 
 * cadastro.AddAluno(new Aluno("Maria", "2023", "ADS"));
 * 
 * 
 * System.out.println("   NOTAS MENSAL"); double[] avaliacaoMensal =
 * CadastroDeNotas();
 * 
 * System.out.println("\n   NOTAS BIMESTRAL"); double [] avaliacaoBimestral =
 * CadastroDeNotas();
 * 
 * 
 * cadastro.AddNotaMensal(new Avaliacao(avaliacaoMensal[0], avaliacaoMensal[1]),
 * "90"); cadastro.AddNotaBimestral(new Avaliacao(avaliacaoBimestral[0],
 * avaliacaoBimestral[1]), "90");
 * 
 * cadastro.getRelatorioTeste();
 * 
 * System.out.println("COnitni"); int opc = input.nextInt();
 * 
 * if(opc == 2) { break; }
 * 
 * 
 * } }
 * 
 * public static double[] setAvaMensal() {
 * 
 * return null; }
 * 
 * public static double[] setAvaBimestral() {
 * 
 * 
 * return null; }
 * 
 * public static double[] CadastroDeNotas() { double prova = 0; double trabalhos
 * = 0; double[] notas= {prova, trabalhos};
 * 
 * try {
 * 
 * System.out.print(" NOTA PROVA\n   > "); prova = input.nextDouble();
 * 
 * System.out.print(" NOTA TRABALHO\n   > "); trabalhos = input.nextDouble();
 * 
 * notas[0] = prova; notas[1] = trabalhos;
 * 
 * return notas;
 * 
 * } catch (Exception e) { }
 * 
 * return notas; }
 */
/*
 * String nome = "Maria";
 * 
 * 
 * System.out.println(nome.substring(0, 4));
 */

/*
 * while (true) { try { System.out.println("PRIMERIO NOME");
 * System.out.print(" > "); String nome = input.nextLine().strip();
 * System.out.print("");
 * 
 * System.out.println("MATRICULA"); System.out.print(" > "); String matricula =
 * input.nextLine();
 * 
 * System.out.println("CURSO"); System.out.print(" > "); String curso =
 * input.nextLine();
 * 
 * System.out.println("CONTINUAR?"); System.out.print("< 1 > SIM | ");
 * System.out.println("< 2 > NÃO"); System.out.print(" >> "); String opc =
 * input.next(); input.nextLine();
 * 
 * if (opc.equals(2)) { break; } else { System.out.println();
 * System.out.printf("NOME: %s  MATRIUCLA: %s  CURSO: %s", nome, matricula,
 * curso); System.out.println(); } } catch (Exception e) {
 * System.out.println("TEU CUUUUUUUUUUUU"); } }
 */

/*
 * for(int i = 0; i<200; i++) { System.out.println(); }
 * 
 * System.out.print("DIGITE AI: "); input.next();
 */

/*
 * System.out.println("DIGITE UM NÚMERO: "); boolean num = input.hasNext();
 * 
 * System.out.println(num);
 * 
 */

/*
 * try { FileOutputStream arquivo = new FileOutputStream("arquivoTeste.file");
 * 
 * PrintWriter pw = new PrintWriter(arquivo);
 * pw.println("TESTANDO ARQUIVO TXT AQUI NO JAVA;"); pw.println("Tkayky JAVA");
 * pw.println("TLuan mAsiro dj JAVA");
 * 
 * 
 * 
 * pw.close(); arquivo.close();
 * 
 * } catch(Exception e) { System.out.println("Erro!"); }
 */

/*
 * try { Path caminho = Paths.
 * get("C:/Users/STi/eclipse-workspace/Kaaa/Cadastro Alunos/src/Classes/DataBase"
 * );
 * 
 * byte [] texto = Files.readAllBytes(caminho);
 * 
 * String arquivo = new String(texto);
 * 
 * System.out.println(arquivo);
 * 
 * } catch(Exception e) { System.out.println(e); }
 */
/*
 * try { Paths caminho = Paths.get("C:\\Users\\STi"); } catch(Exception e) {
 * 
 * }
 */

/*
 * String num = "2";
 * 
 * int numero = Integer.valueOf(num); int soma = numero + 2;
 * System.out.println(soma);
 */
/*
 * Excecoes exceptions = new Excecoes();
 * 
 * String text = "DIGITE UM VALOR ENTRE 0 E 10: "; int valor =
 * exceptions.LerInt(0, 10);
 * 
 * System.out.println("O NÚMERO " + valor + " É VÁLIDO!");
 */

/*
 * System.out.printf("Nº MATRÍCULA...: %s\n", "2023ADS01");
 * System.out.printf("NOME...........: %s\n", "KAYKY BRUNO");
 * System.out.printf("MÉDIA PROVA....: %s\n", 8.0);
 * System.out.printf("MÉDIA TRABALHO.: %s\n", 5.0);
 * System.out.printf("SITUAÇÃO.......: %s\n", "APROVADO");
 * 
 * System.out.println("---------------------------------");
 * 
 * System.out.printf(" Nº MATRÍCULA...: %s\n", "2023ENG01");
 * System.out.printf(" NOME...........: %s\n", "MARIA EDUARDA");
 * System.out.printf(" MÉDIA PROVA....: %s\n", 9.0);
 * System.out.printf(" MÉDIA TRABALHO.: %s\n", 10.0);
 * System.out.printf(" SITUAÇÃO.......: %s\n", "APROVADO");
 */

/*
 * System.out.
 * println("   Nº\t     NOME\t MÉDIA PROVA\t MÉDIA TRABALHO \tSITUAÇÃO");
 * System.out.print("2023ADS01\t"); System.out.print("Kayky\t");
 * System.out.print("\t9.0\t"); System.out.print("\t8.0\t");
 * System.out.println("\tRECUPERAÇÃO");
 * 
 * System.out.print("2023ENG02\t"); System.out.print("MAria\t");
 * System.out.print("\t0.0\t"); System.out.print("\t 7.0\t");
 * System.out.print("\t APROVADO");
 */
/*
 * double notas[][] = new double [2][2]; double[] provas = new double[2];
 * double[] trabalhos = new double[4];
 * 
 * provas[0] = 9; provas[1] = 3;
 * 
 * trabalhos[0] = 8; trabalhos[1] = 2; trabalhos[2] = 10; trabalhos[3] = 25;
 * 
 * notas[0] = provas; notas[1] = trabalhos;
 * 
 * notas(notas[0], notas[1]); }
 * 
 * public static void notas(double[] provas, double[] trabalhos) {
 * 
 * System.out.println("P1 = " + provas[0]); System.out.println("P2 = " +
 * provas[1]); System.out.println("T1 = " + trabalhos[0]);
 * System.out.println("T2 = " + trabalhos[1]); System.out.println("T3 = " +
 * trabalhos[2]); System.out.println("T4 = " + trabalhos[3]); }
 */
