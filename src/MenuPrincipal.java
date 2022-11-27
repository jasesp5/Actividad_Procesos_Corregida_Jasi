import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuPrincipal {
    public static Scanner scanner;

    public static void main(String[] args) throws Exception {

        int numero = 0;
        do {
            scanner = new Scanner(System.in);
            mostrarMenu();

            try {
                numero = scanner.nextInt();
                realizarOperciones(numero);
            } catch (InputMismatchException e) {
                System.err.println("Debes introducir un número entre 1 y 5");

            }

        } while (numero != 5);
        scanner.close();
    }

    public static void mostrarMenu() {
        System.out.println("1. Convertir a números romanos");
        System.out.println("2. Crear fichero de usuario");
        System.out.println("3. Comprobar calificaciones");
        System.out.println("4. Hacer Ping");
        System.out.println("5. Salir");
        System.out.println("Seleccione una opción (1-5):");

    }

    public static void realizarOperciones(int numero) throws IOException {
        switch (numero) {
            case 1:
                ProcesoParaLosNumerosRomanos procesoParaLosNumerosRomanos = new ProcesoParaLosNumerosRomanos();
                procesoParaLosNumerosRomanos.procesoNumeros(scanner);
                pulsarParaContinuar();
                break;
            case 2:
                ProcesoParaPedirDatos procesoEscribPedirDatos = new ProcesoParaPedirDatos();
                procesoEscribPedirDatos.proceso2(scanner);
                pulsarParaContinuar();
                break;
            case 3:
                ProcesoCalificaciones proceso3 = new ProcesoCalificaciones();
                proceso3.procesoCalificaciones(scanner);
                pulsarParaContinuar();
                break;
            case 4:
                ProcesoParaIniciarPing proceso4 = new ProcesoParaIniciarPing();
                proceso4.proceso4(scanner);
                pulsarParaContinuar();
                break;
        }
    }

    public static void pulsarParaContinuar() throws IOException {
        System.out.println("Pulsa cualquier tecla para continuar");
        System.in.read();
    }
}
