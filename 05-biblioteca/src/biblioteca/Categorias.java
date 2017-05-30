package biblioteca;

import java.util.Set;

/**
 * 
 * @author aline.correa
 *
 */
public interface Categorias extends AcoesEmMemoria<Categoria> {

	Set<Categoria> buscarCategoriaPorDescricao(String descricao);

	Categoria buscarPorCodigoSequencial(String codigoSequencial);
}
