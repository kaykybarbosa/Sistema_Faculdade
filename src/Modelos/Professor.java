package Modelos;

public class Professor {
	private String nome;
	private String codProfessor;
	private int idMateria;
	private String materia;

	public Professor() {

	}

	public Professor(String nome, String codProfessor, int idMateria, String materia) {
		this.nome = nome;
		this.codProfessor = codProfessor;
		this.idMateria = idMateria;
		this.materia = materia;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodProfessor() {
		return codProfessor;
	}

	public void setCodProfessor(String codProfessor) {
		this.codProfessor = codProfessor;
	}

	public int getIdMateria() {
		return idMateria;
	}

	public void setIdMateria(int idMateria) {
		this.idMateria = idMateria;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public boolean AddNotaMensal(Aluno aluno, double[] notas) {
	
		for (Materia materia : aluno.getMaterias()) {

			if (materia.getIdMateria() == this.idMateria) {
				materia.setMensal(new Avaliacao(notas[0], notas[1]));
				return true;
			}
		}
		return false;
		
	}

	public boolean AddNotaBimestral(Aluno aluno, double[] notas) {

		for (Materia materia : aluno.getMaterias()) {

			if (materia.getIdMateria() == this.idMateria) {
				materia.setBimestral(new Avaliacao(notas[0], notas[1]));
				
				this.AddSituacaoDoAluno(aluno);
				return true;
			}
		}
		return false;
	}

	private void AddSituacaoDoAluno(Aluno aluno) {

		for (Materia materia : aluno.getMaterias()) {
			
			if(materia.getIdMateria() == idMateria) {
				
				double mensal = materia.getMensal().getNota();
				double bimestral = materia.getBimestral().getNota();
				
				materia.setSituacao(ControleDeNotas.VerificarSituacao(mensal, bimestral));
			}
		}
	}

	public String toString() {

		return " CÓDIGO.......: "		+ codProfessor
				+ "\n\n NOME.........: "+ nome 
				+ "\n MATÉRIA......: " + materia;
	}
}