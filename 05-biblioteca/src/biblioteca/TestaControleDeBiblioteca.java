package biblioteca;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/**
 * 
 * @author aline.correa
 *
 */
public class TestaControleDeBiblioteca {
	
	public static void main(String[] args) {

		try {
			Collection<Livro> bibliotecaDeLivros = new HashSet<>();
			Collection<Categoria> categorias = new HashSet<>();
			Collection<Autor> autores = new HashSet<>();

			Biblioteca sistema = new Biblioteca();
			int opcao0 = sistema.indexMenu();
			System.out.println(opcao0);
			sistema.menu1(opcao0, categorias, autores, bibliotecaDeLivros);
			/*
			 * // arquivo onde vai sair(gravar) o conteudo inserido pelo usuario
			 * OutputStream os = new FileOutputStream("saidaBiblioteca.txt");
			 * OutputStreamWriter osw = new OutputStreamWriter(os);
			 * BufferedWriter bw = new BufferedWriter(osw);
			 * 
			 * System.out.println("Digite sua mensagem:"); while
			 * (entrada.hasNextLine()) { String linha = entrada.nextLine();
			 * bw.write(linha); bw.newLine(); } bw.close(); entrada.close();
			 * 
			 * // EOF para gravar no arquivo // windows Ctrl + Z // linux Ctrl +
			 * D
			 */
			sistema.encerra();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
