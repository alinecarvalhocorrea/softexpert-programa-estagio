package br.com.biblioteca.repositorios.memoria;

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

public class BancoDeLivrosEmMemoria implements Livros {

	private static Set<Livro> banco = new TreeSet<>();

	public void adicionar(Livro livro) {
		banco.add(livro);
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
	public Set<Livro> buscarPorTitulo(String titulo) throws NullPointerException {
		Set<Livro> livrosEncontrados = new TreeSet<>();
		for (Livro livro : banco) {
			titulo = titulo.toUpperCase();
			String tituloLivroNoSistema = livro.getTitulo();
			tituloLivroNoSistema = tituloLivroNoSistema.toUpperCase();
				if(tituloLivroNoSistema.contains(titulo)){
					livrosEncontrados.add(livro);
				}
		}
		if(livrosEncontrados.isEmpty()){
			throw new NullPointerException("Nenhum livro encontrado com o título informado");
		}
		return livrosEncontrados;
	}

	@Override
	public Livro buscarPorCodigoSequencial(String codigoSequencial) throws NullPointerException {
		for (Livro livro : banco) {
			String codigoLivro = livro.getCodigoSequencial();
			if (codigoLivro.equals(codigoSequencial)) {
				return livro;
			}
		}
		throw new NullPointerException("Nenhum livro encontrado com o código sequencial informado");
	}

	@Override
	public Livro buscarPorCodigoDeBarras(String codigoDeBarras) {
		for (Livro livro : banco) {
			String codigoLivro = livro.getCodigoDeBarras();
			if (codigoLivro.equals(codigoDeBarras)) {
				return livro;
			}
		}
		throw new NullPointerException("Nenhum livro encontrado com o código de barras informado");
	}

	@Override
	public Set<Livro> buscarPorCategoria(String descricaoCategoria) {
		descricaoCategoria = descricaoCategoria.toUpperCase();
		Set<Livro> livrosEncontrados = new TreeSet<>();
		for (Livro livro : banco) {
			String descricaoLivro = livro.getCategoria().getDescricao();
			descricaoLivro = descricaoLivro.toUpperCase();
			if (descricaoLivro.equals(descricaoCategoria)) {
				livrosEncontrados.add(livro);
			}
		}
		if(livrosEncontrados.isEmpty()){
			throw new NullPointerException("Nenhum livro encontrado com a categoria informada");
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
		if(livrosEncontrados.isEmpty()){
			throw new NullPointerException("Nenhum livro encontrado com o(a) autor(a) informado(a)");
		}
		return livrosEncontrados;
	}

}
