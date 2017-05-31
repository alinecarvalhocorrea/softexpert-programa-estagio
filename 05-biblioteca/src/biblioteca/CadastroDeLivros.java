package biblioteca;

import java.util.Scanner;

import biblioteca.memoria.BancoDeAutores;
import biblioteca.memoria.BancoDeCategorias;
import biblioteca.memoria.BancoDeLivros;

public class CadastroDeLivros {
	private Scanner scanner;
	private static BancoDeLivros bancoDeLivros;
	private static BancoDeAutores bancoDeAutores;
	private static BancoDeCategorias bancoDeCategorias;
	
	public CadastroDeLivros(Scanner scanner, BancoDeLivros bancoDeLivros,BancoDeAutores bancoDeAutores,BancoDeCategorias bancoDeCategorias){
		this.scanner = scanner;
		CadastroDeLivros.bancoDeLivros = bancoDeLivros;
		CadastroDeLivros.bancoDeAutores = bancoDeAutores;
		CadastroDeLivros.bancoDeCategorias = bancoDeCategorias;
	}
	
	public void cadastrarLivro(){
		System.out.println("Insira o título do livro:");
		String titulo = scanner.nextLine();
		System.out.println("Insira o local do livro: ");
		String local = scanner.nextLine();
		System.out.println("Insira a quantidade de páginas do livro: ");
		String quantidadeDePaginas = scanner.nextLine();
		System.out.println("Insira a data de aquisição do livro(dd/mm/aaaa): ");
		String dataDeAquisicao = scanner.nextLine();
		System.out.println("Insira a categoria do livro: ");
		String categoria = scanner.nextLine();
		// pesquisa por descricao de categoria
		
		/*
		 * System.out.println("Verificando categoria no sistema: \n"
		 * );
		 * System.out.println("Categoria encontrada no sistema: \n"
		 * );
		 */
		// printa na tela categoria encontrado
		System.out.println("Insira o resumo do livro: ");
		String resumo = scanner.nextLine();
		System.out.println("Insira o nome do autor do livro: ");
		String autor = scanner.nextLine();
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
	
	
}
