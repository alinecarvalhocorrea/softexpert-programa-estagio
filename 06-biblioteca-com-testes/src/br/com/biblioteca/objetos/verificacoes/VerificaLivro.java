package br.com.biblioteca.objetos.verificacoes;

import br.com.biblioteca.objetos.Livro;

public class VerificaLivro {
	public void verificacaoDeDadosLivro(Livro livro) {
		if (livro.getTitulo() == null) {
			throw new NullPointerException("O livro está sem titulo, favor informar");
		}
		if (livro.getAutor() == null) {
			throw new NullPointerException("O livro está sem autor, favor informar");
		}
		if (livro.getLocal() == null) {
			throw new NullPointerException("O livro está sem local, favor informar");
		}
		if (livro.getCategoria() == null) {
			throw new NullPointerException("O livro está sem categoria, favor informar");
		}
	}
}
