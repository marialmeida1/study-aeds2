public class palindromo_0101 {

    public void isPalindromo(String str) {

        String strInverse = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            strInverse += str.charAt(i);
            int ascii = (int) str.charAt(i);
        }

        if (str.equals(strInverse)) {
            MyIO.println("SIM");
        } else {
            MyIO.println("NAO");
        }
    }

    public static void main(String[] args) {

        palindromo_0101 fnc = new palindromo_0101();

        String str;

        while (true) {
            str = MyIO.readLine();
            if (str.equals("FIM")) {
                break;
            }
            fnc.isPalindromo(str);
        }

    }
}