package Modelos;

public class Coordenador {
	private String nome;
	private String longin;
	private String senha;

	public Coordenador() {
		this.nome = "ADMIN";
		this.longin = "ADMIN1";
		this.senha = "123";
	}
	
	public Coordenador(String nome, String longin, String senha) {
		this.nome = nome;
		this.longin = longin;
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLongin() {
		return longin;
	}

	public void setLongin(String longin) {
		this.longin = longin;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}