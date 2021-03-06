package br.com.biblioteca.objetos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

import br.com.biblioteca.objetos.interfaces.ItemBiblioteca;
import br.com.biblioteca.objetos.verificacoes.VerificaLivro;

public class Livro implements Comparable<Livro>,ItemBiblioteca {
	static private int contadorDeLivrosRegistrados = 0;
	private int digitoVerificador;
	private String codigoSequencial;
	private String titulo;
	private String resumo;
	private String codigoDeBarras;
	private int quantidadeDePaginas;
	private String local;
	private Calendar dataDeAquisicao;
	private Set<Autor> autor;
	private Categoria categoria;
	private static final SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");

	// Construtores
	public Livro(){
		setCodigoSequencial();
		contadorDeLivrosRegistrados += 1;
		setDigitoVerificador(contadorDeLivrosRegistrados);
			if (contadorDeLivrosRegistrados == 10) {
				contadorDeLivrosRegistrados = 0;
				setDigitoVerificador(contadorDeLivrosRegistrados);
			}
		setCodigoDeBarras();
	}
	
	public Livro(Set<Autor> autor, Categoria categoria, String titulo, String local) throws NullPointerException{
			try{
				VerificaLivro verificacao = new VerificaLivro();
				verificacao.verificacaoDeDadosLivro(this);
				setCodigoSequencial();
				contadorDeLivrosRegistrados += 1;
				setDigitoVerificador(contadorDeLivrosRegistrados);
				if (contadorDeLivrosRegistrados == 10) {
					contadorDeLivrosRegistrados = 0;
					setDigitoVerificador(contadorDeLivrosRegistrados);
				}
				setCodigoDeBarras();
				setAutor(autor);
				setCategoria(categoria);
				setTitulo(titulo);
				setLocal(local);
			}catch(NullPointerException e){
				System.out.println(e.getMessage());
			}
			
	}

	// M�todos da classe

	// CompareTO : titulo e codSequencial
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
		return "Livro: " + titulo + ", (" + quantidadeDePaginas + " P�ginas) | Categoria: " + categoria +" | Autor(es/a/as): " + autor  + " | C�digo De Barras: " + codigoDeBarras + " | Data de Aquisi��o: " + getDataDeAquisicao() + " | Resumo: "+ resumo +".";
		
	}

	// Getters e Setters
	public void setCodigoSequencial() {
		UUID idOne = UUID.randomUUID();
		this.codigoSequencial = idOne.toString().replaceAll("-", "");
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

	public String getCodigoSequencial() {
		return this.codigoSequencial;
	}

	public void setTitulo(String titulo) {
		titulo = titulo.toUpperCase();
		this.titulo = titulo;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public String getResumo() {
		return this.resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public void setCodigoDeBarras() {
		// 13 digitos
		// 3 primeiros digitos: prefixo do pais de registro da empresa(789)
		// do quarto ao nono digito:identificacao da empresa(456789)
		// do decimo ao decimo segundo:referencia do produto(codSequencial -
		// 001)
		// decimo terceiro: digito verificador(5)
		int prefixoDoPaisDeRegistroDaEmpresa = 847;
		int identificadorDaEmpresa = 892174;
		String codigoSequencial = this.getCodigoSequencial();
		int digitoVerificador = this.getDigitoVerificador();

		// TODO Livro: tem que retirar/usar apenas 3 numeros do CodSequencial
		// para utilizar no codDeBarras
		String stringCodigoDeBarras = "" + prefixoDoPaisDeRegistroDaEmpresa + identificadorDaEmpresa + codigoSequencial
				+ digitoVerificador;
		this.codigoDeBarras = stringCodigoDeBarras;
	}

	public String getCodigoDeBarras() {
		return this.codigoDeBarras;
	}

	public void setQuantidadeDePaginas(int quantidadeDePaginas) {
		this.quantidadeDePaginas = quantidadeDePaginas;
	}

	public int getQuantidadeDePaginas() {
		return this.quantidadeDePaginas;
	}

	public void setLocal(String local) {
		local = local.toUpperCase();
		this.local = local;
	}

	public String getLocal() {

		return this.local;
	}

	public void setDataDeAquisicao(String dataDeAquisicao) {
		try {
			Date date = formatoData.parse(dataDeAquisicao);
			Calendar dataVerifica = Calendar.getInstance();
			dataVerifica.setTime(date);
			if (verificarDataDeAquisicao(dataVerifica)) {
				this.dataDeAquisicao = Calendar.getInstance();
				this.dataDeAquisicao.setTime(date);
			} else {
				System.out.println("######################" + dataDeAquisicao);
			}
		} catch (ParseException e) {
			throw new IllegalArgumentException("Data inserida invalida, por favor utilize o formato (dd/mm/yyyy)");
		}
	}

	private boolean verificarDataDeAquisicao(Calendar dataVerifica) {
		Calendar dataDeHoje = Calendar.getInstance();
		if (dataVerifica.getTime().after(dataDeHoje.getTime())) {
			return false;
		}
		return true;
	}

	public String getDataDeAquisicao() {
		if (this.dataDeAquisicao == null) {
			return "";
		}
		String dataString = formatoData.format(this.dataDeAquisicao.getTime());
		return dataString;
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

	public String getCategoria() {
		Categoria categoriaDesseLivro = this.categoria;
		String descricaoCategoriaDesseLivro = categoriaDesseLivro.getDescricao();
		return descricaoCategoriaDesseLivro;
	}

	public int getDigitoVerificador() {
		return this.digitoVerificador;
	}

	public void setDigitoVerificador(int digitoVerificador) {
		this.digitoVerificador = digitoVerificador;
	}

}
