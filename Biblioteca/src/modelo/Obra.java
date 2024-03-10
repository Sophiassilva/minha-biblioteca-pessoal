package modelo;

public abstract class Obra {
	protected String titulo;
	protected String etiqueta;
	protected int qtdPags;
	protected Avaliacao avaliacao;
	public Obra(String titulo, String etiqueta, int qtdPags) {
		super();
		this.titulo = titulo;
		this.etiqueta = etiqueta;
		this.qtdPags = qtdPags;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getEtiqueta() {
		return etiqueta;
	}
	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}
	public int getQtdPags() {
		return qtdPags;
	}
	public void setQtdPags(int qtdPags) {
		this.qtdPags = qtdPags;
	}
	public Avaliacao getAvaliacao() {
		return avaliacao;
	}
	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}

}
