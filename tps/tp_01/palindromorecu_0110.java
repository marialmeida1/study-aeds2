public class palindromorecu_0110 {

    // Chama o método e imprime as respostas
    public void isPalindromo(String str) {

        // Str = entrada | 0 = de onde começa | lenght - 1 = tamanho da string - 1 porque é um vetor
        if (isPalindromoRecu(str, 0, str.length() - 1)) {
            MyIO.println("SIM");
        } else {
            MyIO.println("NAO");
        }
    }

    // Metodo que chama a string | onde o metodo irá começar | onde irá terminar
    private boolean isPalindromoRecu(String str, int start, int end) {
        // Se o começo for igual ou menor que o final toda a função retorna falso
        // Encerrando assim a recursividade
        if (start >= end) {
            return true;
        }

        // Se o inicio e o final forem diferentes coloca falso em toda função
        // Encerra toda a recursividade
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        // Se não deu nem um, nem outro -> segue a recursividade
        return isPalindromoRecu(str, start + 1, end - 1);
    }

    public static void main(String[] args) {
        palindromorecu_0110 fnc = new palindromorecu_0110();
        String str = "";

        while (true) {
            str = MyIO.readLine("");
            if (str.equals("FIM")) {
                break;
            }
            fnc.isPalindromo(str);
        }
    }
}
