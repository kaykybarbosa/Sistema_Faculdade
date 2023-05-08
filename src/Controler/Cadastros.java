package Controles;

import java.util.ArrayList;
import java.util.List;

import Modelos.Aluno;
import Modelos.Professor;
import Modelos.Materia;

public class Cadastros {
	private List<Aluno> alunos;
	private List<Professor> professores;
	private List<Materia> materias;

	public Cadastros() {
		this.alunos = new ArrayList<Aluno>();
		this.professores = new ArrayList<Professor>();
		this.materias = new ArrayList<Materia>();
	}

	public int SizeAluno() {
		return this.alunos.size();
	}

	public List<Aluno> getListaAlunos() {
		return alunos;
	}

	public Aluno getAluno(String matricula) {

		for (int i = 0; i < this.alunos.size(); i++) {
			for (Aluno aluno : this.getListaAlunos()){

				if (aluno.getCarteiraEstudante().getMatricula().equals(matricula)){
					return aluno;
				}
			}
		}
		return null;
	}
	
	public boolean AddAluno(Aluno aluno) {

		if (!this.AlunoExiste(aluno.getCarteiraEstudante().getMatricula())) {

			if (aluno.getCarteiraEstudante().getCurso().toLowerCase().equals("ads")) {
				aluno.setMaterias(this.getMateriaADS());
			}

			this.alunos.add(aluno);
			return true;
		}
		return false;
	}
	
	public boolean RemoverAluno(String matricula) {

		for (Aluno aluno : this.alunos) {
			
			if (aluno.getCarteiraEstudante().getMatricula().equals(matricula)) {

				this.alunos.remove(aluno);
				return true;
			}
		}
		return false;
	}
	
	public boolean AlunoExiste(String matricula) {

		for (Aluno aluno : this.alunos) {
			
			if (aluno.getCarteiraEstudante().getMatricula().equals(matricula)) {
				return true;
			}
		}
		return false;
	}
	
	public int SizeProfessor() {
		return this.professores.size();
	}


	public List<Professor> getListaProfessores() {
		return professores;
	}
	
	public Professor getProfessor(String codProfessor) {

		for (Professor professor : this.professores) {
			
			if (professor.getCodProfessor().equals(codProfessor)) {
				return professor;
			}
		}
		return null;
	}

	public boolean AddProfessor(Professor professor) {

		if (!this.ProfessorExiste(professor.getCodProfessor())) {

			this.professores.add(professor);
			return true;
		}
		return false;
	}

	public boolean RemoverProfessor(String codProfessor) {

		for (Professor professor : this.professores) {
			
			if (professor.getCodProfessor().equals(codProfessor)) {
				this.professores.remove(professor);
				return true;
			}
		}
		return false;
	}

	public boolean ProfessorExiste(String codProfessor) {

		for (Professor professor : this.professores) {
			
			if (professor.getCodProfessor().equals(codProfessor)) {
				return true;
			}
		}
		return false;
	}
	
	public List<Materia> getListaMaterias(){
		return materias;
	}
	
	public boolean AddMateria(Materia materia) {
		
		if (this.VerificarSePossuiMateria(materia.getIdMateria())) {
			return false;
		}

		materias.add(materia);
		return true;
	}
	
	private boolean VerificarSePossuiMateria(int idMateria) {
		
		for (Materia materia : this.materias) {
			
			if (materia.getIdMateria() == idMateria) {
				return true;
			}
		}
		return false;
	}
	
	private List<Materia> getMateriaADS(){
		List<Materia> materiasADS = new ArrayList<Materia>();
		
		String materia1 = "Bancos De Dados";
		String materia2 = "Algoritmos";
		String materia3 = "Estrutura De Dados I";
		String materia4 = "Redes De Computadores I";
		String materia5 = "Linguagem De Programação I";

		materiasADS.add(new Materia(1, materia1));
		materiasADS.add(new Materia(2, materia2));
		materiasADS.add(new Materia(3, materia3));
		materiasADS.add(new Materia(4, materia4));
		materiasADS.add(new Materia(5, materia5));

		return materiasADS;
	}
}