package test;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import banco.Moneda;

/**
 * Test para la clase Moneda.
 */
class MonedaTest {
	/**
	 * test del método getNombre para verificar que el nombre de la moneda sea
	 * correcto
	 */
	@Test
	void testGetNombreMoneda() {
		Moneda moneda = Moneda.EUR;
		assertEquals("Euro", moneda.getNombreMoneda());
	}

	/**
	 * test del método setNombreMoneda para verificar que se establezca
	 * correctamente el nombre de la moneda.
	 */
	@Test
	void testSetNombreMoneda() {
		Moneda moneda = Moneda.USD;
		moneda.setNombreMoneda("Dolar Estadounidense");
		assertEquals("Dolar Estadounidense", moneda.getNombreMoneda());
	}

	/**
	 * test getSigla para verificar que la sigla de la moneda sea correcta
	 */
	@Test
	void testGetSigla() {
		Moneda moneda = Moneda.CLP;
		assertEquals("CLP", moneda.getSigla());
	}

	/**
	 * test del método setSigla para verificar que se establezca correctamente la
	 * sigla de la moneda
	 */
	@Test
	public void testSetSigla() {
		Moneda moneda = Moneda.EUR;
		moneda.setSigla("EUR");
		assertEquals("EUR", moneda.getSigla());
	}

	/**
	 * test método setSimbolo para verificar que se establezca correctamente el
	 * símbolo de la moneda.
	 */
	@Test
	void testSetSimbolo() {
		Moneda moneda = Moneda.ARS;
		moneda.setSimbolo("$");
		assertEquals("$", moneda.getSimbolo());
	}

	/**
	 * test getSimbolo para verificar que el simbolo de la moneda sea correcto
	 */
	@Test
	void testGetSimbolo() {
		Moneda moneda = Moneda.USD;
		assertEquals("$", moneda.getSimbolo());
	}
	
}
