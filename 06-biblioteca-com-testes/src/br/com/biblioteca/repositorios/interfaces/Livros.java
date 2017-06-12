package br.com.biblioteca.repositorios.interfaces;

import java.util.Set;

import br.com.biblioteca.objetos.Livro;

public interface Livros extends AcoesNoRepositorio<Livro> {
	
	Set<Livro> buscarPorTitulo(String titulo);

	Livro buscarPorCodigoSequencial(String codigoSequencial);

	Livro buscarPorCodigoDeBarras(String codigoDeBarras);
	
	Set<Livro> buscarPorCategoria(String descricaoCategoria);

	Set<Livro> buscarPorAutor(String nomeAutor);	

}
