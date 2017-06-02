package com.biblioteca.console;

import java.util.Scanner;

import com.biblioteca.console.cadastro.CadastroDeAutor;
import com.biblioteca.console.cadastro.CadastroDeCategoria;
import com.biblioteca.console.cadastro.CadastroDeLivro;
import com.biblioteca.console.edita.EditaAutor;
import com.biblioteca.console.edita.EditaCategoria;
import com.biblioteca.console.lista.ListaDeAutores;
import com.biblioteca.console.lista.ListaDeCategorias;
import com.biblioteca.console.lista.ListaDeLivros;
import com.biblioteca.console.pesquisa.autor.PesquisaAutorPorCodigoSequencial;
import com.biblioteca.console.pesquisa.autor.PesquisaAutorPorDataDeNascimento;
import com.biblioteca.console.pesquisa.autor.PesquisaAutorPorNacionalidade;
import com.biblioteca.console.pesquisa.autor.PesquisaAutorPorNome;
import com.biblioteca.console.pesquisa.categoria.PesquisaCategoriaPorCodigoSequencial;
import com.biblioteca.console.pesquisa.categoria.PesquisaCategoriaPorDescricao;
import com.biblioteca.console.remove.RemoveAutor;
import com.biblioteca.console.remove.RemoveCategoria;
import com.biblioteca.console.remove.RemoveLivro;
import com.biblioteca.repositorios.memoria.BancoDeAutores;
import com.biblioteca.repositorios.memoria.BancoDeCategorias;
import com.biblioteca.repositorios.memoria.BancoDeLivros;

