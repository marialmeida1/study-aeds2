#include <string.h>
#include <stdlib.h>
#include <stdio.h>
#include <stdbool.h>
#include <time.h>

// Variáveis globais
#define MAX_STRING 1024
#define MAX_LIST 10
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

// Lista dinâmica
typedef struct Cel
{
    Pokemons el;
    struct Cel *prox;
    struct Cel *ant;
} Cel;

Cel *newCel(Pokemons x)
{
    Cel *tmp = (Cel *)malloc(sizeof(Cel));
    tmp->el = x;
    tmp->prox = NULL;
    tmp->ant = NULL;
    return tmp;
}

// CLASSE LIST
Cel *first;
Cel *last;

// ====== GERENCIAMENTO DA LISTA ======
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

// Retorna um recolorte de uma string
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

int tamanho()
{
    int tam = 0;
    for (Cel *i = first; i != NULL; i = i->prox)
    {
        tam++;
    }
    return tam;
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

// ====== GERENCIAMENTO DA LISTA CLASSE ======{
// Inserir no início
void inserirInicio(Pokemons x)
{
    Cel *tmp = newCel(x);

    if (first == NULL)
    {
        first = last = tmp;
    }
    else
    {
        tmp->prox = first;
        first->ant = tmp;
        first = tmp;
    }
}

// Inserir no final
void inserirFim(Pokemons x)
{
    Cel *tmp = newCel(x);

    if (last == NULL)
    {
        first = last = tmp;
    }
    else
    {
        tmp->ant = last;
        last->prox = tmp;
        last = tmp;
    }
}

// Inserir em qualquer posição
void inserir(Pokemons x, int pos)
{
    int tam = tamanho();

    if (pos < 0 || pos > tam)
    {
        printf("Erro ao inserir posição (%d/ tamanho = %d) inválida!\n", pos, tam);
    }
    else if (pos == 0)
    {
        inserirInicio(x);
    }
    else if (pos == tam)
    {
        inserirFim(x);
    }
    else
    {
        Cel *tmp = newCel(x);
        Cel *i = first;

        // Caminha até a posição
        for (int j = 0; j < pos; j++, i = i->prox)
            ;

        tmp->prox = i;
        tmp->ant = i->ant;
        i->ant->prox = tmp;
        i->ant = tmp;
    }
}

// Remover do início
Pokemons removerInicio()
{
    if (first == NULL)
    {
        printf("Erro ao remover (lista vazia)!\n");
        exit(1);
    }

    Cel *tmp = first;
    Pokemons resp = first->el;

    if (first == last)
    {
        first = last = NULL;
    }
    else
    {
        first = first->prox;
        first->ant = NULL;
    }

    free(tmp);
    return resp;
}

// Remover do final
Pokemons removerFim()
{
    if (last == NULL)
    {
        printf("Erro ao remover (lista vazia)!\n");
        exit(1);
    }

    Cel *tmp = last;
    Pokemons resp = last->el;

    if (first == last)
    {
        first = last = NULL;
    }
    else
    {
        last = last->ant;
        last->prox = NULL;
    }

    free(tmp);
    return resp;
}

// Remover de qualquer posição
Pokemons remover(int pos)
{
    int tam = tamanho();

    if (first == NULL)
    {
        printf("Erro ao remover (lista vazia)!\n");
        exit(1);
    }
    else if (pos < 0 || pos >= tam)
    {
        printf("Erro ao remover posição (%d/ tamanho = %d) inválida!\n", pos, tam);
        exit(1);
    }
    else if (pos == 0)
    {
        return removerInicio();
    }
    else if (pos == tam - 1)
    {
        return removerFim();
    }
    else
    {
        Cel *i = first;

        // Caminha até a posição
        for (int j = 0; j < pos; j++, i = i->prox)
            ;

        Pokemons resp = i->el;
        i->ant->prox = i->prox;
        i->prox->ant = i->ant;
        free(i);
        return resp;
    }
}

// Mostrar elementos da lista
void mostrar()
{
    Cel *i;
    int cont = 0;
    for (i = first; i != NULL; i = i->prox)
    {
        print(&i->el);
        cont++;
    }
}

// Mostrar elementos na ordem inversa
void mostrarReverso()
{
    Cel *i;
    int cont = tamanho() - 1;
    for (i = last; i != NULL; i = i->ant)
    {
        printf("[%d] ", cont);
        print(&i->el);
        cont--;
    }
}

// Variáveis globais
static Pokemons listPokemons[MAX_CLASS];
static char PATH[] = "/tmp/pokemon.csv";
static int comparisons = 0;
static int movements = 0;
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

void cloneArray(int id, Pokemons *newArray, int *pos)
{
    for (int i = 0; listPokemons[i].name[0] != '\0'; i++)
    {
        if (listPokemons[i].id == id)
        {
            newArray[*(pos)] = listPokemons[i];
        }
    }
}

void swapNodes(Cel *nodeA, Cel *nodeB)
{
    if (nodeA == NULL || nodeB == NULL)
    {
        printf("Erro: Não é possível trocar nós nulos.\n");
        exit(EXIT_FAILURE);
    }

    Pokemons temp = nodeA->el;
    nodeA->el = nodeB->el;
    nodeB->el = temp;

    movements++;
}

Cel* partition(Cel *low, Cel *high)
{
    Pokemons pivot = high->el; 
    Cel *i = low->ant;        

    for (Cel *j = low; j != high; j = j->prox)
    {
        comparisons++;
        if (j->el.generation < pivot.generation ||
            (j->el.generation == pivot.generation &&
             strcmp(j->el.name, pivot.name) < 0))
        {
            i = (i == NULL) ? low : i->prox;
            swapNodes(i, j);
        }
    }

    i = (i == NULL) ? low : i->prox;
    swapNodes(i, high);
    return i;
}


void quickSort(Cel *low, Cel *high)
{
    if (low != NULL && high != NULL && low != high && low != high->prox)
    {
        Cel *pi = partition(low, high);

        quickSort(low, pi->ant);
        quickSort(pi->prox, high);
    }
}

void generatorLog(long executionTime)
{
    char matricula[] = "863593_quicksort";
    char nomeArquivo[32];
    snprintf(nomeArquivo, sizeof(nomeArquivo), "%s.txt", matricula);

    FILE *file = fopen(nomeArquivo, "w");
    if (file == NULL)
    {
        printf("Erro ao abrir o arquivo de log: %s\n", nomeArquivo);
        return;
    }

    fprintf(file, "Matrícula\tTempo\tBigO\tValor de Comparações\tValor de Movimentações\n");
    fprintf(file, "%s\t%ld\tO(n * log(n)))\t%d\t%d\n", matricula, executionTime, comparisons, movements);
    fclose(file);
}

int main()
{
    struct timespec start, end;
    clock_gettime(CLOCK_MONOTONIC, &start);
    setListPokemons();
    Pokemons newArray[MAX_CLASS];
    char ln[MAX_STRING];
    int i = 0;
    int pos = 0;

    scanf("%s", ln);

    while (strcmp(ln, "FIM") != 0)
    {
        ln[strcspn(ln, "\n")] = 0;
        if (i == 0)
        {
            int id = atoi(ln);
            Pokemons *pokemon = findID(id);
            if (id != 0)
            {
                if (pokemon != NULL)
                {
                    inserirFim(*pokemon);
                }
                else
                {
                    printf("Pokemon não encontrado!\n");
                }
            }
        }
        scanf("%s", ln);
    }

    int size = tamanho();
    quickSort(first, last);
    for (int i = 0; i < pos; i++)
    {
        print(&newArray[i]);
    }
    mostrar();

    clock_gettime(CLOCK_MONOTONIC, &end);
    long elapsedTime = (end.tv_sec - start.tv_sec) * 1e9 + (end.tv_nsec - start.tv_nsec);
    generatorLog(elapsedTime);

    return 0;
}
