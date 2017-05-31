package biblioteca.console;

/**
 * 
 * @author aline.correa
 * 
 */
import java.util.Set;
import biblioteca.Categoria;
import biblioteca.memoria.BancoDeCategorias;

public class TestaBancoDeCategorias {

	public static void main(String[] args) {

		// TESTE : Cria categorias padroes
		Categoria categoriaDrama = new Categoria("drama");
		System.out.println("Criando Categoria: " + categoriaDrama.getDescricao());

		Categoria categoriaSuspense = new Categoria("suspense");
		System.out.println("Criando Categoria: " + categoriaSuspense.getDescricao());

		Categoria categoriaAcao = new Categoria("acao");
		System.out.println("Criando Categoria: " + categoriaAcao.getDescricao());

		System.out.println("\n");

		// TESTE : Inicializar BancoDeCategorias
		System.out.println("Inicializando banco de categorias...");
		BancoDeCategorias bancoDeCategorias = new BancoDeCategorias();

		System.out.println("\n");

		// TESTE : Inserir categorias padrões no BancoDeCategorias
		System.out.println("Adicionando Categoria no Banco: " + categoriaDrama.getDescricao());
		bancoDeCategorias.adicionar(categoriaDrama);
		System.out.println("Adicionando Categoria no Banco: " + categoriaSuspense.getDescricao());
		bancoDeCategorias.adicionar(categoriaSuspense);
		System.out.println("Adicionando Categoria no Banco: " + categoriaAcao.getDescricao());
		bancoDeCategorias.adicionar(categoriaAcao);

		System.out.println("\n");

		// TESTE : Remover categoria do BancoDeCategorias
		System.out.println("Excluindo Categoria: " + categoriaAcao);
		bancoDeCategorias.excluir(categoriaAcao);

		System.out.println("\n");

		// TESTE : Listar BancoDeCategorias
		System.out.println("Listando Categorias...");
		Set<Categoria> listaDeCategorias = bancoDeCategorias.listar();
		for (Categoria categoria : listaDeCategorias) {
			System.out.println(categoria);
		}

		System.out.println("\n");

		// TESTE : Procurar categoria pela descricao(Não existente)
		System.out.println("Procurar categoria pela descricao(Não existente):");
		Categoria resultadoPesquisa = bancoDeCategorias.buscarCategoriaPorDescricao("Acao");
		if (resultadoPesquisa != null) {
			String descricaoResultadoPesquisa = resultadoPesquisa.getDescricao();
			String codigoResultadoPesquisa = resultadoPesquisa.getCodigoSequencial();
			System.out.println("Código: " + codigoResultadoPesquisa + " Categoria: " + descricaoResultadoPesquisa);
		} else {
			System.out.println("Categoria não encontrada");
		}

		System.out.println("\n");

		// TESTE : Procurar categoria pela descricao(Existente)
		System.out.println("Procurar categoria pela descricao(Existente):");
		Categoria resultadoPesquisa2 = bancoDeCategorias.buscarCategoriaPorDescricao("suspense");
		if (resultadoPesquisa2 != null) {
			String codigoResultadoPesquisa = resultadoPesquisa2.getCodigoSequencial();
			String descricaoResultadoPesquisa = resultadoPesquisa2.getDescricao();
			System.out.println("Código: " + codigoResultadoPesquisa + " Categoria: " + descricaoResultadoPesquisa);
		}
		if (resultadoPesquisa2 == null) {
			System.out.println("Categoria não encontrada");
		}

		System.out.println("\n");

		// TESTE : Procurar categoria pelo codigo sequencial(Não Existente)
		System.out.println("Procurar categoria pelo codigo sequencial(Não existente):");
		Categoria resultadoPesquisa4 = bancoDeCategorias.buscarPorCodigoSequencial("gbaiugfius");
		if (resultadoPesquisa4 != null) {
			String descricaoResultadoPesquisa = resultadoPesquisa4.getDescricao();
			System.out.println("Código: " + resultadoPesquisa4.getCodigoSequencial() + " Categoria: "
					+ descricaoResultadoPesquisa);
		}
		if (resultadoPesquisa4 == null) {
			System.out.println("Categoria não encontrada");
		}

		System.out.println("\n");

		// TESTE : Procurar categoria pelo codigo sequencial(Existente)
		System.out.println("Procurar categoria pelo codigo sequencial(Existente):");
		Categoria resultadoPesquisa5 = bancoDeCategorias
				.buscarPorCodigoSequencial(resultadoPesquisa2.getCodigoSequencial());
		if (resultadoPesquisa5 != null) {
			String descricaoResultadoPesquisa = resultadoPesquisa5.getDescricao();
			System.out.println("Código: " + resultadoPesquisa5.getCodigoSequencial() + " Categoria: "
					+ descricaoResultadoPesquisa);
		}
		if (resultadoPesquisa5 == null) {
			System.out.println("Categoria não encontrada");
		}

	}

}
