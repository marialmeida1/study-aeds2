#include <stdio.h>

int main() {
   
   int n = 6;
   char values[n];
   for(int i = 0; i < n; i++){
        scanf(" %c", &values[i]);
   }
   
    int cont = 0;
   for(int i = 0; i < n; i++){
        if(values[i] == 'V'){
            cont++;
        }
   }

   if( (cont == 5 || cont == 6)){
    printf("1");
   } else if( (cont == 3 || cont == 4)){
    printf("2");
   } else if( (cont == 1 || cont == 2)){
    printf("3");
   } else {
    printf("-1");
   }

   

}