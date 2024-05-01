package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


import banco.Cliente;

import banco.ValidadorEntradaUsuario;

/**
 * clase test de ValidadorEntradaUsuario
 */
class ValidadorEntradaUsuarioTest {

	@Test
	void testSaldoEsSuficiente() {
		Cliente cliente = new Cliente("Juan", 100000);

		// verifico que el saldo del cliente es suficiente
		boolean saldoSuficiente = ValidadorEntradaUsuario.SaldoSuficiente(cliente, 50500);

		// Se espera que el saldo sea suficiente
		assertTrue(saldoSuficiente);
	}

	@Test
	public void testMontoEsValido() {
		// Verificar si el monto 100000 es válido
		boolean resultadoUno = ValidadorEntradaUsuario.MontoEsValido(100000);

		// Se espera que el monto sea válido
		assertTrue(resultadoUno);

		// Verificar si el monto -55 es válido
		boolean resultadoDos = ValidadorEntradaUsuario.MontoEsValido(-55);

		// Se espera que el monto no sea válido por ende de false
		assertFalse(resultadoDos);
	}
}
