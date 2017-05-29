package biblioteca.console;

/**
 * 
 * @author aline.correa
 *
 */
public class GerenciaBiblioteca {
	public static void main(String[] args) {
		
		System.out.println("Bem-Vindo(a) a biblioteca!");   //new Biblioteca
		
		System.out.println("Criar banco de livros...");     //Construtor biblioteca 
		System.out.println("Criar banco de autores...");    //Construtor biblioteca
		System.out.println("Criar banco de categorias..."); //Construtor biblioteca
		
		System.out.println("MENU:"); 
		//new menu 
		//new Scanner
		//mostrar index (LER INT)
		
		System.out.println("1 - Consultar"); //menu Index  
			//Se na leitura do menu index for opcao == 1
			//menu.menuConsultar(); 
			//menu consultar (LER INT)
			System.out.println("    Consultar Livro"); 
				System.out.println("        0 - Consultar Livro por Título");
				System.out.println("        1 - Consultar Livro por Código Sequencial");
				System.out.println("        2 - Consultar Livro por Código de Barras");
				System.out.println("        3 - Consultar Livro por Categoria");
			System.out.println("    Consultar Categoria");
				System.out.println("        4 - Consultar Categoria por Descrição");
				System.out.println("        5 - Consultar Categoria por Código Sequencial");
			System.out.println("    Consultar Autor");
				System.out.println("        6 - Consultar Autor por Nome");
				System.out.println("        7 - Consultar Autor por Nacionalidade");
				System.out.println("        8 - Consultar Autor por Data de Nascimento");
				System.out.println("        9 - Consultar Autor por Código Sequencial");
				//solicitarOpcaoUsuario()			
				System.out.println("Insira a opção desejada(CONSULTAR): ");
				//int opcao = scanner.nextInt();
		
		System.out.println("2 - Adicionar"); //menu Index
		//Se na leitura do menu index for opcao == 2 
		//menu.menuAdicionar(); 
		//menu adicionar (LER INT)
			System.out.println("    1 - Adicionar Livro"); //menu adicionar
			System.out.println("    2 - Adicionar Autor"); //menu adicionar
			System.out.println("    3 - Adicionar Categoria"); //menu adicionar
			//solicitarOpcaoUsuario()			
			System.out.println("Insira a opção desejada(ADICIONAR): ");
			//int opcao = scanner.nextInt();
		
		System.out.println("3 - Remover"); 	//menu Index
		//Se na leitura do menu index for opcao == 3
		//menu.menuRemover(); 
		//menu remover (LER INT)
			System.out.println("    1 - Remover Livro"); //menu remover
			// 1 - Solicitar código sequencial 
			// 2 - Pesquisar e retornar o livro pelo código sequencial 
			// 3 - excluir() livro retornado
			System.out.println("    2 - Remover Autor"); //menu remover
			// 1 - Solicitar código sequencial
			// 2 - Pesquisar e retornar o autor pelo código sequencial 
			// 3 - excluir() autor retornado
			System.out.println("    3 - Remover Categoria"); //menu remover
			// 1 - Solicitar código sequencial
			// 2 - Pesquisar e retornar o categoria pelo código sequencial 
			// 3 - excluir() categoria retornada
			
			//solicitarOpcaoUsuario()			
			System.out.println("Insira a opção desejada(REMOVER): ");
			//int opcao = scanner.nextInt();
		
		System.out.println("4 - Alterar"); //menu Index
		//Se na leitura do menu index for opcao == 4
		//menu.menuAlterar(); 
		//menu alterar (LER INT)
			System.out.println("    1 - Alterar Livro");
			// 1 - Solicitar código sequencial
			// 2 - Pesquisar e retornar o lIVRO pelo código sequencial 
			// 3 - editar() Livro retornado
			System.out.println("    2 - Alterar Autor"); 
			// 1 - Solicitar código sequencial
			// 2 - Pesquisar e retornar o Autor pelo código sequencial 
			// 3 - editar() Autor retornado
			System.out.println("    3 - Alterar Categoria");
			// 1 - Solicitar código sequencial
			// 2 - Pesquisar e retornar o categoria pelo código sequencial 
			// 3 - editar() categoria retornada
			
			//solicitarOpcaoUsuario()			
			System.out.println("Insira a opção desejada(ALTERAR): ");
			//int opcao = scanner.nextInt();
		
		System.out.println("5 - Listar"); //menu Index
		//Se na leitura do menu index for opcao == 5
		//menu.menuListar(); 
		//menu listar (LER INT)
			System.out.println("    1 - Listar Livros"); 
			System.out.println("    2 - Listar Autores(as)");
			System.out.println("    3 - Listar Categorias");
			
			//solicitarOpcaoUsuario()			
			System.out.println("Insira a opção desejada(LISTAR): ");
			//int opcao = scanner.nextInt();	
			
		System.out.println("6 - Sair"); //menu Index
			//Se na leitura do menu index for opcao == 5
			//menu.encerrar(); 
			//scanner.close();

		//solicitarOpcaoUsuario()			
		System.out.println("Insira a opção desejada(INDEX): ");
		//int opcao = scanner.nextInt();


		
	}
}
