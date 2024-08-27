public class palindromo_0101 {

    public boolean isPalindromo(String str) { // Retorna uma resposta true ou false por meio de uma string

        int end = str.length() - 1; // Pega a posição final da string
        int start = 0; // Pega a posição de inicio da string

        while (start < end) { // Irá rodar até o inicio ser menor que o final, pois se for igual ou maior para
            if(str.charAt(start) != str.charAt(end)){ // Se alguma posição for diferente o inicio do final já retorna falso e para o método
                return false;
            }
            start++; // Soma mais uma posição ao início
            end--; // Soma mais uma posição no final
        }

        return true; // Resposta
    }

    // Responsável por printar as respostas no formato correto
    public void print(boolean resp) {
        if (resp) { // Se é true
            MyIO.println("SIM");
        } else { // SE é false
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
            boolean resp = fnc.isPalindromo(str); // Chama a verificação de palindromo e insere a string
            fnc.print(resp); // Chama o método responsável por printar
        }

    }
}