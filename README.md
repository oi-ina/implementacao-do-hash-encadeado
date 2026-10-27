# Simulação de Tabela Hash em Java

## Sobre o trabalho

A proposta é distribuir 1.000 números inteiros em uma tabela com apenas 100 posições e tratar os casos em que mais de um número cai no mesmo índice. Para isso, o programa usa listas encadeadas feitas manualmente, sem recorrer a coleções prontas do Java.

## Como os dados são armazenados

Cada posição da tabela aponta para um nó ou fica vazia (`null`). Um nó guarda o número sorteado e uma referência para o próximo elemento.

Os números são gerados com `Random`, usando a semente **1090** e o intervalo de **0 a 100.000**, incluindo os dois limites. O índice é calculado pelo resto da divisão por 100:

`int indice = numero % 100;`

Quando o índice ainda não tem nenhum elemento, o nó é colocado diretamente naquela posição. Se já houver um número armazenado, ocorre uma colisão: o novo nó passa a apontar para o primeiro nó da lista e assume o início do encadeamento.

Dessa forma, não é necessário percorrer a lista para inserir um elemento. Como os nós novos entram na frente, a ordem exibida dentro de uma mesma posição vai do mais recente para o mais antigo.

## O que é verificado ao final

Depois dos 1.000 sorteios, o programa percorre as 100 posições e conta os elementos de cada encadeamento. Com isso, identifica:

- Quantas posições apresentam listas com dois ou mais nós (colisões);
- Quantas posições permaneceram vazias;
- Qual foi o total de colisões;
- Onde está a lista mais longa, seu tamanho e todos os seus valores;
- Quais foram os três últimos números inseridos em situações de colisão.

Os últimos três números são guardados durante as inserções em um vetor simples, sem precisar consultar as listas novamente.

## Exemplo de resultado

Na execução com a seed definida, foram registradas **900 colisões**, distribuídas pelas **100 posições** da tabela. Nenhuma posição ficou vazia. A maior lista está no **índice 62** e possui **17 elementos**.

Os três últimos números inseridos em colisões foram **28163**, **20395** e **33346**, nessa ordem.

## Executando o programa

Com o JDK instalado, abra o terminal na pasta do arquivo `Main.java` e digite:

`javac Main.java`

`java Main`

O código também pode ser executado em compiladores online configurados para Java e para a classe `Main`.

## Recursos utilizados

A solução utiliza um vetor de 100 referências, uma classe `No` com os campos `valor` e `proximo`, além das estruturas `if`, `else`, `for` e `while`.

A classe `Random` é usada apenas para gerar os valores; não há uso de `LinkedList`, `ArrayList` ou `HashMap`.
