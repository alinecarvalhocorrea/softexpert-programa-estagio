package br.com.biblioteca.codigosparaauxilio;

public class TesteComparacaoDeLong {

	public static void main(String[] args) {
		long a = 1111;
		Long b = 1111l; //Antes: Long b = 1113;

		if(a == b)
		{
		    System.out.println("Iguais");
		}else{
		    System.out.println("Não são iguais");
		}
	}

}
