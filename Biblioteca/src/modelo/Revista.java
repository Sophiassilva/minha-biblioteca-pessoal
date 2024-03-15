package modelo;

public class Revista extends Obra{
	private String editora;
	private int ano;
	private int numero;
	public Revista(String titulo, String etiqueta, int qtdPags, String editora, int ano,
			int numero) {
		super(titulo, etiqueta, qtdPags);
		this.editora = editora;
		this.ano = ano;
		this.numero = numero;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	@Override
	public String toString() {
		return "Revista: " + titulo + "\n" + "Editora: " + editora + " Ano: " + ano + 
				" Número: " + numero + " Etiqueta: " + etiqueta + " Quant. de páginas: " + qtdPags + "\n";
	}
	
	
}
