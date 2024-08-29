#include <stdio.h>
#include <stdbool.h>

void writeToFile(FILE *file, int n) { // Escreve no arq.
    for (int i = 0; i < n; i++) {
        double d; // Variavel double
        scanf("%lf", &d); // Entrada do double
        fwrite(&d, sizeof(double), 1, file); // Gravação no arq.
    }
}

void readFromFile(FILE *file, int n) { // Le inverso
    for (int i = n - 1; i >= 0; i--) {
        double d; // Variavel double
        fseek(file, i * sizeof(double), SEEK_SET); // Pont na posicao correta
        fread(&d, sizeof(double), 1, file); // Le um valor

        if (d == (int)d) { // Verifica se é inteiro
            printf("%d\n", (int)d); // Imprime inteiro
        } else {
            printf("%g\n", d); // Imprime real
        }
    }
}

int main() {
    FILE *file;// Cria arq.
    int n; // Cria x que sera repetida

    scanf("%d", &n); // Entrada de x

    file = fopen("arquivo.bin", "wb"); // Modo de escrita
    if (file == NULL) { // Vazio -> erro
        printf("Erro ao abrir o arquivo para escrita.\n");
        return 1;
    }

    writeToFile(file, n); // Escreve valores dentro
    fclose(file); // Fecha

    file = fopen("arquivo.bin", "rb"); // Modo leitura
    if (file == NULL) { // Vazio -> erro
        printf("Erro ao abrir o arquivo para leitura.\n");
        return 1;
    }

    readFromFile(file, n); //Le inverso
    fclose(file); // Fecha

    return 0;
}
