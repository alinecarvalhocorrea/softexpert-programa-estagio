package biblioteca;

/**
 * 
 *@author aline.correa
 *
 */
import java.util.List;

public interface Livros extends AcoesEmMemoria<Livro> {
	
	List<Livro> buscarPorTitulo(String titulo);

	Livro buscarPorCodigoSequencial(long codigoSequencial);

	Livro buscarPorCodigoDeBarras(long codigoDeBarras);

}
