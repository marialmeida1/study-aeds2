# Questão 01 - Gerando Atibutos e Buscando Sequencialmente (JAVA)

Essa questão consiste em um algoritimo que armazena e busca dados de Pokémons, onde há informações como nome, habilidades, tipos, etc. As informações são carregadas a partir de um arquivo CSV e armazenadas em uma lista do tipo ArrayList. O programa permite buscar um Pokémon por seu ID e exibir suas informações.

## Funcionalidades

- Armazenamento de informações detalhadas sobre cada Pokémon, incluindo:
- Leitura de dados de Pokémon a partir de um arquivo CSV.
    - ID
    - Descrição
    - Nome
    - Tipos
    - Habilidades
    - Peso
    - Altura
    - Taxa de captura
    - Geração
    - Status de lendário
    - Data de captura
- Busca de Pokémon por ID.
- Exibição formatada de dados do Pokémon encontrado.

## Estrutura do Código

### Classes

- ``Pokemons``: Classe principal que representa um Pokémon com vários atributos. Ela inclui métodos para ler os dados do CSV, buscar Pokémon por ID e imprimir suas informações.

### Atributos

A classe ``Pokemons`` possui os seguintes atributos:

- ``id``: Identificador único do Pokémon.
- ``generation``: Geração do Pokémon.
- ``name``: Nome do Pokémon.
- ``description``: Descrição do Pokémon.
- ``types``: Tipos do Pokémon (ex: Fogo, Água).
- ``abilities``: Habilidades do Pokémon.
- ``weight``: Peso do Pokémon.
- ``height``: Altura do Pokémon.
- ``captureRate``: Taxa de captura do Pokémon.
- ``isLegendary``: Indica se o Pokémon é lendário.
- ``captureDate``: Data em que o Pokémon foi capturado.

### Principais Métodos

- ``read(String line)``: Faz a leitura de uma linha do CSV e preenche os atributos do objeto Pokemons.
- ``setListPokemons()``: Lê os dados do arquivo CSV e preenche a lista listPokemons com objetos do tipo Pokemons.
- ``findID(int id, ArrayList<Pokemons> pokemons)``: Busca um Pokémon pelo seu ID dentro da lista.
- ``print()``: Exibe as informações formatadas de um Pokémon.