package br.com.biblioteca.console.lista;

import java.util.Set;
import java.util.TreeSet;

import br.com.biblioteca.objetos.Autor;
import br.com.biblioteca.objetos.Livro;
import br.com.biblioteca.repositorios.memoria.BancoDeLivros;

public class ListaDeLivros {
private static BancoDeLivros bancoDeLivros;
	
	public  ListaDeLivros(BancoDeLivros bancoDeLivros){
		ListaDeLivros.bancoDeLivros = bancoDeLivros;
	}
	
	public void listarLivros(){
		Set<Livro> listaDeLivros = bancoDeLivros.listar();
		Set<Autor> listaDeAutores = new TreeSet<>();
		for (Livro livro : listaDeLivros) {
			listaDeAutores = livro.getAutor();
			Set<String> nomesDeAutores = new TreeSet<>();
			for(Autor autor : listaDeAutores){
				nomesDeAutores.add(autor.getNome());
			}
			
			System.out.println("Livro: " + livro.getTitulo() + ", (" + livro.getQuantidadeDePaginas() + " Páginas) | Categoria: " + livro.getCategoria() +" | Autor(es/a/as): " + nomesDeAutores  + " | Código Sequencial: "+ livro.getCodigoSequencial() +" | Código De Barras: " + livro.getCodigoDeBarras() + " | Data de Aquisição: " + livro.getDataDeAquisicao() + " | Resumo: "+ livro.getResumo() +".");
		}
		
	}
}
