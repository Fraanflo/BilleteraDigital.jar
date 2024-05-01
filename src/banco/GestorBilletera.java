package banco;

/**
 * Interfaz que define operaciones para gestionar la billetera del cliente.
 */
public interface GestorBilletera {
	/**
	 * Obtiene el balance actual del cliente.
	 * 
	 * @param cliente Cliente del cual se desea obtener el balance.
	 * @return balance actual del cliente.
	 */
	double getBalance(Cliente cliente);

	/**
	 * Realiza un depósito en la billetera del cliente.
	 *
	 * @param cliente Cliente que en su billetera se realizará el depósito.
	 * @param monto   El monto que se depositará.
	 */
	void deposito(Cliente cliente, double monto);

	/**
	 * Realiza un retiro de la billetera del cliente.
	 *
	 * @param cliente Cliente que en su billetera se realizará el retiro.
	 * @param monto   El monto que se retirará.
	 * @return devuelve TRUE si el retiro se realizó con bien, FALSE en caso
	 *         contrario.
	 */
	boolean retiro(Cliente cliente, double monto);

	/**
	 * Realiza transferencia de monto de un cliente a otro.
	 *
	 * @param cliente         Cliente desde donde se realizaráa la transferencia.
	 * @param clientesDestino Cliente a quien se realizará la transferencia.
	 * @param monto           El monto que se transferirá.
	 * @return TRUE si la transferencia se realizó correctamente, si no FALSE.
	 */

	boolean transferir(Cliente cliente, Cliente clientesDestino, double monto);
}