# Problema: Gerenciamento de Processos no SBC

## Contexto
A Federação dos Apagadores e Celulares Esquisitos (FACE) firmou um contrato com o Governo Federal para desenvolver um telefone celular de baixo custo, distribuído gratuitamente a populações de baixa renda. Embora simples, o aparelho terá vários aplicativos, e o sistema operacional SBC (Sistema Bonito para Celulares) deve gerenciar esses aplicativos de forma eficiente, respeitando as seguintes diretrizes:

1. **Execução Única por Vez**: Apenas um processo pode ser executado por vez, e ele deve ser executado até o fim.
2. **Sem Tempo Ocioso**: O sistema nunca pode ficar ocioso se há processos aguardando.
3. **Limite de Tempo de Execução**: Cada processo informa o tempo exato (em ciclos de processamento) para sua execução. O sistema aborta o processo se ele ultrapassar esse tempo, e se terminar antes, o tempo ocioso é aproveitado para rotinas internas.
4. **Espera Mínima**: O sistema minimiza o tempo total de espera dos processos.

## Objetivo
Escrever o módulo do SBC para calcular a soma total do tempo de espera de todos os processos.

## Entrada
- Vários casos de teste.
- Para cada caso:
  - A primeira linha contém o número \( N \) (1 ≤ N ≤ \( 10^5 \)), representando o número de processos.
  - As próximas \( N \) linhas contêm dois inteiros \( t_e \) e \( c \) (1 ≤ \( t_e \), \( c \) ≤ \( 10^3 \)), representando o tempo em que o processo requisitou sua execução e o número de ciclos que durará sua execução.
- A entrada é finalizada com fim de arquivo.

## Saída
- Para cada caso de teste, a saída deve ser um valor inteiro que representa a soma total do tempo de espera de todos os processos.
