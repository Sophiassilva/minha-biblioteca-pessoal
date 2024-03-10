package modelo;

public class Avaliacao {
	private String resenha;
	private float estrelas;
	public Avaliacao(String resenha, float estrelas) {
		this.resenha = resenha;
		this.estrelas = estrelas;
	}
	public String getResenha() {
		return resenha;
	}
	public void setResenha(String resenha) {
		this.resenha = resenha;
	}
	public float getEstrelas() {
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
