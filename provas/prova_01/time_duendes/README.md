# Time de Duendes

Em 2020, o Papai Noel não poderá sair de casa para entregar presentes devido à pandemia do Coronavírus. Então ele ordenou que seus gnomos entregassem no dia de Natal. Como eles são bastante inexperientes, eles se dividirão em várias equipes compostas por três membros: um líder, um entregador e um motorista de trenó. O plano do Papai Noel é que os líderes das equipes sejam sempre os gnomos mais velhos, então ele pediu que todos escrevessem seus nomes e idades em uma lista. Como você é um gnomo programador, decidiu ajudar o Papai Noel a organizar a lista e montar as equipes a partir dela.

Aqui estão algumas regras:
- A lista deve ser organizada em ordem decrescente de idade;
- Se dois gnomos tiverem a mesma idade, eles devem ser organizados em ordem crescente de nome;
- Não há dois gnomos com o mesmo nome;
- Nenhum gnomo tem mais de 20 caracteres em seu nome;
- Os gnomos da lista têm entre 10 e 100 anos;
- O primeiro 1/3 dos gnomos (os mais velhos), serão os líderes de equipe;
- A ordem dos gnomos de entrega e pilotos segue a mesma lógica dos líderes. Ex) Se houver 6 gnomos na lista, haverá duas equipes, onde o gnomo mais velho é o líder da equipe 1, e o segundo mais velho é o líder da equipe 2. O terceiro mais velho é o entregador da equipe 1 e o quarto mais velho é o entregador da equipe 2. O quinto é um motorista de trenó da equipe 1 e o último é um motorista da equipe 2;

## Entrada

A entrada é composta de um inteiro N (3 <= N <= 30), onde N é um múltiplo de 3, que representa o número de gnomos na lista. Então as próximas N linhas contêm o nome e a idade de cada gnomo.

## Saída

A saída é composta de 4 linhas por equipe. A primeira linha deve seguir o formato "Time X" (em inglês, Team X), onde X é o número da equipe. A segunda, terceira e quarta linhas contêm, respectivamente, o nome e a idade do gnomo líder, do entregador e do motorista do trenó. Depois de cada equipe, deve haver uma linha em branco, mesmo depois da última equipe.

| **Entrada 1**   | **Saída 1**      |
|------------------|-----------------------|
| 6                | Time 1                |
| Josh 56          | Harley 61             |
| Alfred 32        | Josh 56               |
| Joshua 34        | Alfred 32             |
| Harley 61        |                       |
| Peggy 60         | Time 2                |
| Jim 25           | Peggy 60              |
|                  | Joshua 34             |
|                  | Jim 25                |
| **Entrada 2** | **Saída 2**   |
| 9                | Time 1                |
| Kepeumo 67       | Gyun 99               |
| Necoi 62         | Kepeumo 67            |
| Seies 77         | Galvaindir 55         |
| Ciule 49         |                       |
| Gyun 99          | Time 2                |
| Finron 27        | Seies 77              |
| Norandir 66      | Norandir 66           |
| Galvaindir 55    | Ciule 49              |
| Pinhoubor 70     |                       |
|                  | Time 3                |
|                  | Pinhoubor 70          |
|                  | Necoi 62              |
|                  | Finron 27             |
