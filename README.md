# Relatório de Testes: Análise do Valor Limite

## 1. Introdução

Este relatório documenta os testes realizados na aplicação de cálculo de cashback, com foco na aplicação do critério de Análise do Valor Limite (AVL). A aplicação em questão calcula o valor de cashback que os clientes recebem com base em suas compras e no grau de fidelidade (Bronze, Prata, Ouro).

### Objetivo dos Testes

O objetivo dos testes é garantir que a aplicação calcula corretamente o cashback para diferentes valores de compra, especialmente nos pontos críticos, ou seja, nos limites das faixas de valor onde as regras de cashback mudam. Esses testes são essenciais para identificar possíveis erros ou comportamentos inesperados no cálculo de cashback quando valores de entrada estão nos extremos.

### Importância da Análise do Valor Limite

A Análise do Valor Limite é uma técnica de teste que foca nos valores de entrada que estão nos limites das faixas de entrada válidas. Esta técnica é importante porque erros de software são mais prováveis de ocorrer em valores de limite do que em valores internos, devido à transição de uma lógica para outra. Portanto, testar esses limites ajuda a garantir a robustez do sistema.

## 2. Análise do Valor Limite

### Casos de Teste

Os valores escolhidos para os testes incluem os limites das faixas de cashback: imediatamente abaixo do limite inferior (R$ 99,99), no limite inferior (R$ 100,00), logo acima do limite inferior (R$ 100,01 e R$ 100,02), próximo ao limite superior (R$ 499,99), no limite superior (R$ 500,00) e logo acima do limite superior (R$ 500,01). Essa abordagem permite verificar a precisão da implementação para cada ponto crítico de mudança nas faixas de cashback.

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

Para cada combinação de valor limite e grau de fidelidade, foram testados os valores imediatamente abaixo, no limite, e acima do limite. Isso garante que o sistema responde corretamente às transições entre as faixas de cashback e aplica os ajustes de fidelidade adequadamente.

## 3. Execução dos Testes

### Processo de Execução

Os testes foram implementados utilizando JUnit 4 e executados via Maven. Para cada combinação de valor e grau de fidelidade, foram escritos métodos de teste específicos que verificam se o valor de cashback calculado corresponde ao esperado.

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
Durante a execução dos testes, foi identificada uma falha para o valor de R$ 500,00 em todos os graus de fidelidade. O sistema retornou valores de cashback como se o valor fosse superior a R$ 500,00, aplicando percentuais de 15% para Bronze, 20% para Prata e 25% para Ouro. Os testes para este valor foram reexecutados considerando a faixa de cashback para valores acima de R$ 500,00.

- **Testes realizados:** 24
- **Testes bem-sucedidos:**21

Esse erro ocorreu devido a uma escolha de lógica na implementação do método, onde o cálculo para o valor acima de 500, pegava o valor 500 em si ou seja é uma faixa maior ou igual a.


## 4. Conclusão

Os testes revelaram que o sistema, de maneira geral, lida corretamente com os valores de entrada, exceto para o caso específico de R$ 500,00. A implementação atual considera R$ 500,00 como parte da faixa superior (> R$ 500,00), aplicando percentuais de cashback incorretos. Este comportamento foi detectado através de testes de caixa-preta, que assumiam que R$ 500,00 estaria na faixa intermediária.

### Avaliação da Robustez

Embora a maioria dos testes tenha sido bem-sucedida, a falha encontrada com o valor de R$ 500,00 indica que a lógica de decisão no código precisa ser revisada para garantir que os limites sejam corretamente tratados. Esse problema sugere uma vulnerabilidade na implementação que pode afetar a precisão do cálculo do cashback, comprometendo a confiança dos clientes e a integridade financeira do sistema.

