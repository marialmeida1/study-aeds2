# Prova de Algoritimos e Estrutura de Dados 2 - Prova 02

1. [Ordenação](#ordenacao)
    - [Introdução]
2. [Estrutura de Dados Flexível](#estrutura-de-dados-flexivel)

## Ordenação

### Introdução 

A ordenação de códigos é uma tarefa extremamente importante pois facilita a busca de dados e análise de conjuntos de informações. Com dados ordenados podemos realizar pesquisas mais ágeis e de custos inferiores. Alguns algoritimos de ordenação são o Seleção, Inserção, Quick Sort, sendo cada um deles será abordado abaixo.

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

Se o array tiver 10 posições, o `for externo` irá se iniciar na posição `9` irá seu `for interno` na posição 0. O segundo passo, fará com que o for interno caminhe até a posição `8`. O `for interno` possui sua referência por meio da variável `j`, ou seja, a cada novo incremento do `j` será feito uma comparação se na posição `j` o valor é maior que na posição `j+1`. Realizando trocas incessantes por meio do método `swap`, caso a premissa seja verdadeira.

###### O que pode se concluir desse algorítimo?

O `for externo` funciona somente como um modo de referência sobre até onde o `j` no qual pertence ao `for interno` poderá caminhar. Ou seja, ele é um limitador de informações! Enquanto isso o `for interno` realiza todo o papel em si de ordenação.

###### Mas porque começar de (n-1)?

Importante sempre relembrar que o nosso for inicia no índice no 0, assim, para acessar de modo adequado todas as posições devemos tem a inicialização como n-1, pois, por exemplo, se o array tiver 4 posições começaremos na posição 3, ou seja a última!

###### Código

```java
for(int i = (n-1); i > 0; i--){
    for(int j = 0; j < i; i++){
        if(array[j] > array[j+1]){
            swap(j, j+1);
        }
    }
}
```

#### Bolha - Análise de Complexidade

##### Comparações
-  O(n²) para todos os casos

##### Movimentações
- **Pior Caso:** ordenado de forma decrescente O(n²)
- **Melhor Caso:** ordeado de forma creceste O(n)



### Algorítimo de Ordenação - Inserção

O algorítimo de `inserção` é conhecido por ser um algorítimo de fácil compreensão e que apresenta uma complexidade ruim, comparado a algoŕitimos mais modernos. Entretanto, apresenta um bom desempenho quando necessitamos somente ordenar poucos valores ou com arrays já ordenados.

Seu funcionamento básico segue: 
- início na segunda posição
- ordenação de trás para frente de onde a posição index se encontra

#### Inserção - Algorítimo

O código de inserção apresenta três características muito importantes, sendo elas:
- `for externo`: ele inicia na segunda posição e define qual elemento será ordenado
- `for interno`: ele apresenta estrutura condicionais, assim, caso existam posições ordenadas ele não irá ser percorrido. Ele é o método principal de ordenação de valores.
- `troca de valores`: diferente de muitos métodos conhecidos ele não utiliza o famoso método `swap`, e sim, uma forma de trocas de posições e valores, como se "copiasse um valor para um posição a frente", para que assim, encontre a posição exata que seu elemento `i` deve estar.

Uma das partes mais importantes desse método é a sua estrutura de repetição interna, pois a partir dela iremos realizar em si a ordenação do código. Ela apresenta dois condicionais muito importantes, sendo eles:

- `j >= 0`: dentro da nossa estrutura de repetição que desse caso será o `while`, sempre que repetirmos o laço interno iremos decrementar o `j`. Desse modo, como precisamos acessar a posição `0` em algum momento o nossa variável `j` será inferior a `0`, e a partir desse momento teremos que encerrar o laço para não acessar posições inexistêntes. Portanto, caso essa afirmativa: `j >= 0` for falsa não iremos nem entrar na segunda condição.
- `tmp < array[j]`: caso a primeira condição for validada como verdadeira iremos validar a segunda condição, que agora sim, se refere a fatores de ordenação. Logo no início do for interno, temos a declaração da nossa variável `tmp` que armazenará o dado que estamos validando. Essa condição irá verificar se a nossa variável `tmp` que de formas lógicas está mais a frente no array, se ela é menor que os valores anteriores. Caso for, entrará no método e a ordenação e busca de posição será feita.

##### Porque chamar `inserção`:

Analisando a estrutura do código vemos que a posição do elemento `tmp` é algo encontrado, ou seja, a variável fica "suspensa" até a sua posição ser definida. Somente após o fim do `while` interno que temos a definição de onde esse valor se localizará na nossa estrutura

##### Código

```java
for(int i = 1; i < n; i++){

    int tmp = array[i];
    int j = i - 1;

    while( (j >= 0) && (tmp < array[j])){
        array[j-1] = array[j];
        j--;
    }

    array[j+1] = tmp;
}
``` 

##### Informações importantes

- **Definição de `j`:** a variável `j` deve ser definida como um valor anterior a `i` para que assim não seja acessado o valor que estamos trabalhando, e a ordenção de valores dentro do while interno não ultrapasse dados.
- **Posição da variável `tmp`:** como o `j` é decrementado sempre em um valor a mais do que o desejado, devemos fazer um incremento em `j` para que assim possamos definir seu valor com exatidão

#### Inserção - Análise de Complexidade

- **Pior caso:** o pior caso acontecesse quando os dados estão ordenados de forma decrescente, tendo que realizar uma reeordenação de todos os valores. Sua análise de complexidade nesse caso é igual a O(n²).
- **Melhor caso:** por meio da estrutura condicional criada temos um possibilidade do for interno nunca ser acessado caso os dados estejam ordenados de forma crescente. Assim, sua análise de complexidade será O(n).