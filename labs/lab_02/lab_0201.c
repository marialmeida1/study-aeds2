#include <stdio.h>
#include <string.h>
#define MAX 100

void positionStr(char str1[], char str2[]) {
    int l1 = strlen(str1);
    int l2 = strlen(str2);

    char aux[MAX] = {0}; 
    int j = 0;
    int lenght = l1 + l2;

    for (int i = 0; i < lenght; i++) {
        if (i < l1) {
            aux[j++] = str1[i];
        }
        if (i < l2) {
            aux[j++] = str2[i];
        }
    }

    aux[j] = '\0';  // Garante que a string seja terminada com nulo
    printf("%s\n", aux);
}

int main() {
    char str[MAX];
    int i = 0;
    char temp[MAX];

    // Vai ler até ter um valor inválido
    while (scanf("%s", str) == 1) {
        if (i % 2 == 0) {
            strcpy(temp, str);
        } else {
            positionStr(temp, str);
        }

        i++;
    }

    return 0;
}
