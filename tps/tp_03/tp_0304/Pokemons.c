#include <string.h>
#include <stdlib.h>
#include <stdio.h>
#include <stdbool.h>
#include <math.h>

// Variáveis globais
#define MAX_STRING 1024
#define MAX_LIST 10
#define MAX_LIST_CLASS 100
#define MAX_CLASS 1000

// Estruturas de struct

// Date -> armazena a data do Pokemon
typedef struct
{
    int day;
    int month;
    int year;
} Date;

typedef struct // "Classe" Lista
{
    int n;
    char *element[MAX_LIST];
} List;

typedef struct // "Classe" Pokemons
{
    int id;
    int generation;
    char name[MAX_STRING];
    char description[MAX_STRING];
    List types;     // Lista -> aponta para uma posição da lista
    List abilities; // Lista -> aponta para uma posição da lista
    double weight;
    double height;
    int captureRate;
    bool isLegendary;
    Date captureDate;
} Pokemons;

typedef struct // "Classe" Lista para Classe
{
    int n;
    int start;
    int end;
    Pokemons element[5];
} ListPokemons;

// ====== GERENCIAMENTO DA LISTA ATRIBUTOS ======
// Inciar lista
void initList(List *list)
{
    list->n = 0;
    for (int i = 0; i < MAX_LIST; i++)
    {
        list->element[i] = NULL; // Inicializa os elementos como NULL
    }
}

// Insere no início da lista
int insertList(List *list, char *el)
{
    if (list->n < MAX_LIST)
    {
        list->element[list->n] = (char *)malloc(strlen(el) + 1);
        if (list->element[list->n] != NULL)
        {
            strcpy(list->element[list->n], el);
            list->n++;
            return 1;
        }
    }
    return 0;
}

// Mostra elementos da lista
void showList(List *list)
{
    for (int i = 0; i < list->n; i++)
    {
        printf("'%s'", list->element[i]);
        if (list->element[i + 1] != NULL)
        {
            printf(", ");
        }
    }
}

// ======= FUNÇÕES AUXILIARES =======
// Pega a posição do caracter procurado
int indexOf(const char *str, const char *find)
{
    char *pos = strstr(str, find);
    if ((pos != NULL))
    {
        return pos - str;
    }
    return -1;
}

// Retorna um recorte de uma string
char *substring(const char *str, int start, int lenght)
{
    // Se "não foi" colocado valor seta como o tamanho da string
    if (lenght == 0)
    {
        lenght = strlen(str);
    }

    // Cria uma String
    char *subStr = (char *)malloc(lenght + 1);
    if (subStr == NULL)
    {
        return NULL;
    }

    strncpy(subStr, str + start, lenght);
    subStr[lenght] = '\0';
    return subStr;
}

// String -> Date
Date insertDate(char *date)
{
    Date newDate;
    char *day_str = substring(date, 0, indexOf(date, "/"));
    date = substring(date, indexOf(date, "/") + 1, 0);
    char *month_str = substring(date, 0, indexOf(date, "/"));
    date = substring(date, indexOf(date, "/") + 1, 0);
    char *year_str = malloc(5 * sizeof(char));
    strcpy(year_str, date);

    int day = atoi(day_str);
    int month = atoi(month_str);
    int year = atoi(year_str);
    newDate.day = day;
    newDate.month = month;
    newDate.year = year;
    free(year_str);
    return newDate;
}

// Date -> String
char *formatDate(Date date)
{
    char *dateStr = malloc(11 * sizeof(char));
    if (dateStr == NULL)
    {
        fprintf(stderr, "Memory allocation failed\n");
        exit(1);
    }

    snprintf(dateStr, 11, "%02d/%02d/%04d", date.day, date.month, date.year);

    return dateStr;
}

// ========= Funções básicas para a manipulação da classe pokemons ========
// Construtor da classe Pokemons
void initPokemon(Pokemons *pokemon, int id, int generation, const char *name, const char *description,
                 double weight, double height, int captureRate, bool isLegendary, Date captureDate)
{
    pokemon->id = id;
    pokemon->generation = generation;
    strncpy(pokemon->name, name, MAX_STRING);
    strncpy(pokemon->description, description, MAX_STRING);
    pokemon->weight = weight;
    pokemon->height = height;
    pokemon->captureRate = captureRate;
    pokemon->isLegendary = isLegendary;
    pokemon->captureDate = captureDate;

    initList(&pokemon->types);
    initList(&pokemon->abilities);
}

