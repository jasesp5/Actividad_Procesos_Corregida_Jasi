
public class NumerosRomanos {
    
    public static void main(String[] args) {
        if(Integer.valueOf(args[0])>3999 || Integer.valueOf(args[0])<0){
            System.err.println("Solo convertimos a romano números del 1 al 3999.");
            System.exit(-1);
        }
       int numero = Integer.valueOf(args[0]);
        System.out.println(enNumeroRomanos(numero));
    }

    public static String enNumeroRomanos(int numero) {
        String m[] = { "", "M", "MM", "MMM" };
        String c[] = { "", "C", "CC", "CCC", "CD",
                "D", "DC", "DCC", "DCCC", "CM" };
        String x[] = { "", "X", "XX", "XXX", "XL",
                "L", "LX", "LXX", "LXXX", "XC" };
        String i[] = { "", "I", "II", "III", "IV",
                "V", "VI", "VII", "VIII", "IX" };

        String mil = m[numero / 1000];

        String cien = c[(numero % 1000) / 100];

        String diez = x[(numero % 100) / 10];

        String unos = i[numero % 10];

        String numeroRomano = mil + cien + diez + unos;

        return numeroRomano;
    }
}