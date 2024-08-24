import java.util.Scanner;

public class palindromo_0101 {

    public void isPalindromo(String str) {

        String strInverse = "";
        
        for (int i = str.length() - 1; i >= 0 ; i--) {
            strInverse += str.charAt(i);
        }

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