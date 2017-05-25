package biblioteca;

import java.util.Comparator;

public class OrdenarLivroPorResumo implements Comparator<Livro>{

	@Override
	public int compare(Livro livro1, Livro livro2) {
		int comparacao = livro1.getTitulo().compareTo(livro2.getTitulo());
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
		return 0;
		
	}
	
}
