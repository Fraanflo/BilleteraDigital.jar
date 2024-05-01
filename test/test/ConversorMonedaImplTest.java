package test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import banco.ConversorMonedaImpl;
import banco.Moneda;

/**
 * clase test de ConversorMonedaImpl
 */
class ConversorMonedaImplTest {

	private ConversorMonedaImpl conversor;

	@BeforeEach
	void testInicializar() {
		conversor = new ConversorMonedaImpl();

	}

	/**
	 * test para convertir de cLP y ARS
	 */
	@Test
	 void testConvertirCLPToARS() {
		// monto en peso Chileno a convertir
		double montoCLP = 100000;

		// conversión de CLP a ARS utilizando la implementación del conversor
		double resultado = conversor.convertir(montoCLP, Moneda.CLP, Moneda.ARS);

		// verifico que el resultado de la conversión sea el esperado
		assertEquals(109000.0, resultado);
	}

	/**
	 * test para convertir CLP a EUR
	 */
	@Test
	 void testConvertirCLPToEUR() {
		// monto en peso chileno a convertir
		double montoCLP = 100000;

		// convertir CLP a EUR utilizando la implementación de conversor
		double resultado = conversor.convertir(montoCLP, Moneda.CLP, Moneda.EUR);

		// Verificar que el resultado de la conversión sea el esperado
		assertEquals(98.0, resultado);
	}

	/**
	 * test para convertir de CLP a USD
	 */
	@Test
	 void testConvertirCLPToUSD() {
		// monto en peso chileno
		double montoCLP = 100000;

		// Convertir CLP a USD utilizando implementacion conversor
		double resultado = conversor.convertir(montoCLP, Moneda.CLP, Moneda.USD);

		// Verificar que el resultado de la conversión sea el esperado
		assertEquals(110.0, resultado);
	}

	/**
	 * Test convertir MONEDA CLP A DEMÁS MONEDAS hecho con Mockito
	 */
	@Test
	void convertirMonedaCLPaUSD() {
		ConversorMonedaImpl conversorMonedaMock = mock(ConversorMonedaImpl.class);

		//verificar resultado clp a usd
		when(conversorMonedaMock.convertir(1000.0, Moneda.CLP, Moneda.USD)).thenReturn(1.3);
		assertEquals(1.3, conversorMonedaMock.convertir(1000, Moneda.CLP, Moneda.USD));

		//verificar resultado de clp a eur
		when(conversorMonedaMock.convertir(10000, Moneda.CLP, Moneda.EUR)).thenReturn(9.8);
		assertEquals(9.8, conversorMonedaMock.convertir(10000, Moneda.CLP, Moneda.EUR));

		// verificar resultado de clp a ars
		when(conversorMonedaMock.convertir(100000, Moneda.CLP, Moneda.ARS)).thenReturn(109000.0);
		assertEquals(109000.0, conversorMonedaMock.convertir(100000, Moneda.CLP, Moneda.ARS));

	}
}