package br.com.biblioteca.repositorios.arquivo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import br.com.biblioteca.objetos.Autor;
import br.com.biblioteca.repositorios.interfaces.Autores;

public class BancoDeAutoresEmArquivo implements Autores {

	private static Set<Autor> banco = new TreeSet<>();

	@Override
	public void adicionar(Autor autor) {
		if (autor.getNome() == null) {
			throw new NullPointerException("O autor(a) está sem nome, favor colocar");
		}
		banco.add(autor);
		salvar();
	}

	private void salvar() {
		try {
			FileOutputStream arquivo = new FileOutputStream("autores.txt", false);
			ObjectOutputStream os = new ObjectOutputStream(arquivo);
			os.writeObject(banco);
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void excluir(Autor autor) {
		banco.remove(autor);
		salvar();
	}

	@Override
	public void editar(Autor autor) {
		excluir(autor);
	}

	@Override
	public Set<Autor> listar() {
		try {
			FileInputStream arquivo = new FileInputStream("autores.txt");
			ObjectInputStream objetos = new ObjectInputStream(arquivo);
			@SuppressWarnings("unchecked")
			Set<Autor> lista = (Set<Autor>) objetos.readObject();
			objetos.close();
			arquivo.close();
			return lista;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Set<Autor> buscarPorNome(String nome) {
		Set<Autor> bancoEmArquivo = listar();
		Set<Autor> autoresEncontrados = new HashSet<>();
		for (Autor autor : bancoEmArquivo) {
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
		Set<Autor> bancoEmArquivo = listar();
		Set<Autor> autoresEncontrados = new HashSet<>();
		for (Autor autor : bancoEmArquivo) {
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
		Set<Autor> bancoEmArquivo = listar();
		Set<Autor> autoresEncontrados = new TreeSet<>();
		for (Autor autor : bancoEmArquivo) {
			String dataAutor = autor.getDataDeNascimento();
			if(dataAutor.equals(dataDeNascimento)){
				autoresEncontrados.add(autor);
			}
		}
		return autoresEncontrados;
	}

	@Override
	public Autor buscarPorCodigoSequencial(String codigoSequencial) {
		Set<Autor> bancoEmArquivo = listar();
		for (Autor autor : bancoEmArquivo) {
			String codigoAutor = autor.getCodigoSequencial();
			if (codigoAutor.equals(codigoSequencial)) {
				return autor;
			}
		}
		return null;
	}

}
