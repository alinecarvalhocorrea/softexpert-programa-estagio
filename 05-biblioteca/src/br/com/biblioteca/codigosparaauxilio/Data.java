package br.com.biblioteca.codigosparaauxilio;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Data {

	private static Scanner leitura;

	public static void main(String[] args) {
		try{
		leitura = new Scanner(System.in);
	    System.out.println("Digite uma data: ");
		String entrada = leitura.nextLine();
		
		Calendar dataUsuario = Calendar.getInstance();
		Calendar dataDeHoje = Calendar.getInstance();
		String[] dataUsuarioArray = entrada.split("\\/");
		
		dataUsuario.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dataUsuarioArray[0]));
		dataUsuario.set(Calendar.MONTH, Integer.parseInt(dataUsuarioArray[1])-1);
		dataUsuario.set(Calendar.YEAR, Integer.parseInt(dataUsuarioArray[2]));
		
		SimpleDateFormat formatoData = new SimpleDateFormat("dd/MMMM/yyyy");
		String dataUserString = formatoData.format(dataUsuario.getTime());
		System.out.println("Data inserida: "+ dataUserString);
		
		if (dataUsuario.getTime().after(dataDeHoje.getTime())) {
			System.out.println("Data de aquisição inválida : Data inserida futura a data atual (" + formatoData.format(dataDeHoje.getTime()) + ")" );
		} else {
			System.out.println("Data de aquisição valida");
		}
		
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
	}
		
}
