package banco;

/**
 * interfaz que define un conversor de monedas
 */
public interface ConversorMoneda {
	/**
	 * 
	 * @param monto           cantidad de dinero a convertir
	 * @param monedaDeOrigen  moneda de origen
	 * @param monedaDeDestino moneda de destino
	 * 
	 */
	double convertir(double monto, Moneda monedaDeOrigen, Moneda monedaDeDestino);
}
