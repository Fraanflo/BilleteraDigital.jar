package test;

import banco.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import banco.Moneda;

class ConversorMonedaTest {

	@Test
	void testConvertir() {
/*
 * no me toma el coverage ya que al tratar de instanciar una interfaz (ConversorMoneda) no se puede :(:(
 */
		
		ConversorMoneda conversor = new ConversorMonedaImpl();

		double resultadoEsperado = 110.0;
		double resultadoObtenido = conversor.convertir(100000, Moneda.CLP, Moneda.USD);
		
		assertEquals(resultadoEsperado, resultadoObtenido);
	}
}
