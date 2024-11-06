#include <stdio.h>
#include <stdlib.h>

// CLASSE CEL
typedef struct Cel
{
    int el;
    struct Cel* prox;
} Cel;

Cel newCel(int x){
    Cel* newCel = (Cel *)malloc(1*sizeof(Cel));
    newCel->el = x;
    newCel->prox = NULL;
    return newCel;
}

// CLASSE LIST
Cel *first;
Cel *last;

void start(){
    first = newCel(-1);
    last = first;
}

// INSERIR
// Inserir Início
void insertStart(int x){

    Cel *tmp = newCel(x);
    tmp->prox = first->prox;
    first->prox = tmp;
    if(first == last){
        last = tmp;
    }
    tmp = NULL;
}

// Inserir End
void insertEnd(int x){
    Cel* tmp = newCel(x);
    last->prox = tmp;
    last = tmp;
}

// Inserir qualquer posição
void insert(int x, int pos){

    Cel* i = first;
    for(int j = 0; j < pos; j++; i = i.prox);

    Cel* tmp = newCel(x);
    tmp->prox = i.prox;
    i.prox = tmp;
    tmp = NULL;
}
