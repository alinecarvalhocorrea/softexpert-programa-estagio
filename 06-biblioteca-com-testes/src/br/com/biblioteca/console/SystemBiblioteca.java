package br.com.biblioteca.console;

import java.util.Scanner;
import br.com.biblioteca.console.cadastro.CadastroDeAutor;
import br.com.biblioteca.console.cadastro.CadastroDeCategoria;
import br.com.biblioteca.console.cadastro.CadastroDeLivro;
import br.com.biblioteca.console.edita.EditaAutor;
import br.com.biblioteca.console.edita.EditaCategoria;
import br.com.biblioteca.console.edita.EditaLivro;
import br.com.biblioteca.console.lista.ListaDeAutores;
import br.com.biblioteca.console.lista.ListaDeCategorias;
import br.com.biblioteca.console.lista.ListaDeLivros;
import br.com.biblioteca.console.pesquisa.autor.PesquisaAutorPorCodigoSequencial;
import br.com.biblioteca.console.pesquisa.autor.PesquisaAutorPorDataDeNascimento;
import br.com.biblioteca.console.pesquisa.autor.PesquisaAutorPorNacionalidade;
import br.com.biblioteca.console.pesquisa.autor.PesquisaAutorPorNome;
import br.com.biblioteca.console.pesquisa.categoria.PesquisaCategoriaPorCodigoSequencial;
import br.com.biblioteca.console.pesquisa.categoria.PesquisaCategoriaPorDescricao;
import br.com.biblioteca.console.pesquisa.livro.PesquisaLivroPorAutor;
import br.com.biblioteca.console.pesquisa.livro.PesquisaLivroPorCategoria;
import br.com.biblioteca.console.pesquisa.livro.PesquisaLivroPorCodigoDeBarras;
import br.com.biblioteca.console.pesquisa.livro.PesquisaLivroPorCodigoSequencial;
import br.com.biblioteca.console.pesquisa.livro.PesquisaLivroPorTitulo;
import br.com.biblioteca.console.remove.RemoveAutor;
import br.com.biblioteca.console.remove.RemoveCategoria;
import br.com.biblioteca.console.remove.RemoveLivro;
import br.com.biblioteca.objetos.exceptions.FormatoDeDataInvalidoException;
import br.com.biblioteca.objetos.testes.ZerarTestesDeAutores;
import br.com.biblioteca.objetos.testes.ZerarTestesDeCategorias;
import br.com.biblioteca.objetos.testes.ZerarTestesDeLivros;
import br.com.biblioteca.repositorios.interfaces.Autores;
import br.com.biblioteca.repositorios.interfaces.Categorias;
import br.com.biblioteca.repositorios.interfaces.Livros;
import br.com.biblioteca.repositorios.memoria.BancoDeAutoresEmMemoria;
import br.com.biblioteca.repositorios.memoria.BancoDeCategoriasEmMemoria;
import br.com.biblioteca.repositorios.memoria.BancoDeLivrosEmMemoria;

/**
 * 
 * @author aline.correa
 *
 *         Script para a interação do usuário com o sistema (Menus console)
 *
 */

