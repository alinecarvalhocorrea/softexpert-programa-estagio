package br.com.biblioteca.objetos;

import static org.junit.Assert.assertEquals;

import java.util.Set;
import java.util.TreeSet;

import org.junit.After;
import org.junit.Test;

import br.com.biblioteca.objetos.testes.ZerarTestesDeLivros;

/**
 * @author aline.correa
 * 
 *         ETAPAS NOS TESTES
 *
 *         1 - A (Organizar) 2 - A (Executar) 3 - A (Verificar)
 * 
 */

public class LivroTest {

	public Livro criaLivroPadrao() throws NomeAutorNuloException, DescricaoCategoriaNulaException {
		Autor autor = new Autor("Aline Teste");
		Set<Autor> autoresLivro = new TreeSet<>();
		autoresLivro.add(autor);
		Categoria categoria = new Categoria("Romance");
		Livro livro = new Livro(autoresLivro, categoria, "Livro Teste Titulo", "b3");
		return livro;
	}

	@After
	public void aposOTerminoDeCadaTeste() {
		new ZerarTestesDeLivros().zerar();
	}

	@Test
	public void testLivro() {

		Livro livro = new Livro();

		assertEquals("1", livro.getCodigoSequencial());
	}

	@Test
	public void testSetCodigoSequencial() throws NomeAutorNuloException, DescricaoCategoriaNulaException {

		Livro livro = criaLivroPadrao();

		assertEquals("1", livro.getCodigoSequencial());
	}

	@Test
	public void testSetCodigoDeBarras() throws NomeAutorNuloException, DescricaoCategoriaNulaException {

		Livro livro = criaLivroPadrao();

		assertEquals("84789217411", livro.getCodigoDeBarras());
	}

	@Test
	public void testSetDataDeAquisicao()
			throws DataInvalidaException, NomeAutorNuloException, DescricaoCategoriaNulaException {

		Livro livro = criaLivroPadrao();

		livro.setDataDeAquisicao("08/10/2012");

		assertEquals("08/10/2012", livro.getDataDeAquisicao());
	}

	@Test(expected = DataInvalidaException.class)
	public void testDataDeAquisicaoPosteriorAAtual() throws Exception {

		Livro livro = criaLivroPadrao();

		livro.setDataDeAquisicao("08/10/2019");
	}

	@Test
	public void testSetAutor() throws NomeAutorNuloException {

		Livro livro = new Livro();
		Autor autor = new Autor("Teste Autor");
		Set<Autor> autorDoLivro = new TreeSet<>();
		autorDoLivro.add(autor);

		livro.setAutor(autorDoLivro);

		assertEquals("[Teste Autor]", livro.getAutor().toString());
	}

	@Test
	public void testSetCategoria() throws DescricaoCategoriaNulaException {

		Livro livro = new Livro();
		Categoria categoria = new Categoria("drama");

		livro.setCategoria(categoria);

		assertEquals("DRAMA", livro.getCategoria());
	}
}
