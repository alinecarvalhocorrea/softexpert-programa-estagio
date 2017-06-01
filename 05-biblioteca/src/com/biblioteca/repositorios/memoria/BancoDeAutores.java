package com.biblioteca.repositorios.memoria;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import com.biblioteca.objetos.Autor;
import com.biblioteca.repositorios.interfaces.Autores;

public class BancoDeAutores implements Autores {

	private static Set<Autor> banco = new TreeSet<>();

	@Override
	public void adicionar(Autor autor) {
		if (autor.getNome() == null) {
			throw new NullPointerException("O autor(a) est� sem nome, favor colocar");
		}
		banco.add(autor);
	}

	@Override
	public void excluir(Autor autor) {
		banco.remove(autor);

	}

	@Override
	public void editar(Autor autorParaEditar) {
		excluir(autorParaEditar);
	}

	@Override
	public Set<Autor> listar() {
		return banco;
	}

	@Override
	public Set<Autor> buscarPorNome(String nome) {
		Set<Autor> autoresEncontrados = new HashSet<>();
		for (Autor autor : banco) {
			String nomeAutor = autor.getNome();
			nomeAutor = nomeAutor.toUpperCase();
			nome = nome.toUpperCase();
			if (nomeAutor.contains(nome)) {
				autoresEncontrados.add(autor);
			}
		}
		return autoresEncontrados;
	}

	@Override
	public Set<Autor> buscarPorNacionalidade(String nacionalidade) {
		Set<Autor> autoresEncontrados = new HashSet<>();

		for (Autor autor : banco) {
			String nacionalidadeAutor = autor.getNacionalidade().toUpperCase();
			nacionalidade = nacionalidade.toUpperCase();
			if (nacionalidadeAutor.equalsIgnoreCase(nacionalidade)) {
				autoresEncontrados.add(autor);
			}
		}
		return autoresEncontrados;
	}

	@Override
	public Set<Autor> buscarPorDataDeNascimento(String dataDeNascimento) {
		Set<Autor> autoresEncontrados = new TreeSet<>();
		for (Autor autor : banco) {
			String dataAutor = autor.getDataDeNascimento();
			if(dataAutor.equals(dataDeNascimento)){
				autoresEncontrados.add(autor);
			}
		}
		return autoresEncontrados;
		
	}

	@Override
	public Autor buscarPorCodigoSequencial(String codigoSequencial) {
		for (Autor autor : banco) {
			String codigoAutor = autor.getCodigoSequencial();
			if (codigoAutor.equals(codigoSequencial)) {
				return autor;
			}
		}
		return null;
	}

}