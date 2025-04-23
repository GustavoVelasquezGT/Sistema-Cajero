import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CajeroAutomatico {
    private static final String ARCHIVO_SALDO = "saldo.dat";
    
    public static void main(String[] args) {
        inicializarSaldo(1000.0); // Inicia con un saldo predefinido
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            try {
                System.out.println("\n--- Cajero Automático ---");
                System.out.println("1. Consultar saldo");
                System.out.println("2. Retirar dinero");
                System.out.println("3. Salir");
                System.out.print("Seleccione una opción: ");
                
                int opcion = scanner.nextInt();
                
                switch (opcion) {
                    case 1:
                        consultarSaldo();
                        break;
                    case 2:
                        System.out.print("Ingrese la cantidad a retirar: ");
                        double cantidad = scanner.nextDouble();
                        retirarDinero(cantidad);
                        break;
                    case 3:
                        System.out.println("Gracias por usar el cajero. Hasta luego.");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Entrada no válida. Debe ingresar un número.");
                scanner.nextLine(); // Limpiar el buffer del scanner
            }
        }
    }

    private static void inicializarSaldo(double saldoInicial) {
        File archivo = new File(ARCHIVO_SALDO);
        if (!archivo.exists()) {
            guardarSaldo(saldoInicial);
        }
    }

    private static void consultarSaldo() {
        double saldo = leerSaldo();
        System.out.println("Su saldo actual es: Q" + saldo);
    }

    private static void retirarDinero(double cantidad) {
        double saldo = leerSaldo();
        if (cantidad <= 0) {
            System.out.println("Error: La cantidad debe ser mayor que cero.");
            return;
        }
        if (cantidad > saldo) {
            System.out.println("Saldo insuficiente.");
        } else {
            saldo -= cantidad;
            guardarSaldo(saldo);
            System.out.println("Retiro exitoso. Su nuevo saldo es: Q" + saldo);
        }
    }

    private static double leerSaldo() {
        try (DataInputStream entrada = new DataInputStream(new FileInputStream(ARCHIVO_SALDO))) {
            return entrada.readDouble();
        } catch (IOException e) {
            System.out.println("Error: No se pudo leer el saldo.");
            return 0.0;
        }
    }

    private static void guardarSaldo(double saldo) {
        try (DataOutputStream salida = new DataOutputStream(new FileOutputStream(ARCHIVO_SALDO))) {
            salida.writeDouble(saldo);
        } catch (IOException e) {
            System.out.println("Error: No se pudo guardar el saldo.");
        }
    }
}
