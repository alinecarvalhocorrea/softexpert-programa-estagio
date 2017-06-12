package br.com.biblioteca.console.remove;

import java.util.Scanner;

import br.com.biblioteca.console.confirmacao.Confirmacao;
import br.com.biblioteca.console.pesquisa.livro.PesquisaLivroPorCodigoSequencial;
import br.com.biblioteca.objetos.Livro;
import br.com.biblioteca.repositorios.interfaces.Livros;

/**
 * 
 * @author aline.correa
 *
 *         Script de integra��o de remo��o: Intera��o com o usu�rio e remo��o de
 *         Livro
 *
 */

public class RemoveLivro {
	private static Livros bancoDeLivros;
	private Scanner scanner;

	public RemoveLivro(Scanner scanner, Livros bancoDeLivros) {
		this.scanner = scanner;
		RemoveLivro.bancoDeLivros = bancoDeLivros;
	}

	public void removerLivro() {
		System.out.println("Insira o c�digo sequencial da categoria: ");
		scanner.nextLine();
		String codigoSequencial = scanner.nextLine();
		System.out.println("Buscando categoria...");
		boolean verifica = new PesquisaLivroPorCodigoSequencial(scanner, bancoDeLivros)
				.verificaExistenciaDeLivroPorCodigoSequencial(codigoSequencial);
		if (verifica) {
			Livro livro = bancoDeLivros.buscarPorCodigoSequencial(codigoSequencial);
			System.out.println("Livro Encontrado:");
			System.out.println(livro);
			boolean decisao = new Confirmacao(scanner, livro).confirmaRemocao();
			if (decisao) {
				bancoDeLivros.excluir(livro);
				System.out.println("Livro " + livro.getTitulo() + " removido.");
			} else {
				return;
			}
		} else {
			System.out.println(
					"Livro n�o encontrado. Por favor, verifique o c�digo sequencial informado e tente novamente.");
			return;
		}
	}
}