public class SystemBiblioteca {
	public static void main(String[] args) throws FormatoDeDataInvalidoException {

		Livros bancoDeLivros = new BancoDeLivrosEmMemoria();
		Autores bancoDeAutores = new BancoDeAutoresEmMemoria();
		Categorias bancoDeCategorias = new BancoDeCategoriasEmMemoria();

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
			System.out.print("Insira a opção desejada:");
			opcaoIndex = scanner.next();
			System.out.println("-----------------------------------------------------------");

			if (opcaoIndex.equals("1")) {
				System.out.println("             >-------- Cadastrar ---------<");
				System.out.println("1 - Cadastrar Categoria");
				System.out.println("2 - Cadastrar Autor");
				System.out.println("3 - Cadastrar Livro");
				System.out.println("4 - Voltar ao Menu Principal");
				System.out.println("Insira a opção desejada: ");
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

				if (opcaoCadastrar.equals("3")) {
					System.out.println("-----------------------------------------------------------------");
					System.out.println(" ----------------------- CADASTRAR LIVRO -----------------------");
					System.out.println("-----------------------------------------------------------------");
					System.out.println("\n");
					CadastroDeLivro cadastraLivro = new CadastroDeLivro(scanner, bancoDeLivros, bancoDeAutores,
							bancoDeCategorias);
					cadastraLivro.cadastrarLivro();
					System.out.println("\n");
				}

				if (opcaoCadastrar.equals("4")) {
					continue;
				}
			}
			if (opcaoIndex.equals("2")) {
				System.out.println("             >-------- Listar ---------<");
				System.out.println("1 - Listar Categorias");
				System.out.println("2 - Listar Autores");
				System.out.println("3 - Listar Livros");
				System.out.println("4 - Voltar ao Menu Principal");
				System.out.println("Insira a opção desejada: ");
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

				if (opcaoListar.equals("3")) {
					System.out.println("-----------------------------------------------------------------");
					System.out.println(" ------------------------ LISTAR LIVROS ------------------------");
					System.out.println("-----------------------------------------------------------------");
					System.out.println("\n");
					ListaDeLivros lista = new ListaDeLivros(bancoDeLivros);
					lista.listarLivros();
					System.out.println("\n");
				}

				if (opcaoListar.equals("4")) {
					continue;
				}
			}
			if (opcaoIndex.equals("3")) {
				System.out.println("             >-------- Remover ---------<");
				System.out.println("1 - Remover Categoria");
				System.out.println("2 - Remover Autor(a)");
				System.out.println("3 - Remover Livro");
				System.out.println("4 - Voltar ao Menu Principal");
				System.out.println("Insira a opção desejada: ");
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
					RemoveCategoria removeCategoria = new RemoveCategoria(scanner, bancoDeCategorias);
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
					RemoveAutor removeAutor = new RemoveAutor(scanner, bancoDeAutores);
					removeAutor.removerAutor();
					System.out.println("\n");
				}

				if (opcaoRemover.equals("3")) {
					System.out.println("-----------------------------------------------------------------");
					System.out.println(" ------------------------ REMOVER LIVRO ------------------------");
					System.out.println("-----------------------------------------------------------------");
					System.out.println("\n");
					ListaDeLivros lista = new ListaDeLivros(bancoDeLivros);
					lista.listarLivros();
					System.out.println("\n");
					System.out.println("-----------------------------------------------------------------");
					RemoveLivro removeLivro = new RemoveLivro(scanner, bancoDeLivros);
					removeLivro.removerLivro();
					System.out.println("\n");
				}
				if (opcaoRemover.equals("4")) {
					continue;
				}
			}
			if (opcaoIndex.equals("4")) {
				System.out.println("             >-------- Editar ---------<");
				System.out.println("1 - Editar Categoria");
				System.out.println("2 - Editar Autor");
				System.out.println("3 - Editar Livro");
				System.out.println("4 - Voltar ao Menu Principal");
				System.out.println("Insira a opção desejada: ");
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
					EditaLivro editaLivro = new EditaLivro(scanner, bancoDeLivros, bancoDeAutores, bancoDeCategorias);
					editaLivro.editarLivro();
					System.out.println("\n");
				}
				if (opcaoEditar.equals("4")) {
					continue;
				}
			}
			if (opcaoIndex.equals("5")) {
				System.out.println("             >-------- Pesquisar ---------<");
				System.out.println("1 - Pesquisar Categoria");
				System.out.println("2 - Pesquisar Autor(a)");
				System.out.println("3 - Pesquisar Livro");
				System.out.println("4 - Voltar ao Menu Principal");
				System.out.println("Insira a opção desejada: ");
				String opcaoPesquisar = scanner.next();
				System.out.println("\n");

				if (opcaoPesquisar.equals("1")) {
					System.out.println("****Pesquisar Categoria****");
					System.out.println("1 - Pesquisar categoria por código sequencial");
					System.out.println("2 - Pesquisar categoria por descrição");
					System.out.println("Insira a opção desejada: ");
					String opcaoPesquisarCategoria = scanner.next();
					System.out.println("\n");

					if (opcaoPesquisarCategoria.equals("1")) {
						System.out.println("-----------------------------------------------------------------");
						System.out.println(" --------------------- PESQUISAR CATEGORIA ---------------------");
						System.out.println("-----------------------------------------------------------------");
						System.out.println("\n");
						PesquisaCategoriaPorCodigoSequencial pesquisaCategoriaCod = new PesquisaCategoriaPorCodigoSequencial(
								scanner, bancoDeCategorias);
						pesquisaCategoriaCod.pesquisarCategoriaPorCodigoSequencial();
						System.out.println("\n");
					}

					if (opcaoPesquisarCategoria.equals("2")) {
						System.out.println("-----------------------------------------------------------------");
						System.out.println(" --------------------- PESQUISAR CATEGORIA ---------------------");
						System.out.println("-----------------------------------------------------------------");
						System.out.println("\n");
						PesquisaCategoriaPorDescricao pesquisaCategoriaDesc = new PesquisaCategoriaPorDescricao(scanner,
								bancoDeCategorias);
						pesquisaCategoriaDesc.pesquisarCategoriaPorDescricao();
						System.out.println("\n");
					}

				}
				if (opcaoPesquisar.equals("2")) {
					System.out.println("****Pesquisar Autor(a)****");
					System.out.println("1 - Pesquisar autor(a) por código sequencial");
					System.out.println("2 - Pesquisar autor(a) por nome");
					System.out.println("3 - Pesquisar autor(a) por nacionalidade");
					System.out.println("4 - Pesquisar autor(a) por data de nascimento");
					System.out.println("Insira a opção desejada: ");
					String opcaoPesquisarAutor = scanner.next();
					System.out.println("\n");

					if (opcaoPesquisarAutor.equals("1")) {
						System.out.println("-----------------------------------------------------------------");
						System.out.println(" ---------------------- PESQUISAR AUTOR(A) ---------------------");
						System.out.println("-----------------------------------------------------------------");
						System.out.println("\n");
						PesquisaAutorPorCodigoSequencial pesquisaAutor = new PesquisaAutorPorCodigoSequencial(scanner,
								bancoDeAutores);
						pesquisaAutor.pesquisarAutorPorCodigoSequencial();
						System.out.println("\n");
					}

					if (opcaoPesquisarAutor.equals("2")) {
						System.out.println("-----------------------------------------------------------------");
						System.out.println(" ---------------------- PESQUISAR AUTOR(A) ---------------------");
						System.out.println("-----------------------------------------------------------------");
						System.out.println("\n");
						PesquisaAutorPorNome pesquisaAutorNome = new PesquisaAutorPorNome(scanner, bancoDeAutores);
						pesquisaAutorNome.pesquisarAutorPorNome();
						System.out.println("\n");
					}

					if (opcaoPesquisarAutor.equals("3")) {
						System.out.println("-----------------------------------------------------------------");
						System.out.println(" ---------------------- PESQUISAR AUTOR(A) ---------------------");
						System.out.println("-----------------------------------------------------------------");
						System.out.println("\n");
						PesquisaAutorPorNacionalidade pesquisaAutorNacionalidade = new PesquisaAutorPorNacionalidade(
								scanner, bancoDeAutores);
						pesquisaAutorNacionalidade.pesquisarAutorPorNacionalidade();
						System.out.println("\n");
					}

					if (opcaoPesquisarAutor.equals("4")) {
						System.out.println("-----------------------------------------------------------------");
						System.out.println(" ---------------------- PESQUISAR AUTOR(A) ---------------------");
						System.out.println("-----------------------------------------------------------------");
						System.out.println("\n");
						PesquisaAutorPorDataDeNascimento pesquisaAutorPorDataDeNascimento = new PesquisaAutorPorDataDeNascimento(
								scanner, bancoDeAutores);
						pesquisaAutorPorDataDeNascimento.pesquisarAutorPorDataDeNascimento();
						System.out.println("\n");
					}
				}
				if (opcaoPesquisar.equals("3")) {
					System.out.println("*****Pesquisar Livro*****");
					System.out.println("1 - Pesquisar livro por código sequencial");
					System.out.println("2 - Pesquisar livro por código de barras");
					System.out.println("3 - Pesquisar livro por título");
					System.out.println("4 - Pesquisar livro por autor");
					System.out.println("5 - Pesquisar livro por categoria");
					System.out.println("Insira a opção desejada: ");
					String opcaoPesquisarLivro = scanner.next();
					System.out.println("\n");

					if (opcaoPesquisarLivro.equals("1")) {
						System.out.println("-----------------------------------------------------------------");
						System.out.println(" ------------------------ PESQUISAR LIVRO ----------------------");
						System.out.println("-----------------------------------------------------------------");
						System.out.println("\n");
						PesquisaLivroPorCodigoSequencial pesquisaLivro = new PesquisaLivroPorCodigoSequencial(scanner,
								bancoDeLivros);
						pesquisaLivro.pesquisarLivroPorCodigoSequencial();
					}

					if (opcaoPesquisarLivro.equals("2")) {
						System.out.println("-----------------------------------------------------------------");
						System.out.println(" ------------------------ PESQUISAR LIVRO ----------------------");
						System.out.println("-----------------------------------------------------------------");
						System.out.println("\n");
						PesquisaLivroPorCodigoDeBarras pesquisaLivro = new PesquisaLivroPorCodigoDeBarras(scanner,
								bancoDeLivros);
						pesquisaLivro.pesquisaLivroPorCodigoDeBarras();
					}

					if (opcaoPesquisarLivro.equals("3")) {
						System.out.println("-----------------------------------------------------------------");
						System.out.println(" ------------------------ PESQUISAR LIVRO ----------------------");
						System.out.println("-----------------------------------------------------------------");
						System.out.println("\n");
						PesquisaLivroPorTitulo pesquisaLivro = new PesquisaLivroPorTitulo(scanner, bancoDeLivros);
						pesquisaLivro.pesquisaLivroPorTitulo();
					}

					if (opcaoPesquisarLivro.equals("4")) {
						System.out.println("-----------------------------------------------------------------");
						System.out.println(" ------------------------ PESQUISAR LIVRO ----------------------");
						System.out.println("-----------------------------------------------------------------");
						System.out.println("\n");
						PesquisaLivroPorAutor pesquisaLivro = new PesquisaLivroPorAutor(scanner, bancoDeLivros);
						pesquisaLivro.pesquisaLivroPorAutor();
					}

					if (opcaoPesquisarLivro.equals("5")) {
						System.out.println("-----------------------------------------------------------------");
						System.out.println(" ------------------------ PESQUISAR LIVRO ----------------------");
						System.out.println("-----------------------------------------------------------------");
						System.out.println("\n");
						PesquisaLivroPorCategoria pesquisaLivro = new PesquisaLivroPorCategoria(scanner, bancoDeLivros);
						pesquisaLivro.pesquisaLivroPorCategoria();
					}
				}
				if (opcaoPesquisar.equals("4")) {
					continue;
				}
			}
		}
		if (opcaoIndex.equals("6")) {
			System.out.println("############# Sistema encerrado ##############");
			scanner.close();
			System.exit(0);
			new ZerarTestesDeAutores().zerar();
			new ZerarTestesDeLivros().zerar();
			new ZerarTestesDeCategorias().zerar();
		}
	}
}
