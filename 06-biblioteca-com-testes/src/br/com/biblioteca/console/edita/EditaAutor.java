package br.com.biblioteca.console.edita;

import java.util.Scanner;

import br.com.biblioteca.console.cadastro.CadastroDeAutor;
import br.com.biblioteca.console.confirmacao.Confirmacao;
import br.com.biblioteca.console.pesquisa.autor.PesquisaAutorPorCodigoSequencial;
import br.com.biblioteca.objetos.Autor;
import br.com.biblioteca.repositorios.interfaces.Autores;

/**
 * 
 * @author aline.correa
 *
 *         Script de integração de edição: Interação com o usuário e edição de
 *         Autor
 *
 */

public class EditaAutor {
	private Scanner scanner;
	private static Autores bancoDeAutores;

	public EditaAutor(Scanner scanner, Autores bancoDeAutores) {
		this.scanner = scanner;
		EditaAutor.bancoDeAutores = bancoDeAutores;
	}

	public void editarAutor() {
		System.out.println("Insira o código sequencial do(a) autor(a): ");
		scanner.nextLine();
		String codigoSequencial = scanner.nextLine();
		PesquisaAutorPorCodigoSequencial verifica = new PesquisaAutorPorCodigoSequencial(scanner, bancoDeAutores);
		System.out.println("Pesquisando por autor(a) no banco...");
		boolean verificacao = verifica.verificaExistenciaDeAutorPorCodigoSequencial(codigoSequencial);

		if (verificacao) {
			Autor autor = bancoDeAutores.buscarPorCodigoSequencial(codigoSequencial);
			Confirmacao confirmacao = new Confirmacao(scanner, autor);
			boolean decisaoUsuario = confirmacao.confirmaEdicao();
			if (decisaoUsuario) {
				bancoDeAutores.excluir(autor);
				CadastroDeAutor cadastraAutor = new CadastroDeAutor(scanner, bancoDeAutores);
				cadastraAutor.cadastrarAutor();
			}

		} else {

			return;
		}
	}
}
