package biblioteca;

/**
 * 
 *@author aline.correa
 *
 */
import java.util.List;
import java.util.Set;

public interface Livros extends AcoesEmMemoria<Livro> {
	
	Set<Livro> buscarPorTitulo(String titulo);

	Livro buscarPorCodigoSequencial(String codigoSequencial);

	Livro buscarPorCodigoDeBarras(String codigoDeBarras);
	
	List<Livro> buscarPorCategoria(String descricaoCategoria);

	List<Livro> buscarPorAutor(String nomeAutor);

}
