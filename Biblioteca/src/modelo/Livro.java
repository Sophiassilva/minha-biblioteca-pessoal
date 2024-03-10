package modelo;

public class Livro extends Obra{
	private String autor;
	private String genero;
	private String sinopse;
	public Livro(String titulo, String etiqueta, int qtdPags, String autor, String genero,
			String sinopse) {
		super(titulo, etiqueta, qtdPags);
		this.autor = autor;
		this.genero = genero;
		this.sinopse = sinopse;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getSinopse() {
		return sinopse;
	}
	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}
	@Override
	public String toString() {
		return "";
	}
	
}
