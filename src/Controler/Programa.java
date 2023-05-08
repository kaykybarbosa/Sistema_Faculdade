package Controles;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import IPrograma.Tela;
import Modelos.Aluno;
import Modelos.Autenticacoes;
import Modelos.ControleDeNotas;
import Modelos.Coordenador;
import Modelos.Excecoes;
import Modelos.Materia;
import Modelos.Metodos;
import Modelos.Professor;

//Developer: Kayky Bruno S.Barbosa
//Date: 05/03/23

public class Programa {

	static Cadastros cadastro = new Cadastros();
	static Scanner input = new Scanner(System.in);

	static final int sim = 1;
	static final int nao = 2;
	static int interetor = 0;

	public static void main(String[] arg) {

		int opcaoLimparTela = 0;

		while (true) {

			try {
				if (opcaoLimparTela == 5) {
					opcaoLimparTela = 0;
					Tela.LimparTela();
				}

				opcaoLimparTela++;
				Tela.TituloDoSistema();

				Tela.OpcoesPrincipais();
				int opcaoMenu = Metodos.LerValorInteiro(1, 4);

				if (opcaoMenu == 1) {

					try {
						Tela.TitulosCenter("ACESSO DO ALUNO", "-");

						System.out.print(" MATRÍCULA \n  > ");
						String matriculaAluno = input.nextLine().trim();

						Aluno alunoAtual = cadastro.getAluno(matriculaAluno);

						if (alunoAtual == null) {
							Excecoes.ErroAcessoAluno();
						}

						String nomeAluno = alunoAtual.getCarteiraEstudante().getNome().toUpperCase();
						Tela.MensagensCenter("BEM - VINDO, " + nomeAluno);

						Tela.OpcoesAluno();
						int opcAluno = Metodos.LerValorInteiro(1, 2);

						Tela.Linha();
						switch (opcAluno) {
						case 1:
							System.out.println(alunoAtual.toStringCarteiraEstudante());
							Tela.Linha();

							break;

						case 2:

							List<Materia> materiasAluno = alunoAtual.getMaterias();

							if (materiasAluno.size() == 0) {
								Tela.MensagensCenter("NENHUMA MATÉRIA NO MOMENTO.");
							} else {
								Tela.TitulosCenter("MATÉRIAS DO SEMESTRE", "-");
							}

							for (int i = 0; i < materiasAluno.size(); i++) {
								System.out.println(materiasAluno.get(i).toString());
								Tela.Linha();
							}

							break;

						}

					} catch (Exception e) {
						Tela.MensagensCenter(e.getMessage());
					} finally {
						Tela.LimparBuffer();
					}

				} else if (opcaoMenu == 2) {

					try {
						Tela.TitulosCenter("ACESSO DOS PROFESSORES", "-");

						List<Aluno> alunosDoProfessor = cadastro.getListaAlunos();

						System.out.print(" CÓDIGO \n  > ");
						String codProfessor = input.nextLine().trim();

						if (!cadastro.ProfessorExiste(codProfessor)) {
							Excecoes.ErroAcessoProfessor();
						}

						Professor professor = cadastro.getProfessor(codProfessor);
						Tela.MensagensCenter("BEM - VINDO, " + professor.getNome().toUpperCase());
						interetor = 0;

						int login = 0;
						while (login != 4) {

							try {
								if (interetor > 0) {
									Tela.InicioDasOpcoes();
								}

								Tela.OpcoesProfessor();
								int opcProfessor = Metodos.LerValorInteiro(1, 4);

								switch (opcProfessor) {
								case 1:

									Tela.TitulosCenter("CENTRAL DE NOTAS", "-");

									System.out.print(" INFORME A MATRÍCULA DO ALUNO \n  > ");
									String matricula = input.nextLine();

									if (!cadastro.AlunoExiste(matricula)) {
										Excecoes.AlunoNaoEncontrado();
									}

									Aluno alunoAtual = cadastro.getAluno(matricula);

									if (!Metodos.VerificarSeTemMateria(alunoAtual.getMaterias(), professor)) {
										Excecoes.AlunoNaoTemMateria();
									}

									System.out.println("\n  ALUNO: " + alunoAtual.getCarteiraEstudante().getNome());

									Tela.OpcoesNotas();
									int mensal = 1;
									int bimestral = 2;
									int opcaoNotas = Metodos.LerValorInteiro(mensal, bimestral);

									Tela.Linha();
									double notas[] = ControleDeNotas.CadastroDeNotas();

									if (opcaoNotas == mensal) {

										if (!professor.AddNotaMensal(alunoAtual, notas)) {
											Excecoes.AlunoNaoTemMateria();
										}
										Tela.MensagensCenter("NOTA MENSAL SALVA!");

									} else if (opcaoNotas == bimestral) {

										if (!professor.AddNotaBimestral(alunoAtual, notas)) {
											Excecoes.AlunoNaoTemMateria();
										}
										Tela.MensagensCenter("NOTA BIMESTRAL SALVA!");

									} else {
										Excecoes.OpcaoIncorreta();
									}

									break;

								case 2:

									Tela.TitulosCenter("SEUS ALUNOS", "-");

									alunosDoProfessor = cadastro.getListaAlunos();
									Metodos.ListarAlunos(alunosDoProfessor, professor);

									if (alunosDoProfessor.size() > 4) {
										Aluno alunoBuscado = BuscarAluno(alunosDoProfessor);

										if (alunoBuscado != null) {
											System.out.print("\n" + alunoBuscado.toString());
											Tela.Linha();
										}
									}

									break;

								case 3:

									Tela.TitulosCenter("SITUAÇÃO DOS SEUS ALUNOS", "-");

									Metodos.ListarAlunos(alunosDoProfessor, professor, true);

									if (alunosDoProfessor.size() > 4) {
										Aluno alunoBuscado = BuscarAluno(alunosDoProfessor);

										if (alunoBuscado != null) {
											System.out.print("\n" + alunoBuscado.toString());
											Tela.Linha();
										}
									}

									break;

								case 4:

									Tela.MensagensCenter("DESCONECTOU!");
									login = 4;

									break;

								default:
									Excecoes.OpcaoIncorreta();
								}

							} catch (Exception e) {
								Tela.MensagensCenter(e.getMessage());
							} finally {
								Tela.LimparBuffer();
							}
							interetor++; 
						}

					} catch (Exception e) {
						Tela.MensagensCenter(e.getMessage());
					} finally {
						Tela.LimparBuffer();
					}

				} else if (opcaoMenu == 3) {

					try {
						Tela.TitulosCenter("ACESSO DO COORDENADOR", "-");

						Coordenador coordenador = new Coordenador();

						Autenticacoes.LoginCoordenador(coordenador);
						interetor = 0;

						int login = 0;
						while (login != 8) {

							try {

								if (interetor > 0) {
									Tela.InicioDasOpcoes();
								}

								Tela.OpcoesCoordenador();

								int opcCoordenador = Metodos.LerValorInteiro(1, 8);
								switch (opcCoordenador) {
								case 1:

									Tela.TitulosCenter("TODOS ALUNOS", "-");

									List<Aluno> alunos = cadastro.getListaAlunos();

									if (alunos.size() == 0) {
										Tela.MensagensCenter("NENHUM ALUNO NA TURMA!");
									}

									for (int i = 0; i < alunos.size(); i++) {
										System.out.println(alunos.get(i).toStringCarteiraEstudante());
										System.out.println(
												" ID MATERIA..: " + alunos.get(i).getMaterias().get(i).getIdMateria());
										Tela.Linha();
									}

									if (alunos.size() > 4) {
										Aluno alunoBuscado = BuscarAluno(alunos);

										if (alunoBuscado != null) {
											System.out.print("\n" + alunoBuscado.toString());
											Tela.Linha();
										}
									}

									break;

								case 2:

									Tela.TitulosCenter("TODOS PROFESSORES", "-");

									List<Professor> professores = cadastro.getListaProfessores();

									if (professores.size() == 0) {
										Tela.MensagensCenter("NENHUM PROFESSOR CADASTRADO!");
									}

									for (int i = 0; i < professores.size(); i++) {
										System.out.println(professores.get(i).toString());
										Tela.Linha();
									}

									if (professores.size() > 5) {

										Tela.OpcoesSimNao(" BUSCAR POR UM PROFESSOR?");
										int opcaoBuscarProfessor = Metodos.LerValorInteiro(sim, nao);

										if (opcaoBuscarProfessor != nao) {

											Tela.Linha();
											System.out.print("\n CÓDIGO DO PROFESSOR \n  > ");
											String codigoBuscado = input.nextLine();

											if (!cadastro.ProfessorExiste(codigoBuscado)) {
												Excecoes.ProfessorNaoExiste();
											}

											Professor professorBuscado = cadastro.getProfessor(codigoBuscado);
											System.out.print("\n" + professorBuscado.toString());
											Tela.Linha();
										}
									}

									break;

								case 3:

									Tela.TitulosCenter("CADASTRO DE ALUNOS", "-");

									System.out.print(" NOME \n  > ");
									String nome = input.nextLine().trim();

									System.out.print(" MATRÍCULA \n  > ");
									String matricula = input.nextLine().trim();

									System.out.print(" CURSO \n  > ");
									String curso = input.nextLine().trim();

									Autenticacoes.CadastroAluno(nome, matricula, curso);

									if (!cadastro.AddAluno(new Aluno(nome, matricula, curso))) {
										Excecoes.AlunoExiste();
									}

									Tela.MensagensCenter("CADASTRO REALIZADO!");

									break;

								case 4:

									Tela.TitulosCenter("CADASTRO DE PROFESSORES", "-");

									System.out.print(" NOME \n  > ");
									String nomeProfessor = input.nextLine().trim();

									System.out.print(" CÓDIGO \n  > ");
									String codprofessor = input.nextLine().trim();

									System.out.print(" MATÉRIA \n > ");
									String materia = input.nextLine().trim();

									Autenticacoes.CadastroProfessor(nomeProfessor, codprofessor, materia);
									int idp = cadastro.getListaProfessores().size() + 1;

									if (!cadastro
											.AddProfessor(new Professor(nomeProfessor, codprofessor, idp, materia))) {
										Excecoes.ProfessorExiste();
									}

									Tela.MensagensCenter("CADASTRO REALIZADO!");

									break;

								case 5:

									Tela.TitulosCenter("REMOÇÃO DE ALUNOS", "-");

									System.out.print("\n MATRÍCULA DO ALUNO \n > ");
									String matriculaRemover = input.nextLine().trim().toUpperCase();

									if (!cadastro.RemoverAluno(matriculaRemover)) {
										Excecoes.AlunoNaoEncontrado();
									}

									Tela.MensagensCenter("ALUNO EXCLUÍDO!");

									break;

								case 6:

									Tela.TitulosCenter("REMOÇÃO DE PROFESSORES", "-");

									System.out.print(" CÓDIGO DO PROFESSOR \n > ");
									String codProfessor = input.nextLine();

									if (!cadastro.RemoverProfessor(codProfessor)) {
										Excecoes.ProfessorNaoExiste();
									}
									Tela.MensagensCenter("PROFESSOR EXCLUÍDO!");

									break;

								case 7:

									Tela.TitulosCenter("CADASTRO DE MATÉRIAS", "-");

									System.out.print(" INFORME A MATRÍCULA DO ALUNO \n  > ");
									String matriculaAluno = input.nextLine();

									Aluno alunoAtual = cadastro.getAluno(matriculaAluno);

									if (alunoAtual == null) {
										Excecoes.AlunoNaoEncontrado();
									}

									Tela.Linha();
									System.out.println("\n  ALUNO: " + alunoAtual.getCarteiraEstudante().getNome() + "\n");

									while (true) {

										System.out.print(" ID DA MATÉRIA \n  > ");
										int idMateria = input.nextInt();
										input.nextLine();

										System.out.print(" NOME DA MATÉRRIA \n  > ");
										String nomeMateria = input.nextLine();

										Autenticacoes.CadastroDeMateria(nomeMateria);
										cadastro.AddMateria(new Materia(idMateria, nomeMateria));
										
										Tela.MensagensCenter("MATÉRIA SALVA!");

										Tela.OpcoesSimNao(" CONTINUAR NO CADASTRO?");
										int opcContinuar = Metodos.LerValorInteiro(sim, nao);

										if (opcContinuar == nao) {

											alunoAtual.setMaterias(cadastro.getListaMaterias());
											cadastro.getListaMaterias().clear();

											Tela.LinhaVazia();
											Tela.MensagensCenter("MATÉRIAS ADICIONADAS COM SUCESSO!");
											break;
										}
										Tela.Linha();
									}

									break;

								case 8:
									Tela.MensagensCenter("DESCONECTOU!");
									login = 8;

									break;

								default:
									Excecoes.OpcaoIncorreta();
								}

							} catch (InputMismatchException e) {
								Tela.MensagensCenter("ID INCORRETO!");
							} catch (Exception e) {
								Tela.MensagensCenter(e.getMessage());
							} finally {
								Tela.LimparBuffer();
							}
							interetor++;
						}
					} catch(Exception e){
						Tela.MensagensCenter(e.getMessage());
					} finally {
						Tela.LimparBuffer();
					}

				} else if (opcaoMenu == 4) {
					Tela.MensagemSaida();
					System.exit(0);
				}

			} catch (Exception e) {
				Tela.MensagensCenter(e.getMessage());
			} finally {
				Tela.LimparBuffer();
			}
		}
	}

	public static Aluno BuscarAluno(List<Aluno> alunos) {
		int opcErro = 999;

		Tela.OpcoesSimNao(" BUSCAR POR UM ALUNO ?");
		int opcaoBuscarAluno = Metodos.LerValorInteiro(sim, nao);

		if (opcaoBuscarAluno == opcErro) {
			Excecoes.OpcaoIncorreta();
		}

		if (opcaoBuscarAluno == nao) {
			return null;
		}

		Tela.Linha();
		System.out.print("\n MATRÍCULA DO ALUNO\n  > ");
		String matriculaBuscado = input.next();

		if (!cadastro.AlunoExiste(matriculaBuscado)) {
			Excecoes.AlunoNaoEncontrado();
		}

		return cadastro.getAluno(matriculaBuscado);
	}
}