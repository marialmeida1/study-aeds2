import java.util.Random;

public class isrecu_0114 {

    // Recebe a string, o índice que estamos "andando", contador que é o verificador
    public boolean isVowelRecu(String str, int i, int cont) {
        String vowel = "aeiouAEIOU"; // Conjunto de vogais
        
        if (i == str.length()) { // Quando leu a string inteira
            return cont == str.length(); // Retorna a resposta se contador é igual ao tamanho da string
        }
    
        char caracter = str.charAt(i); // Pega o caracter da vez
    
        for (int j = 0; j < vowel.length(); j++) { // Lê o conjunto
            if (caracter == vowel.charAt(j)) { // Se a letra pertencer ao conjunto, entra no contador
                cont++;
                break; // Se encontrou a vogal, não precisa continuar o loop
            }
        }
    
        // Chamada recursiva para o próximo caractere
        return isVowelRecu(str, i + 1, cont);
    }
    
    // Recebe a string, o índice que estamos "andando", contador que é o verificador
    public boolean isConsonantRecu(String str, int i, int cont) {
        String consonant = "bcdfghjklmnpqrstvwxyzçBCDFGHJKLMNPQRSTVWXYZÇ"; // Conjunto de consoantes
        
        if (i == str.length()) { // Quando leu a string inteira
            return cont == str.length(); // Retorna a resposta se contador é igual ao tamanho da string
        }
    
        char caracter = str.charAt(i); // Caracter da vez
    
        for (int j = 0; j < consonant.length(); j++) { // Lê o conjunto
            if (caracter == consonant.charAt(j)) { // Se a letra pertencer ao conjunto, entra no contador
                cont++;
                break; // Se encontrou a consoante, não precisa continuar o loop
            }
        }
    
        // Chamada recursiva para o próximo caractere
        return isConsonantRecu(str, i + 1, cont);
    }

    public boolean isIntegerRecu(String str, int i) { // Recebe a string e o indice que estamos percorrendo

        String integer = "1234567890"; // Conjunto de números

        if (i == str.length()) { // Quando leu a string inteira
            return true; // Retorna true, porque se não fosse inteiro, a recursividade já teria se encerrado
        }

        boolean found = false; // Auxiliar para definir se é inteiro

        for (int j = 0; j < integer.length(); j++) { // Lê todo o conjunto
            if (str.charAt(i) == integer.charAt(j)) { // Se a letra for igual ao conjunto então achou um número
                found = true; // Quando acha já sai e coloca como verdadeira
                break; 
            }
        }

        // Se permaneceu falsa é porque ela já não é um inteiro
        if (!found) { // Se permancer falsa -> resposta fica falsa
            return false;
        }

        return isIntegerRecu(str, i + 1);
    }

    public boolean isRealRecu(String str, int i, int cont) { // Recebe a string, o índice e um contador para contar . e ,

        String real = "1234567890.,"; // Conjunto de números

        if (i == str.length()) { // Quando leu a string inteira
            return true; // Retorna true, porque se não fosse inteiro, a recursividade já teria se encerrado
        }

        boolean found = false; // Auxiliar para definir se é inteiro 

        for (int j = 0; j < real.length(); j++) { // Lê todo o conjunto
            if (str.charAt(i) == real.charAt(j)) { // Se a letra for igual ao conjunto então achou um número
                found = true; // Quando acha já sai e coloca como verdadeira
                break; 
            }
        }

        if(str.charAt(i) == ',' || str.charAt(i) == '.') { // Se tiver mais de um ponto ou virgula dá erro
            cont++; // Se existir mais de 1 cont é pq tem mais de uma: , ou .
        }

        // Valida se é um real + se tem mais de uma . ou ,
        if (!found || cont > 1) { // Se permancer falsa -> resposta fica falsa
            return false; // Retorna falso e encerra a recursividade
        }

        return isRealRecu(str, i + 1, cont);
    }

    public void control(String str){

        boolean isV = isVowelRecu(str, 0, 0); // Pega a resposta
        MyIO.print(isV ? "SIM " : "NAO "); // Ternário que printa o resultado

        boolean isC = isConsonantRecu(str, 0, 0); // Pega a resposta
        MyIO.print(isC ? "SIM " : "NAO "); // Ternário que printa o resultado
        
        boolean isI = isIntegerRecu(str, 0); // Pega a resposta
        MyIO.print(isI ? "SIM " : "NAO "); // Ternário que printa o resultado

        boolean isR = isRealRecu(str, 0, 0); // Pega a resposta
        MyIO.print(isR ? "SIM " : "NAO "); // Ternário que printa o resultado

        MyIO.println("");
    }

    public static void main(String[] args) {
        isrecu_0114 fnc = new isrecu_0114();

        String str = "";
        while (true) {
            str = MyIO.readLine("");
            if (str.equals("FIM")) {
                break;
            }

            // Envia para todos o string capturada
            fnc.control(str);
        }
    }
}
