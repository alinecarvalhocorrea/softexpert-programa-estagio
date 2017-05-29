package biblioteca;

/**
 * 
 * @author aline.correa
 *
 */
public interface Categorias extends AcoesEmMemoria<Categoria> {

	Categoria buscarCategoriaPorDescricao(String descricao); // Map(descricao,Livro livro); get(descricao);

	Categoria buscarPorCodigoSequencial(String codigoSequencial);
}
