package br.com.biblioteca.objetos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.After;
import org.junit.Test;

import br.com.biblioteca.objetos.testes.ZerarTestesDeAutores;

/**
 * @author aline.correa
 * 
 *         ETAPAS NOS TESTES
 *
 *         1 - A (Organizar) 2 - A (Executar) 3 - A (Verificar)
 * 
 */

public class AutorTest {

	private Autor criarAutorPadrao() throws NomeAutorNuloException {
		Autor autor = new Autor("Teste Autor");
		return autor;
	}

	@After
	public void aposOTerminoDeCadaTeste() {
		new ZerarTestesDeAutores().zerar();
	}

	@Test
	public void testAutor() throws NomeAutorNuloException {

		Autor autor = new Autor();

		assertFalse(autor.equals(null));
	}

	@Test
	public void testAutorConstrutor() throws NomeAutorNuloException {

		Autor autor = criarAutorPadrao();

		assertEquals("Teste Autor", autor.getNome());
	}

	@Test
	public void testSetCodigoSequencial() {

		Autor autor = new Autor();

		assertEquals("1", autor.getCodigoSequencial());
	}

	@Test
	public void testSetNome() throws NomeAutorNuloException {

		Autor autor = criarAutorPadrao();

		autor.setNome("João Vitor");

		assertEquals("João Vitor", autor.getNome());
	}

	@Test(expected = NomeAutorNuloException.class)
	public void testQuandoNomeDeAutorForNulo() throws Exception {
		new Autor(null);
	}

	@Test(expected = NomeAutorNuloException.class)
	public void testQuandoNomeDeAutorForVazio() throws Exception {
		new Autor("");
	}

	@Test
	public void testSetDataDeNascimento() throws NomeAutorNuloException, DataInvalidaException {

		Autor autor = criarAutorPadrao();

		autor.setDataDeNascimento("08/11/2003");

		assertEquals("08/11/2003", autor.getDataDeNascimento());
	}

	@Test(expected = DataInvalidaException.class)
	public void testDataDeNascimentoFutura() throws NomeAutorNuloException, Exception {

		Autor autor = criarAutorPadrao();

		autor.setDataDeNascimento("08/11/2018");
	}

	@Test(expected = FormatoDeDataInvalidoException.class)
	public void testDataDeNascimentoFormatoInvalido() throws NomeAutorNuloException, Exception {

		Autor autor = criarAutorPadrao();

		autor.setDataDeNascimento("aaa");
	}

	@Test
	public void testSetNacionalidade() throws NomeAutorNuloException {

		Autor autor = criarAutorPadrao();

		autor.setNacionalidade("brasileiro");

		assertEquals("brasileiro", autor.getNacionalidade());
	}

}
