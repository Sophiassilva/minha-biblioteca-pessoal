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
	
	public void buscarObraPorTitulo(String busca) {
		System.out.println("Resultado da busca: ");
		int aux = 0;
		for (int i = 0; i < qtdObras; i++) {
			if(obras[i].getTitulo().equalsIgnoreCase(busca)) {
				aux++;
				System.out.println(getObras(i).toString());
			} 
		}
		if (aux == 0) {
			System.out.println( "Obra não encontrada!");
		}
	}
	
	public void listarObras() {
		System.out.println("***** Lista de obras *****");
		for(int i = 0; i < qtdObras; i++) {
			System.out.println(i+1 + " -> " + getObras(i).getTitulo());
		}
	}

	public void listarAvaliacoes() {
		System.out.println("***** Lista de avaliações *****");
		int a = 0;
		for (int i = 0; i < qtdObras; i++) {
			if(obras[i].getAvaliacao() != null)  {
				System.out.println( i+1 + " -> Avaliação da obra: " + obras[i].titulo + 
						"\n" + obras[i].avaliacao.toString());
				a++;
			}
		}
		if (a == 0) {
			System.out.println("Não há avaliações cadastradas!");
		}
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
