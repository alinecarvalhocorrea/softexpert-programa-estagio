package br.com.biblioteca.repositorios.memoria;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author aline.correa
 *
 */
import java.util.Set;
import java.util.TreeSet;

import br.com.biblioteca.objetos.Autor;
import br.com.biblioteca.objetos.Livro;
import br.com.biblioteca.repositorios.interfaces.Livros;

public class BancoDeLivros implements Livros {

	private static Set<Livro> banco = new TreeSet<>();

	public void adicionar(Livro livro) {
		try {
			banco.add(livro);
		} catch (NullPointerException e) {
			e.getMessage();
		}
	}

	public void excluir(Livro livro) {
		banco.remove(livro);
	}

	public void editar(Livro livroParaEditar) {
		excluir(livroParaEditar);
	}

	public Set<Livro> listar() {
		return banco;
	}

	@Override
	public Set<Livro> buscarPorTitulo(String titulo) {
		Set<Livro> livrosEncontrados = new TreeSet<>();
		titulo = titulo.toUpperCase();
		String[] tituloArray = titulo.split(" ");

		for (int contador = 0; contador < tituloArray.length; contador++) {
			for (Livro livro : banco) {
				String livroTitulo = livro.getTitulo();
				String tituloArraySistema[] = livroTitulo.split(" ");
				int i = 0;
				while (i < tituloArraySistema.length) {
					if (tituloArraySistema[i].contains(tituloArray[contador])) {
						livrosEncontrados.add(livro);
					}
					i++;
				}
			}
		}
		if (!livrosEncontrados.isEmpty()) {
			return livrosEncontrados;
		}
		return null;
	}

	@Override
	public Livro buscarPorCodigoSequencial(String codigoSequencial) {
		for (Livro livro : banco) {
			String codigoLivro = livro.getCodigoSequencial();
			if (codigoLivro.equals(codigoSequencial)) {
				return livro;
			}
		}
		return null;
	}

	@Override
	public Livro buscarPorCodigoDeBarras(String codigoDeBarras) {
		for (Livro livro : banco) {
			String codigoLivro = livro.getCodigoDeBarras();
			if (codigoLivro.equals(codigoDeBarras)) {
				return livro;
			}
		}
		return null;
	}

	@Override
	public List<Livro> buscarPorCategoria(String descricaoCategoria) {
		descricaoCategoria = descricaoCategoria.toUpperCase();
		List<Livro> livrosEncontrados = new ArrayList<>();
		for (Livro livro : banco) {
			String descricaoLivro = livro.getCategoria();
			descricaoLivro = descricaoLivro.toUpperCase();
			if (descricaoLivro.equals(descricaoCategoria)) {
				livrosEncontrados.add(livro);
			}
		}
		return livrosEncontrados;
	}

	@Override
	public Set<Livro> buscarPorAutor(String nomeAutor) {
		nomeAutor = nomeAutor.toUpperCase();
		Set<Livro> livrosEncontrados = new TreeSet<>();
		for (Livro livro : banco) {
			Set<Autor> autorLivro = livro.getAutor();
			for (Autor autor : autorLivro) {
				String nomeAutorLivro = autor.getNome().toUpperCase();
				if (nomeAutorLivro.contains(nomeAutor)) {
					livrosEncontrados.add(livro);
				}
			}
			
		}
		return livrosEncontrados;

	}

}
