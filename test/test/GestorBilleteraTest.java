package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import banco.Cliente;
import banco.GestorBilletera;
import banco.GestorBilleteraImpl;

/**
 * Pruebas unitarias para la clase GestorBilletera
 */
class GestorBilleteraTest {
	private GestorBilletera gestor;
	private Cliente cliente;
	private Cliente clienteDestino;
	private ByteArrayOutputStream outContent;

	@BeforeEach
	public void inicializar() {
		/**
		 * Inicialización de datos antes de cada prueba
		 */

		gestor = new GestorBilleteraImpl();
		cliente = new Cliente("Fran", 100000);
		clienteDestino = new Cliente("Manuel", 10000);
		outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
	}

	/**
	 * prueba para verificar que se obtenga el balance correcto del cliente
	 */
	@Test
	void testGetBalance() {
		//
		double balance = gestor.getBalance(cliente);

		// Verificación del resultado
		assertEquals(100000, balance);
	}

	/**
	 * prueba para verificar que se realice un depósito correcto en la billetera del
	 * cliente
	 */
	@Test
	public void testDeposito() {
		// act
		gestor.deposito(cliente, 50000);

		// Verifico resultado
		assertEquals(150000, cliente.getBalance());
	}

	/**
	 * prueba para verificar que se realice un retiro correctamente de la billetera
	 * del cliente
	 * 
	 */
	@Test
	void testRetiro() {
		// act
		boolean retiro = gestor.retiro(cliente, 50000);

		// Verifico resultado
		assertTrue(retiro);
		assertEquals(50000, cliente.getBalance());
	}

	/**
	 * prueba para verificar que lance print cuando saldo es insuficiente al retirar
	 */
	@Test
	void testRetiroSaldoInsuficiente() {
		assertFalse(gestor.retiro(cliente, 1000000));
		assertEquals("Error: el monto ingresado no es válido o no tienes saldo suficiente para retirar :(.\n",
				outContent.toString());
	}

	/**
	 * Prueba para verificar que se realice una transferencia correctamente entre 2
	 * clientes
	 * 
	 */
	@Test
	public void testTransferir() {
		// arrange
		Cliente clienteDestino = new Cliente("Manuel", 200000);

		// act
		boolean transferenciaExitosa = gestor.transferir(cliente, clienteDestino, 50000);

		// verifico resultado
		assertTrue(transferenciaExitosa);
		assertEquals(50000, cliente.getBalance());
		assertEquals(250000, clienteDestino.getBalance());

	}

	/**
	 * prueba para verificar que lance print cuando saldo es insuficiente para
	 * transferir
	 * 
	 */
	@Test
	public void testTransferirFalloSaldoInsuficiente() {
		assertFalse(gestor.transferir(cliente, clienteDestino, 2000000));
		assertEquals("Error: el monto ingresado no es válido o no tienes saldo suficiente para transferir :(.\n",
				outContent.toString());
	}
}