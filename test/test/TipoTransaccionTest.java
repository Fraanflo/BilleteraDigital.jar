package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import banco.TipoTransaccion;

/**
 * Pruebas unitarias para la enumeración TipoTransaccion
 */
class TipoTransaccionTest {

	@Test
	void testValue() {
		/**
		 * Prueba del método values para verificar que la enumeración tiene los valores
		 * correctos.
		 */
		TipoTransaccion[] values = TipoTransaccion.values();
		assertEquals(3, values.length);
		assertEquals(TipoTransaccion.DEPOSITO, values[0]); // Verificar primer valor
		assertEquals(TipoTransaccion.RETIRO, values[1]); // Verificar segundo valor
		assertEquals(TipoTransaccion.TRANSFERENCIA, values[2]); // Verificar tercer valor

	}

}
