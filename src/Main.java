import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Inicialização das lojas e contas
        Conta contaLojaA = new Conta(0, 1, "Loja A");
        Conta contaLojaB = new Conta(0, 2, "Loja B");
        Loja lojaA = new Loja(contaLojaA);
        Loja lojaB = new Loja(contaLojaB);
        List<Cliente> clientes = new ArrayList<>();

        // Criando e inicializando as contas dos funcionários
        Conta contaFuncionario1 = new Conta(0, 3, "Funcionário 1");
        Conta contaFuncionario2 = new Conta(0, 4, "Funcionário 2");
        Conta contaFuncionario3 = new Conta(0, 5, "Funcionário 3");
        Conta contaFuncionario4 = new Conta(0, 6, "Funcionário 4");

        Conta contaInvestimentoFuncionario1 = new Conta(0, 7, "Investimento Funcionário 1");
        Conta contaInvestimentoFuncionario2 = new Conta(0, 8, "Investimento Funcionário 2");
        Conta contaInvestimentoFuncionario3 = new Conta(0, 9, "Investimento Funcionário 3");
        Conta contaInvestimentoFuncionario4 = new Conta(0, 10, "Investimento Funcionário 4");

        Funcionario funcionario1 = new Funcionario(contaFuncionario1, contaInvestimentoFuncionario1, lojaA);
        Funcionario funcionario2 = new Funcionario(contaFuncionario2, contaInvestimentoFuncionario2, lojaA);
        Funcionario funcionario3 = new Funcionario(contaFuncionario3, contaInvestimentoFuncionario3, lojaB);
        Funcionario funcionario4 = new Funcionario(contaFuncionario4, contaInvestimentoFuncionario4, lojaB);


        // Iniciando as threads dos funcionários
        funcionario1.start();
        funcionario2.start();
        funcionario3.start();
        funcionario4.start();

        // Criando e inicializando os clientes
        for (int i = 0; i < 5; i++) {
            Cliente cliente = new Cliente(new Conta(1000, 7 + i, "Cliente " + (i + 1)), lojaA, lojaB);
            clientes.add(cliente);
        }

        // Iniciando as threads dos clientes
        for (Cliente cliente : clientes) {
            cliente.start();
        }

        // Aguardando a conclusão de todas as threads dos clientes
        for (Cliente cliente : clientes) {
            try {
                cliente.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Pagar os funcionários após o término das operações de todos os clientes
        lojaA.pagarFuncionarios();
        lojaB.pagarFuncionarios();

        // Aguardando a conclusão de todas as threads dos funcionários
        try {
            funcionario1.join();
            funcionario2.join();
            funcionario3.join();
            funcionario4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Exibindo os saldos finais das lojas
        System.out.println("Saldo Final Loja A: R$ " + contaLojaA.getSaldo());
        System.out.println("Saldo Final Loja B: R$ " + contaLojaB.getSaldo());

        // Exibindo os saldos finais dos clientes
        for (Cliente cliente : clientes) {
            System.out.println("Saldo Final " + cliente.getContaCliente().getTitular() + ": R$ " + cliente.getContaCliente().getSaldo());
        }

        // Exibindo os saldos finais dos funcionários e seus investimentos
        System.out.println("Saldo Final Funcionário 1: R$ " + contaFuncionario1.getSaldo());
        System.out.println("Investimento Final Funcionário 1: R$ " + contaInvestimentoFuncionario1.getSaldo());

        System.out.println("Saldo Final Funcionário 2: R$ " + contaFuncionario2.getSaldo());
        System.out.println("Investimento Final Funcionário 2: R$ " + contaInvestimentoFuncionario2.getSaldo());

        System.out.println("Saldo Final Funcionário 3: R$ " + contaFuncionario3.getSaldo());
        System.out.println("Investimento Final Funcionário 3: R$ " + contaInvestimentoFuncionario3.getSaldo());

        System.out.println("Saldo Final Funcionário 4: R$ " + contaFuncionario4.getSaldo());
        System.out.println("Investimento Final Funcionário 4: R$ " + contaInvestimentoFuncionario4.getSaldo());
    }
}
