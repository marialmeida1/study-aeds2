# Prova de Algoritimos e Estrutura de Dados 2 - Prova 01

1. [Contando operações](#contando-operações)
    - [Como expressar os resultados](#como-expressar-os-resultados)
    - [Piores e melhores casos](#piores-e-melhores-casos)
2. [Somatórios](#somatórios)
    - [Explicação da Fórmula](#explicação-da-fórmula)
    - [Manipulação da Soma](#manipulação-da-soma)
    - [Propriedades](#propriedades)
    - [Métodos Gerais](#métodos-gerais)
3. [Algoritimos de Pesquisa](#algoritimo-de-pesquisa)
    - [Sequencial](#busca-sequencial)
    - [Binário](#busca-binária)
4. [Algoritimos de Ordenação](#algoritimo-de-ordenação)
    - [Seleção](#seleção)
    - [Inserção](#inserção)
    - [Método Bolha](#bubble-sort)
4. [TAD - Estruturas de Dados Abstratos ](#conclusão)
    - [Lista](#seção-22---tópico-2)
    - [Pilha](#seção-22---tópico-2)
    - [Fila](#seção-22---tópico-2)


## Contando operações

Toda código gera um custo de implementação, e isso pode ocorrer perante ao tempo, custo de memória e diversificados fatores. Normalmente conta-se de acordo com uma operção em específico, como multiplicação, comparações, subtrações ...
Segue um exemplo de contagem abaixo:

```java
int sum(int a, int b){
    int a = 3 - 1;
    int b = 2 + 2;
    return a + b;
}
```

O custo da operação acima é de F(n) = 3, pois é realizado três operações;

```java
int sum(){
    int cont = 0;
    for(int i = 0; i < n; i++){
        cont++;
    }
}
```

Observa-se que a operação acima tem custo de F(n) = n, pois é realizado uma conta similar com a abaixo:
F(n) = 1 + 1 + 1 + 1 + ....

Para facilitar a demostração de qual o custo da operação e evitar possíveis erros de aproximação colocamos todos os resultados como, aproximadamente x, ou ϴ(Theta) de algo. Exemplo, o código acima teria custo de ϴ(n).

### Como expressar os resultados:

Dentro da computação temos três representação muitos usuais, conhecidas como:
- Theta -> ϴ
- BigO -> O
- Ômega -> Ω

O ϴ(Theta) é usado para representar algo aproximado, como "mais ou menos isso". Por exemplo, o código seleção tem custo aproximado de ϴ(n²). Já o O(BigO) é usualmente utilizado para representar o pior caso de uma situação, e é normalmente o mais utilizado dentro do campo de computação. Por fim, o Ω(Ômega) é utilizado para representar o melhor caso de uma complexidade, seguindo assim, uma notação correta perante a matemática.

### Piores e melhores casos

Analise o código abaixo e encontre o pior e melhor caso:

```java
int find(int x, int array[]){
    for(int i = 0; i < n; i++){
        if(array[i] == x){
            return true;
        }
    }
    return false;
}
```

No código acima é possível analisar que teremos duas situações em que a nossa complexidade será afetada, nos trazendo um pior e melhor caso.

#### Pior caso

O pior caso nesse código ocorre quando o elemento "x" que estamos procurando não está no array ou se encotra na última posição, sendo necessário percorrer todo a lista de elementos para verificar a validação. Desse modo, é possível observar que o nossa função terá custo de ``O(n)``, visto que é o pior caso que encontramos.

#### Melhor caso

O melhor caso ocorre quando o elemento "x" se encontrar na primeira posição do array, evitando assim que o array percorra inteiro até encontrar o elemento correto. Quando o elemento está na primeira posição realizamos somente uma operação de comparação, tendo desse modo, um custo constante de 1, tendo assim, custo de ``Ω(1)``.    


## Somatórios

Realizar contar com códigos pequenos como os demostrados é um operação tranquila, entretanto, cada vez em que uma linha de código aumenta mais complicado fica a contagem dos dados. Para isso, é comumente usado somatórios(∑) para representar e realizar contas de modo mais fácil.

### Explicação da fórmula

```txt

 n         (n) = limite máximo
 ∑ i       (i) = fator somatório
i=0        (i = 0) = limite mínimo -> passo base

S(n) = 1 + 2 + 3 ....

```

### Manipulação da Soma

Algumas vezes teremos somatórios complexos, em que, realizar as contas manualmente realizarão problemas para atingir o resultado final. Desse modo, usamos de modos que tornem a conta mais fácil de ser realizada, utilizando basicamente três principios, sendo eles:

- Distributividade 
- Associatividade
- Comutatividade

#### Distributividade

A distributividade serve basicamente para manipular constantes multiplicativas nos somatórios, podendo serem colocadas tanto para "dentro", quando para "fora" do somatório, exemplo:

```txt
 n                     n
 ∑ i * a      ->  a *  ∑ i   
i=0                    i=0
```

#### Associatividade

A associatividade é fortemente usada quando temos uma soma ou subtração de dois somatórios, servindo assim para manipular a soma do modo a nos agradar, podendo serem "retiradas" do somatório, tanto quanto "inseridas" nele.

```txt
 n                     n
 ∑ i + a     ->  ∑ a + ∑ i   
i=0                    i=0
```

#### Comutativade

A comutatividade segue o principio da "multiplicação" -> "a ordem dos fatores não altera o resultado". Por exemplo, se temos um somatório que realiza a conta: 1 + 2 + 3 ... e outro que a realiza a conta n ... 3 + 2 + 1, teremos por final o mesmo resultado, então inverter a ordem não traz efeitos para a conta, somente a manipulação.

```txt
 n               n
 ∑ i * n     ->  ∑ i * (n-1)   
i=0              i=0
```

### Propriedades

Quando precisamos encontrar a fórmula fechada de um somatório podemos utilizar diversas técnicas que possibilitam essa transformações. Uma dessas técnicas é utilizar das propriedades dos somatórios, caracterizadas como P1 e P2. 

#### P1

A ``P1`` se trata de uma propriedade que une dos conjuntos de informações diferentes em um somatório. Por exemplo:

```txt
 m      n        n
 ∑ ai + ∑ ai  =  ∑ ai + am 
 0      m        1
```

Nesse caso, jutamos os iguais e separamos a união, como em um conjunto. Por exemplo, se temos uma conjunto i={1,2,3} e outro conjunto i'={3,4,5}, a união deles será iUi'={1,2,3,4,5} e seus exclusivos ii'={3}

#### P2

A ``P2`` se refere a base da perturbação, usada comumenete para encontrar fórmulas fechadas de alguns somatórios, como por exemplo, PG, PA...
 

```txt
                       n
S(n) + a(n+1) = a(0) + ∑ a(i+1)
                       0
```

### Métodos Gerais

Aprendemos diversos modos para achar a fórmula fechada de um somatório, mas como aplicá-las?

#### 1. Procure!

Sempre procurar nos livros qual o fórmula de um somatório, pois certamente ele já foi resolvido por alguém.

#### 2. Indução

A indução é um método utilizado para provar se a fórmula fechada do somatório está correta, usando basicamente dois métodos para isso. Sendo eles o: ``passo base`` e o outro a ``indução propriamente dita``.

##### Passo base

O passo base basta testar os valores da fórmula fechada a a fórmula padrão do somatório com o valor base. Por exemplo:

```txt
Fórmula fechada = n(n+1)/2
                      n
Fórmula do somatório: ∑i
                      1

Resultado: 

Fórmula fechada: 1(1+1)/2 -> 2/2 -> 1
Fórmula aberta: 1 -> 1
```

##### Passo indução propriamente dita

Nesse passo você a fórmula que posibilitará encontrar o valor igual a fórmula fechada, se o resultado for igual, então a fórmula fechada está correta.

```txt

S(n) = S(n) -1 + a(n)

```

#### 3. Aplicação de técnicas, P1 e P2

Nesse passo você aplicará todas as regras básicas de transformação, além da ``P1``e ``P2``.



## Algoritimo de Pesquisa

A realização de pesquisa dentro da computação é algo extremamente utilizado, como por exemplo, em busca de pessoas em listas, realização de query em banco de dados e em demais aplicações. Entretanto, tais buscas possuem custos, e algumas delas são mais favoraveis que as demais, desse vez, iremos ressaltar duas buscas muito utilizadas, sendo elas a ``busca sequencial`` e ``busca binária``.

### Busca Sequencial

A busca sequencial é um dos métodos mais simples de serem implementados dentro de algoritimos. Ela realiza uma busca contínua pelo "array" até encontrar o elemento buscado. 

```java
boolean resp = false;
    for (int i = 0; i < n; i++){
        if (array[i] == x){
        resp = true;
        i = n;
    }
}
```

#### Complexidade de Algoritimo: Busca Sequencial

A complexidade de algoritimo da busca sequencial se apresenta dois casos, sendo eles, o de melhor e pior caso. 

O melhor caso acontece quando o elemento está na primeira posição, fazendo com que o método realize somente um comparação, possuindo assim uma função de ``f(n) = 1``, de maneiras mais práticas ``O(1)``, ou seja uma complexidade constante.

O pior caso acontece quando o elemento não está no array ou se encontra na última posição, visto que, desse modo, será necessário percorrer todo o array para encontrar o elemento. Dessa maneira, realizaremos ``n`` comparações, caracterizando uma função de ``f(n) = n``, ou, ``O(n)``, desse modo, uma função linear.

### Busca Binária

Sendo um dos melhores métodos para procurar um elemento dentro de um array a busca binária se caracteriza por possuir uma complexidade boa. O método se difere do anterior por não percorrer todo o vetor de modo linear, mas sim por realizar uma busca de acordo com o valor preenchido no vetor. O funcionamento básico se trata na sub-divisão de arrays, com o primeiro passo indo em direção ao meio do array.

A partir do momento em que se encontra o meio do array, é feita uma verificação se o elemento está maior ou menor do que o elemento do meio, pois caso seja maior, a direção da busca será para o lado direito, e caso for menor, a direção será para o lado esquerdo. É muito importante ressaltar que o vetor deve estar ordenado, pois somente assim, será possível aplicar a busca.


```java
boolean resp = false;
int dir = n - 1, esq = 0, meio;
while (esq <= dir) {
    meio = (esq + dir) / 2;
    if (x == array[meio]){
        resp = true;
        esq = n;
    } else if (x > array[meio]){
        esq = meio + 1;
    } else {
        dir = meio - 1;
    }
}
```

#### Complexidade de Algoritimo: Busca Sequencial

O método também possui melhor e pior caso, variando de acordo com a posição que se encontra o elemento procurado. 

O melhor caso ocorre quando o elemento está exatamente, no meio do array, já que esse é o primeiro passo realizado pelo método. Assim, a busca binária nesse caso terá função igual a ``f(n)=1``, ou seja constante com ``O(1)``.

Já o pior caso acontece quando o elemento não se encontra no array ou está na última posição de procura, assim será realizado diversas execuções. Diferentemente do método anterior, cada vez que o método é exutado, ``n`` cai sempre pela metade, ou seja, realizando uma função igual a ``f(n) = lg(n)``, ou seja, logarítima, com ``O(lg(n))``. Portanto, se n igual a 32, o método será executado somente 5 vezes, enquanto no primeiro método de busca, seria executado 32 vezes.


## Algoritimo de Ordenação

Como afirmado anteriormente para realizar uma pesquisa de alto desempenho (busca binária) temos que ter um array ordenado, e para isso precisamos ter métodos que realizam essa ordenação. Desse vez iremos destacar três métodos de ordenação:

- Seleção (Selection)
- Inserção (Insertion)
- Método Bolha (Bubble Sort)

### Seleção 

O método seleção é um dos métodos mais básicos de ordenção. Ele realiza uma leitura pelo array parte por parte, até todos estarem ordenados. Podemos dividir seu funcionamento em duas partes, sendo essas o ``for externo`` e ``for interno``. 

O ``for externo`` determina qual parte estamos comparando, então por exemplo, estamos com ``i=0`` desse modo iremos comparar o que está dentro do array nessa determinada posição. O ``for interno`` será responsável por buscar os resultados a serem comparados, ele irá rodar até o final do array menos a posição i, até chegar ao final. É realizado desse modo para que seja armazenado a posição aonde se encontra o menor valor do array.

Chegando ao fim do array interno iremos realizar uma troca, com a posição onde se encontra ``i`` e com a posição que encontramos o menor valor do array, sendo esse o método ``swap``. Isso irá se repetir até que i seja finalizado e desse modo a ordenação também.

```java
for (int i = 0; i < (n - 1); i++) {
    int menor = i;

    for (int j = (i + 1); j < n; j++){
        if (array[menor] > array[j]){
            menor = j;
        }
    }

    swap(menor, i);
}
```

#### Como é a complexidade do algoritimo Seleção?

O algoritimo seleção possui dois loops, desse modo isso irá gerar uma função com valor O(n²), mas porque?

Quando criamos um somatório desse método iremos notar as seguintes informações:
- O somatório tem passo base de 0 por o for externo começa por 0
- Ele para em n - 2, pois vai até "menor que n - 1", ou seja, n - 2
- O for interno que é responsável por determinar que operação será validada
- O laço inteno é executado cerca de (n - (i+1)) vezes, visto que ele vai até n mas o for começa na posição i + 1
- Ou seja, o somatório tem valor de n-i-1

```txt
 n - 2     
 ∑ n - 1 - i 
 0   
```

Quando realizamos a operação para encontrar a fórmula fechada do método veremos que iremos encontrar os seguintes somatórios que nos darão a seguinte fórmula fechada:

```txt
 n - 2            n - 2   n - 2    n - 2
 ∑ n - 1 - i  ->  ∑ n -   ∑ 1 -    ∑ i
 0                0       0        0

 Isso retornará os seguintes resultados:

n(n-1) - (n-2)(n-1)/2 - (n-1) -> n²/2 - n/2

```

Analisando o resultado obtido podemos resumir que para a complexidade do nosso algoritimo é sempre O(n²).


### Inserção

Comumente usado para métodos pelo quais já estão parcialmente ordenados ou para aqueles que necessitam realizar alguma nova inserção, o "Inserção" é um bom método que apresenta características a serem analisadas quanto a sua adoção.

O método apresenta idéia de elemento "suspenso", ou seja, o elemento que será alterado de local fica temporáriamente até a finalização do while sem local até que seja encontrado a sua posição exata. Tal como o método anterior, o "Inserção" apresenta duas repartições, a do ``for`` e a do ``while``.

Como anteriormente o for determina qual elemento será comparado, mas diferente do demais, não realiza uma busca para "frente", e sim percorrendo para trás do vetor. Por exemplo, temos três dados, sendo eles 101, 110 e 20, respectivamente nas posições escritas. Quando o for chegar no "20", ele não irá prosseguir para frente, mas sim, irá realizar uma leitura inversa, colocando ele como um elemento suspenso até encontrar a sua posição exata.

```java
for (int i = 1; i < n; i++) {
    int tmp = array[i];
    int j = i - 1;
    while ( (j >= 0) && (array[j] > tmp) ){
        array[j + 1] = array[j]; // Deslocamento
        j--;
    }
    array[j + 1] = tmp;
}
```

#### Como é a complexidade do algoritimo Inserção?

O algoritimo inserção pode ter pior e melhor caso dependendo da ordem de ordenação do array. O melhor caso irá ocorrer quando o array já estiver ordenado em ordem crescente, pois desse modo, não entrará dentro das comparações do while e assim, realizará somente as repetições padrões dentro do for externo. Nesse caso, como é realizado somente pelo for externo sua função é igual a ``f(n) = n``, ou seja, função linear de ``O(n)``.

Já o pior caso ocorre quando o vetor está ordenado de forma decrescente, já que em todas posições do for externo entrará dentro do while. Portanto, como o while realiza uma própria repetição o somatório do método inserção terá as seguintes informações:
- O laço externo determina a quantidade de repetição do somatório
- O somatório começa com 0
- O somatório  vai até n - 1 

```txt
 n - 1            
 ∑ i    ->  somatório de Gauss -> S(n) = n(n-1)/2
 0              
```

Pode se concluir que no pior caso o algoritimo de inserção realiza ``O(n²), ou seja, apresenta uma função quadrática como sua complexidade.

### Bubble Sort

O Bubble Sort é um dos métodos de troca mais fáceis apresentados, visto que é extremamente didático. Esse método realiza incessantes trocas e comparações até percorrer totalmente o array. Diferente do Seleção, ele começa na parte contrária do array, fazendo uma comparação de 0 até aonde i se encontra, por padrão, i inicia do final do array indo até seu início.

Nesse método, temos dois loops, o externo que sua condição de parada é o 0 e seu inicio no n - 1, realizando de modo decrescente. O interno por sua vez, inicia de 0 e e para em i, sendo que, dentro dele, há uma condição de verificação que se o elemento na posição j for maior que seu posterior é realizado uma troca. Assim, esse método se repete constantemente até percorrer o array por completo.

```java
public void sort() {
    for (int i = (n - 1); i > 0; i--) {
        for (int j = 0; j < i; j++) {
            if (array[j] > array[j + 1]) {
                swap(j, j + 1);
            }
        }
    }
}
```
#### Como é a complexidade do algoritimo Bolha?

O algoritimo Bolha (sem otimização) possui complexidade de O(n²) em todos os casos, não apresentando melhor ou pior caso. Por possuir dois loops acoplados seu somatório apresentará o seguinte somatório:

- "for" externo determina onde o somatório começa e até onde ele vai
- ele começa em n - 1 e vai até 0, decrescendo

```txt
 n - 1            
 ∑ i    ->  somatório de Gauss -> S(n) = n(n-1)/2
 0              
```

Entretanto, é possível realizar uma otimização que possibilita o método de ordenação encerrar mais cedo que o usual, e possibilitar que faça menos comparações. Essa otimização ocorre quando o array é percorrido inteiramente e não ocorre nenhuma troca, indicando que o array está ordenado.

```java
for (int i = 0; i < n - 1; i++) {
    swapped = false;
    for (int j = 0; j < n - 1 - i; j++) {
        if (array[j] > array[j + 1]) {
            swap(j, j+1);
            swapped = true;
        }
    }
    if (!swapped) {
        break;
    }
}
```

Desse modo, evitará que o array se repita mesmo com o array já ordenado, assim, a função que antes era ``O(n²)`` agora será ``O(n)``.

## TAD - Algoritimos de Dados Básicas Lineares

Dentro de algoritimos e estruturas de dados temos organizações pré-definidas que realizam funçõe dentro de aplicações. Nesse caso, iremos ressaltar três das mais importantes:
- Lista
- Pilha
- Fila

Elas são estruturas nas quais possuem modos adequados para realizarem a inserção e deleção de seus elementos, e possuem funções que se adequam as suas diferenças. Iremos trabalhar com os dados ordenados de modo linear, como um array.

### Lista

A lista é uma estrutura de dados que possibilita o usuário inserir ou retirar informações em qualquer lugar da lista. A lista pode estar ordenada ou não, sendo de acordo com a necessidade do usuário. Ela possui alguns métodos principais, sendo eles:

- Inserir(int el, int pos)
- InserirInicio(int el)
- InserirFim(int el)
- Remover(int pos)
- RemoverInicio()
- RemoverFim()
- Mostrar()
- Pesquisar()

### Pilha

A pilha apresenta uma característica que ela ordenada de acordo com a ordem de chegada. Ou seja, ela não pode ser reeordenada. A ordem da pilha de caracteriza por, quem chega primeiro é o último a sair. Desse modo, a remoção e inserção estão na mesma porta.

``FIRST IN, LAST OUT`` ou ``FILO``

Na pilha temos duas soluções de inserção e retirada, uma delas caracterizada por ser ótimo e outra péssima.

#### Solução ótima

- Inserção no Fim
- Remoção no Fim

#### Solução péssima

- Inserção no Início
- Remoção no Início


Por padrão buscamos sempre a melhor solução, desse modo, os métodos padrões do Pilha serão:

- InserirFim(int el)
- RemoverFim()

### Fila

A fila é um padrão muito adotado em implementações de sistemas, visto que segue um ordem por chegada. Como a pilha não pode ser ordenado, visto que a ordem de entrada é importante para determinar a ordem de saída. Ela apresenta uma organização definida por quem entra primeiro, é o primeiro a sair.

``FIRST IN, FIRST OUT`` ou ``FIFO``

Diferente da pilha, os duas formas de organizar a entrada e saída não são eficientes. Por exemplo:

- Inserção no Início (Ineficiente)
- Remoção no Fim

- Inserção no Fim 
- Remoção no Início (Ineficiente)

#### Fila Circular

Desse modo, para suprir um problema ocorrido pela ineficiencia de inserção ou remoção no método da fila, foi criada uma solução denominada como ``Fila Circular``. Na fila circular, o que determina o início ou fim da fila não é o valor 0 ou n-1, mas sim uma variavel que controla o determinado local onde se encontra a última posição e primeira.

Toda vez que realizado uma nova inserção, teremos  a nossa variável ``último`` acrementada como mais um, enquanto a primeira permanecerá com o valor padrão. Entretanto toda vez que realizarmos uma remoção a variável ``primeiro`` que realizá um incremento. 

Mas para manter um padrão circular usamos de uma ferramenta, o ``mod`` para que assim que o tamanho do vetor chegar no último podermos voltar para a primeira posição (caso haja espaço). Vale ressaltar também que o array sempre é criado com uma posição a mais, o que possibilita que a circulação ocorra da maneira correta, tendo sempre um espaço vazio como padrão. 

```java
// Exemplo do "Primeiro"
primeiro = (primeiro + 1) % array.length;
```