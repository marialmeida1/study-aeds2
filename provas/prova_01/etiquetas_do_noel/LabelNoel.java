import java.util.Scanner;

public class LabelNoel {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        // Entrada idiomas e tradução
        int n = 0;
        if (entrada.hasNextInt()) { // Valida se é um número
            n = entrada.nextInt();
        }
        String mat[][] = new String[n][2]; // matriz dados
        entrada.nextLine(); // Evita problemas de quebra de linha
        // Irá criar uma matriz no esquema 0 | 1
        //                                 idioma | tradução
        // Possibilitando que os dados sejam consultados de modo mais simples

        // Prenchendo valores
        for (int i = 0; i < n; i++) {
            // Idioma -> em zero preenche sempre idioma
            mat[i][0] = entrada.next();
            // Tradução -> em um preenche sempre saudação
            mat[i][1] = entrada.nextLine();
        }

        // Preenche a busca -> matriz "pessoa"
        int m = 0;
        if (entrada.hasNextInt()) {
            m = entrada.nextInt(); // Cria o tamanho das linhas dos nomes armazenados
        }
        String find[][] = new String[m][2]; // Cria uma matriz no estilo 0 | 1
        entrada.nextLine(); //                                        nome | idioma

        // Prenchendo valores
        for (int i = 0; i < m; i++) {
            // Nome -> preenche nome sempre em 0
            find[i][0] = entrada.nextLine();
            // Idioma -> preenche idioma sempre em 1
            find[i][1] = entrada.nextLine();
        }

        // Vai ler a busca
        for (int i = 0; i < m; i++) { // Lê todos os idiomas armezados na matriz -> pessoa
            for (int j = 0; j < n; j++) { // Lê todos os idiomas na matriz -> dados
                if (find[i][1].equalsIgnoreCase(mat[j][0])) { // Se temos idiomas iguais = entra
                    System.out.println(find[i][0]); // Printa o nome pessoa encontrada
                    // Como o nome sempre está na coluna 0 o que muda é so a linha
                    System.out.println(mat[j][1]); // Printa a saudação
                    // Como saudação está sempre na coluna 1 o que muda é a linha
                }
            }
            System.out.println(); // Estilização
        }

        entrada.close();
    }

}