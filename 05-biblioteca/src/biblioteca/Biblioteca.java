package biblioteca;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;
import biblioteca.Categoria;
import biblioteca.TestaControleDeBiblioteca;

public class Biblioteca {
	Scanner entrada = new Scanner(System.in);
	private String indexMenu = "MENU \n 1 - Consulta no acervo; \n 2 - Cadastrar Livro; \n 3 - Cadastrar Autor; \n 4 - Cadastrar Categoria;";
	
	public int indexMenu() {
		System.out.println(indexMenu);
		System.out.println("Qual operacao que deseja realizar? ");
		int opcao0 = entrada.nextInt();
		return opcao0;
	}
	void listarCategorias(Collection<Categoria> colecao){
		Iterator<Categoria> i = colecao.iterator();
		while (i.hasNext()) {
			// recebe o próximo objeto
			Categoria palavra = i.next();
			System.out.println(palavra.getDescricao());
		}
	}
	public int menu1(int opcao0, Collection<Categoria> categorias, Collection<Autor> autores, Collection<Livro> bibliotecaDeLivros) {
		if (opcao0 == 1) {
			System.out.println("MENU :  Consulta no acervo \n 1 - Consultar por livro; \n 2 - Consultar por Autor; \n 3 - Consultar por Categoria; \n 4 - Consultar por Código;");
			int opcao1 = entrada.nextInt();
			return opcao1;
		}
		if (opcao0 == 2) {
			System.out.println("MENU :  Cadastrar Livro \n Por favor, insira o título do livro:"); 
			String titulo = entrada.next();
			entrada.nextLine();
			System.out.println("\n Por favor, insira a quantidade de páginas do livro:"); 
			int quantidadeDePaginas = entrada.nextInt();
			entrada.nextLine();
			System.out.println("\n Por favor, selecione a categoria do livro:");
			this.listarCategorias(categorias);
			int categoria = entrada.nextInt();
			entrada.nextLine();
			Livro livro = new Livro(titulo, quantidadeDePaginas);
			System.out.println("Criando livro...");
			
			if(equals(livro)){
				System.out.println("Livro criado com exito \n Título: "+ livro.getTitulo() + ". Quantidade de Páginas: " + livro.getQuantidadeDePaginas());
			}else{
				System.out.println("Falha na criacao de livro.");
			}
			boolean verifica = bibliotecaDeLivros.add(livro);
			System.out.println("Inserindo livro na biblioteca...");
			if(verifica){
			System.out.println("Livro inserido na biblioteca");
			}
			else{
				System.out.println("Falha na insercao de livro na biblioteca");
			}
		}
		if (opcao0 == 3) {
			System.out.println("MENU :  Cadastrar Autor \n"); 
			String opcao1 = entrada.nextLine();
			//return autor.getCodigoSequencial();
		}
		if (opcao0 == 4) {
			System.out.println("MENU :  Cadastrar Categoria \n Por favor, insira nova categoria:"); 
			entrada.nextLine();
			String opcao1 = entrada.next();
			Categoria categoria = new Categoria(opcao1);
			System.out.println("Criando categoria...");
			
			if(equals(categoria)){
				System.out.println("Categoria criada com exito \n"+categoria.getDescricao());
			}else{
				System.out.println("Falha na criacao de categoria.");
			}
			boolean verifica = categorias.add(categoria);
			System.out.println("Inserindo categoria na biblioteca...");
			if(verifica){
			System.out.println("categoria inserida na biblioteca");
			}
			else{
				System.out.println("Falha na insercao de categoria na biblioteca");
			}
			
		}
		return 0000;
	}
	
	public void encerra() {
		entrada.close();
	}
	
	//public int menu2(){}
	//public int menu3(){}
	//public int menu4(){}
}
