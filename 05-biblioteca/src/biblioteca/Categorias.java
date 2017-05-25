package biblioteca;

/**
 * 
 * @author aline.correa
 *
 */
import java.util.List;

public interface Categorias extends AcoesEmMemoria<Categoria> {

	List<Categoria> buscarPorDescricao(String descricao); //Map(descricao,Livro livro); get(descricao);

	List<Categoria> buscarPorCodigoSequencial(String codigoSequencial);
}
