#include <string.h>
#include <stdlib.h>
#include <stdio.h>
#include <stdbool.h>

// Tamanhos definidos
#define MAX_STRING 1000
#define MAX_LIST 10
#define MAX_CLASS 1000
#define MAX_LINE 1024

// Classe de "Date"
typedef struct
{
    int day;
    int month;
    int year;
} Date;

// Classe de Pokemon
typedef struct
{
    int id;
    int generation;
    char *name;
    char *description;
    char **types;     // Lista
    char **abilities; // Lista
    double weight;
    double height;
    int captureRate;
    bool isLegendary;
    Date captureDate;
} Pokemons;

// Funções auxiliares
int indexOf(const char *str, const char *find)
{
    char *pos = strstr(str, find);
    if ((pos != NULL))
    {
        int value = pos - str;
        return pos - str;
    }
    return -1;
}

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

// Construtor
void ConstPokemons(Pokemons *pokemons, int id, int generation, char *name, char *description, char **types,
                   char **abilities, double weight, double height, int captureRate, bool isLegendary,
                   Date captureDate)
{

    // Diretamente
    pokemons->id = id;
    pokemons->generation = generation;

    // Alocando memórias
    pokemons->name = malloc(MAX_STRING);
    strcpy(pokemons->name, name);
    pokemons->description = malloc(MAX_STRING);
    strcpy(pokemons->description, description);

    // Lista de tamanho 2 -> Cria um String em cada posição
    pokemons->types = malloc(2 * sizeof(char *));
    for (int i = 0; i < 2; i++)
    {
        pokemons->types[i] = malloc(MAX_STRING + 1); // Tamanho de uma string
        strcpy(pokemons->types[i], types[i]);
    }

    // Lista de tamanho MAX_LIST = 10 -> Cria um String em cada posição
    pokemons->abilities = malloc(MAX_LIST * sizeof(char *));
    for (int i = 0; i < MAX_LIST; i++)
    {
        pokemons->abilities[i] = malloc(MAX_STRING + 1); // Tamanho de uma string
        strcpy(pokemons->abilities[i], abilities[i]);
    }

    // Diretamente
    pokemons->weight = weight;
    pokemons->height = height;
    pokemons->captureRate = captureRate;
    pokemons->isLegendary = isLegendary;
    pokemons->captureDate = captureDate;
}

// Getter
int getId(Pokemons *pokemons)
{
    return pokemons->id;
}

int getGeneration(Pokemons *pokemons)
{
    return pokemons->generation;
}

char *getName(Pokemons *pokemons)
{
    return pokemons->name;
}

char *getDescription(Pokemons *pokemons)
{
    return pokemons->description;
}

char **getTypes(Pokemons *pokemons)
{
    return pokemons->types;
}

char **getAbilities(Pokemons *pokemons)
{
    return pokemons->abilities;
}

double getWeight(Pokemons *pokemons)
{
    return pokemons->weight;
}

double getHeight(Pokemons *pokemons)
{
    return pokemons->height;
}

int getCaptureRate(Pokemons *pokemons)
{
    return pokemons->captureRate;
}

bool getIsLegendary(Pokemons *pokemons)
{
    return pokemons->isLegendary;
}

char *getCaptureDate(Pokemons *pokemons)
{
    return formatDate(pokemons->captureDate);
}

// Setter
void setId(Pokemons *pokemons, int id)
{
    pokemons->id = id;
}

void setGeneration(Pokemons *pokemons, int generation)
{
    pokemons->generation = generation;
}

void setName(Pokemons *pokemons, char *name)
{
    pokemons->name = strdup(name);
}

void setDescription(Pokemons *pokemons, char *description)
{
    pokemons->description = strdup(description);
}

void setTypes(Pokemons *pokemons, char **types)
{
    pokemons->types = malloc(2 * sizeof(char *)); // Aloca memória 
    if (pokemons->types == NULL)
    {
        printf(stderr, "Erro na alocação de memória para tipos\n");
        return;
    }

    // Copia dados | Tamanho 2
    for (int i = 0; i < 2; i++)
    {
        if (types[i] != NULL) // Verifica se a string não é nula
        {                                        
            pokemons->types[i] = strdup(types[i]); // Copia a string
            if (pokemons->types[i] == NULL) // Verificação
            {
                fprintf(stderr, "Erro na duplicação do tipo\n");
                exit(1);
            }
        }
        else
        {
            pokemons->types[i] = NULL; // Se NULL = NULL
        }
    }
}

void setAbilities(Pokemons *pokemons, char **abilities)
{

    pokemons->abilities = malloc(MAX_LIST * sizeof(char *)); // Aloca memória 
    if (pokemons->abilities == NULL) // Verificação
    {
        printf("Falha na alocação de memória\n");
        exit(1);
    }

    // Insere dados - tamanho MAX_LIST = 10
    for (int i = 0; i < MAX_LIST; i++) 
    {
        pokemons->abilities[i] = malloc(MAX_STRING * sizeof(char)); // Insere valores
        if (pokemons->abilities[i] == NULL) // Verificação
        {
            printf("Falha na alocação de memória para a habilidade %d\n", i);
            exit(1);
        }

        // Copia dados
        if (abilities[i] != NULL)
        {
            strcpy(pokemons->abilities[i], abilities[i]);
        }
        else
        {
            pokemons->abilities[i] = NULL; // Se NULL = NULL
        }
    }
}

void *setWeight(Pokemons *pokemons, double weight)
{
    pokemons->weight = weight;
}

