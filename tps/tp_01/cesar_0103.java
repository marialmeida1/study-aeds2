public class cesar_0103 {
    
    void ciframento(String str){

        char caractere; // Variavel que armazena qual letra está sendo lida
        int cod; // Variavel que armazena o codigo da letra está sendo lida
        int codAux = 0; // Novo valor do código
        char caractereAux; // Novo valor da letra
        String strAux = ""; // Resultado final

        for (int i = 0; i < str.length(); i++) {
            caractere = str.charAt(i); // Pega a letra de acordo com a posição na string
            cod = (int) caractere; // Pega o codigo da letra lida

            codAux = cod + 3; // Soma mais três para o novo código

            caractereAux = (char) codAux; // O caractere que será gerado de acordo com o novo código
            strAux += caractereAux; // String final
        }

        MyIO.println(strAux); // Printa o valor
    }

    public static void main(String[] args) {
        cesar_0103 fnc = new cesar_0103();
        String str = "";

        while (true) {
            str = MyIO.readLine("");
            if (str.equals("FIM")) {
                break;
            }
            fnc.ciframento(str);
        }
    }
}
