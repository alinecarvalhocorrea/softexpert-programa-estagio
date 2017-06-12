package br.com.biblioteca.repositorios.arquivo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import br.com.biblioteca.objetos.Categoria;
import br.com.biblioteca.repositorios.interfaces.Categorias;

/**
 * 
 * @author aline.correa
 *
 */

public class BancoDeCategoriasEmArquivo implements Categorias {

	private static Set<Categoria> banco = new TreeSet<>();

	@Override
	public void adicionar(Categoria categoria) {
		if (categoria.getDescricao() == null) {
			throw new NullPointerException("A categoria está sem descrição, favor colocar");
		}
		banco.add(categoria);
		salvar();
	}

	private void salvar() {
		try {
			FileOutputStream arquivo = new FileOutputStream("categorias.txt", false);
			ObjectOutputStream os = new ObjectOutputStream(arquivo);
			os.writeObject(banco);
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void excluir(Categoria categoria) {
		banco.remove(categoria);
		salvar();
	}

	@Override
	public void editar(Categoria categoria) {
		excluir(categoria);
	}

	@Override
	public Set<Categoria> listar() {
		try {
			FileInputStream arquivo = new FileInputStream("categorias.txt");
			ObjectInputStream objetos = new ObjectInputStream(arquivo);
			@SuppressWarnings("unchecked")
			Set<Categoria> lista = (Set<Categoria>) objetos.readObject();
			objetos.close();
			arquivo.close();
			return lista;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Set<Categoria> buscarCategoriaPorDescricao(String descricao) {
		Set<Categoria> bancoEmArquivo = listar();
		Set<Categoria> categoriasEncontradas = new HashSet<>();
		descricao = descricao.toUpperCase();
		for (Categoria categoria : bancoEmArquivo) {
			String descricaoCategoria = categoria.getDescricao();
			if (descricaoCategoria.contains(descricao)) {
				categoriasEncontradas.add(categoria);
			}
		}
		return categoriasEncontradas;
	}

	@Override
	public Categoria buscarPorCodigoSequencial(String codigoSequencial) {
		Set<Categoria> bancoEmArquivo = listar();
		for (Categoria categoria : bancoEmArquivo) {
			String codigoCategoria = categoria.getCodigoSequencial();
			if (codigoCategoria.equals(codigoSequencial)) {
				return categoria;
			}
		}
		return null;
	}

}
