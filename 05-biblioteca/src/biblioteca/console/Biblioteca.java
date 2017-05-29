package biblioteca.console;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

import biblioteca.Autor;
import biblioteca.Categoria;
import biblioteca.Livro;
import biblioteca.memoria.BancoDeAutores;
import biblioteca.memoria.BancoDeCategorias;
import biblioteca.memoria.BancoDeLivros;

/**
 * 
 * @author aline.correa
 *
 */

public class Biblioteca {
	public static void main(String[] args) {

		BancoDeLivros bancoDeLivros = new BancoDeLivros();
		BancoDeAutores bancoDeAutores = new BancoDeAutores();
		BancoDeCategorias bancoDeCategorias = new BancoDeCategorias();

		Autor autor1 = new Autor("Aline", "brasileira");
		Autor autor2 = new Autor("Teste autor", "francês");

		Categoria categoria1 = new Categoria("Drama");
		Categoria categoria2 = new Categoria("Comedia");

		Livro livro1 = new Livro();
		livro1.setTitulo("Testando o sistema");
		livro1.setAutor(autor1);
		livro1.setLocal("a8");
		livro1.setCategoria(categoria1);
		Livro livro2 = new Livro();
		livro1.setTitulo("Aline Testando o sistema");
		livro1.setAutor(autor2);
		livro1.setLocal("d2");
		livro1.setCategoria(categoria2);

		bancoDeAutores.adicionar(autor1);
		bancoDeAutores.adicionar(autor2);
		bancoDeCategorias.adicionar(categoria1);
		bancoDeCategorias.adicionar(categoria2);
		bancoDeLivros.adicionar(livro1);
		bancoDeLivros.adicionar(livro2);
		int opcaoIndex = 0;
		System.out.println("Bem-Vindo(a) a biblioteca!");
		Scanner entrada = new Scanner(System.in);

		while (opcaoIndex != 6) {
			System.out.println("\nMENU PRINCIPAL");
			System.out.println("1 - Consultar");
			System.out.println("2 - Adicionar");
			System.out.println("3 - Remover");
			System.out.println("4 - Alterar");
			System.out.println("5 - Listar");
			System.out.println("6 - Sair");
			System.out.println("Insira a opção desejada: ");
			opcaoIndex = entrada.nextInt();

			if (opcaoIndex == 1) {
				System.out.println("1 - Consultar");
				System.out.println("    Consultar Livro");
				System.out.println("        0 - Consultar Livro por Título");
				System.out.println("        1 - Consultar Livro por Código Sequencial");
				System.out.println("        2 - Consultar Livro por Código de Barras");
				System.out.println("        3 - Consultar Livro por Categoria");
				System.out.println("    Consultar Categoria");
				System.out.println("        4 - Consultar Categoria por Descrição");
				System.out.println("        5 - Consultar Categoria por Código Sequencial");
				System.out.println("    Consultar Autor");
				System.out.println("        6 - Consultar Autor por Nome");
				System.out.println("        7 - Consultar Autor por Nacionalidade");
				System.out.println("        8 - Consultar Autor por Data de Nascimento");
				System.out.println("        9 - Consultar Autor por Código Sequencial");
				System.out.println("Insira a opção desejada: ");
				int opcao1 = entrada.nextInt();

				if (opcao1 == 0) {
					// TODO SISTEMA : Consultar livro por titulo
					System.out.println("Consultar Livro por Título");
					System.out.println("Insira sua pesquisa: ");
					String pesquisaPorTitulo = " " + entrada.next();
					System.out.println(pesquisaPorTitulo);
				}
				if (opcao1 == 1) {
					System.out.println("Consultar Livro por Código Sequencial");
					System.out.println("Insira o código sequencial: ");
					String pesquisaPorCodigoSequencial = entrada.next();
					Livro livroEncontrado = bancoDeLivros.buscarPorCodigoSequencial(pesquisaPorCodigoSequencial);
					System.out.println("Consultando no Banco de Livros...");
					if (livroEncontrado == null) {
						System.out.println("Livro não encontrado");
					} else {
						System.out.println(livroEncontrado);
					}
				}
				if (opcao1 == 2) {
					System.out.println("Consultar Livro por Código de Barras");
					System.out.println("Insira o código de barras: ");
					String pesquisaPorCodigoDeBarras = entrada.next();
					Livro livroEncontrado = bancoDeLivros.buscarPorCodigoDeBarras(pesquisaPorCodigoDeBarras);
					System.out.println("Consultando no Banco de Livros...");
					if (livroEncontrado == null) {
						System.out.println("Livro não encontrado");
					} else {
						System.out.println(livroEncontrado);
					}
				}
				if (opcao1 == 3) {
					// TODO SISTEMA : Consultar livros por categoria
					System.out.println("Consultar Livros por Categoria");
					System.out.println("Insira a categoria (Exemplo : drama, suspense): ");
					String pesquisaPorCategoria = entrada.next();
					System.out.println("\nConsultando no Banco de Livros...");
					/*
					 * List<Livro> livrosEncontrados =
					 * bancoDeLivros.buscarPorCategoria(pesquisaPorCategoria);
					 * if(livrosEncontrados.isEmpty()){ System.out.
					 * println("Não foram encontrados livros na categoria informada"
					 * ); }else{ for (Livro livro : livrosEncontrados) {
					 * System.out.println(livro); } }
					 */
				}
				if (opcao1 == 4) {
					System.out.println("Consultar Categoria por Descrição");
					System.out.println("Insira a descrição: ");
					String pesquisaPorDescricao = entrada.next();
					Categoria categoriaEncontrada = bancoDeCategorias.buscarCategoriaPorDescricao(pesquisaPorDescricao);
					System.out.println("Consultando no Banco de Categorias...");
					if (categoriaEncontrada == null) {
						System.out.println("Categoria não encontrada");
					} else {
						System.out.println("Categoria : " + categoriaEncontrada + ", código sequencial: "
								+ categoriaEncontrada.getCodigoSequencial());
					}

				}
				if (opcao1 == 5) {
					System.out.println("Consultar Categoria por Código Sequencial");
					System.out.println("Insira o código sequencial: ");
					// TODO SISTEMA : Consultar Categoria por Código Sequencial
					System.out.println("Consultando no Banco de Categorias...");
				}
				if (opcao1 == 6) {
					System.out.println("Consultar Autor por Nome");
					System.out.println("Insira o nome: ");
					// TODO SISTEMA : Consultar Autor por Nome
					System.out.println("Consultando no Banco de Autores...");
				}
				if (opcao1 == 7) {
					System.out.println("Consultar Autor por Nacionalidade");
					System.out.println("Insira a nacionalidade: ");
					// TODO SISTEMA : Consultar Autor por Nacionalidade
					System.out.println("Consultando no Banco de Autores...");
				}
				if (opcao1 == 8) {
					System.out.println("Consultar Autor por Data de Nascimento");
					System.out.println("Insira a data de nascimento: ");
					// TODO SISTEMA : Consultar Autor por Data de Nascimento
					System.out.println("Consultando no Banco de Autores...");
				}
				if (opcao1 == 9) {
					System.out.println("Consultar Autor por Código Sequencial");
					System.out.println("Insira o código sequencial: ");
					// TODO SISTEMA : Consultar Autor por Código Sequencial
					System.out.println("Consultando no Banco de Autores...");
				}
			}
			if (opcaoIndex == 2) {
				System.out.println("2 - Adicionar");
				System.out.println("    1 - Adicionar Livro");
				System.out.println("    2 - Adicionar Autor");
				System.out.println("    3 - Adicionar Categoria");
				System.out.println("Insira a opção desejada: ");
				int opcao2 = entrada.nextInt();

				if (opcao2 == 1) {
					// TODO SISTEMA : Adicionar Livro
					System.out.println("Insira o título do livro:");
					String titulo = entrada.nextLine();
					System.out.println("Insira o local do livro: Prateleira ");
					String local = "Prateleira " + entrada.nextLine();
					System.out.println("Insira a quantidade de páginas do livro:");
					String quantidadeDePaginas = entrada.nextLine();
					System.out.println("Insira a data de aquisição do livro:");
					String dataDeAquisicao = entrada.nextLine();
					System.out.println("Insira a categoria do livro:");
					String categoria = entrada.nextLine();
					// pesquisa por descricao de categoria
					/*
					 * System.out.println("Verificando categoria no sistema: \n"
					 * );
					 * System.out.println("Categoria encontrada no sistema: \n"
					 * );
					 */
					// printa na tela categoria encontrado
					System.out.println("Insira o resumo do livro:");
					String resumo = entrada.nextLine();
					System.out.println("Insira o nome do autor do livro:");
					String autor = entrada.nextLine();
					// pesquisa por nome de autor
					/*
					 * System.out.println("Verificando autor(a) no sistema: \n"
					 * );
					 * System.out.println("Autor(a) encontrado no sistema: \n");
					 */
					// printa na tela autor encontrado

					/*
					 * Livro novoLivro = new Livro(); novoLivro.setTitulo();
					 * novoLivro.setQuantidadeDePaginas(quantidadeDePaginas);
					 * novoLivro.setAutor(autorEncontrado);
					 * novoLivro.setCategoria(autorEncontrado);
					 * novoLivro.setLocal(local); novoLivro.setResumo(resumo);
					 * novoLivro.setDataDeAquisicao(dataDeAquisicao);
					 */
				}
				if (opcao2 == 2) {
					// TODO SISTEMA : Adicionar Autor
				}
				if (opcao2 == 3) {
					// TODO SISTEMA : Adicionar Categoria
					System.out.println("Insira a descrição da categoria(Exemplo: Drama): ");
					String descricao = entrada.next();
					Categoria novaCategoria = new Categoria(descricao);
					bancoDeCategorias.adicionar(novaCategoria);
					System.out.println("Criando categoria: " + descricao);
					System.out.println("Adicionando Categoria ao Banco...");
					// TODO SISTEMA : Verificação de criação de nova categoria
					System.out.println(novaCategoria.getDescricao() + " adicionada ao Banco de Categorias");

				}
			}

			if (opcaoIndex == 3) {
				System.out.println("3 - Remover");
				System.out.println("    1 - Remover Livro");
				System.out.println("    2 - Remover Autor");
				System.out.println("    3 - Remover Categoria");
				System.out.println("Insira a opção desejada: ");
				int opcao3 = entrada.nextInt();

				if (opcao3 == 1) {
					// TODO SISTEMA : Remover livro
					System.out.println("1 - Remover Livro");
					System.out.println("Por favor, insira o código sequencial do livro: ");
					String codigoSequencial = entrada.nextLine();
					Livro livroParaRemover = bancoDeLivros.buscarPorCodigoSequencial(codigoSequencial);
					// 3 - Pesquisar e retornar o livro pelo código sequencial
					// 4 - excluir() livro retornado
				}
				if (opcao3 == 2) {
					// TODO SISTEMA : Remover Autor
					System.out.println("2 - Remover Autor");
					System.out.println("\nListando Autores...\n");
					System.out.println("Banco de Autores:\n");
					Set<Autor> listaDeAutores = bancoDeAutores.listar();
					for (Autor autor : listaDeAutores) {
						System.out.println(autor);
					}
					System.out.println("Insira o nome do autor:");
					String nome = entrada.nextLine();

					// 3 - excluir() autor retornado
				}
				if (opcao3 == 3) {
					// TODO SISTEMA : Remover Categoria
					System.out.println("3 - Remover Categoria");
					// 1 - Solicitar código sequencial
					// 2 - Pesquisar e retornar o categoria pelo código
					// sequencial
					// 3 - excluir() categoria retornada
				}
			}
			if (opcaoIndex == 4) {
				System.out.println("4 - Alterar");
				System.out.println("    1 - Alterar Livro");
				System.out.println("    2 - Alterar Autor");
				System.out.println("    3 - Alterar Categoria");
				System.out.println("Insira a opção desejada: ");
				int opcao4 = entrada.nextInt();

				if (opcao4 == 1) {
					// TODO SISTEMA : Alterar Livro
					// 1 - Solicitar código sequencial
					// 2 - Pesquisar e retornar o livro pelo código sequencial
					// 3 - editar() livro retornado
				}
				if (opcao4 == 2) {
					// TODO SISTEMA : Alterar Autor
					// 1 - Solicitar código sequencial
					// 2 - Pesquisar e retornar o Autor pelo código sequencial
					// 3 - editar() Autor retornado
				}
				if (opcao4 == 3) {
					// TODO SISTEMA : Alterar Categoria
					// 1 - Solicitar código sequencial
					// 2 - Pesquisar e retornar o categoria pelo código
					// sequencial
					// 3 - editar() categoria retornada
				}
			}
			if (opcaoIndex == 5) {
				System.out.println("5 - Listar");
				System.out.println("    1 - Listar Livros");
				System.out.println("    2 - Listar Autores(as)");
				System.out.println("    3 - Listar Categorias");
				System.out.println("Insira a opção desejada: ");
				int opcao5 = entrada.nextInt();

				if (opcao5 == 1) {
					// TODO SISTEMA : Listar Livros
					System.out.println("\nListando Livros...\n");
					System.out.println("Banco de Livros:\n");
					Set<Livro> listaDeLivros = bancoDeLivros.listar();
					for (Livro livro : listaDeLivros) {
						System.out.println(livro);
					}
				}
				if (opcao5 == 2) {
					System.out.println("\nListando Autores...\n");
					System.out.println("Banco de Autores:\n");
					Set<Autor> listaDeAutores = bancoDeAutores.listar();
					for (Autor autor : listaDeAutores) {
						System.out.println(autor);
					}
				}
				if (opcao5 == 3) {
					System.out.println("\nListando Categorias...\n");
					System.out.println("Banco de Categorias:\n");
					Set<Categoria> listaDeCategorias = bancoDeCategorias.listar();
					for (Categoria categoria : listaDeCategorias) {
						System.out.println(
								"Descrição: " + categoria + ", Código Sequencial: " + categoria.getCodigoSequencial());
					}
				}
			}
		}
		if (opcaoIndex == 6) {
			entrada.close();
			System.out.println("--------Sistema Fechado-------");
		}

		/*
		 * Menu menus = new Menu(); menus.menuIndex();
		 * 
		 * int opcaoIndex = scanner.nextInt();
		 * 
		 * menus.lerIndex(scanner, opcaoIndex, bancoDeLivros, bancoDeAutores,
		 * bancoDeCategorias);
		 */

	}
}
