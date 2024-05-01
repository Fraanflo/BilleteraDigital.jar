package banco;

/**
 * Clase que proporciona métodos para validar la entrada del usuario.
 */
public class ValidadorEntradaUsuario {
	/**
	 * Verifica que el saldo de un cliente es suficiente para realizar una
	 * transacción con el monto indicado.
	 *
	 * @param cliente cliente cuyo saldo se va a verificar
	 * @param monto   monto de la transacción a verificar
	 * @return devuelve true si el saldo del cliente es suficiente,si no, false
	 */
	public static boolean SaldoSuficiente(Cliente cliente, double monto) {
		return cliente.getBalance() >= monto;
	}

	/**
	 * Verifica que el monto especificado es válido.
	 *
	 * @param monto monto a verificar
	 * @return devuelve true si el monto es válido, si no, false.
	 */
	public static boolean MontoEsValido(double monto) {
		return monto >= 0;
	}

	
	}
	

