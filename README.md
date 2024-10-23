# Relatório de Testes: Análise do Valor Limite

## 1. Introdução

Este documento relata os testes realizados sobre o sistema de cálculo de cashback, com foco na aplicação da técnica de Análise de Limite de Valor (AVL). A funcionalidade em questão calcula o cashback recebido pelos clientes com base em suas compras e seu nível de fidelidade (Bronze, Prata, Ouro).

### Objetivo dos Testes

O principal objetivo dos testes é verificar a correta aplicação do cálculo de cashback para diferentes faixas de compra, especialmente nos pontos críticos onde as regras de cashback mudam. O foco é identificar possíveis falhas ou comportamentos inesperados nos valores-limite, onde transições ocorrem entre diferentes percentuais de cashback.

### Relevância da Análise do Valor Limite

A Análise de Limite de Valor é uma técnica de teste que concentra-se em verificar os valores nos limites das faixas definidas. Esta abordagem é essencial, pois erros tendem a ocorrer mais frequentemente nos valores próximos aos limites, onde a lógica do sistema muda. Assim, testar esses pontos críticos é fundamental para garantir a estabilidade e confiabilidade do sistema.

## 2. Análise do Valor Limite

### Casos de Teste

Os casos de teste escolhidos abrangem os limites das faixas de cashback: imediatamente abaixo do limite inferior (R$ 99,99), no limite inferior (R$ 100,00), logo acima do limite inferior (R$ 100,01 e R$ 100,02), próximo ao limite superior (R$ 499,99), no limite superior (R$ 500,00) e logo acima do limite superior (R$ 500,01). A ideia é verificar a precisão do sistema em cada transição de faixa de cashback.

1. **Faixa de até R$ 100 (5% de cashback):**
   - **Valor de Compra:** R$ 99,99 | **Grau de Fidelidade:** Bronze, Prata, Ouro
   - **Valor de Compra:** R$ 100,00 | **Grau de Fidelidade:** Bronze, Prata, Ouro
   - **Valor de Compra:** R$ 100,01 | **Grau de Fidelidade:** Bronze, Prata, Ouro
   - **Valor de compra:** R$ 100,02 | **Grau de Fidelidade:** Bronze, Prata, Ouro

2. **Faixa entre R$ 100,01 e R$ 500 (10% de cashback):**
   - **Valor de Compra:** R$ 499,99 | **Grau de Fidelidade:** Bronze, Prata, Ouro
   - **Valor de Compra:** R$ 500,00 | **Grau de Fidelidade:** Bronze, Prata, Ouro
   - **Valor de Compra:** R$ 500,01 | **Grau de Fidelidade:** Bronze, Prata, Ouro

3. **Faixa de acima R$ 500 (15% de cashback):**
   - **Valor de Compra:** R$ 500,00 | **Grau de Fidelidade:** Bronze, Prata, Ouro

### Aplicação do Critério

Para cada combinação de valor-limite e nível de fidelidade, foram testados valores imediatamente abaixo, no próprio limite e acima dele. Isso garante que o sistema está tratando corretamente as transições entre as faixas de cashback, além de aplicar adequadamente os percentuais correspondentes ao nível de fidelidade.

## 3. Execução dos Testes

### Procedimento de Execução

Os testes foram escritos com o uso do JUnit 4 e executados via Maven. Cada cenário de teste avaliou se o cashback calculado pelo sistema estava correto, comparando os resultados obtidos com os esperados.

### Resultados dos Testes