void *setHeight(Pokemons *pokemons, double height)
{
    pokemons->height = height;
}

void *setCaptureRate(Pokemons *pokemons, int captureRate)
{
    pokemons->captureRate = captureRate;
}

void *setIsLegendary(Pokemons *pokemons, bool isLegendary)
{
    pokemons->isLegendary = isLegendary;
}

void *setCaptureDate(Pokemons *pokemons, Date captureDate)
{
    pokemons->captureDate = captureDate;
}

void print(Pokemons *pokemons)
{

    if (pokemons == NULL || getId(pokemons) == 0 || getName(pokemons) == NULL || getDescription(pokemons) == NULL)
    {
        return; // Sai da função se o Pokémon não for válido
    }

    printf(
        "[#%d -> %s: ",
        getId(pokemons),
        getName(pokemons));

    printf("%s - ", getDescription(pokemons));

    char **types = getTypes(pokemons);

    if (types == NULL)
    {
        return;
    }

    printf("[");
    for (int i = 0; i < 2; i++) 
    {
        if (types[i] != NULL && strcmp(types[i], "") != 0)
        {
            if (i > 0)
            {
                printf(", ");
            }
            printf("'%s'", types[i]);
        }
    }
    printf("] - ");

    char **abilities = getAbilities(pokemons);
    printf("[");
    for (int i = 0; abilities[i] != NULL; i++) // Até ser diferente de null
    {
        printf("'%s'", abilities[i]);
        if (abilities[i + 1] != NULL)
        {
            printf(", ");
        }
    }
    printf("] - ");

    printf(
        "%.1fkg - %.1fm - %d%% - %s - %d gen] - %s\n",
        getWeight(pokemons),
        getHeight(pokemons),
        getCaptureRate(pokemons),
        getIsLegendary(pokemons) ? "true" : "false",
        getGeneration(pokemons),
        getCaptureDate(pokemons));
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
    setId(pokemons, id);
    free(id_str);

    // Generation
    // Pega valores
    end = indexOf(line, ",");
    char *generation_str = substring(line, 0, end);
    line = substring(line, end + 1, 0);
    int generation = atoi(generation_str);
    setGeneration(pokemons, generation);
    free(generation_str);

    // Name
    // Pega valores
    end = indexOf(line, ",");
    char *name = substring(line, 0, end);
    line = substring(line, end + 1, 0);
    setName(pokemons, name);
    free(name);

    // Description
    // Pega valores
    end = indexOf(line, ",");
    char *description = substring(line, 0, end);
    line = substring(line, end + 1, 0);
    setDescription(pokemons, description);
    free(description);

    // PEGANDO TYPE
    //================
    char **types = malloc(2 * sizeof(char *));

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

    // Setando valores
    types[0] = strdup(type1);
    if (end != 0)
    {
        types[1] = strdup(type2);
    }
    setTypes(pokemons, types);
    for (int i = 0; i < 2; i++)
    {
        free(types[i]); // Free after setting
    }
    free(types);

    // Liberando memória

    // PEGANDO ABILITIES
    // =======================
    start = indexOf(line, "[") + 1;
    end = indexOf(line, "]");
    char **abilities_array = malloc(MAX_LIST * sizeof(char *));

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
                abilities_array[n] = abilities;
            }
            break;
        }
        abilities = substring(expression, 1, start - 2);
        if (abilities != NULL)
        {
            abilities_array[n] = abilities;
        }
        expression = substring(expression, start + 2, 0);
        n++;
    } while (n < MAX_LIST);

    setAbilities(pokemons, abilities_array);
    free(expression);
    for (int i = 0; i < n; i++)
    {
        free(abilities_array[i]);
    }
    free(abilities_array);

    start = 0;

    // Weight
    // Pega valores
    end = indexOf(line, ",");
    char *weight_str = substring(line, 0, end);
    line = substring(line, end + 1, 0);
    double weight = atof(weight_str);
    setWeight(pokemons, weight);
    free(weight_str);

    // Height
    // Pega valores
    end = indexOf(line, ",");
    char *height_str = substring(line, 0, end);
    line = substring(line, end + 1, 0);
    double height = atof(height_str);
    setHeight(pokemons, height);
    free(height_str);

    // CaptureRate
    // Pega valores
    end = indexOf(line, ",");
    char *captureRate_str = substring(line, 0, end);
    line = substring(line, end + 1, 0);
    int captureRate = atoi(captureRate_str);
    setCaptureRate(pokemons, captureRate);
    free(captureRate_str);

    // IsLegendary
    // Pega valores
    end = indexOf(line, ",");
    char *isLegendary_str = substring(line, 0, end);
    line = substring(line, end + 1, 0);
    int isLegendary_int = atoi(isLegendary_str);
    bool isLegendary = (isLegendary_int != 0);
    setIsLegendary(pokemons, isLegendary);
    free(isLegendary_str);

    // CaptureRate
    // Pega valores
    Date date = insertDate(line);
    setCaptureDate(pokemons, date);
}

// Variável Global
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
    char line[MAX_LINE];
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
    setListPokemons();
    char ln[MAX_LINE];
    while (fgets(ln, sizeof(MAX_LINE), stdin))
    {
        ln[strcspn(ln, "\n")] = 0;
        if (strcmp(ln, "FIM") == 0)
        {
            break;
        }

        int id = atoi(ln);
        Pokemons *pokemon = findID(id);
        if (pokemon != NULL)
        {
            print(pokemon);
        }
        else
        {
            printf("Pokemon não encontrado!\n");
        }
    }
    return 0;
}