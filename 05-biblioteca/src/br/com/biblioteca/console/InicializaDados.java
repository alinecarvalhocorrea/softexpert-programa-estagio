package br.com.biblioteca.console;

import java.util.Set;
import java.util.TreeSet;

import br.com.biblioteca.objetos.Autor;
import br.com.biblioteca.objetos.Categoria;
import br.com.biblioteca.objetos.Livro;
import br.com.biblioteca.repositorios.memoria.BancoDeAutores;
import br.com.biblioteca.repositorios.memoria.BancoDeCategorias;
import br.com.biblioteca.repositorios.memoria.BancoDeLivros;

public class InicializaDados {
	public InicializaDados(BancoDeAutores bancoDeAutores, BancoDeCategorias bancoDeCategorias,
			BancoDeLivros bancoDeLivros) {
		Autor a1 = new Autor("Aline");
		a1.setDataDeNascimento("08/11/1997");
		a1.setNacionalidade("brasileira");
		bancoDeAutores.adicionar(a1);
		Autor a2 = new Autor("Teste nome autor");
		a2.setDataDeNascimento("10/09/2011");
		a2.setNacionalidade("brasileira");
		bancoDeAutores.adicionar(a2);
		Autor a3 = new Autor("joaquim teste biblioteca de autores");
		a3.setDataDeNascimento("01/10/2004");
		a3.setNacionalidade("francês");
		bancoDeAutores.adicionar(a3);
		Autor a4 = new Autor("biblioteca de autores joaquim teste  aline soft");
		a4.setDataDeNascimento("05/12/2001");
		a4.setNacionalidade("britânico");
		bancoDeAutores.adicionar(a4);

		Categoria c1 = new Categoria("Romance");
		bancoDeCategorias.adicionar(c1);
		Categoria c2 = new Categoria("Conto");
		bancoDeCategorias.adicionar(c2);
		Categoria c3 = new Categoria("Poesia");
		bancoDeCategorias.adicionar(c3);
		Categoria c4 = new Categoria("ficçao");
		bancoDeCategorias.adicionar(c4);

		Livro livro1 = new Livro();
		livro1.setTitulo("TEste livro tal aline soft");
		Set<Autor> autores = new TreeSet<>();
		autores.add(a3);
		autores.add(a1);
		livro1.setAutor(autores);
		livro1.setCategoria(c4);
		livro1.setDataDeAquisicao("08/12/2009");
		bancoDeLivros.adicionar(livro1);
	}
}
