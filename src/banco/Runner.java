package banco;

import java.util.Scanner;

import org.junit.Ignore;

/**
 * clase que ejecuta BilleteraDigital
 */
@Ignore
public class Runner {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		// creacion cliente
		Cliente cliente = new Cliente("Pepito López", 100000.0);
		// array de clientes destino ficticios
		Cliente[] clientesDestino = { new Cliente("Pedrito Engel", 50000), new Cliente("Gabriel Muñoz", 50000),
				new Cliente("Manuel Guevara", 50000) };
		// instancia gestion billetera
		GestorBilletera gestorBilletera = new GestorBilleteraImpl();
		// instancia conversor moneda
		ConversorMoneda conversorMoneda = new ConversorMonedaImpl();

		// mensaje bienvenida billetera
		System.out.println("______________________________________________________________");
		System.out.println("Bienvenido a su Billetera. ¡¡ Nos alegra verte nuevamente!! :D ");
		System.out.println("______________________________________________________________");
		while (true) { // menu principal
			System.out.println("\n|¿Qué deseas hacer? :O           |");
			System.out.println("| 1. Consultar mi saldo          |");
			System.out.println("| 2. Realizar depósito           |");
			System.out.println("| 3. Realizar retiro             |");
			System.out.println("| 4. Conversión de moneda        |");
			System.out.println("| 5. Realizar Transferencia	 |");
			System.out.println("| 6. Deseo salir de la billetera |");
			System.out.print(" Selecciona una opción:         ");
			int opcion = scanner.nextInt();

			switch (opcion) {
			case 1: // consultar saldo
				double saldo = gestorBilletera.getBalance(cliente);
				System.out.println("______________________________________________________________");
				System.out.println("Tu saldo actual es: " + saldo + " :)");
				break;
			case 2:// realizar deposito
				System.out.print("Ingresa un monto a depositar: ");
				double montoDeposito = scanner.nextDouble();
				gestorBilletera.deposito(cliente, montoDeposito);
				break;
			case 3: // realizar retiro
				System.out.print("Ingresa un monto a retirar: ");
				double montoRetiro = scanner.nextDouble();
				gestorBilletera.retiro(cliente, montoRetiro);
				break;
			case 4: // conversion de moneda
				System.out.print("Ingresa el monto a convertir: ");
				double monto = scanner.nextDouble();
				if (monto <= 0) {
					System.out.print("El monto ingresado debe ser mayor a 0. Intenta nuevamente :( .");// lanza error si
																										// a 0
					break;
				}
				scanner.nextLine();
				System.out.print("Ingresa la moneda que deseas convertir: USD, EUR, ARS, CLP: ");
				String monedaAConvertirStr = scanner.nextLine().toUpperCase();
				Moneda monedaAConvertir;
				if (monedaAConvertirStr.equals("USD") || monedaAConvertirStr.equals("EUR")
						|| monedaAConvertirStr.equals("ARS") || monedaAConvertirStr.equals("CLP")) {
					monedaAConvertir = Moneda.valueOf(monedaAConvertirStr);
				} else {
					System.out.println("Error: Moneda no válida >:(. Por favor ingresa una de las opciones señaladas.");// lanza
																													// moneda
					continue;
				}

				System.out.print("Ingresa la moneda a la que deseas cambiar: USD, EUR, ARS, CLP: ");
				String monedaConvertidaStr = scanner.nextLine().toUpperCase();

				Moneda monedaConvertida;

				if (monedaConvertidaStr.equals("USD") || monedaConvertidaStr.equals("EUR")
						|| monedaConvertidaStr.equals("ARS") || monedaConvertidaStr.equals("CLP")) {
					monedaConvertida = Moneda.valueOf(monedaConvertidaStr);
				} else {
					System.out.println("Error: Moneda no válida >:(. Por favor ingresa una de las opciones señaladas.");// lanza
																													// moneda
					continue;
				}

				double resultado = conversorMoneda.convertir(monto, monedaAConvertir, monedaConvertida);
				System.out.println("______________________________________________________________");
				System.out.println(
						monto + " " + monedaAConvertir + " equivalen a : " + resultado + " " + monedaConvertida);
				System.out.println("______________________________________________________________");
				break;
			case 5:
				// Realizar transferencia
				System.out.println("_________________________________");

				System.out.println("Realizar Transferencia");
				System.out.println("Contactos Disponibles:");
				for (int i = 0; i < clientesDestino.length; i++) {
					System.out.println((i + 1) + ". " + clientesDestino[i].getNombre());
				}
				System.out.println("_________________________________");
				System.out.println("Selecciona un cliente destino: ");
				System.out.println("_________________________________");
				int indiceDestino = scanner.nextInt();
				if (indiceDestino >= 1 && indiceDestino <= clientesDestino.length) {
					Cliente clienteDestino = clientesDestino[indiceDestino - 1];
					System.out.println("_________________________________");
					System.out.println("Ingresa el monto a transferir: ");
					System.out.println("_________________________________");
					double montoTransferencia = scanner.nextDouble();
					gestorBilletera.transferir(cliente, clienteDestino, montoTransferencia);
				} else {
					System.out.println("ERROR: Ingresa un monto mayor a cero o una opción válida"); // lanza error si se
																									// ingresa un monto
																									// inferior a 0
				}
				break;

			case 6: // salir billetera
				System.out.println("______________________________________________________________");
				System.out.println("¡Adiós, Hasta la próxima! :D ");
				System.out.println("______________________________________________________________");
				scanner.close();
				System.exit(0);
				break;

			default: // si se digita una opcion erronea salta error
				System.out.println("______________________________________________________________");
				System.out.println("ERROR: ingresa una opción válida >:( !!.");
				System.out.println("______________________________________________________________");
			}
		}
	}

}
