# Etiquetas de Noel

Como de costume, este ano Noel recebeu inúmeros pedidos de presentes. No entanto, devido a alguns imprevistos, ele não poderá entregar pessoalmente todos os presentes este ano. Então, ele decidiu usar o bom e velho correio tradicional, para alguns pedidos que podem ser entregues por carta.

Para esta tarefa, ele pediu ao elfo Evergreen Xadada para ajudá-lo a imprimir etiquetas em todos os envelopes que serão destinados a algumas dessas crianças, cujo pedido pode ser entregue por carta. Cada uma dessas etiquetas deve conter apenas o nome da criança e a saudação de "Feliz Natal" no idioma da criança. Para auxiliar nesta tarefa, Noel forneceu uma tabela com vários idiomas e o nome e país de cada uma das crianças selecionadas, conforme o exemplo abaixo. Você deve ajudar Evergreen fazendo um programa que imprima essas etiquetas.

## Entrada

A entrada é composta de um único caso de teste. A primeira linha da entrada contém um inteiro N (1 < N < 100) que indica o número de traduções da palavra "Feliz Natal" na entrada. As próximas N * 2 linhas contêm respectivamente o nome de um idioma seguido pela tradução de "Feliz Natal" neste idioma. Em seguida, a entrada contém um inteiro M (1 < M < 100) que indica o número de crianças que receberão os cartões. As próximas M * 2 linhas conterão, respectivamente, o nome da criança e o idioma nativo desta criança.

Nota: É garantido que nenhuma tradução apareça repetida ou duplicada e os países de todas as crianças estejam presentes na lista de países.

## Saída

Seu programa deve imprimir todos os rótulos de acordo com a entrada, como no exemplo abaixo. Sempre imprima uma linha em branco após imprimir cada um dos rótulos, mesmo após o último.

| **Entrada** | **Saída** |
|-------------------|--------------------|
| 2                 | John Brolargo      |
| frances           | Merry Christmas    |
| Joyeux Noel       |                    |
| ingles            |                    |
| Merry Christmas   |                    |
| 1                 |                    |
| John Brolargo     |                    |
| ingles            |                    |


| **Entrada** | **Saída**     |
|-------------------|------------------------|
| 7                 | Joao Paulo Silva       |
| frances           | Feliz Natal            |
| Joyeux Noel       |                        |
| ingles            | Pedro Guerra           |
| Merry Christmas   | Feliz Natal            |
| alemao            |                        |
| Frohe Weihnachten | Pietro Gonsalez        |
| espanhol          | Feliz Navidade         |
| Feliz Navidade    |                        |
| italiano          | Karol Kosinski         |
| buon natale       | Wesotych Swiat         |
| polones           |                        |
| Wesotych Swiat    | John Smith             |
| portugues         | Merry Christmas        |
| Feliz Natal       |                        |
| 5                 |                        |
| Joao Paulo Silva  |                        |
| portugues         |                        |
| Pedro Guerra      |                        |
| portugues         |                        |
| Pietro Gonsalez   |                        |
| espanhol          |                        |
| Karol Kosinski    |                        |
| polones           |                        |
| John Smith        |                        |
| ingles            |                        |
