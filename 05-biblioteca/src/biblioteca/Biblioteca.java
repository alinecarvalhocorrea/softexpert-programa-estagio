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
			System.out.println("Insira a op��o desejada: ");
			opcaoIndex = scanner.next();
			
			if (opcaoIndex.equals("1")) {
				System.out.println("Cadastrar");
				System.out.println("1 - Cadastrar Categoria");
				System.out.println("2 - Cadastrar Autor");
				System.out.println("3 - Voltar ao Menu Principal");
				System.out.println("Insira a op��o desejada: ");
				String opcaoCadastrar = scanner.next();
				
				if (opcaoCadastrar.equals("1")) {
					CadastroDeCategoria cadastrarCategoria = new CadastroDeCategoria(scanner, bancoDeCategorias);
					cadastrarCategoria.cadastrarCategoria();
				}
				if (opcaoCadastrar.equals("2")) {
					CadastroDeAutor cadastraAutor = new CadastroDeAutor(scanner, bancoDeAutores);
					cadastraAutor.cadastrarAutor();
				}
				if(opcaoCadastrar.equals("3")){
					continue;
				}
			}
			if (opcaoIndex.equals("2")) {
				System.out.println("Listar");
				System.out.println("1 - Listar Categorias");
				System.out.println("2 - Listar Autores");
				System.out.println("3 - Voltar ao Menu Principal");
				System.out.println("Insira a op��o desejada: ");
				String opcaoListar = scanner.next();
				
				if (opcaoListar.equals("1")) {
					ListaDeCategorias listaDeCategorias = new ListaDeCategorias(bancoDeCategorias);
					listaDeCategorias.listarCategorias();
				}
				if (opcaoListar.equals("2")) {
					ListaDeAutores listaDeAutores = new ListaDeAutores(bancoDeAutores);
					listaDeAutores.listarAutores();
				}
				if(opcaoListar.equals("3")){
					continue;
				}
			}
			if(opcaoIndex.equals("3")){
				System.out.println("Remover");
				System.out.println("1 - Remover Categoria");
				System.out.println("2 - Remover Autor(a)");
				System.out.println("3 - Voltar ao Menu Principal");
				System.out.println("Insira a op��o desejada: ");
				String opcaoRemover = scanner.next();
				
				if (opcaoRemover.equals("1")) {
					ListaDeCategorias listaDeCategorias = new ListaDeCategorias(bancoDeCategorias);
					listaDeCategorias.listarCategorias();
					RemoveCategoria removeCategoria = new RemoveCategoria(scanner,bancoDeCategorias);
					removeCategoria.removerCategoria();
				}
				if (opcaoRemover.equals("2")) {
					ListaDeCategorias listaDeCategorias = new ListaDeCategorias(bancoDeCategorias);
					listaDeCategorias.listarCategorias();
					RemoveCategoria removeCategoria = new RemoveCategoria(scanner,bancoDeCategorias);
					removeCategoria.removerCategoria();
				}
				if(opcaoRemover.equals("3")){
					continue;
				}
			}
			if(opcaoIndex.equals("4")){
				System.out.println("Editar");
				System.out.println("1 - Editar Categoria");
				System.out.println("3 - Voltar ao Menu Principal");
				System.out.println("Insira a op��o desejada: ");
				String opcaoEditar = scanner.next();
				
				if (opcaoEditar.equals("1")) {
					ListaDeCategorias listaDeCategorias = new ListaDeCategorias(bancoDeCategorias);
					listaDeCategorias.listarCategorias();
					EditaCategoria editaCategoria = new EditaCategoria(scanner, bancoDeCategorias);
					editaCategoria.editarCategoria();	
				}
				if(opcaoEditar.equals("3")){
					continue;
				}
			}
			if(opcaoIndex.equals("5")){
				System.out.println("Pesquisar");
				System.out.println("1 - Pesquisar Categoria");
				System.out.println("2 - Pesquisar Autor(a)");
				System.out.println("3 - Voltar ao Menu Principal");
				System.out.println("Insira a op��o desejada: ");
				String opcaoPesquisar = scanner.next();
				if(opcaoPesquisar.equals("1")){
					System.out.println("Pesquisar Categoria");
					System.out.println("1 - Pesquisar categoria por c�digo sequencial");
					System.out.println("2 - Pesquisar categoria por descri��o");
					System.out.println("Insira a op��o desejada: ");
					String opcaoPesquisarCategoria = scanner.next();
					if(opcaoPesquisarCategoria.equals("1")){
						PesquisaCategoriaPorCodigoSequencial pesquisaCategoriaCod = new PesquisaCategoriaPorCodigoSequencial(scanner, bancoDeCategorias);
						pesquisaCategoriaCod.pesquisarCategoriaPorCodigoSequencial();
					}
					if(opcaoPesquisarCategoria.equals("2")){
						PesquisaCategoriaPorDescricao pesquisaCategoriaDesc = new PesquisaCategoriaPorDescricao(scanner, bancoDeCategorias);
						pesquisaCategoriaDesc.pesquisarCategoriaPorDescricao();
					}
					
				}
				if(opcaoPesquisar.equals("2")){
					System.out.println("Pesquisar Autor(a)");
					System.out.println("1 - Pesquisar autor(a) por c�digo sequencial");
					System.out.println("2 - Pesquisar autor(a) por nome");
					System.out.println("3 - Pesquisar autor(a) por nacionalidade");
					System.out.println("Insira a op��o desejada: ");
					String opcaoPesquisarAutor = scanner.next();
					if(opcaoPesquisarAutor.equals("1")){
						PesquisaAutorPorCodigoSequencial pesquisaAutor = new PesquisaAutorPorCodigoSequencial(scanner, bancoDeAutores);
						pesquisaAutor.pesquisarAutorPorCodigoSequencial();
					}
					if(opcaoPesquisarAutor.equals("2")){
						PesquisaAutorPorNome pesquisaAutorNome = new PesquisaAutorPorNome(scanner, bancoDeAutores);
						pesquisaAutorNome.pesquisarAutorPorNome();
					}
					if(opcaoPesquisarAutor.equals("3")){
						PesquisaAutorPorNacionalidade pesquisaAutorNacionalidade = new PesquisaAutorPorNacionalidade(scanner, bancoDeAutores);
						pesquisaAutorNacionalidade.pesquisarAutorPorNacionalidade();
					}
				}
				if(opcaoPesquisar.equals("3")){
					continue;
				}
				
			}
		}
		System.out.println("############# Sistema encerrado ##############");
		scanner.close();
	}
}
