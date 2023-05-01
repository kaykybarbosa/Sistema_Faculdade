package Modelos;

public class Materia {
	
	private int idMateria;
	private String nome;
	private Avaliacao mensal;
	private Avaliacao bimestral;
	private String situacao;
	
	public Materia() {
		
	}
	
	public Materia(int idMateria, String nome) {
		this.idMateria = idMateria;
		this.nome= nome;
		this.mensal = new Avaliacao();
		this.bimestral = new Avaliacao();
		this.situacao = "' '";
	}
	
	public int getIdMateria() {
		return idMateria;
	}
	
	public void setIdMateria(int idMateria) {
		this.idMateria = idMateria;
	}
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Avaliacao getMensal() {
		return mensal;
	}

	public void setMensal(Avaliacao mensal) {
		this.mensal = mensal;
	}

	public Avaliacao getBimestral() {
		return bimestral;
	}

	public void setBimestral(Avaliacao bimestral) {
		this.bimestral = bimestral;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
	@Override
	public String toString() {
		return " MATÉRIA.........: "		+ nome
				+ "\n\n NOTA MENSAL.....: " + mensal.getNota()
				+ "\n NOTA BIMESTRAL..: " 	+ bimestral.getNota()
				+ "\n SITUAÇÃO........: " 	+ situacao
				+ "\n ID .............: "   + idMateria;
	}
}