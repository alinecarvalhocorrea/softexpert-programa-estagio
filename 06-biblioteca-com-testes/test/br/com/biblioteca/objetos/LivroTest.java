package br.com.biblioteca.objetos;

import static org.junit.Assert.assertEquals;

import java.util.Set;
import java.util.TreeSet;

import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.com.biblioteca.objetos.exceptions.CriacaoDeAtributoException;
import br.com.biblioteca.objetos.exceptions.DataException;
import br.com.biblioteca.objetos.exceptions.DataInvalidaException;
import br.com.biblioteca.objetos.exceptions.DescricaoCategoriaNulaException;
import br.com.biblioteca.objetos.exceptions.FormatoDeDataInvalidoException;
import br.com.biblioteca.objetos.exceptions.NomeAutorNuloException;
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

	@Rule
	public ExpectedException exception = ExpectedException.none();

	public Livro criaLivroPadrao() throws NomeAutorNuloException, DescricaoCategoriaNulaException, DataException {
		Autor autor = new Autor("Aline Teste");
		Set<Autor> autoresLivro = new TreeSet<>();
		autoresLivro.add(autor);
		Categoria categoria = new Categoria("Romance");

		Livro livro = new Livro();

		livro.setAutor(autoresLivro);
		livro.setCategoria(categoria);
		livro.setTitulo("Livro teste Titulo");
		livro.setLocal("b3");
		livro.setDataDeAquisicao("08/10/2003");
		livro.setQuantidadeDePaginas("23");
		livro.setResumo("resumo livro teste");
		return livro;
	}

	@After
	public void aposOTerminoDeCadaTeste() {
		new ZerarTestesDeLivros().zerar();
	}

	@Test
	public void testLivro() throws NomeAutorNuloException, DescricaoCategoriaNulaException, DataException, Exception {

		Livro livro = criaLivroPadrao();

		livro.verificacaoDeDadosLivro();

		assertEquals("1", livro.getCodigoSequencial());

	}

	@Test
	public void testCriarLivrosAteOCodigoSequencialTerQuatroDigitos()
			throws DescricaoCategoriaNulaException, NomeAutorNuloException, DataException {
		for (int contador = 1; contador < 1999; contador++) {
			new Livro();
		}
		assertEquals("7897321719998", new Livro().getCodigoDeBarras());
	}

	@Test
	public void testLivroSemTitulo() throws Exception {

		exception.expect(CriacaoDeAtributoException.class);
		exception.expectMessage("está sem titulo");

		Livro livro = new Livro();
		livro.verificacaoDeDadosLivro();
	}

	@Test
	public void testLivroSemAutor() throws Exception {

		exception.expect(CriacaoDeAtributoException.class);
		exception.expectMessage("está sem autor");

		Livro livro = new Livro();
		livro.setTitulo("teste titulo");
		Set<Autor> autor = new TreeSet<>();
		livro.setAutor(autor);
		livro.verificacaoDeDadosLivro();
	}

	@Test
	public void testLivroSemCategoria() throws Exception {

		exception.expect(CriacaoDeAtributoException.class);
		exception.expectMessage("está sem categoria");

		Livro livro = new Livro();
		livro.setTitulo("teste titulo");
		Set<Autor> autor = new TreeSet<>();
		autor.add(new Autor());
		livro.setAutor(autor);
		livro.verificacaoDeDadosLivro();
	}

	@Test
	public void testLivroSemLocal() throws Exception {

		exception.expect(CriacaoDeAtributoException.class);
		exception.expectMessage("está sem local");

		Livro livro = new Livro();
		livro.setTitulo("teste titulo");
		Set<Autor> autor = new TreeSet<>();
		autor.add(new Autor());
		livro.setAutor(autor);
		livro.setCategoria(new Categoria("drama"));
		livro.verificacaoDeDadosLivro();
	}

	@Test
	public void testLivroSemDataDeAquisicao() throws Exception {

		Livro livro = new Livro();
		livro.setTitulo("teste titulo");
		Set<Autor> autor = new TreeSet<>();
		autor.add(new Autor());
		livro.setAutor(autor);
		livro.setCategoria(new Categoria("drama"));
		livro.setDataDeAquisicao(null);
		livro.setLocal("b5");
		livro.verificacaoDeDadosLivro();
		assertEquals("*** Data de Aquisição não informada ***", livro.getDataDeAquisicao());
	}

	@Test
	public void testSetCodigoDeBarras() throws NomeAutorNuloException, DescricaoCategoriaNulaException, DataException {

		assertEquals("7897321700015", criaLivroPadrao().getCodigoDeBarras());
	}

	@Test
	public void testSetDataDeAquisicao() throws NomeAutorNuloException, DescricaoCategoriaNulaException, DataException {

		Livro livro = criaLivroPadrao();

		livro.setDataDeAquisicao("08/10/2012");

		assertEquals("08/10/2012", livro.getDataDeAquisicao());
	}

	@Test
	public void testDataDeAquisicaoPosteriorAAtual() throws Exception {

		exception.expect(DataInvalidaException.class);

		Livro livro = criaLivroPadrao();

		livro.setDataDeAquisicao("08/10/2019");
	}

	@Test
	public void testDataDeAquisicaoFormatoErrado() throws Exception {

		exception.expect(FormatoDeDataInvalidoException.class);

		Livro livro = criaLivroPadrao();

		livro.setDataDeAquisicao("aaaa");
	}

	@Test
	public void testQuantidadeDePaginasNaoInformado() throws Exception {

		Livro livro = criaLivroPadrao();

		livro.setQuantidadeDePaginas(null);

		assertEquals("*** Quantidade de páginas não informado ***", livro.getQuantidadeDePaginas());
	}

	@Test
	public void testSetAutor() throws NomeAutorNuloException, DescricaoCategoriaNulaException, DataException {

		Livro livro = criaLivroPadrao();
		Autor autor = new Autor("Teste Autor");
		Set<Autor> autorDoLivro = new TreeSet<>();
		autorDoLivro.add(autor);

		livro.setAutor(autorDoLivro);

		assertEquals("[Nome: Teste Autor | Código Sequencial: 3]", livro.getAutor().toString());
	}

	@Test
	public void testSetCategoria() throws DescricaoCategoriaNulaException, NomeAutorNuloException, DataException {

		Livro livro = criaLivroPadrao();
		Categoria categoria = new Categoria("drama");

		livro.setCategoria(categoria);

		assertEquals("DRAMA", livro.getCategoria().getDescricao());
	}

	@Test
	public void testSetResumo() throws Exception {

		Livro livro = criaLivroPadrao();

		livro.setResumo("Resumo teste teste");

		assertEquals("Resumo teste teste", livro.getResumo());
	}

	@Test
	public void testGetResumoNulo() throws Exception {

		Livro livro = criaLivroPadrao();

		livro.setResumo(null);

		assertEquals("*** Resumo não informado ***", livro.getResumo());
	}

	@Test
	public void testGetResumoVazio() throws Exception {

		Livro livro = criaLivroPadrao();

		livro.setResumo("");

		assertEquals("*** Resumo não informado ***", livro.getResumo());
	}
}
