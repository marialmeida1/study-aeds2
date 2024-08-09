public class PesquisaBina {

    public boolean isCrescente(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) { // Se a posição atual for menor que a posição anterior, não está em ordem crescente
                return false;
            }
        }
        return true;
    }

    public int binaria(int[] array, int x) {
        int inicio = 0;
        int fim = array.length - 1;

        while (inicio <= fim) {
            int meio = inicio + (fim - inicio) / 2;

            if (array[meio] == x) {
                return meio;
            }

            if (array[meio] > x) {
                fim = meio - 1; 
            } else {
                inicio = meio + 1; 
            }
        }

        return -1; 
    }

    public static void main(String[] args) {
        PesquisaBina pesquisa = new PesquisaBina();

        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        boolean resposta = pesquisa.isCrescente(array);
        int posicao = pesquisa.binaria(array, 5); // Alterado para procurar um valor presente no array

        MyIO.println("Array está crescente? " + resposta);
        MyIO.println("Posição do valor 5: " + posicao);
    }
}
