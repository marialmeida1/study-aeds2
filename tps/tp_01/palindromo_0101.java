import java.util.Scanner;

public class palindromo_0101 {

    public void isPalindromo(String str) {
        StringBuilder sb = new StringBuilder(str);
        String strInverse = sb.reverse().toString();

        if(str.equals(strInverse)){
            System.out.println("SIM");
        } else {
            System.out.println("NAO");
        }
    }

    public static void main(String[] args) {

        palindromo_0101 fnc = new palindromo_0101();
        
        try (Scanner sc = new Scanner(System.in)) {
            String str;

            while (true) {
                str = sc.nextLine();

                fnc.isPalindromo(str);
            }
        }
    }
}