package Modelos;

public class CarteiraDoEstudante {
	private String nome;
	private String matricula;
	private String curso;

	public CarteiraDoEstudante(String nome, String matricula, String curso) {
		this.nome = nome;
		this.matricula = matricula;
		this.curso = curso;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	@Override
	public String toString() {
		return " MATRÍCULA..: " + matricula
			 + "\n\n NOME.......: " + nome.toUpperCase()
			 + "\n CURSO......: " + curso.toUpperCase();
	}
}