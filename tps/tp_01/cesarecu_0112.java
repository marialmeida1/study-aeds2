public class cesarecu_0112 {
    

    // Chama o método recursivo de modo mais simples
    public void ciframento(String str) {
        String resp = ciframentoRecu(str, "", 0); // Insere a string | O aux começa vazio | O inicio é do zero
        MyIO.println(resp);
    }

    public String ciframentoRecu(String str, String strAux, int i) {

        // Se o i atingir o tamanho da string é porque tudo foi lido
        if(i == str.length()){
            return strAux; // Retorna a string
        }

        int codAux = 0; // O código de cada letra
        char caractere = str.charAt(i); // O caracter da vez da recursividade
        int cod = (int) caractere; // O codigo da vez da recursividade

        codAux = cod + 3; 

        char caractereAux = (char) codAux; // Transforma em char
        strAux += caractereAux; // Insere na string auxiliar

        return ciframentoRecu(str, strAux, i + 1); // Se não atingiu o tamanho chama de novo a recursividade
    }

    public static void main(String[] args) {
        cesarecu_0112 fnc = new cesarecu_0112();
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
