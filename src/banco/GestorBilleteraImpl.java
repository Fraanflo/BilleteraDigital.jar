package banco;

import java.time.LocalDateTime;
/**
 * Implementación de la interfaz GestorBilletera que otorga operaciones para gestionar la billetera deL cliente.
 */
public class GestorBilleteraImpl implements GestorBilletera {
	 /**
     * Obtiene el balance actual del cliente.
     *
     * @param cliente Cliente del cual se va a obtener el balance.
     * @return Balance actual del cliente.
     */
    @Override
    public double getBalance(Cliente cliente) {
        return cliente.getBalance();
    }
    /**
     * Realiza un depósito en la billetera del cliente.
     *
     * @param cliente cliente que realizará el depósito en su billetera.
     * @param monto   El monto que se va a depositar.
     */
    @Override
    public void deposito(Cliente cliente, double monto) {
        if (monto > 0) {
        	LocalDateTime fecha = LocalDateTime.now();
            cliente.setBalance(cliente.getBalance() + monto);
            cliente.AnadirTransaccion(new Transaccion(monto, fecha, TipoTransaccion.DEPOSITO));
            System.out.println("Has realizado con éxito un depósito a tu cuenta por el monto de: $" + monto + " con fecha: " + fecha +"  $_$ !");
        } else {
            System.out.println("Error: El monto del depósito debe ser mayor que cero");
        }
    }
    /**
     * Realiza un retiro en la billetera del cliente.
     *
     * @param cliente Cliente que realizará el retiro en su billetera.
     * @param monto   El monto que se va a retirar.
     * @return devuelve true si el retiro se realizó con éxito, si no, false.
     
     */
    @Override
    public boolean retiro(Cliente cliente, double monto) {
        if (monto > 0 && cliente.getBalance() >= monto) {
        	LocalDateTime fecha = LocalDateTime.now();
            cliente.setBalance(cliente.getBalance() - monto);
            cliente.AnadirTransaccion(new Transaccion(monto, fecha, TipoTransaccion.RETIRO));
            System.out.println("Has realizado con éxito un retiro por el monto de: $" + monto + " con fecha: " + fecha + "  :D ");
            return true;
        } else {
            System.out.println("Error: el monto ingresado no es válido o no tienes saldo suficiente para retirar :(.");
            return false;
        }
    }
    /**
     * Realiza transferencia de un monto de la billetera de un cliente a otro genérico.
     *
     * @param clienteOrigen   cliente que realizará la transferencia
     * @param clienteDestino  cliente que recibirá la transferencia
     * @param monto           monto que se va a transferir.
     * @return devuelve TRUE si la transferencia se realizó correctamente, FALSE si no.
     */
    @Override
    public boolean transferir(Cliente cliente, Cliente clienteDestino, double monto) {
        if (monto > 0 && cliente.getBalance() >= monto) {
            LocalDateTime fecha = LocalDateTime.now();
            cliente.setBalance(cliente.getBalance() - monto);
            clienteDestino.setBalance(clienteDestino.getBalance() + monto);
            cliente.AnadirTransaccion(new Transaccion(monto, fecha, TipoTransaccion.TRANSFERENCIA));
            clienteDestino.AnadirTransaccion(new Transaccion(monto, fecha, TipoTransaccion.TRANSFERENCIA));
            System.out.println("Se ha realizado con éxito una transferencia por el monto de: $" + monto + " a la cuenta del destinatario con fecha: " + fecha + " :)");
            return true;
        } else {
            System.out.println("Error: el monto ingresado no es válido o no tienes saldo suficiente para transferir :(.");
            return false;
        }
    }
}