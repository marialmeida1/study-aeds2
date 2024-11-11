# Prova de Algoritimos e Estrutura de Dados 2 - Prova 02

1. [Ordenação](#ordenacao)
    - [Introdução]
2. [Estrutura de Dados Flexível](#estrutura-de-dados-flexivel)

## Ordenação

### Introdução 

A ordenação de códigos é uma tarefa extremamente importante pois facilita a busca de dados e análise de conjuntos de informações. Com dados ordenados podemos realizar pesquisas mais ágeis e de custos inferiores de maneiras padrões. Alguns algoritimos de ordenação são o Seleção, Inserção, Quick Sort, cada um deles será abordado abaixo.

### Algoritimo de Ordenação - Bolha

Sendo um dos algoritimos mais simples e de fácil compreenssão, é também um dos menos eficientes em questão de desempenho. Seu nome advém do fato dele "borbulhar" trocas, ou seja, suas trocas são realizadas de forma constante e repetidamente até que todos os dados esteja ordenados.

Seu funcionamento básico segue:
- se: elemento `esquerda` maior que o da `direita` troca de posição

#### Bolha - Algoritimo

Seu algoritimo segue uma ordem de três etapas importantes:
- percorrer dados: externo
- percorrer dados: interno
- troca de informações: método `swap`

Seu primeiro passo se inicia com o `i` na posição `n-1`, ou seja, seu `for externo` apresenta seu início no fim do array de dados. Esse array externo irá percorrer com o `i` até que ele permaneça como maior que `0`, decrementando a cada novo passo. Seu segundo passo, ou seu `for externo`, dessa vez faz o sentido contrário do seu anterior, começando dessa vez da posição inicial, ou `0` e indo até a posição anterior a `i`. O que isso significa?

Se o array tiver 10 posições, o `for externo` irá se iniciar na posição `9` irá seu `for interno` na posição 0. O segundo passo, que é exatamente o for referenciado por último, irá caminhar até a posição `8`. O `for externo` possui sua referência por meio da variável `j`, ou seja, a cada novo incremento do `j` será feito uma comparação se na posição `j` o valor é maior que na posição `j+1`. Realizando trocas incessantes por meio do método `swap`, caso a premissa seja verdadeira.

O que pode se concluir desse algorítimo? O `for externo` funciona somente como um modo de referência sobre até onde o `j` no qual pertence ao `for interno` poderá caminhar. 