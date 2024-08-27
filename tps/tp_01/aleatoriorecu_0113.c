#include <stdio.h>
#include <string.h>
#include <stdlib.h> 
#define MAX 1000

// Função recursiva para substituir letras na string
char* replaceRecu(char str[], char letter1, char letter2, int i) {
    int length = strlen(str);
    if (i == length) {
        return str;
    }

    if (str[i] == letter1) {
        str[i] = letter2;
    }

    return replaceRecu(str, letter1, letter2, i + 1);
}

// Função que inicializa a substituição e imprime o resultado
void replace(char str[], char letter1, char letter2) {
    char *resp = replaceRecu(str, letter1, letter2, 0);
    printf("%s\n", resp);
}

int main() {
    char str[MAX];

    srand(4);

    while (1) {
        fgets(str, MAX, stdin);
        str[strcspn(str, "\n")] = '\0'; // Remove o caractere de nova linha

        if (strcmp(str, "FIM") == 0) {
            break;
        }

        // Gera duas letras aleatórias
        char letter1 = 'a' + ( rand() % 26 );
        char letter2 = 'a' + ( rand() % 26 );

        replace(str, letter1, letter2); // Substitui e imprime o resultado
    }

    return 0;
}
