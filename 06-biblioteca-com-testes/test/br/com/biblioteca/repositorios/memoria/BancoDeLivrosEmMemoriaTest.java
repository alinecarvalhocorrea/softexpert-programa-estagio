package br.com.biblioteca.repositorios.memoria;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Set;
import java.util.TreeSet;

import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.com.biblioteca.objetos.Autor;
import br.com.biblioteca.objetos.Categoria;
import br.com.biblioteca.objetos.DataException;
import br.com.biblioteca.objetos.DescricaoCategoriaNulaException;
import br.com.biblioteca.objetos.Livro;
import br.com.biblioteca.objetos.NomeAutorNuloException;
import br.com.biblioteca.objetos.testes.ZerarTestesDeLivros;
import br.com.biblioteca.objetos.verificacoes.AttributeCreationException;
import br.com.biblioteca.repositorios.interfaces.Livros;

public class BancoDeLivrosEmMemoriaTest {
	
	private Livros banco = new BancoDeLivrosEmMemoria();
	
	@Rule
    public ExpectedException exception = ExpectedException.none();
	
	// Inicia Dados padrão para os testes
		private void prepararDadosParaPesquisa() throws DataException, DescricaoCategoriaNulaException, NomeAutorNuloException, AttributeCreationException{
			
			Categoria categoria1 = new Categoria("Romance");
			Categoria categoria2 = new Categoria("Poesia");
			Categoria categoria3 = new Categoria("Conto");
			
			Autor autor1 = new Autor("Autor Padrao 1 Aline");
			Autor autor2 = new Autor("Autor Padrao 2 Joao");
			Autor autor3 = new Autor("Autor Padrao 3 Paulo");
			Autor autor4 = new Autor("Autor Padrao 4 Junior");
			
			Set<Autor> autoresLivro1 = new TreeSet<>();
			Set<Autor> autoresLivro2 = new TreeSet<>();
			Set<Autor> autoresLivro3 = new TreeSet<>();
			Set<Autor> autoresLivro4 = new TreeSet<>();
			
			autoresLivro1.add(autor1);
			autoresLivro2.add(autor2);
			autoresLivro2.add(autor4);
			autoresLivro3.add(autor3);
			autoresLivro3.add(autor1);
			autoresLivro4.add(autor2);
			
			Livro livro1 = new Livro();
			livro1.setAutor(autoresLivro1);
			livro1.setCategoria(categoria3);
			livro1.setTitulo("Livro teste Titulo João");
			livro1.setLocal("b3");
			livro1.setDataDeAquisicao("08/10/2003");
			livro1.setQuantidadeDePaginas("21");
			livro1.setResumo("resumo livro teste");
			livro1.verificacaoDeDadosLivro();
			banco.adicionar(livro1);

			Livro livro2 = new Livro();
			livro2.setAutor(autoresLivro2);
			livro2.setCategoria(categoria3);
			livro2.setTitulo("Livro teste Aline");
			livro2.setLocal("c9");
			livro2.setDataDeAquisicao("10/02/2012");
			livro2.setQuantidadeDePaginas("10");
			livro2.setResumo("Resumindo livro 2 teste");
			livro2.verificacaoDeDadosLivro();
			banco.adicionar(livro2);

			Livro livro3 = new Livro();
			livro3.setAutor(autoresLivro3);
			livro3.setCategoria(categoria1);
			livro3.setTitulo("Titulo");
			livro3.setLocal("d8");
			livro3.setDataDeAquisicao("09/10/2000");
			livro3.setQuantidadeDePaginas("85");
			livro3.setResumo("livro 3 teste resumo");
			livro3.verificacaoDeDadosLivro();
			banco.adicionar(livro3);

			Livro livro4 = new Livro();
			livro4.setAutor(autoresLivro4);
			livro4.setCategoria(categoria2);
			livro4.setTitulo("Livro");
			livro4.setLocal("a5");
			livro4.setDataDeAquisicao("01/02/2005");
			livro4.setQuantidadeDePaginas("132");
			livro4.setResumo("Testando resumo do livro");
			livro4.verificacaoDeDadosLivro();
			banco.adicionar(livro4);
			
		}

		@After
		public void aposOTerminoDeCadaTeste() {
			new ZerarTestesDeLivros().zerar();
		}
	
