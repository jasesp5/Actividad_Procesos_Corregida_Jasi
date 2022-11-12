import java.util.InputMismatchException;
import java.util.Scanner;

public class PedirDatos {

    public static Scanner scanner = new Scanner(System.in);

    private static String nombre;
    private static String apellido;
    private static int year;

    public static void main(String[] args) {

        pedirNombre();
        pedirApellido();
        pedirYearNacimiento();
        scanner.close();
        escribir();

    }

    public static void pedirNombre() {

        try {
            nombre = scanner.next();
        } catch (NullPointerException exception) {
            System.err.println("La información proporcionada no es correcta");
            System.exit(1);
        }

    }

    public static void pedirApellido() {
        try {

            apellido = scanner.next();

        } catch (NullPointerException exception) {
            System.err.println("La información proporcionada no es correcta");
            System.exit(1);
        }

    }

    public static void pedirYearNacimiento() {
        try {

            year = scanner.nextInt();

        } catch (InputMismatchException  e) {

            System.err.println("La información proporcionada no es correcta");
            System.exit(-1);
        }

    }

    public static void escribir() {
        System.out.println("---------------");
        System.out.println(" |   NEW USER  |");
        System.out.println("---------------");
        System.out.println("Name : " + nombre);
        System.out.println("Surname: " + apellido);
        System.out.println("Birth date: " + year);

    }

}
