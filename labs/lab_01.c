#include <stdio.h>
#include <ctype.h>

int isMaiscula(char c)
{
    if (isupper(c))
    {
        return 1;
    }

    return 0;
}

int contMais(char *str, int n)
{
    printf("%c", str[1]);
    int cont = 0;

    for (int i = 0; i < n; i++)
    {
        if (isMaiscula(str[i]))
        {
            cont++;
        }
    }

    return cont;
}

int contMaisRecursivo(char *str, int index, int n)
{
    if (index == n)
    {
        return 0;
    }

    // Ternário -> soma 1 se for verdade e 0 se for falso
    int cont = isMaiscula(str[index]) ? 1 : 0;

    // Vai somando
    return cont + contMaisRecursivo(str, index + 1, n);
}

int contMais_recu(char *str, int n){
    contMaisRecursivo(str, 0, n);
}

int main()
{

    int result = contMais_recu("maRi", 4);
    printf("Tem %d maisculas", result);
}