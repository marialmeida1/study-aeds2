#include <stdio.h>
#include <string.h>
#define MAX 20

void selection(char name[][MAX], int n){
    for (int i = 0; i < n - 1; i++) {
        int small = i;
        for (int j = i + 1; j < n; j++) {
            if(strcmp(name[small], name[j]) > 0){
                small = j;
            }
        }
        swap(small, i, name);
    }
}

void swap(int small, int i, char array[][MAX]){
    char aux[MAX];
    strcpy(aux, array[i]);
    strcpy(array[i], array[small]);
    strcpy(array[small], aux);
}

void cont(char value[], int n){
    
}

int main() {


    int n;
    do {
        scanf("%d", &n);
    } while(n < 0 || n > 100);

    // Vetores
    char value[n]; // Comportamento
    char name[n][MAX]; // Nomes

    // Leitura
    for (int i = 0; i < n; i++)
    {
        scanf(" %c", &value[i]);
        scanf("%s", name[i]);
    }
    
    selection(name, n);
    int good = 0;
    int bad = 0;
    for (int i = 0; i < n; i++) {
        if(value[i] == '+') {
            good++;
        } else {
            bad++;
        }
    }

    for (int i = 0; i < n; i++) {
        printf("%s\n", name[i]);
    }

    printf("Se comportaram: %d | Nao se comportaram: %d", good, bad);
    

}