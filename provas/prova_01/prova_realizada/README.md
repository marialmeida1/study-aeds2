# Prova 01 - AEDS2 

## Questão 1 - Java

Pedrinho e Zezinho estão precisando estudar resolução de expressões matemáticas para uma prova que irão fazer. Para isso, eles querem resolver muitos exercícios antes da prova. Como sabem programar, então decidiram fazer um gerador de expressões matemáticas.

O gerador de expressões que eles criaram funciona em duas fases. Na primeira fase é gerada uma cadeia de caracteres que contém apenas os caracteres '{', '[', '(', '}', ']' e ')'. Na segunda fase, o gerador adiciona os números e operadores na estrutura criada na primeira fase. Uma cadeia de caracteres é dita bem definida (ou válida) se atende as seguintes propriedades:

Ela é uma cadeia de caracteres vazia (não contém nenhum caractere). Ela é formada por uma cadeia bem definida envolvida por parênteses, colchetes ou chaves. Portanto, se a cadeia S é bem definida, então as cadeias (S), [S] e {S} também são bem definidas. Ela é formada pela concatenação de duas cadeias bem definidas. Logo, se as cadeias X e Y são bem definidas, a cadeia XY é bem definida. Depois que Pedrinho e Zezinho geraram algumas expressões matemáticas, eles perceberam que havia algum erro na primeira fase do gerador. Algumas cadeias não eram bem definidas. Eles querem começar a resolver as expressões o mais rápido possível, e sabendo que você é um ótimo programador (e participa da OBI) resolveram pedir que escreva um programa que dadas várias cadeias geradas na primeira fase, determine quais delas são bem definidas e quais não são.

### Entrada
A entrada é composta por diversas instâncias. A primeira linha da entrada contém um inteiro T (1 ≤ T ≤ 20) indicando o número de instâncias. Em seguida temos T linhas, cada uma com uma cadeia A, (a cadeia de caracteres A tem entre 1 e 100000 caracteres), (a cadeia de caracteres A contém apenas caracteres '{', '[', '(', '}', ']' e ')' ).

### Saída
Para cada instância imprima uma linha contendo a letra S se a cadeia é bem definida, ou a letra N caso contrário

| Entrada   | Saída |
|-----------|-------|
| 12        |       |
| ()        | S     |
| []        | S     |
| {}        | S     |
| )(        | N     |
| )(        | N     |
| ({})      | S     |
| {}[]      | N     |
| (){}      | N     |
| []{}      | N     |
| (         | S     |
| ((({}{})[])(()){} | S     |
| ((((((((((([]))))))))))) | N     |


## Questão 2

A prefeitura contratou um novo professor para ensinar as crianças do bairro a jogar tênis na quadra de tênis do parque municipal. O professor convidou todas as crianças do bairro interessadas em aprender a jogar tênis. Ao final do primeiro mês de aulas e treinamentos foi organizado um torneio em que cada participante disputou exatamente seis jogos.
O professor vai usar o desempenho no torneio para separar as crianças em três grupos, de forma a ter grupos de treino em que os participantes tenham habilidades mais ou menos iguais, usando o seguinte critério:

• participantes que venceram 5 ou 6 jogos serão colocados no Grupo 1;
• participantes que venceram 3 ou 4 jogos serão colocados no Grupo 2;
• participantes que venceram 1 ou 2 jogos serão colocados no Grupo 3;
• participantes que não venceram nenhum jogo não serão convidados a continuar com os treinamentos.

Dada uma lista com o resultado dos jogos de um participante, escreva um programa para determinar em qual grupo ele será colocado.

### Entrada
A entrada consiste de seis linhas, cada linha indicando o resultado de um jogo do participante. Cada linha contém um único caractere: V se o participante venceu o jogo, ou P se o jogador perdeu o jogo. Não há empates nos jogos.

### Saída
Seu programa deve produzir uma única linha na saída, contendo um único inteiro, identificando o grupo em que o participante será colocado. Se o participante não for colocado em nenhum dos três grupos seu programa deve imprimir o valor −1.

| Entrada | Saída |
|---------|-------|
| V       | 2     |
| V       |       |
| P       |       |
| P       |       |
| P       |       |
| V       |       |


