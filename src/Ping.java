import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ping {
    public static void main(String[] args) {

        if (args.length == 0) {
            System.err.println("Se requiere de una dirección para hacer el ping");
            System.exit(-1);
        } else {
            ProcessBuilder pb = new ProcessBuilder("CMD", "/c", "ping", args[0]);

            Process proceso;

            try {

                proceso = pb.start();

                BufferedReader imprimirProceso = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
                String linea = null;
                while ((linea = imprimirProceso.readLine()) != null) {
                    System.out.println(linea);
                }
                imprimirProceso.close();
                int valorSalida = proceso.waitFor();
                if (valorSalida != 0) {
                    BufferedReader imprimirError = new BufferedReader(new InputStreamReader(proceso.getErrorStream()));
                    while ((linea = imprimirError.readLine()) != null) {
                        System.out.println(linea);
                    }
                    imprimirError.close();
                }
                proceso.destroy();
                System.out.println("El valor de salida es " + proceso.waitFor());

            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {

                e.printStackTrace();
            }
        }

    }

}