// Printa a classe Pokemons
void print(Pokemons *pokemons)
{
    if (pokemons == NULL || pokemons->id == 0 || pokemons->name == NULL || pokemons->description == NULL)
    {
        return; // Sai da função se o Pokémon não for válido
    }

    printf("[#%d -> %s: ", pokemons->id, pokemons->name);
    printf("%s - ", pokemons->description);
    printf("[");
    showList(&pokemons->types);
    printf("] - ");
    printf("[");
    showList(&pokemons->abilities);
    printf("] - ");
    printf(
        "%.1fkg - %.1fm - %d%% - %s - %d gen] - %s\n",
        pokemons->weight,
        pokemons->height,
        pokemons->captureRate,
        pokemons->isLegendary ? "true" : "false",
        pokemons->generation,
        formatDate(pokemons->captureDate));
}

void read(char *line, Pokemons *pokemons)
{
    int start = 0; // Inicio da linha
    int end = 0;   // Final da linha

    // ID
    // Pega os valores
    end = indexOf(line, ",");
    char *id_str = substring(line, 0, end);
    line = substring(line, end + 1, 0);
    int id = atoi(id_str);
    pokemons->id = id;

    // Generation
    // Pega valores
    end = indexOf(line, ",");
    char *generation_str = substring(line, 0, end);
    line = substring(line, end + 1, 0);
    int generation = atoi(generation_str);
    pokemons->generation = generation;

    // Name
    // Pega valores
    end = indexOf(line, ",");
    char *name = substring(line, 0, end);
    line = substring(line, end + 1, 0);
    strcpy(pokemons->name, name);

    // Description
    // Pega valores
    end = indexOf(line, ",");
    char *description = substring(line, 0, end);
    line = substring(line, end + 1, 0);
    strcpy(pokemons->description, description);

    // PEGANDO TYPE
    //================
    initList(&pokemons->types);
    // Type1
    // Pega valores
    end = indexOf(line, ",");
    char *type1 = substring(line, 0, end);
    line = substring(line, end + 1, 0);

    // Type2
    // Pega valores
    end = indexOf(line, ",");
    char *type2 = substring(line, 0, end);
    line = substring(line, end + 1, 0);
    insertList(&pokemons->types, type1);
    if (end != 0)
    {
        insertList(&pokemons->types, type2);
    }
    free(type1);
    free(type2);

    // PEGANDO ABILITIES
    // =======================
    initList(&pokemons->abilities);
    start = indexOf(line, "[") + 1;
    end = indexOf(line, "]");

    // === Redimensiona a linha ===
    char *expression = substring(line, start, end - start);
    line = substring(line, end + 3, 0);

    int n = 0;
    do
    {
        char *abilities = NULL;
        start = indexOf(expression, ",");
        if (start < 0)
        {
            abilities = substring(expression, 1, strlen(expression) - 2);
            if (abilities != NULL)
            {
                insertList(&pokemons->abilities, abilities);
            }
            break;
        }
        abilities = substring(expression, 1, start - 2);
        if (abilities != NULL)
        {
            insertList(&pokemons->abilities, abilities);
        }
        expression = substring(expression, start + 2, 0);
        n++;
    } while (n < MAX_LIST);
    free(expression);

    start = 0;

    // Weight
    // Pega valores
    end = indexOf(line, ",");
    char *weight_str = substring(line, 0, end);
    line = substring(line, end + 1, 0);
    double weight = atof(weight_str);
    pokemons->weight = weight;
    free(weight_str);

    // Height
    // Pega valores
    end = indexOf(line, ",");
    char *height_str = substring(line, 0, end);
    line = substring(line, end + 1, 0);
    double height = atof(height_str);
    pokemons->height = height;
    free(height_str);

    // CaptureRate
    // Pega valores
    end = indexOf(line, ",");
    char *captureRate_str = substring(line, 0, end);
    line = substring(line, end + 1, 0);
    int captureRate = atoi(captureRate_str);
    pokemons->captureRate = captureRate;
    free(captureRate_str);

    // IsLegendary
    // Pega valores
    end = indexOf(line, ",");
    char *isLegendary_str = substring(line, 0, end);
    line = substring(line, end + 1, 0);
    int isLegendary_int = atoi(isLegendary_str);
    bool isLegendary = (isLegendary_int != 0);
    pokemons->isLegendary = isLegendary;
    free(isLegendary_str);

    // CaptureRate
    // Pega valores
    Date date = insertDate(line);
    pokemons->captureDate = date;
}

// ====== GERENCIAMENTO DA LISTA CLASSE ======
void init(ListPokemons *list)
{
    list->n = 0;
    list->start = 0;
    list->end = 0;
}

void mostrar(ListPokemons *list)
{
    int i;
    int indice = list->start;

    for (i = 0; i < list->n; i++)
    {
        int indice = (list->start + i) % 5;
        printf("[%d] ", i);
        print(&list->element[indice]);
    }
}

