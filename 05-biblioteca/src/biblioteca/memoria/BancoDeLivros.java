package biblioteca.memoria;

/**
 * 
 * @author aline.correa
 *
 */
import java.util.Set;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.List;
import biblioteca.Livro;
import biblioteca.Livros;

public class BancoDeLivros implements Livros {

	private static Set<Livro> banco = new TreeSet<>();

	public void adicionar(Livro livro) {
		// TODO BancoLivros: tem que colocar mais validações para adição de livros
		if (livro.getTitulo() == null) {
			throw new NullPointerException("O livro está sem titulo, favor colocar");
		}
		banco.add(livro);
	}

	public void excluir(Livro livro) {
		banco.remove(livro);
	}

	public void editar(Livro livroParaEditar) {
		excluir(livroParaEditar);
		adicionar(livroParaEditar);
	}

	public Set<Livro> listar() {
		return banco;
	}

	@Override
	public List<Livro> buscarPorTitulo(String titulo) {
		// TODO BancoLivros: alterar estrutura de pesquisa por titulo de livro
		List<Livro> livrosEncontrados = new ArrayList<>();
		titulo = titulo.toUpperCase();
		String[] tituloArray = titulo.split(" ");
		for (int contador = 0; contador < tituloArray.length; contador++) {
			for (Livro livro : banco) {
				String livroTitulo = livro.getTitulo();
				String tituloArraySistema[] = livroTitulo.split(" ");
				int i = 0;
				while (i < tituloArraySistema.length) {
					if (tituloArraySistema[i].contains(tituloArray[contador])) {
						livrosEncontrados.add(livro);
					}
					i++;
				}
			}
		}
		if (!livrosEncontrados.isEmpty()) {
			return livrosEncontrados;
		}
		return null;
	}

	@Override
	public Livro buscarPorCodigoSequencial(String codigoSequencial) {
		for (Livro livro : banco) {
			String codigoLivro = livro.getCodigoSequencial();
			if (codigoLivro.equals(codigoSequencial)) {
				return livro;
			}
		}
		return null;
	}

	@Override
	public Livro buscarPorCodigoDeBarras(String codigoDeBarras) {
		for (Livro livro : banco) {
			String codigoLivro = livro.getCodigoDeBarras();
			if (codigoLivro.equals(codigoDeBarras)) {
				return livro;
			}
		}
		return null;
	}

}
