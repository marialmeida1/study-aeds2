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


int main()
{
    char str[100];
    scanf("%s", str);

    int length = strlen(str);
    int result = contMais(str, length);
    printf("%d", result);
}