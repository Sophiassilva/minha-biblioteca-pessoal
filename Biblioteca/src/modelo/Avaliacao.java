package modelo;

public class Avaliacao {
	private String resenha;
	private int estrelas;
	public Avaliacao(String resenha, int estrelas) {
		this.resenha = resenha;
		this.estrelas = estrelas;
	}
	public String getResenha() {
		return resenha;
	}
	public void setResenha(String resenha) {
		this.resenha = resenha;
	}
	public int getEstrelas() {
		return estrelas;
	}
	public void setEstrelas(int estrelas) {
		this.estrelas = estrelas;
	}
	@Override
	public String toString() {
		return "Resenha: " + resenha + "\n" + "Estrelas: " + estrelas + "\n";
	}
	
}
