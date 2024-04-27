public class TesteClienteLoja {
    public static void main(String[] args) {
        // Criando uma instância do banco
        Banco banco = new Banco();

        // Criando uma conta para a loja e outra para os clientes
        Conta contaLoja = new Conta(0);
        Conta contaClientes = new Conta(1000);

        // Criando uma instância da loja
        Loja loja = new Loja(contaLoja);

        // Adicionando funcionários à loja
        Conta contaInvestimentos = new Conta(0); // Conta para investimentos dos funcionários
        Funcionario funcionario1 = new Funcionario(contaLoja, contaInvestimentos);
        Funcionario funcionario2 = new Funcionario(contaLoja, contaInvestimentos);
        loja.adicionarFuncionario(funcionario1);
        loja.adicionarFuncionario(funcionario2);

        // Adicionando contas ao banco
        banco.adicionarConta(contaLoja);
        banco.adicionarConta(contaClientes);
        banco.adicionarConta(contaInvestimentos);

        // Criando instâncias de clientes e iniciando as threads
        Cliente[] clientes = new Cliente[5];
        for (int i = 0; i < clientes.length; i++) {
            clientes[i] = new Cliente(contaClientes);
            clientes[i].start(); // Inicia a thread do cliente
        }

    // Simulando compras contínuas até que o saldo da conta dos clientes se esgote
        boolean saldoSuficiente = true;
        while (saldoSuficiente) {
            saldoSuficiente = false;
            for (Cliente cliente : clientes) {
                if (cliente.getContaClientes().getSaldo() >= 100) { // Verifica se o saldo é suficiente para uma compra de R$ 100
                    cliente.getContaClientes().sacar(100); // Realiza uma compra de R$ 100
                    saldoSuficiente = true;
                } else if (cliente.getContaClientes().getSaldo() >= 200) { // Verifica se o saldo é suficiente para uma compra de R$ 200
                    cliente.getContaClientes().sacar(200); // Realiza uma compra de R$ 200
                    saldoSuficiente = true;
                }
            }
        }



        // Simula o pagamento dos clientes à loja
        double totalPagamento = 0;
        for (int i = 0; i < clientes.length; i++) {
            totalPagamento += 200; // Cada cliente pagou R$ 200
        }
        loja.receberPagamento(totalPagamento);

        // Paga os funcionários se houver saldo suficiente na loja
        if (contaLoja.getSaldo() >= loja.calcularSalarios()) {
            loja.pagarFuncionarios();
        }

        // Exibe o saldo final das contas
        System.out.println("Saldo final da conta da loja: R$ " + contaLoja.getSaldo());
        System.out.println("Saldo final da conta dos clientes: R$ " + contaClientes.getSaldo());
        System.out.println("Saldo final da conta de investimentos dos funcionários: R$ " + contaInvestimentos.getSaldo());
    }
}
