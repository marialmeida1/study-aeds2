#include <stdio.h>
#include <string.h>
#define MAX 100

void isPalindromo(char str[]){

    int length = strlen(str);
    char aux[MAX] = {0};
    int j = 0;
    int pali = 1;

    for(int i = length - 1; i >= 0; i--){
        aux[j] = str[i];
        j++;
    }

    for(int i = 0; i < length; i++){
        if(str[i] != aux[i]){
            pali = 0;
        }
    }

    if(pali){
        printf("SIM\n");
    } else {
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
        isPalindromo(str);
    }
    
}