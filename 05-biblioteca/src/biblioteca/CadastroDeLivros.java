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
		System.out.println("Insira o t�tulo do livro:");
		String titulo = scanner.nextLine();
		System.out.println("Insira o local do livro: ");
		String local = scanner.nextLine();
		System.out.println("Insira a quantidade de p�ginas do livro: ");
		String quantidadeDePaginas = scanner.nextLine();
		System.out.println("Insira a data de aquisi��o do livro(dd/mm/aaaa): ");
		String dataDeAquisicao = scanner.nextLine();
		ListaDeCategorias listaDeCategorias = new ListaDeCategorias(bancoDeCategorias);
		listaDeCategorias.listarCategorias();
		System.out.println("Insira o c�digo sequencial da categoria do livro: ");
		String categoria = scanner.nextLine();
		// Pesquisar por c�digo sequencial e adicionar categoria
		System.out.println("Insira o resumo do livro: ");
		String resumo = scanner.nextLine();
		System.out.println("Insira o n�mero de autores(as) do livro: ");
		String numeroDeAutores = scanner.nextLine();
		ListaDeAutores listaDeAutores = new ListaDeAutores(bancoDeAutores);
		listaDeAutores.listarAutores();
		// if quantidade de autores for 1 
		System.out.println("Insira o c�digo sequencial do autor do livro: ");
		String autor = scanner.nextLine();
		// Pesquisar por c�digo sequencial e adicionar autor(a)
		// se a quantidade de autores for maior que 1, repete loop de inser��o de autores referente ao n�mero inserido pelo usuario
		
	}
	
	
}
