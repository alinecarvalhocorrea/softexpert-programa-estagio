package br.com.biblioteca.console.cadastro;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import br.com.biblioteca.console.lista.ListaDeAutores;
import br.com.biblioteca.console.lista.ListaDeCategorias;
import br.com.biblioteca.objetos.Autor;
import br.com.biblioteca.objetos.Categoria;
import br.com.biblioteca.objetos.Livro;
import br.com.biblioteca.repositorios.interfaces.Autores;
import br.com.biblioteca.repositorios.interfaces.Categorias;
import br.com.biblioteca.repositorios.interfaces.Livros;

public class CadastroDeLivro {
	private Scanner scanner;
	private static Livros bancoDeLivros;
	private static Autores bancoDeAutores;
	private static Categorias bancoDeCategorias;
	
	public CadastroDeLivro(Scanner scanner, Livros bancoDeLivros, Autores bancoDeAutores,Categorias bancoDeCategorias){
		this.scanner = scanner;
		CadastroDeLivro.bancoDeLivros = bancoDeLivros;
		CadastroDeLivro.bancoDeAutores = bancoDeAutores;
		CadastroDeLivro.bancoDeCategorias = bancoDeCategorias;
	}
	
	public void cadastrarLivro(){	
		scanner.nextLine();
		Livro novoLivro = new Livro();
		
		System.out.println("ATENÇÃO: CAMPOS COM * DEVEM SER OBRIGATORIAMENTE PREENCHIDOS");
		System.out.println("\n");
		
		System.out.println("*Insira o título do livro*:");
			String titulo = scanner.nextLine();
			novoLivro.setTitulo(titulo);	
			
		System.out.println("*Insira o local do livro*:");
			String local = scanner.nextLine();
			novoLivro.setLocal(local);
			
		System.out.println("Insira a quantidade de páginas do livro:");
			String quantidadeDePaginas = scanner.nextLine();
			
		System.out.println("*Insira a data de aquisição do livro(dd/mm/aaaa)*:");
			String dataDeAquisicao = scanner.nextLine();
			
		System.out.println("==== *Escolha a Categoria* ====");
		
			ListaDeCategorias listaDeCategorias = new ListaDeCategorias(bancoDeCategorias);
			listaDeCategorias.listarCategorias();
			
		System.out.println("*Insira o código sequencial da categoria do livro*:");
		
			String codigoCategoria = scanner.nextLine();
			Categoria categoria = bancoDeCategorias.buscarPorCodigoSequencial(codigoCategoria);
			novoLivro.setCategoria(categoria);
			
		System.out.println("Insira o resumo do livro: ");
			String resumo = scanner.nextLine();
		
		System.out.println("*Insira o número de autores(as) do livro*:");
			String numeroDeAutores = scanner.nextLine();
			int numero = Integer.parseInt(numeroDeAutores);
			Set<Autor> autoresDoLivro = new TreeSet<>();
			
		System.out.println("==== *Lista de Autores(as)* ====");

			ListaDeAutores listaDeAutores = new ListaDeAutores(bancoDeAutores);
			listaDeAutores.listarAutores();

			if(numero == 1){
				System.out.println("*Insira o código sequencial do autor(a) do livro*:");
					String codigoAutor = scanner.nextLine();
					Autor autor = bancoDeAutores.buscarPorCodigoSequencial(codigoAutor);
					autoresDoLivro.add(autor);
			}
			if(numero > 1){
				for(int contador = 1;contador <= numero;contador++){
					System.out.println("*Insira o código sequencial do autor " + contador +" do livro*:");
						String codigoAutor = scanner.nextLine();
						Autor autor = bancoDeAutores.buscarPorCodigoSequencial(codigoAutor);
						autoresDoLivro.add(autor);				}
			}
			
			novoLivro.setAutor(autoresDoLivro);
			
			if(!dataDeAquisicao.equals(null)){
				try{
					novoLivro.setDataDeAquisicao(dataDeAquisicao);
				}catch(IllegalArgumentException e){
					e.printStackTrace();
				}
			}
			if(!resumo.equals(null)){
				novoLivro.setResumo(resumo);
			}
			if(quantidadeDePaginas != null){
				int paginas = Integer.parseInt(quantidadeDePaginas);
				novoLivro.setQuantidadeDePaginas(paginas);
			}
			
			bancoDeLivros.adicionar(novoLivro);
			
			System.out.println("Novo livro Criado !!!");
			System.out.println(novoLivro);
			
		}
	}
