#include <stdio.h>
#include <string.h>
#define MAX 1000

int isPalindromo(char str[]){

   int end = strlen(str) - 1; // Pega a posição final da string
   int start = 0; // Pega a posição de inicio da string

    while (start < end) { // Irá rodar até o inicio ser menor que o final, pois se for igual ou maior para
        if(str[start] != str[end]){ // Se alguma posição for diferente o inicio do final já retorna falso e para o método
            return 0;
        }
        start++; // Soma mais uma posição ao início
        end--; // Soma mais uma posição no final
    }

    return 1; // Resposta
}

void print(int resp) {
    if (resp) { // Se é true
        printf("SIM\n");
    } else { // SE é false
        printf("NAO\n");
    }
}

int main()
{

    char str[MAX];

    while (1) {
        fgets(str, MAX, stdin);
        str[strcspn(str, "\n")] = '\0';
        if (strcmp(str, "FIM") == 0) {
            break;
        }
        int resp = isPalindromo(str);
        print(resp);
    }
    
}