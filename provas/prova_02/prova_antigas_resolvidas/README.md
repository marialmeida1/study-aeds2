# Resolução Prova 02 - Algoritimo e Estrutura de Dados 02

## Questão 01 - Lista Simples em C

### Enunciado

*Dada uma lista simplesmente encadeada, implemente a função void meiose(). Esta função deve percorrer toda
a lista, dividindo cada célula em duas, com cada nova célula contendo a metade do valor da célula original.
Abaixo, é apresentada a estrutura do código e uma ilustração que mostra a lista antes e após a operação.
Apresente a complexidade do código em função de theta.*

### Interpretação

A questão referência a utilização de uma lista como maneira de criar e organizar uma estrutura de meiose. O conceito de `meiose` trata-se de uma repartição uma única célula em duas, nesse caso, o valor presente dentro de uma célula pai, como a exemplo, o valor `8`, se tornará `4` em duas células distintas (filhas). Segue o exemplo na imagem abaixo:

![Meiose](image.png)

Nota-se que as duas células criadas deverão ser conectadas, para que assim a estrutura não perca sua sequencia como uma lista encadeada flexível. O exemplo abaixo demostra como funcionará de modo amplo essa meiose:

![alt text](image-2.png)

### Construção da Lógica e Código

A construção do código pode ser realizada de diversos modos, podendo utilizar da lista já feita e adicionando novas células ou criando uma nova lista. O modo impletado abaixo utiliza da lista já existente, funcionando em 5 (cinco) etapas principais:

1. Estrutura de repetição que percorre as células da lista
2. Criação de uma nova célula
3. Definição dos valores da célula atual e nova por meio do valor presente na célula atual.
4. Redefinição dos ponteiros da célula atual e nova célula.
5. Definição da próxima célula atual.

#### Interpretação do código:

Em vez de criar uma nova lista utilizamos a lista já existente, utilizando de conceitos como `inserção em qualquer posição` já conhecidos em uma estrutura de lista. 

Primeiramente, iremos realizar estrutura de repetição que irá percorrer essa lista, assim, iremos definir qual a célula atual que estamos. 

Identificando a célula atual que estamos podemos criar uma nova célula por meio do método `malloc` da linguagem C. Essa nova célula irá receber em seu parametro `elemento` o valor do `elemento` da célula atual divido por dois. Desse modo, a célula atual fará o mesmo processo de atribuição de valores. 

![alt text](image-3.png)

Posteriormente, iremos redefinir os ponteiros. Esse processo se assemelha muito ao método de inserção em qualquer posição, visto que criará uma célula nova que receberá em seu parametro `prox` o mesmo valor da célula atual. Já a célula atual receberá em seu parametro `prox` a nova célula criada.

![alt text](image-4.png)

Por fim, temos que definir para aonde a célula atual irá apontar, que nesse caso, deverá ser duas posições posteriores visto que foi criado uma nova célula no meio. Assim, célula atual irá receber para aonde a nova célula aponta.

### Código

```C
void meiose() {
    Cel *atual = inicio;
    while(atual != null){
        Cel *novaCel = (Cel *)malloc(1 * sizeof(Cel));
        novaCel->elemento = atual->elemento/2; // Valor: nova célula
        atual->elemento = atual->elemento/2; // Valor: atual célula

        novaCelula->prox = atual->prox; // Ponteiro: nova célula
        atual->prox = novaCelula; // Ponteiro: atual célula

        atual = novaCelula->prox; // Localização: atual célula
    }
}
```


