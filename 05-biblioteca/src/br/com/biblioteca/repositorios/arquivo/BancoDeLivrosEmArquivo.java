package br.com.biblioteca.repositorios.arquivo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import br.com.biblioteca.objetos.Autor;
import br.com.biblioteca.objetos.Livro;
import br.com.biblioteca.repositorios.interfaces.Livros;

public class BancoDeLivrosEmArquivo implements Livros{ 
	
	private static Set<Livro> banco = new TreeSet<>();
	
	@Override
	public void adicionar(Livro livro) {
		try {
			banco.add(livro);
			salvar();
		} catch (NullPointerException e) {
			e.getMessage();
		}
	}
	
	private void salvar(){
		try {
			FileOutputStream arquivo = new FileOutputStream("livros.txt",false);
			ObjectOutputStream os = new ObjectOutputStream(arquivo);
			os.writeObject(banco); 
            os.close( );
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void excluir(Livro livro) {
		banco.remove(livro);
		salvar();
	}

	@Override
	public void editar(Livro livro) {
		excluir(livro);
	}

	@Override
	public Set<Livro> listar() {
		try{
			 FileInputStream arquivo = new FileInputStream("livros.txt");
			 ObjectInputStream objetos = new ObjectInputStream(arquivo);
			 @SuppressWarnings("unchecked")
			 Set<Livro> lista = (Set<Livro>) objetos.readObject();
			 objetos.close();
			 arquivo.close();
			 return lista;
		 }catch(Exception e){
			 e.printStackTrace();
		 }
		return null;
	}

	@Override
	public Set<Livro> buscarPorTitulo(String titulo) {
		Set<Livro> bancoEmArquivo = listar();
		Set<Livro> livrosEncontrados = new TreeSet<>();
		titulo = titulo.toUpperCase();
		String[] tituloArray = titulo.split(" ");
		for (int contador = 0; contador < tituloArray.length; contador++) {
			for (Livro livro : bancoEmArquivo) {
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
		Set<Livro> bancoEmArquivo = listar();
		for (Livro livro : bancoEmArquivo) {
			String codigoLivro = livro.getCodigoSequencial();
			if (codigoLivro.equals(codigoSequencial)) {
				return livro;
			}
		}
		return null;
	}

	@Override
	public Livro buscarPorCodigoDeBarras(String codigoDeBarras) {
		Set<Livro> bancoEmArquivo = listar();
		for (Livro livro : bancoEmArquivo) {
			String codigoLivro = livro.getCodigoDeBarras();
			if (codigoLivro.equals(codigoDeBarras)) {
				return livro;
			}
		}
		return null;
	}

	@Override
	public List<Livro> buscarPorCategoria(String descricaoCategoria) {
		Set<Livro> bancoEmArquivo = listar();
		descricaoCategoria = descricaoCategoria.toUpperCase();
		List<Livro> livrosEncontrados = new ArrayList<>();
		for (Livro livro : bancoEmArquivo) {
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
		Set<Livro> bancoEmArquivo = listar();
		nomeAutor = nomeAutor.toUpperCase();
		Set<Livro> livrosEncontrados = new TreeSet<>();
		for (Livro livro : bancoEmArquivo) {
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
