package br.com.biblioteca.objetos;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Test;

import br.com.biblioteca.objetos.testes.ZerarTestesDeCategorias;

/**
 * @author aline.correa
 * 
 *         ETAPAS NOS TESTES
 *
 *         1 - A (Organizar) 2 - A (Executar) 3 - A (Verificar)
 * 
 */

public class CategoriaTest {

	private Categoria criarCategoriaPadrao() throws DescricaoCategoriaNulaException {
		Categoria categoria = new Categoria("drama");
		return categoria;
	}

	@After
	public void aposOTerminoDeCadaTeste() {
		new ZerarTestesDeCategorias().zerar();
	}

	@Test
	public void testCategoria() throws DescricaoCategoriaNulaException {

		Categoria categoria = criarCategoriaPadrao();

		assertEquals("DRAMA", categoria.getDescricao());
	}

	@Test
	public void testCategoriaConstrutor() throws DescricaoCategoriaNulaException {

		Categoria categoria = new Categoria("Romance");

		assertEquals("ROMANCE", categoria.getDescricao());
	}

	@Test
	public void testSetCodigoSequencial() throws DescricaoCategoriaNulaException {

		Categoria categoria = criarCategoriaPadrao();

		assertEquals("1", categoria.getCodigoSequencial());
	}

	@Test(expected = DescricaoCategoriaNulaException.class)
	public void testQuandoDescricaoDeCategoriaEstiverNula() throws Exception {
		new Categoria(null);
	}

	@Test(expected = DescricaoCategoriaNulaException.class)
	public void testQuandoEntradaDeDescricaoDeCategoriaForVazia() throws Exception {
		new Categoria("");
	}
}