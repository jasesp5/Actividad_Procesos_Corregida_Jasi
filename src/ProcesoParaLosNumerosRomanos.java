import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class ProcesoParaLosNumerosRomanos {

    public void procesoNumeros(Scanner scanner) {

        System.out.println("Introduce un número para convertirlo en romano");
        String number = "";
        number = scanner.next();
        ProcessBuilder processBuilder = new ProcessBuilder("java", "NumerosRomanos", number);
        processBuilder.directory(new File("./bin"));

        try {
            Process proceso = processBuilder.start();
            InputStream inputStream = proceso.getInputStream();
            int caracterParaLeer = 0;
            while ((caracterParaLeer = inputStream.read()) != -1) {
                System.out.print((char) caracterParaLeer);
            }
            inputStream.close();

            int valorSalida = proceso.waitFor();

            if (valorSalida != 0) {
                inputStream = proceso.getErrorStream();
                while ((caracterParaLeer = inputStream.read()) != -1) {
                    System.out.print((char) caracterParaLeer);
                }
                inputStream.close();
            } else {
                System.out.println("El valor de salida es " + valorSalida);
            }
            proceso.destroy();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}