package biblioteca;

/**
 * 
 * @author aline.correa
 * 
 */
import java.util.Comparator;

public class OrdenarLivroPorTitulo implements Comparator<Livro> {

	@Override
	public int compare(Livro livro1, Livro livro2) {
		if (livro1.getTitulo() != null) {
			int comparacaoTitulo = livro1.getTitulo().compareTo(livro2.getTitulo());

			if (comparacaoTitulo != 0) {
				return comparacaoTitulo;
			}
		}

		if (livro1.getCodigoSequencial() != null) {
			int comparacaoCodigoSequencial = livro1.getCodigoSequencial().compareTo(livro2.getCodigoSequencial());

			if (comparacaoCodigoSequencial != 0) {
				return comparacaoCodigoSequencial;
			}
		}

		return 0;

	}

}