void inserirFim(ListPokemons *list, Pokemons x)
{

    // Valida e faz a remoção
    if (list->n == 5)
    {
        list->start = (list->start + 1) % 5;
        list->n--;
    }

    // Insere um novo elemento
    list->element[list->end] = x;
    list->end = (list->end + 1) % 5;
    list->n++;

    int sum = 0;
    for (int i = 0; i < list->n; i++)
    {
        int indice = (list->start + i) % 5;
        sum += list->element[indice].captureRate;
    }

    int media = round((double)sum / list->n);
    printf("Média: %d", media);
    printf("\n");
}

Pokemons removerInicio(ListPokemons *list)
{
    // Faz validação
    if (list->n == 0)
    {
        printf("Erro ao remover!");
        exit(1);
    }

    // Elemento removido
    Pokemons resp = list->element[list->start];

    // Redefine o início
    list->start = (list->start + 1) % 5;
    list->n--;

    // Retorna resposta
    return resp;
}

// Variáveis globais
static Pokemons listPokemons[MAX_CLASS];
static char PATH[] = "/tmp/pokemon.csv";
/*
 * ======================================================
 * MÉTODOS DE INTERAÇÃO DOS DADOS
 * =========================================================
 */

void setListPokemons()
{
    FILE *file = fopen(PATH, "r");
    if (file == NULL) // Verificação
    {
        printf("Erro ao abrir o arquivo\n");
        return;
    }

    // Pular a primeira linha
    char line[MAX_STRING];
    if (fgets(line, sizeof(line), file) == NULL) // Verificação
    {
        printf("Erro ao ler a primeira linha ou arquivo vazio.\n");
        fclose(file);
        return; // Retorna em caso de erro na leitura
    }

    int i = 0;
    while (fgets(line, sizeof(line), file))
    {
        if (i >= MAX_CLASS)
        {
            printf("Limite de pokémons alcançado.\n");
            break;
        }

        Pokemons pokemon;
        read(line, &pokemon);
        listPokemons[i] = pokemon;
        i++;
    }

    fclose(file);
}

Pokemons *findID(int id)
{
    for (int i = 0; i < MAX_CLASS; i++)
    {
        if (listPokemons[i].id == id)
        {
            return &listPokemons[i];
        }
    }

    return NULL;
}

int main()
{
    /*Pokemons pk;
    read("181,2,Ampharos,Light Pokémon,electric,,\"['Static', 'Plus']\",61.5,1.4,45,0,25/05/1999", &pk);*/

    setListPokemons();
    char ln[MAX_STRING];
    ListPokemons pokemonsInsert;

    while (fgets(ln, sizeof(MAX_STRING), stdin))
    {
        ln[strcspn(ln, "\n")] = 0;
        if (strcmp(ln, "FIM") == 0)
        {
            break;
        }

        int id = atoi(ln);
        Pokemons *pokemon = findID(id);
        if (id != 0)
        {
            if (pokemon != NULL)
            {
                inserirFim(&pokemonsInsert, *pokemon);
            }
            else
            {
                printf("Pokemon não encontrado!\n");
            }
        }
    }

    int qtd = 0;
    scanf("%d", &qtd);
    char str_cmd[MAX_STRING];

    for (int i = 0; i <= qtd; i++)
    {
        char *parts[3];
        Pokemons *pk_find = NULL;
        char *cmd = NULL;
        int id = 0, pos = 0;

        fgets(str_cmd, MAX_STRING, stdin);
        str_cmd[strcspn(str_cmd, "\n")] = 0;

        parts[0] = strtok(str_cmd, " ");
        parts[1] = strtok(NULL, " ");
        parts[2] = strtok(NULL, " ");

        if (parts[0] != NULL)
        {
            cmd = parts[0];
        }

        if (parts[2] != NULL)
        {
            pos = atoi(parts[1]);
            id = atoi(parts[2]);
            pk_find = findID(id);
        }
        else if (parts[1] != NULL)
        {

            if (strcmp(cmd, "R*") == 0)
            {
                pos = atoi(parts[1]);
            }
            else
            {
                id = atoi(parts[1]);
                pk_find = findID(id);
            }
        }

        // Switch Case (IF)
        if (cmd != NULL)
        {
            if (strcmp(cmd, "I") == 0)
            {
                inserirFim(&pokemonsInsert, *pk_find);
            }
            else if (strcmp(cmd, "R") == 0)
            {
                Pokemons pkRF = removerInicio(&pokemonsInsert);
                printf("(R) %s\n", pkRF.name);
            }
            else
            {
                printf("Comando não reconhecido.\n");
            }
        }
    }

    printf("\n");
    mostrar(&pokemonsInsert);
    return 0;
}