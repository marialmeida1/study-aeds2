## Infixo e Posfixo

O professor pediu para você escrever um programa que converte uma expressão infixa para uma expressão pós-fixa. Como você sabe, os termos in e pos estão de acordo com os operadores position. O programa terá que lidar apenas com os operadores binários +, -, *, /, ^. parênteses, letras e números. Um exemplo seria uma expressão como:
(A*B+2*C^3)/2*A. O programa deve converter esta expressão (infixa) para a expressão pós-fixa: AB*2C3^*+2/A*
Todas as expressões dos casos de teste são expressões com sintaxe válida.

## Entrada
A primeira linha de entrada é um inteiro N (N < 1000), que indica o número total de casos de teste. Cada caso é uma expressão válida no formato infixo.

## Saída
Para cada caso de teste, imprima a expressão convertida para expressão pós-fixa.

| Input Sample                   | Output Sample              |
|--------------------------------|----------------------------|
| **3**                          | **A2\***                   |
| **A\*2**                       | **A2\*c+d-2/**             |
| **(A\*2+c-d)/2**               | **24\*ab^/2c\*/**          |
| **(2\*4/a^b)/(2\*c)**          |                            |
