package banco;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase Cliente: representa al Cliente de la Billetera.
 */
public class Cliente {
	/**
	 * Atributos
	 */
	private double balance;
	private List<Transaccion> transacciones;
	private String nombre;

	/**
	 * Constructor clase Cliente.
	 * 
	 * @param balanceInicial saldo inicial del cliente.
	 */
	public Cliente(String nombre, double balanceInicial) {
		this.setNombre(nombre);
		this.balance = balanceInicial;
		this.transacciones = new ArrayList<>();
	}

	/**
	 * Obtiene saldo actual del cliente.
	 * 
	 * @return saldo actual
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * establece el saldo del cliente
	 * 
	 * @param balance Saldo nuevo del Cliente.
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}

	/**
	 * Obtiene la lista de transacciones del cliente.
	 * 
	 * @return lista de transacciones del cliente.
	 * 
	 */
	public List<Transaccion> getTransacciones() {
		return transacciones;
	}

	/**
	 * añade una transacción a la lista de transacciones del cliente
	 * 
	 * @param transaccion transaccion que va a añadirse.
	 */
	public void AnadirTransaccion(Transaccion transaccion) {
		transacciones.add(transaccion);
	}

	/**
	 * Obtiene nombre actual del cliente.
	 * 
	 * @return nombre actual
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * establece el nombre del cliente
	 * 
	 * @param nombre nuevo nombre del Cliente.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
