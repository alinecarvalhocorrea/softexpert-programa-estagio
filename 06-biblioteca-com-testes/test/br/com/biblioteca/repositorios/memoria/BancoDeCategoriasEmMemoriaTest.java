package br.com.biblioteca.repositorios.memoria;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.com.biblioteca.objetos.Categoria;
import br.com.biblioteca.objetos.DescricaoCategoriaNulaException;
import br.com.biblioteca.objetos.testes.ZerarTestesDeAutores;
import br.com.biblioteca.repositorios.interfaces.Categorias;

public class BancoDeCategoriasEmMemoriaTest {
	
	private Categorias banco = new BancoDeCategoriasEmMemoria();
	
	@Rule
    public ExpectedException exception = ExpectedException.none();
	
	// Inicia Dados padrão para os testes
	private void prepararDadosParaPesquisa() throws DescricaoCategoriaNulaException{
		Categoria categoria1 = new Categoria("drama");
		banco.adicionar(categoria1);

		Categoria categoria2 = new Categoria("romance");
		banco.adicionar(categoria2);
		
		Categoria categoria3 = new Categoria("suspense");
		banco.adicionar(categoria3);

		Categoria categoria4 = new Categoria("conto");
		banco.adicionar(categoria4);
	}

	@After
	public void aposOTerminoDeCadaTeste() {
		new ZerarTestesDeAutores().zerar();
	}

	
	@Test
	public void testAdicionar() throws DescricaoCategoriaNulaException {
		
		Categoria categoria = new Categoria("teste adicionar");
		
		banco.adicionar(categoria);
		
		assertTrue(banco.listar().contains(categoria));
	}

	@Test
	public void testExcluir() throws DescricaoCategoriaNulaException {
		
		Categoria categoria = new Categoria("teste excluir");
		banco.adicionar(categoria);
		
		banco.excluir(categoria);
		
		assertFalse(banco.listar().contains(categoria));
		
	}

	@Test
	public void testEditar() throws DescricaoCategoriaNulaException {
		
		Categoria categoria = new Categoria("teste editar");
		banco.adicionar(categoria);
		
		banco.editar(categoria);
		
		assertFalse(banco.listar().contains(categoria));
	}
	
	
	@Test
	public void testListar() throws DescricaoCategoriaNulaException {
		
		prepararDadosParaPesquisa();
		
		assertFalse(banco.listar().isEmpty());
	}
	
	
	@Test
	public void testBuscarCategoriaPorDescricao() throws DescricaoCategoriaNulaException {
		
		prepararDadosParaPesquisa();
		
		Set<Categoria> categoriasEncontradas = banco.buscarCategoriaPorDescricao("conto");
		System.out.println(categoriasEncontradas);
		assertEquals(1, categoriasEncontradas.size());
		
	}
	
	@Test
	public void testBuscarCategoriaPorDescricaoSemNenhumResultadoNaPesquisa() throws DescricaoCategoriaNulaException {
		
		exception.expect(NullPointerException.class);
		
		prepararDadosParaPesquisa();
		
		@SuppressWarnings("unused")
		Set<Categoria> categoriasEncontradas = banco.buscarCategoriaPorDescricao("z");		
	}
	
	@Test
	public void testBuscarPorCodigoSequencial() throws DescricaoCategoriaNulaException {
		
		prepararDadosParaPesquisa();
		
		Categoria categoriaEncontrada = banco.buscarPorCodigoSequencial("2");
		
		assertEquals("ROMANCE", categoriaEncontrada.getDescricao());
	}
	
	@Test
	public void testBuscarPorCodigoSequencialQueNaoExisteNoBanco() throws DescricaoCategoriaNulaException {
		
		prepararDadosParaPesquisa();
		
		Categoria categoriaEncontrada = banco.buscarPorCodigoSequencial("0");
		
		assertEquals(null, categoriaEncontrada);
	}
}
