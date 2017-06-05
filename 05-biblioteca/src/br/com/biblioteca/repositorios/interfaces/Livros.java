package br.com.biblioteca.repositorios.interfaces;

/**
 * 
 *@author aline.correa
 *
 */
import java.util.List;
import java.util.Set;

import br.com.biblioteca.objetos.Livro;

public interface Livros extends AcoesNoRepositorio<Livro> {
	
	Set<Livro> buscarPorTitulo(String titulo);

	Livro buscarPorCodigoSequencial(String codigoSequencial);

	Livro buscarPorCodigoDeBarras(String codigoDeBarras);
	
	List<Livro> buscarPorCategoria(String descricaoCategoria);

	Set<Livro> buscarPorAutor(String nomeAutor);	

}
