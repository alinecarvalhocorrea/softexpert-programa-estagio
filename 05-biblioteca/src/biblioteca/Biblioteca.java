package biblioteca;

import java.util.Scanner;

import biblioteca.memoria.BancoDeAutores;
import biblioteca.memoria.BancoDeCategorias;
import biblioteca.memoria.BancoDeLivros;

public class Biblioteca {
	public static void main(String[] args) {

		BancoDeLivros bancoDeLivros = new BancoDeLivros();
		BancoDeAutores bancoDeAutores = new BancoDeAutores();
		BancoDeCategorias bancoDeCategorias = new BancoDeCategorias();

		// TODO Persistir dados em arquivos externos

		System.out.println("Bem-Vindo(a) a biblioteca!");
		Scanner scanner = new Scanner(System.in);
		String opcaoIndex = "0";
		while (opcaoIndex != "6") {
			System.out.println("\n");
			System.out.println("MENU PRINCIPAL");
			System.out.println("1 - Cadastrar");
			System.out.println("2 - Listar");
			System.out.println("3 - Remover");
			System.out.println("4 - Editar");
			System.out.println("5 - Pesquisar");
			System.out.println("6 - Sair");
			System.out.println("Insira a opção desejada: ");
			opcaoIndex = scanner.next();
			
			if (opcaoIndex.equals("1")) {
				System.out.println("Cadastrar");
				System.out.println("1 - Cadastrar Categoria");
				System.out.println("2 - Cadastrar Autor");
				System.out.println("Insira a opção desejada: ");
				String opcaoCadastrar = scanner.next();
				
				if (opcaoCadastrar.equals("1")) {
					CadastroDeCategoria cadastrarCategoria = new CadastroDeCategoria(scanner, bancoDeCategorias);
					cadastrarCategoria.cadastrarCategoria();
				}
				if (opcaoCadastrar.equals("2")) {
					CadastroDeAutor cadastrarCategoria = new CadastroDeAutor(scanner, bancoDeAutores);
					cadastrarCategoria.cadastrarAutor();
				}
			}
			if (opcaoIndex.equals("2")) {
				System.out.println("Listar");
				System.out.println("1 - Listar Categorias");
				System.out.println("Insira a opção desejada: ");
				String opcaoListar = scanner.next();
				
				if (opcaoListar.equals("1")) {
					ListaDeCategorias listaDeCategorias = new ListaDeCategorias(bancoDeCategorias);
					listaDeCategorias.listarCategorias();
				}
			}
			if(opcaoIndex.equals("3")){
				System.out.println("Remover");
				System.out.println("1 - Remover Categoria");
				System.out.println("Insira a opção desejada: ");
				String opcaoRemover = scanner.next();
				
				if (opcaoRemover.equals("1")) {
					ListaDeCategorias listaDeCategorias = new ListaDeCategorias(bancoDeCategorias);
					listaDeCategorias.listarCategorias();
					RemoveCategoria removeCategoria = new RemoveCategoria(scanner,bancoDeCategorias);
					removeCategoria.removerCategoria();
				}
			}
			if(opcaoIndex.equals("4")){
				System.out.println("Editar");
				System.out.println("1 - Editar Categoria");
				System.out.println("Insira a opção desejada: ");
				String opcaoEditar = scanner.next();
				
				if (opcaoEditar.equals("1")) {
					ListaDeCategorias listaDeCategorias = new ListaDeCategorias(bancoDeCategorias);
					listaDeCategorias.listarCategorias();
					EditaCategoria editaCategoria = new EditaCategoria(scanner, bancoDeCategorias);
					editaCategoria.editarCategoria();
					
				}
			}
			if(opcaoIndex.equals("5")){
				System.out.println("Pesquisar");
				System.out.println("1 - Pesquisar Categoria");
				System.out.println("Insira a opção desejada: ");
				String opcaoPesquisar = scanner.next();
				if(opcaoPesquisar.equals("1")){
					System.out.println("Pesquisar Categoria");
					System.out.println("1 - Pesquisar categoria por código sequencial");
					System.out.println("2 - Pesquisar categoria por descrição");
					System.out.println("Insira a opção desejada: ");
					String opcaoPesquisarCategoria = scanner.next();
					if(opcaoPesquisarCategoria.equals("1")){
						PesquisaCategoria pesquisaCategoria = new PesquisaCategoria(scanner, bancoDeCategorias);
						pesquisaCategoria.pesquisarCategoriaPorCodigoSequencial();
					}
					if(opcaoPesquisarCategoria.equals("2")){
						PesquisaCategoria pesquisaCategoria = new PesquisaCategoria(scanner, bancoDeCategorias);
						pesquisaCategoria.pesquisarCategoriaPorDescricao();
					}
				}
				
			}
		}
		System.out.println("############# Sistema encerrado ##############");
		scanner.close();
	}
}
