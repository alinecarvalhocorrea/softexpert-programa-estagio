package br.com.biblioteca.console.edita;

import java.util.Scanner;

import br.com.biblioteca.console.cadastro.CadastroDeLivro;
import br.com.biblioteca.console.confirmacao.Confirmacao;
import br.com.biblioteca.console.pesquisa.livro.PesquisaLivroPorCodigoSequencial;
import br.com.biblioteca.objetos.Livro;
import br.com.biblioteca.repositorios.interfaces.Autores;
import br.com.biblioteca.repositorios.interfaces.Categorias;
import br.com.biblioteca.repositorios.interfaces.Livros;

public class EditaLivro {
	private Scanner scanner;
	private static Livros bancoDeLivros;
	private static Autores bancoDeAutores;
	private static Categorias bancoDeCategorias;
	
	public EditaLivro(Scanner scanner, Livros bancoDeLivros, Autores bancoDeAutores, Categorias bancoDeCategorias){
		this.scanner = scanner;
		EditaLivro.bancoDeLivros = bancoDeLivros;
		EditaLivro.bancoDeAutores  = bancoDeAutores;
		EditaLivro.bancoDeCategorias = bancoDeCategorias;
	}
	
	public void editarLivro(){
		scanner.nextLine();
		System.out.println("Insira o código sequencial do livro:");
		String codigo = scanner.nextLine();
		boolean pesquisa = new PesquisaLivroPorCodigoSequencial(scanner, bancoDeLivros).verificaExistenciaDeLivroPorCodigoSequencial(codigo);
		System.out.println("Pesquisando livro no banco...");
		if(pesquisa){
			Livro livroEncontrado = bancoDeLivros.buscarPorCodigoSequencial(codigo);
			System.out.println(livroEncontrado);
			boolean confirmaEdicao = new Confirmacao(scanner, livroEncontrado).confirmaEdicao();
			if(confirmaEdicao){
				bancoDeLivros.excluir(livroEncontrado);
				CadastroDeLivro cadastraLivro = new CadastroDeLivro(scanner, bancoDeLivros, bancoDeAutores, bancoDeCategorias);
				cadastraLivro.cadastrarLivro();
			}else{
				return;
			}
		}
	}
}
