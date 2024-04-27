import java.util.ArrayList;
import java.util.List;

public class Loja {
    private Conta contaLoja;
    private List<Funcionario> funcionarios;

    public Loja(Conta contaLoja) {
        this.contaLoja = contaLoja;
        this.funcionarios = new ArrayList<>();
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public void receberPagamento(double valor) {
        synchronized (contaLoja) {
            contaLoja.depositar(valor);
            System.out.println("Loja: Recebimento de pagamento de R$ " + valor);
        }
    }

    public void pagarFuncionarios() {
        double totalSalarios = 0;

        // Calcula o total dos salários a serem pagos
        for (Funcionario funcionario : funcionarios) {
            totalSalarios += 1400; // Cada funcionário recebe R$ 1400
        }

        // Verifica se há saldo suficiente na conta da loja para pagar os salários
        synchronized (contaLoja) {
            if (contaLoja.getSaldo() >= totalSalarios) {
                // Paga os salários dos funcionários
                for (Funcionario funcionario : funcionarios) {
                    contaLoja.sacar(1400); // Retira R$ 1400 da conta da loja para pagar o funcionário
                    funcionario.receberSalario(1400); // O funcionário recebe o salário
                    System.out.println("Loja: Pagamento de salário para funcionário realizado. Saldo atual da conta da loja: R$ " + contaLoja.getSaldo());
                }
            } else {
                System.out.println("Loja: Saldo insuficiente para pagar os salários dos funcionários.");
            }
        }
    }

    public double calcularSalarios() {
        double totalSalarios = 0;

        // Calcula o total dos salários dos funcionários
        for (Funcionario funcionario : funcionarios) {
            totalSalarios += 1400; // Cada funcionário recebe R$ 1400
        }

        return totalSalarios;
    }
}
