package biblioteca;

import java.util.Comparator;

public class OrdenarLivroPorResumo implements Comparator<Livro>{

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
		/*int comparacao = livro1.getTitulo().compareTo(livro2.getTitulo());
		if (comparacao < 0) {
			return -1;
		}
		if (comparacao > 0) {
			return 1;
		}
		
		int comparacaoResumo = livro1.getResumo().compareTo(livro2.getResumo());
		if (comparacaoResumo < 0) {
			return -1;
		}
		if (comparacaoResumo > 0) {
			return 1;
		}
		return 0;*/
		
	}
	
}
