import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ProcesoParaIniciarPing {

  

    private static String dirrecion;
    private static int numeroDeVeces;

    public void proceso4(Scanner scanner) throws IOException {

        pedirDirrecion(scanner);
        pedirLaVecesQueElUsuarioQuiereElPing(scanner);
    
     
        
        

    }

    public static void pedirDirrecion(Scanner scanner) {

        try {
            System.out.println("Introduce la dirrección");
            dirrecion = scanner.next();
        } catch (NullPointerException exception) {
            System.err.println("La información proporcionada no es correcta");
        }

    }

    public static void pedirLaVecesQueElUsuarioQuiereElPing(Scanner scanner) throws IOException {
        try {
            System.out.println("Introduce el número de veces que quieres realizar el ping");
            numeroDeVeces = scanner.nextInt();
            for (int i = 0; i < numeroDeVeces; i++) {
                iniciarProceso();
            }

        } catch (InputMismatchException e) {
            System.err.println("Tiene que introducir un número entero");
            scanner.next();

        }

    }

    public static void iniciarProceso() throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder("java", "Ping",dirrecion);
        processBuilder.directory(new File("./bin"));

        try {
            Process proceso= processBuilder.start();
			InputStream inputStream=proceso.getInputStream();
			int caracterParaLeer=0;
			while((caracterParaLeer=inputStream.read())!=-1) {
				System.out.print((char)caracterParaLeer);
			}
			inputStream.close();
			
			int valorSalida=proceso.waitFor();
			if(valorSalida!=0) {
				inputStream=proceso.getErrorStream();
				while((caracterParaLeer=inputStream.read())!=-1) {
					System.out.print((char)caracterParaLeer);
				}
				inputStream.close();
			}
            proceso.destroy();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
