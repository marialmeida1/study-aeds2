import java.util.Random;

public class aleatorio_0104 {
    

    public void replace(String str, char letter1, char letter2){

        String strAux = "";

        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == letter1){
                strAux += letter2;
            } else {
                strAux += str.charAt(i);
            }
        }
        System.out.println(strAux);

    }

    public void generate(String str) {
        Random gerador = new Random();
        gerador.setSeed(4);

        char letter1 = (char)('a' + Math.abs(gerador.nextInt()) % 26);
        char letter2 = (char)('a' + Math.abs(gerador.nextInt()) % 26);

        replace(str, letter1, letter2);
    }

    public static void main(String[] args) {
       aleatorio_0104 fnc = new aleatorio_0104();

        String str = "";

        while (true) {
            str = MyIO.readLine("");
            if (str.equals("FIM")) {
                break;
            }
            fnc.generate(str);
        }
    }
}