| Faixa de Valor      | Grau de Fidelidade | Valor de Compra | Cashback Esperado | Cashback Calculado | Resultado |
|---------------------|--------------------|-----------------|-------------------|--------------------|-----------|
| Até R$ 100          | Bronze             | R$ 99,99        | R$ 4,9995         | R$ 4,9995          | Aprovado  |
| Até R$ 100          | Bronze             | R$ 100,00       | R$ 5,00           | R$ 5,00            | Aprovado  |
| Até R$ 100          | Bronze             | R$ 100,01       | R$ 10,001         | R$ 10,001          | Aprovado  |
| Até R$ 100          | Bronze             | R$ 100,02       | R$ 10,002         | R$ 10,002          | Aprovado  |
| R$ 100,01 - R$ 500  | Bronze             | R$ 499,99       | R$ 49,999         | R$ 49,999          | Aprovado  |
| R$ 100,01 - R$ 500  | Bronze             | R$ 500,00       | R$ 50,00          | R$ 50,00           | Reprovado |
| R$ 100,01 - R$ 500  | Bronze             | R$ 500,00       | R$ 75,00          | R$ 75,00           | Aprovado  |
| R$ 100,01 - R$ 500  | Bronze             | R$ 500,01       | R$ 75,0015        | R$ 75,0015         | Aprovado  |
| Até R$ 100          | Prata              | R$ 99,99        | R$ 9,999          | R$ 9,999           | Aprovado  |
| Até R$ 100          | Prata              | R$ 100,00       | R$ 10,00          | R$ 10,00           | Aprovado  |
| Até R$ 100          | Prata              | R$ 100,01       | R$ 15,0015        | R$ 15,0015         | Aprovado  |
| Até R$ 100          | Prata              | R$ 100,02       | R$ 15,003         | R$ 15,003          | Aprovado  |
| R$ 100,01 - R$ 500  | Prata              | R$ 499,99       | R$ 74,9985        | R$ 74,9985         | Aprovado  |
| R$ 100,01 - R$ 500  | Prata              | R$ 500,00       | R$ 75,00          | R$ 75,00           | Reprovado |
| R$ 100,01 - R$ 500  | Prata              | R$ 500,00       | R$ 100,00         | R$ 100,00          | Aprovado  |
| R$ 100,01 - R$ 500  | Prata              | R$ 500,01       | R$ 100,002        | R$ 100,002         | Aprovado  |
| Até R$ 100          | Ouro               | R$ 99,99        | R$ 14,9985        | R$ 14,9985         | Aprovado  |
| Até R$ 100          | Ouro               | R$ 100,00       | R$ 15,00          | R$ 15,00           | Aprovado  |
| Até R$ 100          | Ouro               | R$ 100,01       | R$ 20,002         | R$ 20,002          | Aprovado  |
| Até R$ 100          | Ouro               | R$ 100,02       | R$ 20,004         | R$ 20,004          | Aprovado  |
| R$ 100,01 - R$ 500  | Ouro               | R$ 499,99       | R$ 99,998         | R$ 99,998          | Aprovado  |
| R$ 100,01 - R$ 500  | Ouro               | R$ 500,00       | R$ 100,00         | R$ 100,00          | Reprovado |
| R$ 100,01 - R$ 500  | Ouro               | R$ 500,00       | R$ 125,00         | R$ 125,00          | Aprovado  | 
| R$ 100,01 - R$ 500  | Ouro               | R$ 500,01       | R$ 125,0025       | R$ 125,0025        | Aprovado  |

## Execução dos Testes
###  Resultados dos Testes
Durante os testes, foi identificada uma falha recorrente para o valor de R$ 500,00. O sistema aplicou percentuais de cashback como se o valor fosse superior a R$ 500,00, causando um erro no cálculo. O valor foi tratado como pertencente à faixa superior, aplicando percentuais incorretos para os diferentes níveis de fidelidade (15% para Bronze, 20% para Prata e 25% para Ouro).

- **Testes realizados:** 22
- **Testes bem-sucedidos:**19

A falha foi causada por um erro na lógica de comparação do valor limite, onde R$ 500,00 estava sendo incluído indevidamente na faixa superior.


## 4. Conclusão

Os testes mostraram que, no geral, o sistema realiza os cálculos de cashback corretamente, com exceção do valor de R$ 500,00. A lógica atual trata este valor como parte da faixa superior, aplicando percentuais maiores do que o esperado. Essa falha foi identificada por meio de testes de caixa-preta que consideravam que R$ 500,00 pertencia à faixa intermediária.

### Avaliação da Robustez

Embora a maioria dos casos tenha passado nos testes, a falha observada com o valor de R$ 500,00 revela uma vulnerabilidade na lógica de decisão, exigindo ajustes para que os limites sejam corretamente tratados. Este erro compromete a precisão dos cálculos de cashback e, consequentemente, a confiabilidade do sistema aos olhos dos clientes.