public class SystemBiblioteca {
	public static void main(String[] args) {		
		
		BancoDeLivros bancoDeLivros = new BancoDeLivros();
		BancoDeAutores bancoDeAutores = new BancoDeAutores();
		BancoDeCategorias bancoDeCategorias = new BancoDeCategorias();
	
		InicializaDados dadosIniciais = new InicializaDados(bancoDeAutores, bancoDeCategorias, bancoDeLivros);
		
		// TODO Persistir dados em arquivos externos

		System.out.println("                 Bem-Vindo(a) a biblioteca!");
		Scanner scanner = new Scanner(System.in);
		String opcaoIndex = "0";
		while (!opcaoIndex.equals("6")) {
			System.out.println("------------------------------------------------------------");
			System.out.println(" --------------------- MENU PRINCIPAL ---------------------");
			System.out.println("------------------------------------------------------------");
			System.out.println("1 - Cadastrar");
			System.out.println("2 - Listar");
			System.out.println("3 - Remover");
			System.out.println("4 - Editar");
			System.out.println("5 - Pesquisar");
			System.out.println("6 - Sair");
			System.out.print("Insira a op��o desejada:");
			opcaoIndex = scanner.next();
			System.out.println("-----------------------------------------------------------");
			
			if (opcaoIndex.equals("1")) {
				System.out.println("             >-------- Cadastrar ---------<");
				System.out.println("1 - Cadastrar Categoria");
				System.out.println("2 - Cadastrar Autor");
				System.out.println("3 - Cadastrar Livro");
				System.out.println("4 - Voltar ao Menu Principal");
				System.out.println("Insira a op��o desejada: ");
				String opcaoCadastrar = scanner.next();
				
					if (opcaoCadastrar.equals("1")) {
						System.out.println("-----------------------------------------------------------------");
						System.out.println(" --------------------- CADASTRAR CATEGORIA ---------------------");
						System.out.println("-----------------------------------------------------------------");
						System.out.println("\n");
						CadastroDeCategoria cadastrarCategoria = new CadastroDeCategoria(scanner, bancoDeCategorias);
						cadastrarCategoria.cadastrarCategoria();
						System.out.println("\n");
					}
					
					if (opcaoCadastrar.equals("2")) {
						System.out.println("-----------------------------------------------------------------");
						System.out.println(" --------------------- CADASTRAR AUTOR(A) ----------------------");
						System.out.println("-----------------------------------------------------------------");
						System.out.println("\n");
						CadastroDeAutor cadastraAutor = new CadastroDeAutor(scanner, bancoDeAutores);
						cadastraAutor.cadastrarAutor();
						System.out.println("\n");
	
					}
					
					if(opcaoCadastrar.equals("3")){
						System.out.println("-----------------------------------------------------------------");
						System.out.println(" ----------------------- CADASTRAR LIVRO -----------------------");
						System.out.println("-----------------------------------------------------------------");
						System.out.println("\n");
						CadastroDeLivro cadastraLivro = new CadastroDeLivro(scanner, bancoDeLivros, bancoDeAutores, bancoDeCategorias);
						cadastraLivro.cadastrarLivro();
						System.out.println("\n");
					}
					
					if(opcaoCadastrar.equals("4")){
						continue;
					}
			}
			if (opcaoIndex.equals("2")) {
				System.out.println("             >-------- Listar ---------<");
				System.out.println("1 - Listar Categorias");
				System.out.println("2 - Listar Autores");
				System.out.println("3 - Listar Livros");
				System.out.println("4 - Voltar ao Menu Principal");
				System.out.println("Insira a op��o desejada: ");
				String opcaoListar = scanner.next();
				
					if (opcaoListar.equals("1")) {
						System.out.println("-----------------------------------------------------------------");
						System.out.println(" ---------------------- LISTAR CATEGORIAS ----------------------");
						System.out.println("-----------------------------------------------------------------");
						System.out.println("\n");
						ListaDeCategorias listaDeCategorias = new ListaDeCategorias(bancoDeCategorias);
						listaDeCategorias.listarCategorias();
						System.out.println("\n");
					}
					
					if (opcaoListar.equals("2")) {
						System.out.println("-----------------------------------------------------------------");
						System.out.println(" ---------------------- LISTAR AUTORES -------------------------");
						System.out.println("-----------------------------------------------------------------");
						System.out.println("\n");
						ListaDeAutores listaDeAutores = new ListaDeAutores(bancoDeAutores);
						listaDeAutores.listarAutores();
						System.out.println("\n");
					}
					
					if(opcaoListar.equals("3")){
						System.out.println("-----------------------------------------------------------------");
						System.out.println(" ------------------------ LISTAR LIVROS ------------------------");
						System.out.println("-----------------------------------------------------------------");
						System.out.println("\n");
						ListaDeLivros lista = new ListaDeLivros(bancoDeLivros);
						lista.listarLivros();
						System.out.println("\n");
					}
					
					if(opcaoListar.equals("4")){
						continue;
					}
			}
			if(opcaoIndex.equals("3")){
				System.out.println("             >-------- Remover ---------<");
				System.out.println("1 - Remover Categoria");
				System.out.println("2 - Remover Autor(a)");
				System.out.println("3 - Remover Livro");
				System.out.println("4 - Voltar ao Menu Principal");
				System.out.println("Insira a op��o desejada: ");
				String opcaoRemover = scanner.next();
				System.out.println("\n");
				
					if (opcaoRemover.equals("1")) {
						System.out.println("-----------------------------------------------------------------");
						System.out.println(" ---------------------- REMOVER CATEGORIA ----------------------");
						System.out.println("-----------------------------------------------------------------");
						System.out.println("\n");
						ListaDeCategorias listaDeCategorias = new ListaDeCategorias(bancoDeCategorias);
						listaDeCategorias.listarCategorias();
						System.out.println("-----------------------------------------------------------------");
						RemoveCategoria removeCategoria = new RemoveCategoria(scanner,bancoDeCategorias);
						removeCategoria.removerCategoria();
						System.out.println("\n");
					}
					
					if (opcaoRemover.equals("2")) {
						System.out.println("-----------------------------------------------------------------");
						System.out.println(" ---------------------- REMOVER AUTOR(A) -----------------------");
						System.out.println("-----------------------------------------------------------------");
						System.out.println("\n");
						ListaDeAutores listaDeAutores = new ListaDeAutores(bancoDeAutores);
						listaDeAutores.listarAutores();
						System.out.println("-----------------------------------------------------------------");
						RemoveAutor removeAutor = new RemoveAutor(scanner,bancoDeAutores);
						removeAutor.removerAutor();
						System.out.println("\n");
					}
					
					if(opcaoRemover.equals("3")){
						System.out.println("-----------------------------------------------------------------");
						System.out.println(" ------------------------ REMOVER LIVRO ------------------------");
						System.out.println("-----------------------------------------------------------------");
						System.out.println("\n");
						ListaDeLivros lista = new ListaDeLivros(bancoDeLivros);
						lista.listarLivros();
						System.out.println("\n");
						System.out.println("-----------------------------------------------------------------");
						RemoveLivro removeLivro = new RemoveLivro(scanner,bancoDeLivros);
						removeLivro.removerLivro();
						System.out.println("\n");
					}
					if(opcaoRemover.equals("4")){
						continue;
					}
			}
			if(opcaoIndex.equals("4")){
				System.out.println("             >-------- Editar ---------<");
				System.out.println("1 - Editar Categoria");
				System.out.println("2 - Editar Autor");
				System.out.println("3 - Editar Livro");
				System.out.println("4 - Voltar ao Menu Principal");
				System.out.println("Insira a op��o desejada: ");
				String opcaoEditar = scanner.next();
				System.out.println("\n");
				
					if (opcaoEditar.equals("1")) {
						System.out.println("--------------------------------------------------------------");
						System.out.println(" --------------------- EDITAR CATEGORIA ---------------------");
						System.out.println("--------------------------------------------------------------");
						System.out.println("\n");
						ListaDeCategorias listaDeCategorias = new ListaDeCategorias(bancoDeCategorias);
						listaDeCategorias.listarCategorias();
						System.out.println("--------------------------------------------------------------");
						EditaCategoria editaCategoria = new EditaCategoria(scanner, bancoDeCategorias);
						editaCategoria.editarCategoria();
						System.out.println("\n");
					}
					
					if (opcaoEditar.equals("2")) {
						System.out.println("--------------------------------------------------------------");
						System.out.println(" --------------------- EDITAR AUTOR(A) ----------------------");
						System.out.println("--------------------------------------------------------------");
						System.out.println("\n");
						ListaDeAutores listaDeAutores = new ListaDeAutores(bancoDeAutores);
						listaDeAutores.listarAutores();
						System.out.println("--------------------------------------------------------------");
						EditaAutor editaAutor = new EditaAutor(scanner, bancoDeAutores);
						editaAutor.editarAutor();	
						System.out.println("\n");
					}
					
					if (opcaoEditar.equals("3")) {
						System.out.println("--------------------------------------------------------------");
						System.out.println(" ----------------------- EDITAR LIVRO -----------------------");
						System.out.println("--------------------------------------------------------------");
						System.out.println("\n");
						ListaDeLivros lista = new ListaDeLivros(bancoDeLivros);
						lista.listarLivros();
						System.out.println("\n");
						System.out.println("--------------------------------------------------------------");
						// TODO editar livro (METODO FEITO)
						// new EditaLivro(scanner, bancoDeLivros,bancoDeAutores,bancoDeCategorias);
						System.out.println("\n");
					}
					if(opcaoEditar.equals("4")){
						continue;
					}
			}
			if(opcaoIndex.equals("5")){
				System.out.println("             >-------- Pesquisar ---------<");
				System.out.println("1 - Pesquisar Categoria");
				System.out.println("2 - Pesquisar Autor(a)");
				System.out.println("3 - Pesquisar Livro");
				System.out.println("4 - Voltar ao Menu Principal");
				System.out.println("Insira a op��o desejada: ");
				String opcaoPesquisar = scanner.next();
				System.out.println("\n");
				
					if(opcaoPesquisar.equals("1")){
						System.out.println("****Pesquisar Categoria****");
						System.out.println("1 - Pesquisar categoria por c�digo sequencial");
						System.out.println("2 - Pesquisar categoria por descri��o");
						System.out.println("Insira a op��o desejada: ");
						String opcaoPesquisarCategoria = scanner.next();
						System.out.println("\n");
						
							if(opcaoPesquisarCategoria.equals("1")){
								System.out.println("-----------------------------------------------------------------");
								System.out.println(" --------------------- PESQUISAR CATEGORIA ---------------------");
								System.out.println("-----------------------------------------------------------------");
								System.out.println("\n");
								PesquisaCategoriaPorCodigoSequencial pesquisaCategoriaCod = new PesquisaCategoriaPorCodigoSequencial(scanner, bancoDeCategorias);
								pesquisaCategoriaCod.pesquisarCategoriaPorCodigoSequencial();
								System.out.println("\n");
							}
							
							if(opcaoPesquisarCategoria.equals("2")){
								System.out.println("-----------------------------------------------------------------");
								System.out.println(" --------------------- PESQUISAR CATEGORIA ---------------------");
								System.out.println("-----------------------------------------------------------------");
								System.out.println("\n");
								PesquisaCategoriaPorDescricao pesquisaCategoriaDesc = new PesquisaCategoriaPorDescricao(scanner, bancoDeCategorias);
								pesquisaCategoriaDesc.pesquisarCategoriaPorDescricao();
								System.out.println("\n");
							}
						
					}
					if(opcaoPesquisar.equals("2")){
						System.out.println("****Pesquisar Autor(a)****");
						System.out.println("1 - Pesquisar autor(a) por c�digo sequencial");
						System.out.println("2 - Pesquisar autor(a) por nome");
						System.out.println("3 - Pesquisar autor(a) por nacionalidade");
						System.out.println("4 - Pesquisar autor(a) por data de nascimento");
						System.out.println("Insira a op��o desejada: ");
						String opcaoPesquisarAutor = scanner.next();
						System.out.println("\n");
						
							if(opcaoPesquisarAutor.equals("1")){
								System.out.println("-----------------------------------------------------------------");
								System.out.println(" ---------------------- PESQUISAR AUTOR(A) ---------------------");
								System.out.println("-----------------------------------------------------------------");
								System.out.println("\n");
								PesquisaAutorPorCodigoSequencial pesquisaAutor = new PesquisaAutorPorCodigoSequencial(scanner, bancoDeAutores);
								pesquisaAutor.pesquisarAutorPorCodigoSequencial();
								System.out.println("\n");
							}
							
							if(opcaoPesquisarAutor.equals("2")){
								System.out.println("-----------------------------------------------------------------");
								System.out.println(" ---------------------- PESQUISAR AUTOR(A) ---------------------");
								System.out.println("-----------------------------------------------------------------");
								System.out.println("\n");
								PesquisaAutorPorNome pesquisaAutorNome = new PesquisaAutorPorNome(scanner, bancoDeAutores);
								pesquisaAutorNome.pesquisarAutorPorNome();
								System.out.println("\n");
							}
							
							if(opcaoPesquisarAutor.equals("3")){
								System.out.println("-----------------------------------------------------------------");
								System.out.println(" ---------------------- PESQUISAR AUTOR(A) ---------------------");
								System.out.println("-----------------------------------------------------------------");
								System.out.println("\n");
								PesquisaAutorPorNacionalidade pesquisaAutorNacionalidade = new PesquisaAutorPorNacionalidade(scanner, bancoDeAutores);
								pesquisaAutorNacionalidade.pesquisarAutorPorNacionalidade();
								System.out.println("\n");
							}
							
							if(opcaoPesquisarAutor.equals("4")){
								System.out.println("-----------------------------------------------------------------");
								System.out.println(" ---------------------- PESQUISAR AUTOR(A) ---------------------");
								System.out.println("-----------------------------------------------------------------");
								System.out.println("\n");
								PesquisaAutorPorDataDeNascimento pesquisaAutorPorDataDeNascimento = new PesquisaAutorPorDataDeNascimento(scanner, bancoDeAutores);
								pesquisaAutorPorDataDeNascimento.pesquisarAutorPorDataDeNascimento();
								System.out.println("\n");
							}
					}
					if(opcaoPesquisar.equals("3")){
						System.out.println("*****Pesquisar Livro*****");
						System.out.println("1 - Pesquisar livro por c�digo sequencial");
						System.out.println("2 - Pesquisar livro por c�digo de barras");
						System.out.println("3 - Pesquisar livro por t�tulo");
						System.out.println("4 - Pesquisar livro por autor");
						System.out.println("5 - Pesquisar livro por categoria");
						System.out.println("Insira a op��o desejada: ");
						String opcaoPesquisarLivro = scanner.next();
						System.out.println("\n");
						
							if(opcaoPesquisarLivro.equals("1")){
								System.out.println("-----------------------------------------------------------------");
								System.out.println(" ------------------------ PESQUISAR LIVRO ----------------------");
								System.out.println("-----------------------------------------------------------------");
								System.out.println("\n");
								// TODO Pesquisar livro por c�digo sequencial (METODO FEITO)
								//new PesquisaLivroPorCodigoSequencial(scanner, bancoDeLivros);
							}
								
							if(opcaoPesquisarLivro.equals("2")){
								System.out.println("-----------------------------------------------------------------");
								System.out.println(" ------------------------ PESQUISAR LIVRO ----------------------");
								System.out.println("-----------------------------------------------------------------");
								System.out.println("\n");
								// TODO Pesquisar livro por c�digo de barras (METODO FEITO)
								//new PesquisaLivroPorCodigoDeBarras(scanner, bancoDeLivros);
							}
							
							if(opcaoPesquisarLivro.equals("3")){
								System.out.println("-----------------------------------------------------------------");
								System.out.println(" ------------------------ PESQUISAR LIVRO ----------------------");
								System.out.println("-----------------------------------------------------------------");
								System.out.println("\n");
								// TODO Pesquisar livro por titulo (METODO FEITO)
								//new PesquisaLivroPorTitulo(scanner, bancoDeLivros);
							}
							
							if(opcaoPesquisarLivro.equals("4")){
								System.out.println("-----------------------------------------------------------------");
								System.out.println(" ------------------------ PESQUISAR LIVRO ----------------------");
								System.out.println("-----------------------------------------------------------------");
								System.out.println("\n");
								// TODO Pesquisar livro por autor (METODO FEITO)
								//new PesquisaLivroPorAutor(scanner, bancoDeLivros);
							}
							
							if(opcaoPesquisarLivro.equals("5")){
								System.out.println("-----------------------------------------------------------------");
								System.out.println(" ------------------------ PESQUISAR LIVRO ----------------------");
								System.out.println("-----------------------------------------------------------------");
								System.out.println("\n");
								// TODO Pesquisar livro por categoria (METODO FEITO)
								//new PesquisaLivroPorCategoria(scanner, bancoDeLivros);
							}
					}
					if(opcaoPesquisar.equals("4")){
						continue;
					}
			}
		}
		
		System.out.println("############# Sistema encerrado ##############");
		scanner.close();
		System.exit(0);
	}
}
