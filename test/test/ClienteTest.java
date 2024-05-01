package test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import banco.Cliente;
import banco.TipoTransaccion;
import banco.Transaccion;

/**
 * Pruebas unitarias para la clase Cliente
 */
class ClienteTest {
	/**
	 * test del constructor clase Cliente.
	 */
	@Test
	void testConstructor() {
		Cliente cliente = new Cliente("Juan Pérez", 10000);
		assertEquals("Juan Pérez", cliente.getNombre());
		assertEquals(10000, cliente.getBalance());
	}

	/**
	 * test del método AnadirTransaccion
	 */
	@Test
	public void testAnadirTransaccion() {
		Cliente cliente = new Cliente("Pedro Pérez", 10000);
		Transaccion transaccion = new Transaccion(500, null, TipoTransaccion.DEPOSITO);
		cliente.AnadirTransaccion(transaccion);
		assertEquals(1, cliente.getTransacciones().size());
		assertTrue(cliente.getTransacciones().contains(transaccion));
	}

	/**
	 * test del método setBalance
	 */
	@Test
	public void testSetBalance() {
		Cliente cliente = new Cliente("Maria Gómez", 150000);
		cliente.setBalance(150000);
		assertEquals(150000, cliente.getBalance());
	}

	/**
	 * test del método setNombre
	 */
	@Test
	public void testSetNombre() {
		Cliente cliente = new Cliente("Luis Fuentes", 20000);
		cliente.setNombre("Franco");
		assertEquals("Franco", cliente.getNombre());
	}

	/**
	 * test simulador método AnadirTRansaccion hecho con Mockito
	 */
	@Test
	void testAnadirTransaccionConMockito() {
		// Cliente simulado
		Cliente clienteMock = mock(Cliente.class);

		// simulacion de transaccion
		Transaccion transaccion1 = new Transaccion(100000, null, TipoTransaccion.DEPOSITO);

		// Simulación del método añadirTransaccion
		when(clienteMock.getTransacciones()).thenReturn(null);
		clienteMock.AnadirTransaccion(transaccion1);

		// Verificar que la transacción se haya añadido correctamente
		verify(clienteMock, times(1)).AnadirTransaccion(transaccion1);
	}
}
