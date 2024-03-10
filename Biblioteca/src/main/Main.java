package main;

import java.util.*;

import modelo.*;

public class Main {
	private static Scanner in = new Scanner(System.in);
	private static Usuario user;
	private static boolean userCadastrado = false;
	private static int aux;

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
					// listarUsuarios();
					break;
				case 2:
					if (userCadastrado) {
						System.out.println(user.toString());
					} else {
						System.out.println("Dados não cadastrados!");
					}
					break;
				case 3: 
					user = lerDadosUsuario();
					break;
				case 4: 
					user = null;
					System.out.println("Dados excluídos com sucesso!\n");
					break;
				case 5: 
					cadastrarObra();
					break;
				case 6:
					user.getEstante().listarObras();
					break;
				case 7:
					System.out.println("Selecione qual obra deseja editar:\n");
					user.getEstante().listarObras();
					user.getEstante().setObras(lerDadosObra(), in.nextInt());
					break;
				case 8: 
					System.out.println("Selecione qual obra deseja excluir:\n");
					user.getEstante().setObras(null, in.nextInt());
					// metodo pra reordenar numero de obras
					break;
				case 9: 
					System.out.println("Digite o título da obra:\n");
					System.out.println(user.getEstante().buscarObraPorTitulo(in.nextLine()));
					break;
				default:
					System.out.println("\nOpcao Invalida!\n");
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
		saida = saida + "1 - Listar usuários\n";
		saida = saida + "2 - Visualizar meus dados\n";
		saida = saida + "3 - Editar meus dados\n";
		saida = saida + "4 - Excluir minha conta\n";
		saida = saida + "5 - Cadastrar obra\n";
		saida = saida + "6 - Listar obras\n";
		saida = saida + "7 - Editar obra\n";
		saida = saida + "8 - Excluir obra\n";
		saida = saida + "9 - Buscar obra\n";
		saida = saida + "10 - Cadastrar avaliacao\n";
		saida = saida + "11 - Listar avaliações\n";
		saida = saida + "12 - Editar avaliacao\n";
		saida = saida + "13 - Excluir avaliacao\n";
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
		System.out.println("Dados cadastrados com sucesso!\n");
		return a;
	}
	
	public static void cadastrarDados() {
		if (userCadastrado) {
			System.out.println("Dados já cadastrados!\n");
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
			System.out.println("Essa opção não existe! Etiqueta não cadastrada.\n");
			saida = "Não cadastrada";
		}
		return saida;
	}
	
	public static Obra lerDadosObra() {
		System.out.println("Sua obra é:\n1) Livro\n2)Revista\n");
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
			System.out.println("Selecione a etiqueta: 1) Leitura atual\n2)Futura leitura\n3)Lido\n ");
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
			System.out.println("Informações cadastradas com sucesso!\n");
		} else if (i == 2) {
			String editora;
			int ano;
			int numero;
			System.out.println("Digite o título: ");
			titulo = in.nextLine();
			System.out.println("Selecione a etiqueta: 1) Leitura atual\n2)Futura leitura\n3)Lido\n");
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
			System.out.println("Informações cadastradas com sucesso!\n");
		} else {
			System.out.println("Essa opção não existe! Informações não cadastradas.\n");
			obra = null;
		}
		return obra;
	}
	
	public static void cadastrarObra() {
		Obra a = lerDadosObra();
		if (a != null) {
			int qtdObras = user.getEstante().getQtdObras();
			user.getEstante().setObras(a, qtdObras);
			user.getEstante().setQtdObras(qtdObras+'1');	
		}
	}
}
