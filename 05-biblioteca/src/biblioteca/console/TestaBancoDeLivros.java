package biblioteca.console;

import java.util.Collection;
import java.util.Set;

import biblioteca.Autor;
import biblioteca.Categoria;
import biblioteca.Livro;
import biblioteca.Livros;
import biblioteca.memoria.BancoDeLivros;

public class TestaBancoDeLivros {
	public static void main(String[] args) {

		Livros bl = new BancoDeLivros();
		//Livros bl = new livrosEmBancoDeDados();


		Autor autor1 = new Autor("Clarice Lispector", "Brasileira");
		Autor autor2 = new Autor("Nome", "alem�");
		Autor autor3 = new Autor("Antonio", "brit�nico");

		Categoria categoria1 = new Categoria("Drama");
		Categoria categoria2 = new Categoria("A��o");
		Categoria categoria3 = new Categoria("Suspense");

		Livro a = new Livro();
		a.setTitulo("Aline 1");
		a.setAutor(autor1);
		a.setCategoria(categoria1);
		a.setResumo("safbfws fesfbuywsf firubfs ");

		Livro b = new Livro();
		b.setTitulo("Aline");
		b.setAutor(autor2);
		b.setCategoria(categoria2);
		b.setResumo("gnnfeiuaf");

		Livro c = new Livro();
		c.setTitulo("teste");
		c.setAutor(autor3);
		c.setCategoria(categoria3);
		c.setResumo("hrsgeh5h ");
		
		adicionar(bl, b);
		adicionar(bl, a);
		adicionar(bl, c);

		Set<Livro> listaDeLivros = bl.listar();

		int contador = 0;
		for (Livro livro : listaDeLivros) {
			contador += 1;
			String livroTitulo = livro.getTitulo();
			String livroAutor = livro.getAutor();
			String livroCategoria = livro.getCategoria();
			String livroLocal = livro.getLocal();
			String livroResumo = livro.getResumo();
			String informacoesDoLivro = +contador + " - " + " T�TULO: '" + livroTitulo + "', AUTOR(A): " + livroAutor
					+", CATEGORIA: " + livroCategoria + ", LOCAL: " + livroLocal + ", Resumo: " + livroResumo + ";";
			System.out.println(informacoesDoLivro);
		}
		/*
		 * Iterator<Livro> iterator = listaDeLivros.iterator(); while
		 * (iterator.hasNext()) {
		 * 
		 * 
		 * String lc = iterator.next(); System.out.print(lc); }
		 */
		bl.excluir(b);

		/*
		 * System.out.println("\n"); List<String> listaDeLivros2 = bl.listar();
		 * Iterator<String> iterator2 = listaDeLivros2.iterator(); while
		 * (iterator2.hasNext()) { String lc = iterator2.next();
		 * System.out.print(lc); }
		 * 
		 * System.out.println("\n");
		 * 
		 * Iterator<Livro> iterator3 = bl.getBanco().iterator(); while
		 * (iterator3.hasNext()) { Livro lc = iterator3.next();
		 * System.out.print("T�tulo livro: '" + lc.getTitulo() + "' "); String
		 * id = lc.toString().replaceAll("biblioteca.Livro@", "");
		 * System.out.print("ID-Objeto:" + id + " \n"); }
		 */
		
		System.out.println("\n");
		
		String entradaPesquisaDeTituloUsuario = "e"; //Vem do usuario
		Collection<Livro> retornoTestePesquisaTitulo = bl.buscarPorTitulo(entradaPesquisaDeTituloUsuario); 
		if(!retornoTestePesquisaTitulo.isEmpty()){
			System.out.println("Livro(s) Encontrado(s): ");
			for (Livro livro : retornoTestePesquisaTitulo) {
				System.out.println(livro);
			}
		}else{
			System.out.println("N�o foram encontrados livros");
		}
		
		long entradaPesquisaDeCodigoSequencialUsuario = 0; //Vem do usuario
		Livro retornoTestePesquisaCodSequencial = bl.buscarPorCodigoSequencial(entradaPesquisaDeCodigoSequencialUsuario);
		if(retornoTestePesquisaCodSequencial != null){
			System.out.println("\nLivro Encontrado");
			System.out.println(retornoTestePesquisaCodSequencial);
		}else{
			System.out.println("Livro n�o encontrado");
		}
		
	}
	
	private static boolean adicionar(Livros banco, Livro livro) {
		
		try {
			banco.adicionar(livro);
			return true;
			
		} catch (NullPointerException e) {
			System.out.println("Nao foi possivel criar com o autor: " + livro.getAutor());
			System.out.println(e.getMessage());
			return false;
		}
	}
}
