package banco;

import java.time.LocalDateTime;

/**
 * Clase que representa una transacción.
 */
public class Transaccion {
	// ATRIBUTOS
	private double monto;
	private LocalDateTime fecha;
	private TipoTransaccion tipoTransaccion;

	/**
	 * Constructor de la clase Transaccion.
	 *
	 * @param monto Monto de la transacción.
	 * @param fecha Fecha y hora de la transacción.
	 * @param tipoTransaccion Tipo de transacción.
	 */
	public Transaccion(double monto, LocalDateTime fecha, TipoTransaccion tipoTransaccion) {

		this.monto = monto;
		this.fecha = fecha;
		this.tipoTransaccion = tipoTransaccion;
	}

	/**
	 * devuelve monto de la transacción.
	 *
	 * @return Monto de la transacción.
	 */
	public double getMonto() {
		return monto;
	}

	/**
	 * Establece monto de la transacción.
	 *
	 * @param monto el nuevo monto de la transacción.
	 */
	public void setMonto(double monto) {
		this.monto = monto;
	}

	/**
	 * Devuelve fecha y hora de la transacción.
	 *
	 * @return fecha y hora de la transacción.
	 */
	public LocalDateTime getFecha() {
		return fecha;
	}

	/**
	 * Establece fecha y hora de la transacción.
	 *
	 * @param fecha nueva fecha y hora de la transacción.
	 */
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	/**
	 * devuelve tipo de transacción.
	 *
	 * @return tipo de transacción.
	 */
	public TipoTransaccion getTipoTransaccion() {
		return tipoTransaccion;
	}

	/**
	 * Establece tipo de transacción.
	 *
	 * @param tipoTransaccion Nuevo tipo de transacción.
	 */
	public void setTipoTransaccion(TipoTransaccion tipoTransaccion) {
		this.tipoTransaccion = tipoTransaccion;
	}

}
