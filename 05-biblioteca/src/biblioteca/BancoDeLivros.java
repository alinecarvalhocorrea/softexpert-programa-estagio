package biblioteca;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class BancoDeLivros implements BancoAcessivel {
	
	public static Set<Livro> banco = new TreeSet<>();
	//TESTE
	public static void main(String[] args) {
		
		BancoDeLivros bl = new BancoDeLivros();
		Livro a = new Livro();
		a.setTitulo("a");
		
		Livro b = new Livro();
		b.setTitulo("b");
		
		Livro c = new Livro();
		c.setTitulo("c");
		
		bl.adicionar(b);
		bl.adicionar(a);
		bl.adicionar(c);
		
		Iterator<Livro> iterator = bl.getBanco().iterator();
		while (iterator.hasNext()) {
		    Livro lc = iterator.next();
			System.out.print(lc.getTitulo() + " ");
		    String id = lc.toString().replaceAll("biblioteca.Livro@", "");
			System.out.print(id + " ");
		}
	}
	
	public static Set<Livro> getBanco() {
		return banco;
	}

	public static void setBanco(Set<Livro> banco) {
		BancoDeLivros.banco = banco;
	}

	public void adicionar(Livro livro){
		banco.add(livro);
	}
	
	public void excluir(Livro livro){
		banco.remove(livro);
	}
	
	public void editar(Livro livro){
		//editar titulo
		//editar autor
		//editar dataDeAquisicao
		//editar resumo
		//editar local
	}
	
	public void listar(){
		List<String> namesList = new ArrayList<>();
		
		namesList.add("ze");
		namesList.add("bia");
		namesList.add("jimmy");
		
		//ordem de insercao
		System.out.println(namesList);
		//ordena por ordem alfabetica
		Collections.sort(namesList);
		//ordem alfabetica
		System.out.println(namesList);
	}
	
}
