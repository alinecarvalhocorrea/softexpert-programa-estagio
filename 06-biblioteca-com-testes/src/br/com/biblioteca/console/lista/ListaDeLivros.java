package br.com.biblioteca.console.lista;

import java.util.Set;
import java.util.TreeSet;

import br.com.biblioteca.objetos.Autor;
import br.com.biblioteca.objetos.Livro;
import br.com.biblioteca.repositorios.interfaces.Livros;

/**
 * 
 * @author aline.correa
 *
 *         Script de integra��o de listagem: Intera��o com o usu�rio e listagem
 *         de Livros no banco
 *
 */

public class ListaDeLivros {
	private static Livros bancoDeLivros;

	public ListaDeLivros(Livros bancoDeLivros) {
		ListaDeLivros.bancoDeLivros = bancoDeLivros;
	}

	public void listarLivros() {
		Set<Livro> listaDeLivros = bancoDeLivros.listar();
		Set<Autor> listaDeAutores = new TreeSet<>();
		for (Livro livro : listaDeLivros) {
			listaDeAutores = livro.getAutor();
			Set<String> nomesDeAutores = new TreeSet<>();
			for (Autor autor : listaDeAutores) {
				nomesDeAutores.add(autor.getNome());
			}

			System.out.println("Livro: " + livro.getTitulo() + ", (" + livro.getQuantidadeDePaginas()
					+ " P�ginas) | Categoria: " + livro.getCategoria() + " | Autor(es/a/as): " + nomesDeAutores
					+ " | C�digo Sequencial: " + livro.getCodigoSequencial() + " | C�digo De Barras: "
					+ livro.getCodigoDeBarras() + " | Data de Aquisi��o: " + livro.getDataDeAquisicao() + " | Resumo: "
					+ livro.getResumo() + ".");
		}

	}
}
