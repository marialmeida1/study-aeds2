#include <stdio.h>

void swap(int array[], int i, int j){
    int tmp = array[i];
    array[i] = array[j];
    array[j] = tmp;
}

void select(int timeStart[], int cicleTime[], int n){
    // Primeira linha
    int sum = timeStart[0] + cicleTime[0];
    
    for (int i = 1; i < n; i++)
    {
        for (int j = i + 1; j < n; j++)
        {
            if((sum - timeStart[j]) > (sum - timeStart[j+1])){
                swap(timeStart, i, j);
                swap(cicleTime, i, j);
            }
        }
        
    }
}

void show(int array[], int n){
    for (int i = 0; i < n; i++)
    {
        printf("%d | ", array[i]);
    }
    
}

int main()
{

    // Vai manter enquanto não parar o programa
    while (1)
    {

        // Tamanho do for
        int n = 0;
        scanf("%d", &n);
        
        int timeStart[n];
        int cicleTime[n];

        // Irá repetir de acordo com o tamanho inserido
        for (int i = 0; i < n; i++)
        {
            scanf("%d", &timeStart[i]); // Tempo início
            scanf("%d", &cicleTime[i]); // Quantidade de tempo gasto
        }

        select(timeStart, cicleTime, n);
        show(timeStart, n);
        show(cicleTime, n);
    }
}