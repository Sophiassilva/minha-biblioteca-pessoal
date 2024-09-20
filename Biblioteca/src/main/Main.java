package main;

import java.util.*;

import modelo.*;

public class Main {
	private static Scanner in = new Scanner(System.in);
	private static Usuario user;
	private static boolean userCadastrado = false;
	private static int aux;
	private static String auxiliar;
	private static Obra obra;

	public static void main(String[] args) {
		int op = 0;

		System.out.println(inicio());
		aux = in.nextInt();
		if (aux == 1) {
			cadastrarDados();
			op = -1;
		}

		while(op != 0) {
			System.out.print(menu());
			op = in.nextInt();
			switch (op) {
			case 0:
				System.out.println("Obrigada por utilizar a aplicação. Até logo!");
				break;
			case 1:
				if (userCadastrado) {
					System.out.println(user.toString());
				} else {
					System.out.println("Dados não cadastrados!");
				}
				break;
			case 2: 
				user = lerDadosUsuario();
				break;
			case 3: 
				user = null;
				System.out.println("Dados excluídos com sucesso!");
				op = 0;
				break;
			case 4: 
				cadastrarObra();
				break;
			case 5:
				user.getEstante().listarObras();
				break;
			case 6:
				System.out.println("Selecione qual obra deseja editar:");
				user.getEstante().listarObras();
				aux = in.nextInt();
				if (aux  > 0 && aux <= user.getEstante().getQtdObras()) {
					obra = lerDadosObra();
					user.getEstante().setObras(obra, aux-1);
				} else {
					System.out.println("Opcão inválida!");

				}
				break;
			case 7: 
				System.out.println("Selecione qual obra deseja excluir:");
				user.getEstante().listarObras();
				aux = in.nextInt();
				if (aux >= 0 && aux <= user.getEstante().getQtdObras()) {
					user.getEstante().setObras(null, aux-1);
					user.getEstante().setQtdObras(user.getEstante().getQtdObras()-1);
					System.out.println("Obra excluída com sucesso!");
					swapObras(aux);
				} else {
					System.out.println("Opcão inválida!");
				}
				break;
			case 8: 
				in.nextLine();
				System.out.println("Digite o título da obra: ");
				auxiliar = in.nextLine();
				user.getEstante().buscarObraPorTitulo(auxiliar);
				break;
			case 9: 
				System.out.println("Selecione qual obra deseja avaliar:");
				user.getEstante().listarObras();
				aux = in.nextInt();
				if (aux >= 0 && aux <= user.getEstante().getQtdObras()) {
					avaliar(aux);
				} else {
					System.out.println("Opcão inválida!");
				}
				break;
			case 10:
				user.getEstante().listarAvaliacoes();
				break;
			case 11:
				System.out.println("Selecione qual avaliação deseja editar:");
				user.getEstante().listarAvaliacoes();
				aux = in.nextInt();
				if (aux >= 0 && aux <= user.getEstante().getQtdObras()) {
					avaliar(aux);
				} else {
					System.out.println("Opcão inválida!");
				}
				break;
			case 12:
				System.out.println("Selecione qual avaliação deseja excluir:");
				user.getEstante().listarAvaliacoes();
				aux = in.nextInt();
				if (aux >= 0 && aux <= user.getEstante().getQtdObras()) {
					user.getEstante().getObras(aux-1).setAvaliacao(null);
					System.out.println("Avaliação excluída com sucesso!");
				} else {
					System.out.println("Opcão inválida!");
				}
				break;
			case 13: 
				System.out.println("Selecione qual obra deseja alterar a etiqueta:");
				user.getEstante().listarObras();
				aux = in.nextInt();
				if (aux >= 0 && aux <= user.getEstante().getQtdObras()) {

					System.out.println("Selecione a etiqueta: 1) Leitura atual\n2)Futura leitura\n3)Lido ");
					user.getEstante().getObras(aux-1).setEtiqueta(cadastrarEtiqueta(in.nextInt()));
				} else {
					System.out.println("Opcão inválida!");

				}
				break;
			case 14:
				System.out.println("Quant. de obras lidas: "
						+ user.getEstante().qtdObrasLidas());
				System.out.println("Quant. de ppáginas lidas: "
						+ user.getEstante().qtdPagsLidas());
				break;
			default:
				System.out.println("Opcao Invalida!");
				break;
			}
		}
		in.close();
	}

	public static String inicio() {
		String saida = new String("***** MENU - MINHA BIBLIOTECA PESSOAL *****\n");
		saida = saida + "0 - Sair da aplicação\n";
		saida = saida + "1 - Cadastrar\n";
		return saida;
	}

