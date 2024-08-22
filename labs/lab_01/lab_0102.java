public class lab_0102 {

    public boolean isMaisculas(char c){
        if (Character.isUpperCase(c)) {
            return true;
        } 

        return false;
    }

    // Método que funciona tudo
    private int contMaisRecursivo(String str, int index) {

        // Chegou no tamanho da string -> para o método | parada
        if (index == str.length()) {
            return 0;
        }

        // Ternário -> soma 1 se for verdade e 0 se for falso
        int cont = isMaisculas(str.charAt(index)) ? 1 : 0;

        // Vai somando
        return cont + contMaisRecursivo(str, index + 1);
    }

    // Inicia o método de Recursividade
    public int contMais_recu(String str) {
        return contMaisRecursivo(str, 0);
    }

    public static void main(String[] args) {
        lab_0102 lab = new lab_0102();

        String str = MyIO.readString("");
        int number = lab.contMais_recu(str);
        MyIO.println(number);
    }
}
