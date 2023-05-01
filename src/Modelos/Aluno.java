package Modelos;

import java.util.ArrayList;
import java.util.List;

public class Aluno {

	private CarteiraDoEstudante carteira_estudante;
	List<Materia> materias;
	
	public Aluno() {}
	
	public Aluno(String nome, String matricula, String curso) {
		super();
		this.carteira_estudante = new CarteiraDoEstudante(nome, matricula, curso);
		this.materias = new ArrayList<Materia>();
	}

	public CarteiraDoEstudante getCarteiraEstudante() {
		return carteira_estudante;
	}

	public void setCarteiraEstudante(CarteiraDoEstudante carteira_estudante) {
		this.carteira_estudante = carteira_estudante;
	}
	
	public List<Materia> getMaterias(){
		return materias;
	}
	
	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}

	public String toStringCarteiraEstudante() {
		return carteira_estudante.toString();
	}
	
	public String toStringMaterias() {
		return materias.toString();
	}
}