# Sistema Bancário e Comercial

Este é um projeto de simulação de um sistema bancário e comercial, desenvolvido em Java 17. Ele inclui classes que representam contas bancárias, clientes, uma loja e funcionários. O objetivo é simular transações bancárias, compras de clientes na loja e o pagamento de salários aos funcionários. E o código está devidamente comentado para maior entendimento de quem gostaria de fazer uma análise.

## Funcionalidades

- Criação de contas bancárias para clientes, loja e funcionários.
- Realização de depósitos e saques em contas bancárias.
- Transferência de fundos entre contas.
- Simulação de compras de clientes em uma loja.
- Pagamento de salários aos funcionários da loja.
- Investimento de parte do salário dos funcionários.

## Estrutura do Projeto

O projeto está dividido em várias classes Java:

- **Conta**: Representa uma conta bancária, com métodos para depositar, sacar e obter saldo.
- **Cliente**: Uma thread que simula o comportamento de um cliente realizando compras.
- **Loja**: Representa uma loja, com métodos para receber pagamentos e pagar salários aos funcionários.
- **Funcionario**: Uma thread que simula o comportamento de um funcionário, recebendo e investindo salário.
- **Banco**: Gerencia uma lista de contas bancárias e permite operações como adicionar contas e transferir fundos.
- **TesteClienteLoja**: Um programa de teste que cria instâncias de contas, loja, funcionários e clientes e simula suas interações.

## Execução

Para executar o programa de teste `TesteClienteLoja`, basta compilá-lo e executá-lo em um ambiente Java adequado. Certifique-se de ter o JDK instalado e configurado corretamente.
