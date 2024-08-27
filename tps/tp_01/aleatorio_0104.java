import java.util.Random;

public class aleatorio_0104 {
    
    // Substitue a ocorrencia da primeira letra pela segunda letra
    public void replace(String str, char letter1, char letter2){

        String strAux = ""; // Retorna a nova string

        for(int i = 0; i < str.length(); i++){ // Lê toda a string
            if(str.charAt(i) == letter1){ // Se existe na string alguma letra como a primeira 
                strAux += letter2; // Entra na nova string
            } else {
                strAux += str.charAt(i); // Se não, recebe o valor antigo
            }
        }
        MyIO.println(strAux); // Printa a resposta

    }

    public static void main(String[] args) {
        aleatorio_0104 fnc = new aleatorio_0104();

        String str = "";

        // Gerador de valores aleatórios
        Random gerador = new Random();
        gerador.setSeed(4);

        while (true) {
            str = MyIO.readLine("");
            if (str.equals("FIM")) {
                break;
            }

            // Gera duas letras
            char letter1 = (char)('a' + Math.abs(gerador.nextInt()) % 26);
            char letter2 = (char)('a' + Math.abs(gerador.nextInt()) % 26);
            fnc.replace(str, letter1, letter2); // Insere a string + duas novas letras para o metodo "replace"
        }
    }
}
