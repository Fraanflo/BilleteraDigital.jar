package test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import banco.TipoTransaccion;
import banco.Transaccion;

/**
 * Pruebas unitarias de la clase Transacción
 */
class TransaccionTest {

	/**
	 * Prueba de los get y set de la clase Transaccion
	 */
	@Test
	void testGetterYSetters() {
		// Crear un test transaccion con monto de 100000
		double monto = 100000.0;
		LocalDateTime fecha = LocalDateTime.now();
		TipoTransaccion tipoTransaccion = TipoTransaccion.DEPOSITO;

		Transaccion transaccion = new Transaccion(monto, fecha, tipoTransaccion);

		// verifico los valores obtenidos a través de los getters
		assertEquals(monto, transaccion.getMonto());
		assertEquals(fecha, transaccion.getFecha());
		assertEquals(tipoTransaccion, transaccion.getTipoTransaccion());

		// modifico los valores utilizando los set
		double nuevoMonto = 150000.0;
		LocalDateTime nuevaFecha = LocalDateTime.now().minusDays(10);
		TipoTransaccion nuevoTipoTransaccion = TipoTransaccion.RETIRO;
		transaccion.setMonto(nuevoMonto);
		transaccion.setTipoTransaccion(nuevoTipoTransaccion);
		transaccion.setFecha(nuevaFecha);

		// verifico que los valores se hayan modificado
		assertEquals(nuevoMonto, transaccion.getMonto());
		assertEquals(nuevaFecha, transaccion.getFecha());
		assertEquals(nuevoTipoTransaccion, transaccion.getTipoTransaccion());
	}

	/**
	 * test con mockito de get y set TipoTransaccion
	 */
	@Test
	void testGetySetTipoTransaccionMockito() {
		// creación mock de transaccion
		Transaccion transaccionMock = mock(Transaccion.class);
		TipoTransaccion tipoTransaccion = TipoTransaccion.DEPOSITO;
		when(transaccionMock.getTipoTransaccion()).thenReturn(tipoTransaccion);

		// llamar método setTipoTransaccion
		transaccionMock.setTipoTransaccion(tipoTransaccion);

		// llamar método getTipoTransaccion y que devuelva tipo de transaccion
		assertEquals(tipoTransaccion, transaccionMock.getTipoTransaccion());
	}

}
