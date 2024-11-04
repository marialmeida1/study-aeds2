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


// Classe Queue
Cel *first;
Cel *last;

void start() {
    first = newCel(-1);
    last = first;
}

void enqueue(int x){
    Cel *tmp = newCel(x);
    last->prox = tmp;
    last = tmp;
}

int dequeue() {
    if(first == last){
        printf("Não é possível remover esse elemento!");
    }

    Cel *tmp = first;
    first = first->prox;
    int aws = first->el;
    tmp->prox = NULL;
    free(tmp);
    tmp = NULL;
    return aws;
} 

void show() {
    for(Cel* i = first->prox; i != NULL; i = i->prox){
        printf("%d ", i->el);
    }
}

int main(int argc, char** argv){
   int x1, x2, x3;
   printf("\n==== FILA FLEXIVEL ====");

   start();

   enqueue(5);
   enqueue(7);
   enqueue(8);
   enqueue(9);

   printf("\nApos insercoes(5, 7, 8, 9): ");
   show();

   x1 = dequeue();
   x2 = dequeue();

   printf("\nApos remocoes (%d, %d):", x1, x2);
   show();

   enqueue(3);
   enqueue(4);


   printf("\nApos insercoes(3, 4): ");
   show();

   x1 = dequeue();
   x2 = dequeue();
   x3 = dequeue();

   printf("\nApos remocoes (%d, %d, %d):", x1, x2, x3);
   show();

   enqueue(4);
   enqueue(5);

   printf("\nApos insercoes(4, 5): ");
   show();

   x1 = dequeue();
   x2 = dequeue();

   printf("\nApos remocoes (%d, %d):", x1, x2);
   show();

   enqueue(6);
   enqueue(7);

   printf("\nApos insercoes(6, 7): ");
   show();

   x1 = dequeue();

   printf("\nApos remocao (%d):", x1);
   show();
}