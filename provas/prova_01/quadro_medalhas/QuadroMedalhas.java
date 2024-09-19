import java.util.Scanner;

public class QuadroMedalhas {

    public static void selecao(int medalhas[][], String nomes[], int n) {
        for (int i = 0; i < n - 1; i++) {
            int maior = i;
            for (int j = i + 1; j < n; j++) {
                if (medalhas[maior][0] < medalhas[j][0]) {
                    maior = j;
                } else if (medalhas[maior][0] == medalhas[j][0]) {

                    if (medalhas[maior][1] < medalhas[j][1]) {
                        maior = j;
                    } else if (medalhas[maior][1] == medalhas[j][1]) {

                        if (medalhas[maior][2] < medalhas[j][2]) {
                            maior = j;
                        } else if (medalhas[maior][2] == medalhas[j][2]) {

                            if (nomes[maior].compareTo(nomes[j]) > 0) {
                                maior = j;
                            }
                        }
                    }
                }
            }
            swapIntMat(maior, i, medalhas);
            swapName(maior, i, nomes);
        }
    }

    public static void swapIntMat(int maior, int i, int medalhas[][]) {
        for (int j = 0; j < 3; j++) {
            int aux = medalhas[i][j];
            medalhas[i][j] = medalhas[maior][j];
            medalhas[maior][j] = aux;
        }
    }

    public static void swapName(int maior, int i, String nomes[]) {
        String aux = nomes[i];
        nomes[i] = nomes[maior];
        nomes[maior] = aux;
    }

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        // Peguei meu tamanho de array
        int n = 0;
        do {
            if (entrada.hasNextInt()) {
                n = entrada.nextInt();
            }
        } while (n <= 0 || n >= 500);

        // Nomes
        String nomes[] = new String[n];
        entrada.nextLine();
        // Medalhas
        int medalhas[][] = new int[n][3];

        for (int i = 0; i < n; i++) {
            nomes[i] = entrada.next(); // Nome
            int g = 0, s = 0, b = 0;
            do {
                if (entrada.hasNextInt()) {
                    g = entrada.nextInt(); // Ouro
                    s = entrada.nextInt(); // Prata
                    b = entrada.nextInt(); // Bronze
                }
            } while( (g <= 0 || g >= 10000) || (s <= 0 || s >= 10000) || (b <= 0 || b >= 10000));
            
            medalhas[i][0] = g; // Ouro
            medalhas[i][1] = s; // Prata
            medalhas[i][2] = b; // Bronze
        }

        selecao(medalhas, nomes, n);

        for (int i = 0; i < n; i++) {
            System.out.println(nomes[i] + " " + medalhas[i][0] + " " + medalhas[i][1] + " " + medalhas[i][2]);
        }
    }

}