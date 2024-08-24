public class palindromo_0101 {

    public void isPalindromo(String str) {

        String strInverse = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            strInverse += str.charAt(i);
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

        do {
            str = MyIO.readLine("");
            if(!str.equals("FIM")){
                fnc.isPalindromo(str);
            }
        }while(!str.equals("FIM"));
    }
}