public class TesteClienteLoja {
    public static void main(String[] args) {
        // Criando uma conta para a loja e outra para os clientes
        Conta contaLoja = new Conta(0);
        Conta contaClientes = new Conta(1000);

        // Criando uma instância da loja
        Loja loja = new Loja(contaLoja);

        // Adicionando funcionários à loja
        Funcionario funcionario1 = new Funcionario(contaLoja, new Conta(0));
        Funcionario funcionario2 = new Funcionario(contaLoja, new Conta(0));
        loja.adicionarFuncionario(funcionario1);
        loja.adicionarFuncionario(funcionario2);

        // Criando instâncias de clientes e iniciando as threads
        Cliente[] clientes = new Cliente[5];
        for (int i = 0; i < clientes.length; i++) {
            clientes[i] = new Cliente(contaClientes);
            clientes[i].start(); // Inicia a thread do cliente
        }

        // Simulando compras contínuas até que o saldo da conta dos clientes se esgote
        for (Cliente cliente : clientes) {
            try {
                cliente.join(); // Aguarda o término da thread do cliente
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Simula o pagamento dos clientes à loja
        double totalPagamento = 0;
        for (int i = 0; i < clientes.length; i++) {
            totalPagamento += 200; // Cada cliente pagou R$ 200
        }
        loja.receberPagamento(totalPagamento);

        // Paga os funcionários
        loja.pagarFuncionarios();

        // Exibe o saldo final das contas
        System.out.println("Saldo final da conta da loja: R$ " + contaLoja.getSaldo());
        System.out.println("Saldo final da conta dos clientes: R$ " + contaClientes.getSaldo());
    }
}
