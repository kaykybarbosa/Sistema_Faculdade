package Modelos;

public class Avaliacao {

	private double prova;
	private double trabalho;

	public Avaliacao() {
		this.prova = 0;
		this.trabalho = 0;
	}
	
	public Avaliacao(double prova, double trabalho) {
		this.prova = prova;
		this.trabalho = trabalho;
	}

	public double getNota() {
		return (this.prova + this.trabalho);
	}

	public double getProva() {
		return prova;
	}

	public void setProva(double prova) {
		this.prova = prova;
	}

	public double getTrabalhos() {
		return trabalho;
	}

	public void setTrabalhos(double traba) {
		this.trabalho = traba;
	}

	@Override
	public String toString() {
		return "Avaliacao ["+ getNota()+ "]";
	}
}