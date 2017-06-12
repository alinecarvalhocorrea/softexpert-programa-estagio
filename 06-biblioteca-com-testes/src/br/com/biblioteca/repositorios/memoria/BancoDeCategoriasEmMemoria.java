package br.com.biblioteca.repositorios.memoria;

/**
 * 
 * @author aline.correa
 * 
 */
import java.util.HashSet;
import java.util.Set;

import br.com.biblioteca.objetos.Categoria;
import br.com.biblioteca.repositorios.interfaces.Categorias;

public class BancoDeCategoriasEmMemoria implements Categorias {

	private static Set<Categoria> banco = new HashSet<>();

	@Override
	public void adicionar(Categoria categoria) {
		banco.add(categoria);
	}
	
	@Override
	public void excluir(Categoria categoria) {
		banco.remove(categoria);
	}

	@Override
	public void editar(Categoria categoriaParaEditar) {
		excluir(categoriaParaEditar);
	}

	@Override
	public Set<Categoria> listar() {
		return banco;
	}

	@Override
	public Set<Categoria> buscarCategoriaPorDescricao(String descricao) throws NullPointerException{
		Set<Categoria> categoriasEncontradas = new HashSet<>();
		descricao = descricao.toUpperCase();
		for (Categoria categoria : banco) {
			String descricaoCategoria = categoria.getDescricao();
			if (descricaoCategoria.contains(descricao)) {
				categoriasEncontradas.add(categoria);
			}
		}
		if(categoriasEncontradas.isEmpty()){
			throw new NullPointerException("Nenhuma categoria com a descrição informada foi encontrada");
		}
		return categoriasEncontradas;
	}

	@Override
	public Categoria buscarPorCodigoSequencial(String codigoSequencial) {
		for (Categoria categoria : banco) {
			String codigoCategoria = categoria.getCodigoSequencial();
			if (codigoCategoria.equals(codigoSequencial)) {
				return categoria;
			}
		}
		return null;
	}

}
