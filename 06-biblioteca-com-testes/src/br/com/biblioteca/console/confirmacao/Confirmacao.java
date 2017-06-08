package br.com.biblioteca.console.confirmacao;

import java.util.Scanner;

import br.com.biblioteca.objetos.interfaces.ItemBiblioteca;

public class Confirmacao {
	private Scanner scanner;
	private ItemBiblioteca item;
	
	public Confirmacao(Scanner scanner, ItemBiblioteca item){
		this.scanner = scanner;
		this.item = item;
	}
	
	public boolean confirmaEdicao() {
		Class<? extends ItemBiblioteca> classe = item.getClass();
		String nomeClasse = classe.getSimpleName();
		System.out.println("Editar "+nomeClasse+"?");
		System.out.println(item);
		System.out.println("1 - Sim");
		System.out.println("2 - Não");
		System.out.println("Digite: ");
		String decisao = scanner.next();
		if (decisao.equals("1")) {
			return true;
		}
		if (decisao.equals("2")) {
			return false;
		} else {
			System.out.println("Opção inválida. Por favor, digite novamente.");
			confirmaEdicao();
		}
		return false;

	}
	public boolean confirmaRemocao() {
		Class<? extends ItemBiblioteca> classe = item.getClass();
		String nomeClasse = classe.getSimpleName();
		System.out.println("Remover "+nomeClasse+"?");
		System.out.println(item);
		System.out.println("1 - Sim");
		System.out.println("2 - Não");
		System.out.println("Digite: ");
		String decisao = scanner.next();
		if (decisao.equals("1")) {
			return true;
		}
		if (decisao.equals("2")) {
			return false;
		} else {
			System.out.println("Opção inválida. Por favor, digite novamente.");
			confirmaRemocao();
		}
		return false;

	}
}
