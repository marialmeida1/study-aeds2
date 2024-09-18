import java.util.Scanner;

class Alienigena {

    public static void verification(String alpha, String msg, int k, int n) {

        int value = 0;

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                if(alpha.charAt(i) == msg.charAt(j)){
                    value++;
                }
            }
        }

        if(value == msg.length()){
            System.out.println('S');
        } else {
            System.out.println('N');
        }
    }

    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);

        // Entrada
        int k = 0;
        int n = 0;
        do {
            if(entrada.hasNextInt()){
                k = entrada.nextInt();
                n = entrada.nextInt();
            }
        } while( (k <= 1 && k >= 68) && (n <= 1 && n >= 1000));


        String alpha = new String();
        String msg = new String();
        entrada.nextLine();

        alpha = entrada.nextLine();
        msg = entrada.nextLine();
        verification(alpha, msg, k, n);

    }
}