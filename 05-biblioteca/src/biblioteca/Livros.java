package biblioteca;

/**
 * 
 *@author aline.correa
 *
 */
import java.util.List;

public interface Livros extends AcoesEmMemoria<Livro> {
	
	List<Livro> buscarPorTitulo(String titulo);

	Livro buscarPorCodigoSequencial(String codigoSequencial);

	Livro buscarPorCodigoDeBarras(String codigoDeBarras);
	
	List<Livro> buscarPorCategoria(String descricaoCategoria);

}
