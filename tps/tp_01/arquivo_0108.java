import java.io.*; 

public class arquivo_0108 {

    // Método para ler os valores em ordem inversa e imprimí-los
    public static void writeArq(String file, int n) throws Exception {
        RandomAccessFile arq = new RandomAccessFile(file, "r");  // Abre o arquivo em modo de leitura ("r")
        double d;  // Variável para armazenar o valor double

        // Loop para ler os valores de trás para frente
        for (int i = n - 1; i >= 0; i--) {
            arq.seek(i * 8);  // Posiciona o ponteiro na posição do double (double = 8bit)
            d = arq.readDouble();  // Lê o double nessa posicao
            if (d == (int) d) {  // Verifica se é inteiro
                System.out.println((int) d);  // Printa inteiro
            } else {
                System.out.println(d);  // Printa double
            }
        }

        arq.close();  // Fecha
    }

    public static void main(String[] args) throws Exception {
        // Abre o arquivo em modo de leitura e escrita ("rw")
        RandomAccessFile arq = new RandomAccessFile("arquivo_0108.txt", "rw");

        int n = MyIO.readInt();  // Le a qtd de numeros lidos
        double d;  // Variavel double

        // Escreve no arq.
        for (int i = 0; i < n; i++) {
            d = MyIO.readDouble();  // Lê double
            arq.writeDouble(d);  // Printa no arq.
        }

        arq.close();  // Fecha

        // Método para ler e imprimir
        writeArq("arquivo_0108.txt", n);
    }
}
