package biblioteca.memoria;

/**
 * 
 * @author aline.correa
 * 
 */
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import biblioteca.Autor;
import biblioteca.Autores;

public class BancoDeAutores implements Autores {

	private static Set<Autor> banco = new TreeSet<>();

	@Override
	public void adicionar(Autor autor) {
		// TODO BancoAutores: pensar em mais validações para adição de autores
		if (autor.getNome() == null) {
			throw new NullPointerException("O autor(a) está sem nome, favor colocar");
		}
		banco.add(autor);
	}

	@Override
	public void excluir(Autor autor) {
		banco.remove(autor);

	}

	@Override
	public void editar(Autor autorParaEditar) {
		excluir(autorParaEditar);
	}

	@Override
	public Set<Autor> listar() {
		return banco;
	}

	@Override
	public Set<Autor> buscarPorNome(String nome) {
		// TODO BancoAutores : pesquisar e implementar forma de pesquisa
		// ignorando acentos
		Set<Autor> autoresEncontrados = new HashSet<>();
		for (Autor autor : banco) {
			String nomeAutor = autor.getNome();
			nomeAutor = nomeAutor.toUpperCase();
			nome = nome.toUpperCase();
			if (nomeAutor.contains(nome)) {
				autoresEncontrados.add(autor);
			}
		}
		return autoresEncontrados;
	}

	@Override
	public Set<Autor> buscarPorNacionalidade(String nacionalidade) {
		Set<Autor> autoresEncontrados = new HashSet<>();

		for (Autor autor : banco) {
			String nacionalidadeAutor = autor.getNacionalidade().toUpperCase();
			nacionalidade = nacionalidade.toUpperCase();
			if (nacionalidadeAutor.equalsIgnoreCase(nacionalidade)) {
				autoresEncontrados.add(autor);
			}
		}
		return autoresEncontrados;
	}

	@Override
	public Set<Autor> buscarPorDataDeNascimento(Date dataDeNascimento) {
		// TODO BancoAutores : TEM que implementar busca por data de nascimento
		return null;
	}

	@Override
	public Autor buscarPorCodigoSequencial(String codigoSequencial) {
		for (Autor autor : banco) {
			String codigoAutor = autor.getCodigoSequencial();
			if (codigoAutor.equals(codigoSequencial)) {
				return autor;
			}
		}
		return null;
	}

}
