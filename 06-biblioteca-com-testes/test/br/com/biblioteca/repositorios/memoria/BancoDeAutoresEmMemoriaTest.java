package br.com.biblioteca.repositorios.memoria;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.com.biblioteca.objetos.Autor;
import br.com.biblioteca.objetos.DataInvalidaException;
import br.com.biblioteca.objetos.FormatoDeDataInvalidoException;
import br.com.biblioteca.objetos.NomeAutorNuloException;
import br.com.biblioteca.objetos.testes.ZerarTestesDeAutores;
import br.com.biblioteca.repositorios.interfaces.Autores;

/**
 * @author aline.correa
 * 
 *	ETAPAS NOS TESTES
 *
 * 1 -  A (Organizar)
 * 2 -  A (Executar)
 * 3 -  A (Verificar)
 * 
 */

public class BancoDeAutoresEmMemoriaTest {

	private Autores banco = new BancoDeAutoresEmMemoria();
	
	@Rule
    public ExpectedException exception = ExpectedException.none();
	
	// Inicia Dados padrão para os testes
	private void prepararDadosParaPesquisa() throws NomeAutorNuloException, DataInvalidaException, FormatoDeDataInvalidoException {
		Autor autor1 = new Autor("Shakespeare Aline");
		autor1.setNacionalidade("BRASILEIRO");
		autor1.setDataDeNascimento("08/11/1997");
		banco.adicionar(autor1);

		Autor autor2 = new Autor("Agatha Christie");
		autor2.setNacionalidade("russa");
		autor2.setDataDeNascimento("02/10/2012");
		banco.adicionar(autor2);

		Autor autor3 = new Autor("Testar Autores");
		autor3.setNacionalidade("brasileiro");
		autor3.setDataDeNascimento("02/11/1997");
		banco.adicionar(autor3);

		Autor autor4 = new Autor("Aline Carvalho Autores");
		autor4.setNacionalidade("britânica");
		autor4.setDataDeNascimento("23/01/1876");
		banco.adicionar(autor4);
	}

	@After
	public void aposOTerminoDeCadaTeste() {
		new ZerarTestesDeAutores().zerar();
	}

	@Test
	public void testAdicionar() throws NomeAutorNuloException, DataInvalidaException, FormatoDeDataInvalidoException {
		
		Autor autor = new Autor("Aline");
		autor.setDataDeNascimento("03/11/1997");

		banco.adicionar(autor);

		Set<Autor> bancoLista = banco.listar();
		assertTrue(bancoLista.contains(autor));
	}

	@Test
	public void testExcluir() throws NomeAutorNuloException {

		Autor autor = new Autor("Resgistro Excluido");
		banco.adicionar(autor);

		banco.excluir(autor);

		Set<Autor> bancoLista2 = banco.listar();
		assertFalse(bancoLista2.contains(autor));
	}

	@Test
	public void testEditar() throws NomeAutorNuloException {

		Autor autor3 = new Autor("Resgistro Editado/Excluido");
		banco.adicionar(autor3);

		banco.editar(autor3);

		Set<Autor> bancoLista3 = banco.listar();
		assertFalse(bancoLista3.contains(autor3));
	}

	@Test
	public void testListar() throws NomeAutorNuloException, DataInvalidaException, FormatoDeDataInvalidoException {

		prepararDadosParaPesquisa();

		Set<Autor> bancoLista4 = banco.listar();

		assertFalse(bancoLista4.isEmpty());
	}

	@Test
	public void testBuscarPorNome() throws NomeAutorNuloException, DataInvalidaException, FormatoDeDataInvalidoException {

		prepararDadosParaPesquisa();

		Set<Autor> autoresBuscaPorNome = banco.buscarPorNome("Aline");

		assertEquals(2, autoresBuscaPorNome.size());
	}

	@Test
	public void testBuscarPorNacionalidade() throws NomeAutorNuloException, DataInvalidaException, FormatoDeDataInvalidoException {

		prepararDadosParaPesquisa();

		Set<Autor> autoresBuscarPorNacionalidade = banco.buscarPorNacionalidade("brasileiro");

		assertEquals(2, autoresBuscarPorNacionalidade.size());
	}

	@Test
	public void testBuscarPorDataDeNascimento() throws NomeAutorNuloException, DataInvalidaException, FormatoDeDataInvalidoException {

		prepararDadosParaPesquisa();

		Set<Autor> autoresBuscarPorDataDeNascimento = banco.buscarPorDataDeNascimento("23/01/1876");
		System.out.println(autoresBuscarPorDataDeNascimento);

		assertEquals(1, autoresBuscarPorDataDeNascimento.size());
	}

	@Test
	public void testBuscarPorCodigoSequencial() throws NomeAutorNuloException, DataInvalidaException, FormatoDeDataInvalidoException {
		
		prepararDadosParaPesquisa();

		Autor autorBuscarPorCodigoSequencial = banco.buscarPorCodigoSequencial("2");

		assertEquals("Agatha Christie", autorBuscarPorCodigoSequencial.getNome());
	}
}
