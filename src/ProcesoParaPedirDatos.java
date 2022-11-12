
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class ProcesoParaPedirDatos {

    public static Scanner scanner = new Scanner(System.in);

    private static String nombre;
    private static String apellido;
    private static String year;

    private static int valorSalida;

    public static void main(String[] args) {

        pedirNombre();
        pedirApellido();
        pedirYearNacimiento();
        scanner.close();

        ProcessBuilder processBuilder = new ProcessBuilder("java", "PedirDatos");
        processBuilder.directory(new File("./bin"));
        File fileSalida = new File(nombre + "_" + apellido + ".txt");
        processBuilder.redirectOutput(fileSalida);
        File fileError = new File("[Error]" + nombre + "_" + apellido + ".txt");
        processBuilder.redirectError(fileError);
        nombre += "\n";
        apellido += "\n";

        Process proceso = null;

        try {
            procesoStart(proceso, processBuilder);
        } catch (IOException e) {

            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void procesoStart(Process proceso, ProcessBuilder processBuilder)
            throws IOException, InterruptedException {
        proceso = processBuilder.start();
        OutputStream outPutStream = proceso.getOutputStream();
        outPutStream.write(nombre.getBytes());
        outPutStream.write(apellido.getBytes());
        outPutStream.write(year.getBytes());
        outPutStream.flush();
        outPutStream.close();
        InputStream inputStream = proceso.getInputStream();
        int caracterParaLeer = 0;

        valorSalida = proceso.waitFor();
        if (valorSalida == 0) {

        }
        System.out.println("El valos de salida es " + valorSalida);
        if (valorSalida != 0) {

            inputStream = proceso.getErrorStream();
            while ((caracterParaLeer = inputStream.read()) != -1) {
                System.out.print((char) caracterParaLeer);
            }
            inputStream.close();
        }
    }

    public static void pedirNombre() {
        System.out.println("Introduce tu nombre");
        nombre = scanner.next();

    }

    public static void pedirApellido() {
        System.out.println("Introduce tu apellido");
        apellido = scanner.next();

    }

    public static void pedirYearNacimiento() {

        System.out.println("Introduce tu año de nacimiento");
        year = scanner.next();

    }
}