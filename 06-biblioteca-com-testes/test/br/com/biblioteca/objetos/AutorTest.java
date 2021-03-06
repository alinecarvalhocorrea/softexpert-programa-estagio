package br.com.biblioteca.objetos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.com.biblioteca.objetos.exceptions.DataException;
import br.com.biblioteca.objetos.exceptions.DataInvalidaException;
import br.com.biblioteca.objetos.exceptions.FormatoDeDataInvalidoException;
import br.com.biblioteca.objetos.exceptions.NomeAutorNuloException;
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

	@Rule
	public ExpectedException exception = ExpectedException.none();

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

		autor.setNome("Jo�o Vitor");

		assertEquals("Jo�o Vitor", autor.getNome());
	}

	@Test
	public void testQuandoNomeDeAutorForNulo() throws Exception {

		exception.expect(NomeAutorNuloException.class);

		new Autor(null);
	}

	@Test
	public void testQuandoNomeDeAutorForVazio() throws Exception {

		exception.expect(NomeAutorNuloException.class);

		new Autor("");
	}

	@Test
	public void testSetDataDeNascimento() throws NomeAutorNuloException, DataException {

		Autor autor = criarAutorPadrao();

		autor.setDataDeNascimento("08/11/2003");

		assertEquals("08/11/2003", autor.getDataDeNascimento());
	}

	@Test
	public void testSetDataDeNascimentoFutura() throws NomeAutorNuloException, Exception {

		exception.expect(DataInvalidaException.class);

		Autor autor = criarAutorPadrao();

		autor.setDataDeNascimento("08/11/2018");
	}

	@Test
	public void testSetDataDeNascimentoFormatoInvalido() throws NomeAutorNuloException, Exception {

		exception.expect(FormatoDeDataInvalidoException.class);

		Autor autor = criarAutorPadrao();

		autor.setDataDeNascimento("aaa");
	}

	@Test
	public void testGetSetDataDeNascimentoNula() throws Exception {

		Autor autor = criarAutorPadrao();

		autor.setDataDeNascimento(null);

		assertEquals("*** Data de nascimento n�o informada ***", autor.getDataDeNascimento());
	}

	@Test
	public void testSetDataDeNascimentoCaractereNAceito() throws NomeAutorNuloException, Exception {

		exception.expect(FormatoDeDataInvalidoException.class);

		Autor autor = criarAutorPadrao();

		autor.setDataDeNascimento("�2215kh2h6");
	}

	@Test
	public void testSetNacionalidade() throws NomeAutorNuloException {

		Autor autor = criarAutorPadrao();

		autor.setNacionalidade("brasileiro");

		assertEquals("brasileiro", autor.getNacionalidade());
	}

	@Test
	public void testSetNacionalidadeVazia() throws Exception {

		Autor autor = criarAutorPadrao();

		autor.setNacionalidade("");

		assertEquals("*** Nacionalidade n�o informada ***", autor.getNacionalidade());
	}

	@Test
	public void testSetNacionalidadeNula() throws Exception {

		Autor autor = criarAutorPadrao();

		autor.setNacionalidade(null);

		assertEquals("*** Nacionalidade n�o informada ***", autor.getNacionalidade());
	}
}
