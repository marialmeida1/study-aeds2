#include <stdio.h>
#include <string.h>
#define MAX 1000

// Chama o método e imprime as respostas
void isPalindromo(char str[]) {

    int lenght = strlen(str);

    // Str = entrada | 0 = de onde começa | lenght - 1 = tamanho da string - 1 porque é um vetor
    if (isPalindromoRecu(str, 0, lenght - 1)) {
        printf("SIM\n");
    } else {
        printf("NAO\n");
    }
}

// Metodo que chama a string | onde o metodo irá começar | onde irá terminar
int isPalindromoRecu(char str[], int start, int end) {
    // Se o começo for igual ou menor que o final toda a função retorna falso
    // Encerrando assim a recursividade
    if (start >= end) {
        return 1;
    }

    // Se o inicio e o final forem diferentes coloca falso em toda função
    // Encerra toda a recursividade
    if (str[start] != str[end]) {
        return 0;
    }

    // Se não deu nem um, nem outro -> segue a recursividade
    return isPalindromoRecu(str, start + 1, end - 1);
}

int main() {
    char str[MAX];

    while (1) {
        fgets(str, MAX, stdin);
        str[strcspn(str, "\n")] = '\0';
        if (strcmp(str, "FIM") == 0) {
            break;
        }
        isPalindromo(str);
    }
}