	@Test
	public void testAdicionar() throws Exception {
		Set<Autor> autoresLivro = new TreeSet<>();
		Autor autor = new Autor("Autor Padrao 1 Aline");
		autoresLivro.add(autor);
		Categoria categoria = new Categoria("Romance");
		Livro livro = new Livro();
		livro.setAutor(autoresLivro);
		livro.setCategoria(categoria);
		livro.setTitulo("Livro teste Titulo");
		livro.setLocal("a5");
		livro.setDataDeAquisicao("01/02/2005");
		livro.setQuantidadeDePaginas("132");
		livro.setResumo("Testando resumo do livro");
		livro.verificacaoDeDadosLivro();
		
		banco.adicionar(livro);
		
		assertTrue(banco.listar().contains(livro));
	}
	

	@Test
	public void testExcluir() {
		Livro livro = new Livro();
		banco.adicionar(livro);
		
		banco.excluir(livro);
		
		assertFalse(banco.listar().contains(livro));
	}
	
	@Test
	public void testEditar() {
		Livro livro = new Livro();
		banco.adicionar(livro);
		
		banco.editar(livro);
		
		assertFalse(banco.listar().contains(livro));
	}
	
	@Test
	public void testListar() throws Exception{
		
		prepararDadosParaPesquisa();
		
		assertFalse(banco.listar().isEmpty());
	}
	
	@Test
	public void testBuscarPorTitulo() throws Exception{
		
			prepararDadosParaPesquisa();
			
			Set<Livro> livrosEncontrados = banco.buscarPorTitulo("teste");
			
			assertEquals(2,livrosEncontrados.size());
	}
	
	@Test
	public void testBuscarPorTituloNaoEncontrado() throws Exception{
		
			exception.expect(NullPointerException.class);
			exception.expectMessage("Nenhum livro encontrado");
			
			prepararDadosParaPesquisa();
			
			@SuppressWarnings("unused")
			Set<Livro> livrosEncontrados = banco.buscarPorTitulo("z");
	}
	
	@Test
	public void testBuscarPorCodigoSequencial() throws Exception{
		
		prepararDadosParaPesquisa();
		
		Livro livroEncontrado = banco.buscarPorCodigoSequencial("2");
		
		assertEquals("LIVRO TESTE ALINE", livroEncontrado.getTitulo());
	}
	
	@Test
	public void testBuscarPorCodigoSequencialQueNaoExisteNoBanco() throws Exception{
		
		exception.expect(NullPointerException.class);
		exception.expectMessage("Nenhum livro encontrado");
		
		prepararDadosParaPesquisa();
		
		@SuppressWarnings("unused")
		Livro livroEncontrado = banco.buscarPorCodigoSequencial("6");
		
	}
	
	@Test
	public void testBuscarPorCodigoDeBarras() throws Exception{
		
		prepararDadosParaPesquisa();
		
		Livro livroEncontrado = banco.buscarPorCodigoDeBarras("7897321700015");
		
		assertEquals("LIVRO TESTE TITULO JOÃO", livroEncontrado.getTitulo());
	}
	
	@Test
	public void testBuscarPorCodigoDeBarrasQueNaoExisteNoBanco() throws Exception{
		
		exception.expect(NullPointerException.class);
		exception.expectMessage("Nenhum livro encontrado");
		
		prepararDadosParaPesquisa();
		
		@SuppressWarnings("unused")
		Livro livroEncontrado = banco.buscarPorCodigoDeBarras("789");
		
	}
	
	@Test
	public void testBuscarPorCategoria() throws Exception{
		
		prepararDadosParaPesquisa();
		
		Set<Livro> livrosEncontrados = banco.buscarPorCategoria("conto");

		assertEquals(2, livrosEncontrados.size());
	}
	
	@Test
	public void testBuscarPorCategoriaQueNaoExiste() throws Exception{
		
		exception.expect(NullPointerException.class);
		exception.expectMessage("Nenhum livro encontrado");
		
		prepararDadosParaPesquisa();
		
		@SuppressWarnings("unused")
		Set<Livro> livrosEncontrados = banco.buscarPorCategoria("ts");

	}

	@Test
	public void testBuscarPorAutor() throws Exception{
		
		prepararDadosParaPesquisa();
		
		Set<Livro> livrosEncontrados = banco.buscarPorAutor("1");

		assertEquals(2, livrosEncontrados.size());
	}
	
	@Test
	public void testBuscarPorAutorQueNaoExiste() throws Exception{
		
		exception.expect(NullPointerException.class);
		exception.expectMessage("Nenhum livro encontrado");
		
		prepararDadosParaPesquisa();
		
		@SuppressWarnings("unused")
		Set<Livro> livrosEncontrados = banco.buscarPorAutor("z");

	}
}
