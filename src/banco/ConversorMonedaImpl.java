package banco;

import java.util.HashMap;
import java.util.Map;

/**
 * Implementación de la interfaz ConversorMoneda que convierte un monto de
 * dinero de una moneda a otra segun tipo de cambio
 *
 */
public class ConversorMonedaImpl implements ConversorMoneda {
	/**
	 * Mapa que almacena las tasas de cambio para cada moneda.
	 */
	private Map<Moneda, Double> tipoDeCambio;

	/**
	 * Constructor de la clase ConversorMonedaImpl almacena tipo de cambio con tasas
	 * de cambio predefinidas.
	 */

	public ConversorMonedaImpl() {
		tipoDeCambio = new HashMap<>();
		cargarTipoDeCambio();
	}

	/**
	 * inicializa el tipo de cambio predefinido
	 */
	private void cargarTipoDeCambio() {
		tipoDeCambio.put(Moneda.ARS, 1.09); // moneda Argentina
		tipoDeCambio.put(Moneda.CLP, 1.0); // moneda Chilena
		tipoDeCambio.put(Moneda.EUR, 0.00098); // Euro
		tipoDeCambio.put(Moneda.USD, 0.0011); // dólar Estadounidense

	}

	/**
	 * Convierte una cantidad de dinero de una moneda a otra utilizando las tasas de
	 * cambio definidas.
	 *
	 * @param monto           Cantidad de dinero a convertir.
	 * @param monedaDeOrigen  La moneda de ORIGEN.
	 * @param monedaDeDestino La moneda de DESTINO.
	 * @return cantidad convertida en la moneda de destino con monto redondeado.
	 */
	@Override
	public double convertir(double monto, Moneda monedaDeOrigen, Moneda monedaDeDestino) {

		double TasaAConvertir = tipoDeCambio.get(monedaDeOrigen);
		double TasaConvertida = tipoDeCambio.get(monedaDeDestino);

		return Math.round((monto * TasaConvertida / TasaAConvertir) * 100.0) / 100.0;

	}

}
