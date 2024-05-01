package banco;

/**
 * Enumeración que representa diferentes tipos de monedas.
 */
public enum Moneda {

	/**
	 * Moneda CLP:Peso Chileno.
	 */
	CLP("CLP", "$", "Peso Chileno"),
	/**
	 * Moneda EUR: Euro.
	 */
	EUR("EUR", "€", "Euro"),
	/**
	 * Moneda USD: Dólar.
	 */
	USD("USD", "$", "Dolar Estadounidense"),
	/**
	 * Moneda ARS: Peso Argentino.
	 */
	ARS("ARS", "$", "Peso Argentino");

	// ATRIBUTOS
	private String sigla;
	private String simbolo;
	private String nombreMoneda;

	/**
	 * Constructor de enum Moneda.
	 *
	 * @param sigla        Sigla de la moneda.
	 * @param simbolo      símbolo de la moneda.
	 * @param nombreMoneda Nombre de la moneda.
	 */
	Moneda(String sigla, String simbolo, String nombreMoneda) {
		this.sigla = sigla;
		this.simbolo = simbolo;
		this.nombreMoneda = nombreMoneda;
	}

	/**
	 * Obtiene sigla de la moneda.
	 *
	 * @return La sigla de la moneda.
	 */
	public String getSigla() {
		return sigla;
	}

	/**
	 * establece sigla de la moneda.
	 *
	 * @param sigla nueva sigla de la moneda.
	 */
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	/**
	 * Obtiene Simbolo de la moneda.
	 *
	 * @return simbolo de la moneda.
	 */
	public String getSimbolo() {
		return simbolo;
	}

	/**
	 * establece simbolo de la moneda.
	 *
	 * @param simbolo nuevo simbolo de la moneda.
	 */
	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}

	/**
	 * Obtiene nombre de la moneda.
	 *
	 * @return La nombre de la moneda.
	 */
	public String getNombreMoneda() {
		return nombreMoneda;
	}

	/**
	 * establece nombre de la moneda.
	 *
	 * @param nombreMoneda nuevo nombre de la moneda.
	 */
	public void setNombreMoneda(String nombreMoneda) {
		this.nombreMoneda = nombreMoneda;
	}

}