	public static String menu() {
		String saida = "***** MENU - MINHA BIBLIOTECA PESSOAL *****\n";
		saida = saida + "0 - Sair da aplicação\n";
		saida = saida + "1 - Visualizar meus dados\n";
		saida = saida + "2 - Editar meus dados\n";
		saida = saida + "3 - Excluir minha conta\n";
		saida = saida + "4 - Cadastrar obra\n";
		saida = saida + "5 - Listar obras\n";
		saida = saida + "6 - Editar obra\n";
		saida = saida + "7 - Excluir obra\n";
		saida = saida + "8 - Buscar obra\n";
		saida = saida + "9 - Cadastrar avaliacao\n";
		saida = saida + "10 - Listar avaliações\n";
		saida = saida + "11 - Editar avaliacao\n";
		saida = saida + "12 - Excluir avaliacao\n";
		saida = saida + "13 - Alterar etiqueta\n";
		saida = saida + "14 - Visualizar quantidade de obras e páginas lidas";
		return saida;
	}

	public static Usuario lerDadosUsuario() {
		String nome;
		String email;
		String senha;
		in.nextLine();
		System.out.println("Digite o nome: ");
		nome = in.nextLine();
		System.out.println("Digite o email: ");
		email = in.nextLine();
		System.out.println("Digite a senha: ");
		senha = in.nextLine();
		Usuario a = new Usuario(nome, email, senha);
		System.out.println("Dados cadastrados com sucesso!");
		return a;
	}

	public static void cadastrarDados() {
		if (userCadastrado) {
			System.out.println("Dados já cadastrados!");
		} else {
			user = lerDadosUsuario();
			userCadastrado = true;
		}

	}

	public static String cadastrarEtiqueta(int i) {
		String saida;
		if (i == 1) {
			saida = "Leitura atual";
		} else if (i == 2) {
			saida = "Futura leitura";
		} else if  (i == 3) {
			saida = "Lido";
		} else {
			System.out.println("Essa opção não existe! Etiqueta não cadastrada.");
			saida = "Não cadastrada";
		}
		return saida;
	}

	public static Obra lerDadosObra() {
		in.nextLine();
		System.out.println("Sua obra é:\n1) Livro\n2)Revista");
		int i = in.nextInt();
		String titulo;
		String etiqueta;
		int qtdPags;
		Obra obra;
		in.nextLine();
		if (i == 1) {
			String autor;
			String genero;
			String sinopse;
			System.out.println("Digite o título: ");
			titulo = in.nextLine();
			System.out.println("Selecione a etiqueta: 1) Leitura atual\n2)Futura leitura\n3)Lido ");
			etiqueta = cadastrarEtiqueta(in.nextInt());
			System.out.println("Digite a quantidade de páginas: ");
			qtdPags = in.nextInt();
			in.nextLine();
			System.out.println("Digite o nome do autor/a: ");
			autor = in.nextLine();
			System.out.println("Digite o gênero do livro: ");
			genero = in.nextLine();
			System.out.println("Digite uma breve sinopse: ");
			sinopse = in.nextLine();
			obra = new Livro(titulo, etiqueta, qtdPags, autor, genero, sinopse);
			System.out.println("Informações cadastradas com sucesso!");
		} else if (i == 2) {
			String editora;
			int ano;
			int numero;
			System.out.println("Digite o título: ");
			titulo = in.nextLine();
			System.out.println("Selecione a etiqueta: 1) Leitura atual\n2)Futura leitura\n3)Lido");
			etiqueta = cadastrarEtiqueta(in.nextInt());
			System.out.println("Digite a quantidade de páginas: ");
			qtdPags = in.nextInt();
			in.nextLine();
			System.out.println("Digite a editora: ");
			editora = in.nextLine();
			System.out.println("Digite o ano da publicação: ");
			ano = in.nextInt();
			System.out.println("Digite o número da edição: ");
			numero = in.nextInt();
			obra = new Revista(titulo, etiqueta, qtdPags, editora, ano, numero);
			System.out.println("Informações cadastradas com sucesso!");
		} else {
			System.out.println("Essa opção não existe! Informações não cadastradas.");
			obra = null;
		}
		return obra;
	}

	public static void cadastrarObra() {
		Obra a = lerDadosObra();
		if (a != null) {
			int qtdObras = user.getEstante().getQtdObras();
			user.getEstante().setObras(a, qtdObras);
			user.getEstante().setQtdObras(qtdObras+1);	
		}
	}

	public static Avaliacao lerDadosAvaliacao() {
		String resenha;
		int estrelas;
		in.nextLine();
		System.out.println("Escreva a resenha: ");
		resenha = in.nextLine();
		System.out.println("Entre 0 a 5, quantas estrelas esse livro merece?: ");
		estrelas = in.nextInt();
		Avaliacao avaliacao = new Avaliacao(resenha, estrelas);
		return avaliacao;
	}

	public static void avaliar(int i) {
		Avaliacao a = lerDadosAvaliacao();
		user.getEstante().getObras(i-1).setAvaliacao(a);
		System.out.println("Avaliação realizada com sucesso!");
	}
	public static void swapObras(int a) {
		for(int i = a; i < user.getEstante().getQtdObras() - 1; i++) {
			user.getEstante().setObras(user.getEstante().getObras(i+1), i);
		}
	}
}
