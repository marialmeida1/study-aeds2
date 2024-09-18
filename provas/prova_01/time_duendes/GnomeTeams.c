#include <stdio.h>
#include <string.h>
#define MAX 20

void selecao(int idade[], char nome[][MAX], int n)
{
    for (int i = 0; i < n - 1; i++)
    {
        int maior = i;
        for (int j = i + 1; j < n; j++)
        {
            if (idade[maior] < idade[j])
            {
                maior = j;
            }
            else if (idade[maior] == idade[j])
            {
                if (strcmp(nome[maior], nome[j]) > 0)
                { 
                    maior = j;
                }
            }
        }
        swapInt(idade, maior, i);
        swapString(nome, maior, i);
    }
}


void swapInt(int array[], int maior, int i)
{
    int aux = array[i];
    array[i] = array[maior];
    array[maior] = aux;
}

void swapString(char array[][MAX], int maior, int i)
{
    char aux[MAX];
    strcpy(aux, array[i]);
    strcpy(array[i], array[maior]);
    strcpy(array[maior], aux);
}

void getTime(int idade[], char nome[][MAX], int n)
{
    int time = n / 3;
    for (int i = 0; i < time; i++)
    {
        int x = 0;
        printf("Time %d\n", i + 1);
        for (int j = 0; j < 3; j++)
        {
            printf("%s %d\n", nome[i + x], idade[i + x]);
            x += time;
        }
        printf("\n");
    }
}

int main()
{

    int n;
    do
    {
        scanf("%d", &n);
    } while (n < 3 || n > 30);

    int idade[n];
    char nome[n][MAX];

    for (int i = 0; i < n; i++)
    {
        scanf("%s", nome[i]);
        scanf("%d", &idade[i]);
    }

    selecao(idade, nome, n);
    getTime(idade, nome, n);
}