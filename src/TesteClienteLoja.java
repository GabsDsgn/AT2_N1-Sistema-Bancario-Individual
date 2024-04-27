//import java.text.DecimalFormat;
//import java.util.Random;
//
//public class TesteClienteLoja {
//    public static void main(String[] args) {
//        // Criando uma instância do banco
//        Banco banco = new Banco();
//
//        // Criando uma conta para a loja e outra para os clientes
//        Conta contaLoja = new Conta(0, 123456); // Adicionando número da conta
//        Conta contaClientes = new Conta(1000, 654321); // Adicionando número da conta
//
//        // Criando uma instância da loja
//        Loja loja = new Loja(contaLoja);
//
//        // Adicionando funcionários à loja
//        Conta contaInvestimentos = new Conta(0, 987654); // Adicionando número da conta
//        Funcionario funcionario1 = new Funcionario(contaLoja, contaInvestimentos);
//        Funcionario funcionario2 = new Funcionario(contaLoja, contaInvestimentos);
//        loja.adicionarFuncionario(funcionario1);
//        loja.adicionarFuncionario(funcionario2);
//
//        // Adicionando contas ao banco
//        banco.adicionarConta(contaLoja);
//        banco.adicionarConta(contaClientes);
//        banco.adicionarConta(contaInvestimentos);
//
//        // Criando instâncias de clientes e iniciando as threads
//        Cliente[] clientes = new Cliente[5];
//        for (int i = 0; i < clientes.length; i++) {
//            clientes[i] = new Cliente(contaClientes);
//            clientes[i].start(); // Inicia a thread do cliente
//        }
//
//        // Simulando compras contínuas até que o saldo da conta dos clientes se esgote
//        boolean saldoSuficiente = true;
//        while (saldoSuficiente) {
//            saldoSuficiente = false;
//            for (Cliente cliente : clientes) {
//                if (cliente.getConta().getSaldo() >= 100) { // Corrigindo o método para obter a conta do cliente
//                    cliente.getConta().sacar(100); // Realiza uma compra de R$ 100
//                    saldoSuficiente = true;
//                } else if (cliente.getConta().getSaldo() >= 200) { // Corrigindo o método para obter a conta do cliente
//                    cliente.getConta().sacar(200); // Realiza uma compra de R$ 200
//                    saldoSuficiente = true;
//                }
//            }
//        }
//
//        // Simula o pagamento dos clientes à loja
//        double totalPagamento = 0;
//        for (int i = 0; i < clientes.length; i++) {
//            totalPagamento += 200; // Cada cliente pagou R$ 200
//        }
//        loja.receberPagamento(totalPagamento);
//        DecimalFormat df = new DecimalFormat("#0.00");
//        System.out.println("Loja: Recebimento de pagamento de R$ " + df.format(totalPagamento));
//
//        // Paga os funcionários se houver saldo suficiente na loja
//        if (contaLoja.getSaldo() >= loja.calcularSalarios()) {
//            loja.pagarFuncionarios();
//        }
//
//        // Adicionando transações aleatórias adicionais
//        Random random = new Random();
//        double valorTransacao = random.nextDouble() * 1000; // Valor aleatório entre 0 e 1000
//        contaLoja.depositar(valorTransacao); // Deposita um valor aleatório na conta da loja
//        System.out.println("Depósito de R$ " + df.format(valorTransacao) + " realizado com sucesso. Novo saldo: R$ " + df.format(contaLoja.getSaldo()));
//        valorTransacao = random.nextDouble() * 1000; // Valor aleatório entre 0 e 1000
//        contaClientes.depositar(valorTransacao); // Deposita um valor aleatório na conta dos clientes
//        System.out.println("Depósito de R$ " + df.format(valorTransacao) + " realizado com sucesso. Novo saldo: R$ " + df.format(contaClientes.getSaldo()));
//        valorTransacao = random.nextDouble() * 1000; // Valor aleatório entre 0 e 1000
//        contaInvestimentos.depositar(valorTransacao); // Deposita um valor aleatório na conta de investimentos dos funcionários
//        System.out.println("Depósito de R$ " + df.format(valorTransacao) + " realizado com sucesso. Novo saldo: R$ " + df.format(contaInvestimentos.getSaldo()));
//
//        // Exibe o saldo final das contas formatado corretamente
//        System.out.println("Saldo final da conta da loja: R$ " + df.format(contaLoja.getSaldo()));
//        System.out.println("Saldo final da conta dos clientes: R$ " + df.format(contaClientes.getSaldo()));
//        System.out.println("Saldo final da conta de investimentos dos funcionários: R$ " + df.format(contaInvestimentos.getSaldo()));
//    }
//}
