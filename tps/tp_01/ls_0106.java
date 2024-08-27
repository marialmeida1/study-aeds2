public class ls_0106 {

    // Verifica se é vogal
    public boolean isVowel(String str) {

        String vowel = "aeiouAEIOU"; // Cria um string de verificação para letras vogais
        int cont = 0; // Realiza um contador para quais letras são vogais
        boolean isVowel = false; // Resposta final

        for(int i = 0; i < str.length(); i++){ // Lê toda string
            for(int j = 0; j < vowel.length(); j++){ // Lê para cada letra da string o conjunto de vogal
                if(str.charAt(i) == vowel.charAt(j)){ // Se igual entra no contador
                    cont++;
                }
            }
        }

        if(cont == str.length()){ // Se o contador for igual ao tamanho da string então são todas vogais
            isVowel = true;
        }

        return isVowel;
    }

    // Verifica se é consoante
    public boolean isConsonant(String str) {

        String consonant = "bcdfghjklmnpqrstvwxyzçBCDFGHJKLMNPQRSTVWXYZÇ"; // Conjunto de consoantes
        int cont = 0; // Contador de quai letras são vogais
        boolean isConsonant = false; // Resposta

        for(int i = 0; i < str.length(); i++){ // Lê toda string
            for(int j = 0; j < consonant.length(); j++){ // Lê o conjunto
                if(str.charAt(i) == consonant.charAt(j)){ // Se a letra pertencer ao conjunto entra no contador
                    cont++;
                }
            }
        }

        if(cont == str.length()){ // Se contador igual ao tamanho da string, então, todas consoantes
            isConsonant = true;
        }

        return isConsonant;
    }

    // Verifica se é inteiro
    public boolean isInteger(String str) {
        String integer = "1234567890"; // Conjunto de números
        boolean isInteger = true; // Resposta
        boolean found = false; // Auxiliar
    
        for (int i = 0; i < str.length(); i++) { // Lê toda a string
            found = false; // Sempre que inicia uma nova letra coloca como false
    
            for (int j = 0; j < integer.length(); j++) { // Lê todo o conjunto
                if (str.charAt(i) == integer.charAt(j)) { // Se a letra for igual ao conjunto então achou um número
                    found = true;
                    break; 
                }
            }
    
            if (!found) { // Se permancer falsa -> resposta fica falsa
                isInteger = false;
            }
        }
    
        return isInteger;
    }

    // Verifica se é Real
    public boolean isReal(String str) {
        String real = "1234567890.,"; // Conjunto de características que compõem um número real
        boolean isReal = true; // Resposta
        boolean found = false; // Auxiliar
        int cont = 0;
    
        for (int i = 0; i < str.length(); i++) { // Lê toda a string
            found = false; // Auxiliar é colocada como falsa toda vez que lê uma nova letra
    
            for (int j = 0; j < real.length(); j++) { // Lê o conjunto
                if (str.charAt(i) == real.charAt(j)) { // Se a letra tiver algo igual no conjunto
                    found = true; // A auxiliar se transforma em verdadeira
                    break; 
                }
            }
    
            if (!found) { // Se permance como falsa -> resposta fica falsa
                isReal = false;
            }

            if(str.charAt(i) == ',' || str.charAt(i) == '.') { // Se tiver mais de um ponto ou virgula dá erro
                cont++; // Se existir mais de 1 cont é pq tem mais de uma: , ou .
            }
        }

        if (cont > 1) { // Verificação
            isReal = false; // Resposta
        }
    
        return isReal;
    }
    

    // verifica se é controla as repostas
    public void control(String str){

        boolean isV = isVowel(str); // Pega a resposta
        System.out.print(isV ? "SIM " : "NAO "); // Ternário que printa o resultado

        boolean isC = isConsonant(str); // Pega a resposta
        System.out.print(isC ? "SIM " : "NAO "); // Ternário que printa o resultado
        
        boolean isI = isInteger(str);  // Pega a resposta
        System.out.print(isI ? "SIM " : "NAO "); // Ternário que printa o resultado

        boolean isR = isReal(str); // Pega a resposta
        System.out.print(isR ? "SIM " : "NAO "); // Ternário que printa o resultado

        System.out.println("");
    }

    public static void main(String[] args) {
        ls_0106 fnc = new ls_0106();
        String str = "";

        while (true) {
            str = MyIO.readLine("");
            if (str.equals("FIM")) {
                break;
            }
            fnc.control(str);
        }
    }
    
}
