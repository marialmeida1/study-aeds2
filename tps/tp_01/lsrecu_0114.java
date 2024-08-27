import java.util.Random;

public class lsrecu_0114 {

    public boolean isVowelRecu(String str, int i) {
        char caracter = str.charAt(i);
        if (i == str.length()) {
            return true;
        }
    
        if (caracter != 'a' && caracter != 'e' && caracter != 'i' && 
            caracter != 'o' && caracter != 'u' && 
            caracter != 'A' && caracter != 'E' && 
            caracter != 'I' && caracter != 'O' && 
            caracter != 'U') {
            return false;
        }
    
        // Chamada recursiva para o próximo caractere
        return isVowelRecu(str, i + 1);
    }

    public boolean isConsonantRecu(String str, int i) {
        // Condição de parada: Se chegamos ao fim da string, retornamos true.
        if (i == str.length()) {
            return true;
        }
    
        // Verificação do caractere atual se não é vogal (logo, é consoante)
        char caracter = str.charAt(i);
        if (caracter == 'a' || caracter == 'e' || caracter == 'i' || 
            caracter == 'o' || caracter == 'u' || 
            caracter == 'A' || caracter == 'E' || 
            caracter == 'I' || caracter == 'O' || 
            caracter == 'U') {
            return false; // Se for vogal, retorna false
        }
    
        // Chamada recursiva para o próximo caractere
        return isConsonantRecu(str, i + 1);
    }
    

    public void isConsonant(String str) {
        boolean resp = isConsonantRecu(str, 0);
        MyIO.print(resp);
    }

    public void isVowel(String str) {
        boolean resp = isVowelRecu(str, 0);
        MyIO.print(resp);
    }


    
    public static void main(String[] args) {
        lsrecu_0114 fnc = new lsrecu_0114();

        String str = "";
        while (true) {
            str = MyIO.readLine("");
            if (str.equals("FIM")) {
                break;
            }

            fnc.isVowel(str);
            MyIO.print(" ");
            fnc.isConsonant(str);
            MyIO.println("");
        }
    }
}
