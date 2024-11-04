#include <stdio.h>
#include <stdlib.h>
#include <err.h>

// Classe Cel

typedef struct Cel {
    int el;
    struct Cel *prox;
} Cel;

Cel* newCel(int x) {
    Cel* new = (Cel*)malloc(sizeof(Cel));
    new->el = x;
    new->prox = NULL;
    return new;
}


// Classe Stack

Cel* top;

void start(){
    top = NULL;
}

void push(int x){
    Cel* tmp = newCel(x);
    tmp->prox = top;
    tmp = top;
    tmp = NULL;
}

int pop() {
    if (top == NULL) {
        printf("Erro ao remover elemento!\n");
        return -1; // Return an error code
    }

    int aws = top->el;
    Cel* tmp = top;
    top = top->prox;
    free(tmp); // Use free to deallocate memory
    return aws;
}


int show(){
    for(Cel* i = top; i != NULL; i = i->prox){
        printf("%d ", i->el);
    }
}

int main(int argc, char** argv){
   int x1, x2, x3;

   printf("==== PILHA FLEXIVEL ====\n");

   start();

   push(0);
   push(1);
   push(2);
   push(3);
   push(4);
   push(5);

   printf("Apos insercoes: \n");
   show();

   x1 = pop();
   x2 = pop();
   x3 = pop();

   printf("Apos as remocoes (%d, %d, %d) \n ", x1, x2, x3);
   show();
}

