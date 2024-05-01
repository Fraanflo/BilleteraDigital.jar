package test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import banco.Cliente;
import banco.GestorBilleteraImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Pruebas unitarias para la clase GestorBilleteraImpl.
 */
class GestorBilleteraImplTest {
	private GestorBilleteraImpl gestor;
	private Cliente cliente;
	private Cliente clienteDos;

	/**
	 * prepara el entorno para cada prueba
	 */
	@BeforeEach
	void inicializar() {
		gestor = new GestorBilleteraImpl(); // Inicializa la variable instancia gestor
		cliente = new Cliente("pepito", 100000); // Inicializa la variable instancia cliente
		clienteDos = new Cliente("pablito", 100000); // Inicializa variable instancia clienteDos
	}

	/**
	 * Prueba del método getBalance
	 */
	@Test
	void testGetBalance() {
		double balance = gestor.getBalance(cliente);
		assertEquals(100000, balance);
	}

	/**
	 * Prueba del método deposito para verificar deposito exitoso
	 */
	@Test
	void testDepositoExitoso() {
		double montoDeposito = 30000;
		gestor.deposito(cliente, montoDeposito);
		assertEquals(130000, cliente.getBalance());
	}

	/**
	 * Prueba del método retiro para verificar retiro exitoso
	 */
	@Test
	void testRetiroExitoso() {
		double montoRetiro = 30000;
		assertTrue(gestor.retiro(cliente, montoRetiro));
		assertEquals(70000, cliente.getBalance());
	}

	/**
	 * Prueba del método transferencia para verificar transferencia exitosa
	 */
	@Test
	void testTransferenciaExitosa() {
		double montoTransferencia = 20000;
		assertTrue(gestor.transferir(cliente, clienteDos, montoTransferencia));
		assertEquals(80000, cliente.getBalance());
		assertEquals(120000, clienteDos.getBalance());
	}
	@Test
	void testTransferenciaExitosaConMockito() {
	Cliente unoMock = mock(Cliente.class);
	Cliente dosMock = mock(Cliente.class);
	GestorBilleteraImpl gestor = new GestorBilleteraImpl();
	double monto = 100000;
	gestor.transferir(unoMock, dosMock, monto);
	verify(unoMock).getBalance();
	
	}
}