package br.com.biblioteca.objetos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import br.com.biblioteca.objetos.interfaces.ItemBiblioteca;
import br.com.biblioteca.objetos.verificacoes.VerificaLivro;

/**
 * 
 * @author aline.correa
 *
 */

public class Livro implements Comparable<Livro>, ItemBiblioteca {
	private static int contadorParaDigitoVerificador = 0;
	private int contador;
	private int digitoVerificador;
	private CodigoSequencial codigo = new CodigoSequencial();
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

	public Livro() {
		setContador(getContador() + 1);
		setCodigoSequencial(codigo.criarCodigoAutor());
		contadorParaDigitoVerificador += 1;
		setDigitoVerificador(getDigitoVerificador());
		if (contadorParaDigitoVerificador == 10) {
			contadorParaDigitoVerificador = 0;
			setDigitoVerificador(contadorParaDigitoVerificador);
		}
		setCodigoDeBarras();
	}

	public Livro(Set<Autor> autor, Categoria categoria, String titulo, String local) throws NullPointerException {
		try {
			VerificaLivro verificacao = new VerificaLivro();
			verificacao.verificacaoDeDadosLivro(this);
			setContador(getContador() + 1);
			setCodigoSequencial(getContador());
			contadorParaDigitoVerificador += 1;
			setDigitoVerificador(contadorParaDigitoVerificador);
			if (contadorParaDigitoVerificador == 10) {
				contadorParaDigitoVerificador = 0;
				setDigitoVerificador(contadorParaDigitoVerificador);
			}
			setCodigoDeBarras();
			setAutor(autor);
			setCategoria(categoria);
			setTitulo(titulo);
			setLocal(local);
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}

	}

	// Métodos Static

	private void setContador(int contador) {
		this.contador = contador;
	}

	private int getContador() {
		return contador;
	}

	// Métodos Private

	private void verificarDataDeAquisicao(Calendar dataVerifica) throws DataInvalidaException {
		Calendar dataDeHoje = Calendar.getInstance();
		if (dataVerifica.getTime().after(dataDeHoje.getTime())) {
			throw new DataInvalidaException("*** ERRO: Data inserida posterior a data atual! ***");
			// return false;
		}
		// return true;
	}

	private void setDigitoVerificador(int digitoVerificador) {
		this.digitoVerificador = digitoVerificador;
	}

	private int getDigitoVerificador() {
		return this.digitoVerificador;
	}

	// Métodos Public

	public void setCodigoSequencial(int contador) {
		String codigoString = String.valueOf(contador);
		this.codigoSequencial = codigoString;
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

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public String getResumo() {
		return this.resumo;
	}

	public void setCodigoDeBarras() {
		// 13 digitos
		// 3 primeiros digitos: prefixo do pais de registro da empresa(789)
		// do quarto ao nono digito: Identificação da empresa(456789)
		// do décimo ao décimo segundo: Referência do produto(codSequencial -
		// 001)
		// décimo terceiro: Digito verificador(5)
		int prefixoDoPaisDeRegistroDaEmpresa = 847;
		int identificadorDaEmpresa = 892174;
		String codigoSequencial = this.getCodigoSequencial();
		int digitoVerificador = this.getDigitoVerificador();
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

	public void setDataDeAquisicao(String dataDeAquisicao)
			throws FormatoDeDataInvalidoException, DataInvalidaException {
		try {
			Date date = formatoData.parse(dataDeAquisicao);
			Calendar dataVerifica = Calendar.getInstance();
			dataVerifica.setTime(date);

			verificarDataDeAquisicao(dataVerifica);

			this.dataDeAquisicao = Calendar.getInstance();
			this.dataDeAquisicao.setTime(date);

		} catch (ParseException e) {
			// formato inserido
			throw new FormatoDeDataInvalidoException(
					"Data inserida invalida, por favor utilize o formato (dd/mm/yyyy)");
		}
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
				+ " | Autor(es/a/as): " + autor + " | Código De Barras: " + codigoDeBarras + " | Data de Aquisição: "
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
