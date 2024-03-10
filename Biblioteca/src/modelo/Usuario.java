package modelo;

public class Usuario {
	private String nome;
	private String email;
	private String senha;
	private Estante estante = new Estante();
	public Usuario(String nome, String email, String senha) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public Estante getEstante() {
		return estante;
	}
	public void setEstante(Estante estante) {
		this.estante = estante;
	}
	public String toString() {
		return "Nome: " + nome + "\n" + "Email: " + email + "\n";
	}
}
