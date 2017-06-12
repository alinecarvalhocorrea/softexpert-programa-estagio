package br.com.biblioteca.repositorios.interfaces;

import java.util.Set;

import br.com.biblioteca.objetos.Categoria;

/**
 * 
 * @author aline.correa
 *
 */

public interface Categorias extends AcoesNoRepositorio<Categoria> {

	Set<Categoria> buscarCategoriaPorDescricao(String descricao);

	Categoria buscarPorCodigoSequencial(String codigoSequencial);
}
