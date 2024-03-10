package modelo;

public class Estante {
	private Obra[] obras = new Obra[2000];
    private int qtdObras = 0;
    
	public Obra getObras(int i) {
		return obras[i];
	}
	public void setObras(Obra obra, int i) {
		this.obras[i] = obra;
	}
	public int getQtdObras() {
		return qtdObras;
	}
	public void setQtdObras(int qtdObras) {
		this.qtdObras = qtdObras;
	}
	
	public String buscarObraPorTitulo(String titulo) {
		String saida = "Resultado da busca: \n";
		for (int i = 0; i < qtdObras; i++) {
			if(obras[i].getTitulo().equalsIgnoreCase(titulo)) {
				saida = saida + obras[i].toString();
			} else {
				saida = saida + "Obra não encontrada!\n";
			}
		}
		return saida;
	}
	
	public String listarObras() {
		String saida = "***** Lista de obras ***** \n" ;
		for(int i = 0; i < qtdObras; i++) {
			System.out.println(i);
			saida = saida + "\n"+ obras[i].toString();
		}
		return saida;
	}
	
	public String filtrarListaDeObras(String etiqueta) {
		String saida = "***** Lista de obras *****\n";
		for (int i = 0; i < qtdObras; i++) {
			if(obras[i].getEtiqueta() == "Lido")  {
				 saida = obras[i].titulo + "\n";
			}
		}
		return saida;
	}

	public String listarAvaliacoes() {
		String saida = "***** Lista de avaliações *****\n";
		for (int i = 0; i < qtdObras; i++) {
			if(obras[i].getAvaliacao() != null)  {
				 saida = "Avaliação da obra: " + obras[i].titulo + "\n" + "Avaliação:\n" 
			+ obras[i].avaliacao.toString();
			}
		}
		return saida;
	}
	
	public int qtdObrasLidas() {
		int saida = 0;
		for (int i = 0; i < qtdObras; i++) {
			if(obras[i].getEtiqueta() == "Lido") {
				saida++;
			}
		}
		return saida;
	}
	
	public int qtdPagsLidas() {
		int saida = 0;
		for (int i = 0; i < qtdObras; i++) {
			if(obras[i].getEtiqueta() == "Lido") {
				saida += obras[i].getQtdPags();
			}
		}
		return saida;
	}
	
}
