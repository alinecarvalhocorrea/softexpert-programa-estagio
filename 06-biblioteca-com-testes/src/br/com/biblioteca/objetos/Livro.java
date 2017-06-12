package br.com.biblioteca.objetos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import br.com.biblioteca.objetos.interfaces.ItemBiblioteca;
import br.com.biblioteca.objetos.verificacoes.AttributeCreationException;

/**
 * 
 * @author aline.correa
 *
 */

public class Livro implements Comparable<Livro>, ItemBiblioteca {
	private int digitoVerificador;
	private CodigoSequencial codigo = new CodigoSequencial();
	private String codigoSequencial;
	private String titulo;
	private String resumo;
	private String codigoDeBarras;
	private String quantidadeDePaginas;
	private String local;
	private Calendar dataDeAquisicao;
	private Set<Autor> autor;
	private Categoria categoria;
	private static final SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");

	// Construtores

	public Livro() {
		setCodigoSequencial(codigo.criarCodigoLivro());
		setDigitoVerificador();
		setCodigoDeBarras();
	}
	
	// Métodos Private
	
	private void setCodigoDeBarras() {
		int prefixoDoPaisDeRegistroDaEmpresa = 789;
		int identificadorDaEmpresa = 73217;
		String codigoSequencial = verificaCodigoSequencial(this.getCodigoSequencial());
		int digitoVerificador = this.getDigitoVerificador();
		String stringCodigoDeBarras = "" + prefixoDoPaisDeRegistroDaEmpresa + identificadorDaEmpresa + codigoSequencial
				+ digitoVerificador;
		this.codigoDeBarras = stringCodigoDeBarras;
	}

	private void verificarDataDeAquisicao(Calendar dataVerifica) throws DataInvalidaException {
		Calendar dataDeHoje = Calendar.getInstance();
		if (dataVerifica.getTime().after(dataDeHoje.getTime())) {
			throw new DataInvalidaException("*** ERRO: Data inserida posterior a data atual! ***");
		}
	}

	private void setDigitoVerificador() {
		List<Integer> numeros = calculaDigitoVerificador();
		this.digitoVerificador = numeros.get(12);
	}
	
	private String verificaCodigoSequencial(String codigo){
		if(!(codigo.length() == 4)){
			for(int tamanho = codigo.length();tamanho != 4;){
				codigo = "0" + codigo;
				tamanho = codigo.length();
			}
		}
		return codigo;
	}
	
	private List<Integer> calculaDigitoVerificador(){
		String codigoSequencial = verificaCodigoSequencial(this.getCodigoSequencial());
		List<Integer> numeros = new ArrayList<>();
		numeros.add(7);	
		numeros.add(8);	
		numeros.add(9);	
		numeros.add(7);	
		numeros.add(3);	
		numeros.add(2);	
		numeros.add(1);	
		numeros.add(7);	
		for(int posicao = 0;posicao < 4;posicao++){
			String num = String.valueOf(codigoSequencial.charAt(posicao));
			int numero = Integer.parseInt(num);
			numeros.add(numero);
		}
		int somaImpares = 0;
		int somaPares = 0;
			//soma dos numeros nas posicões pares
			for(int posicao = 0; posicao < 11;){
				int num = numeros.get(posicao);
				somaPares += num;
				posicao += 2;
			}
			//soma dos numeros nas posicões impares
			for(int posicao = 1; posicao <= 11;){
				int num = numeros.get(posicao);
				somaImpares += num;
				posicao += 2;
			}
			int numPares = somaPares * 3;
			int numeroFinal = somaImpares + numPares;
			int contador = 0;
			while(numeroFinal%10 != 0){
				numeroFinal = numeroFinal+1;
				contador += 1;
			}	
			numeros.add(contador);
			return numeros;
	}
	
	private void setCodigoSequencial(int contador) {
		String codigoString = String.valueOf(contador);
		this.codigoSequencial = codigoString;
	}

	// Métodos Public
	
	public int getDigitoVerificador() {
		return this.digitoVerificador;
	}
	
	public String getCodigoSequencial() {
		return this.codigoSequencial;
	}
	
