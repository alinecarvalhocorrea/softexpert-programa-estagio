package com.biblioteca.codigosparaauxilio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * 
 * @author aline.correa
 *Método para ordenar em ordem alfabetica
 */
public class ordenarListPorString {
	public static void main(String[] args){
		
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
