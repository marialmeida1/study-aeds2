#include <stdio.h>
#include <ctype.h>
#include <string.h>

int isMaiscula(char c)
{
    if (isupper(c))
    {
        return 1;
    }

    return 0;
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
    char str[100];
    scanf("%s", str);

    int length = strlen(str);  // Calcula o comprimento da string
    int result = contMais_recu(str, length);
    printf("%d", result);
}