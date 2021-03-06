package br.com.biblioteca.console.lista;

import java.util.Set;

import br.com.biblioteca.objetos.Autor;
import br.com.biblioteca.repositorios.interfaces.Autores;

/**
 * 
 * @author aline.correa
 *
 *         Script de integra��o de listagem: Intera��o com o usu�rio e listagem
 *         de Autores no banco
 *
 */

public class ListaDeAutores {
	private static Autores bancoDeAutores;

	public ListaDeAutores(Autores bancoDeAutores) {
		ListaDeAutores.bancoDeAutores = bancoDeAutores;
	}

	public void listarAutores() {
		Set<Autor> listaDeAutores = bancoDeAutores.listar();
		for (Autor autor : listaDeAutores) {
			System.out.println("Nome: " + autor.getNome() + " | Nacionalidade: " + autor.getNacionalidade()
					+ " | Data De Nascimento: " + autor.getDataDeNascimento() + " | C�digo Sequencial: "
					+ autor.getCodigoSequencial());
		}

	}
}
