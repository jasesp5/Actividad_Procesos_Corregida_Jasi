import java.util.ArrayList;

public class ComprobarCalificaciones {

    private static ArrayList<Integer> numeros3 = new ArrayList<>();

    public static void main(String[] args) throws Exception {

       String numeros = args[0];
        String[] numeros1 = numeros.split(",");

            for (int i = 0; i < numeros1.length; i++) {
                try{
                    if (Integer.parseInt(numeros1[i]) >= 0 && Integer.parseInt(numeros1[i]) <= 10) {
                        numeros3.add(Integer.parseInt(numeros1[i]));
                    } else {
                        System.err.println("Los números tienen que estar entre 10 y 0");
                        System.exit(-1);
                    }
                    
                }catch(NumberFormatException e) {
                    System.err.println("Todos los operadores deben ser números enteros.");;
                    System.exit(-1);
                }
               
            }
            comrprobarCalificaciones();

    }

    public static void comrprobarCalificaciones() {
        int aprobadas = 0;
        int suspendidas = 0;
        for (Integer integer : numeros3) {
            if (integer >= 5) {
                aprobadas++;
            } else {
                suspendidas++;
            }
        }
        System.out.println("Tienes aprobada " + aprobadas);
        System.out.println("Tienes suspendidas " + suspendidas);
    }
}