	public void verificacaoDeDadosLivro() throws AttributeCreationException{
		if (this.getTitulo() == null) {
			throw new AttributeCreationException("*** ERRO: O livro está sem titulo. Por favor, informe o título. ***");
		}
		if(this.getAutor().isEmpty()){
			throw new AttributeCreationException("*** ERRO: O livro está sem autor. Por Favor, informe pelo menos um(a) autor(a). ***");
		}
		if(this.getCategoria() == null){
			throw new AttributeCreationException("*** ERRO: O livro está sem categoria. Por favor, informe a categoria do livro. ***");
		}
		if (this.getLocal() == null) {
			throw new AttributeCreationException("*** ERRO: O livro está sem local. Por favor, informe o local do livro. ***");
		}
	}

	public void setTitulo(String titulo) {
		titulo = titulo.toUpperCase();
		this.titulo = titulo;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setResumo(String resumo) {
		try{
			if(resumo.equals("")){
				this.resumo = "*** Resumo não informado ***";
			}else{
				this.resumo = resumo;
			}
		}catch(NullPointerException e){
			this.resumo = "*** Resumo não informado ***";
		}
	}

	public String getResumo() {
		return this.resumo;
	}

	public String getCodigoDeBarras() {
		return this.codigoDeBarras;
	}

	public void setQuantidadeDePaginas(String quantidadeDePaginas) {
		try{
			if(quantidadeDePaginas.equals("")){
				this.quantidadeDePaginas = "*** Quantidade de páginas não informado ***";
			}else{
				this.quantidadeDePaginas = quantidadeDePaginas;
			}
		}catch(NullPointerException e){
			this.quantidadeDePaginas = "*** Quantidade de páginas não informado ***";
		}
	}

	public String getQuantidadeDePaginas() {
		return this.quantidadeDePaginas;
	}

	public void setLocal(String local) {
		local = local.toUpperCase();
		this.local = local;
	}

	public String getLocal() {
		return this.local;
	}

	public void setDataDeAquisicao(String dataDeAquisicao) throws FormatoDeDataInvalidoException, DataInvalidaException {
		try {
			Date date = formatoData.parse(dataDeAquisicao);
			Calendar dataVerifica = Calendar.getInstance();
			dataVerifica.setTime(date);

			verificarDataDeAquisicao(dataVerifica);

			this.dataDeAquisicao = Calendar.getInstance();
			this.dataDeAquisicao.setTime(date);

		} catch (ParseException e) {
			throw new FormatoDeDataInvalidoException("Data inserida invalida, por favor utilize o formato (dd/mm/yyyy)");
		}catch (NullPointerException e){
			this.dataDeAquisicao = null;
			return;
		}
	}

	public String getDataDeAquisicao() {
		try{
			if (this.dataDeAquisicao.equals(null)) {
				return "*** Data de Aquisição não informada ***";
			}
			if (this.dataDeAquisicao.equals("")) {
				return "*** Data de Aquisição não informada ***";
			}
			String dataString = formatoData.format(this.dataDeAquisicao.getTime());
			return dataString;
		}catch(NullPointerException e ){
			return "*** Data de Aquisição não informada ***";
		}
	}

	public void setAutor(Set<Autor> autor) {
		this.autor = autor;
	}

	public Set<Autor> getAutor() {
		return this.autor;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	// Métodos da classe

	@Override
	public int compareTo(Livro outroLivro) {

		if (this.titulo != null) {
			int comparacao = this.titulo.compareTo(outroLivro.getTitulo());

			if (comparacao != 0) {
				return comparacao;
			}
		}
		if (this.codigoSequencial != null) {
			int comparacaoCodigoSequencial = this.codigoSequencial.compareTo(outroLivro.getCodigoSequencial());

			if (comparacaoCodigoSequencial != 0) {
				return comparacaoCodigoSequencial;
			}
		}
		return 0;
	}

	@Override
	public String toString() {
		return "Livro: " + titulo + ", (" + quantidadeDePaginas + " Páginas) | Categoria: " + categoria
				+ " | Autor(es/a/as): " + autor + " | Código De Barras: " + codigoDeBarras + " | Código Sequencia: " + codigoSequencial + " | Data de Aquisição: "
				+ getDataDeAquisicao() + " | Resumo: " + resumo + ".";

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoSequencial == null) ? 0 : codigoSequencial.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		if (codigoSequencial == null) {
			if (other.codigoSequencial != null)
				return false;
		} else if (!codigoSequencial.equals(other.codigoSequencial))
			return false;
		return true;
	}

}
