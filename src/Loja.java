import java.util.ArrayList;
import java.util.List;

public class Loja {
    private Conta contaLoja;
    private List<Funcionario> funcionarios;

    public Loja(Conta contaLoja) {
        this.contaLoja = contaLoja;
        this.funcionarios = new ArrayList<>();
    }

    public synchronized void pagarSalario(Funcionario funcionario, double valor) {
        contaLoja.sacar(valor); // Deduz o valor do salário do saldo da loja
        funcionario.receberSalario(valor); // Chama o método do funcionário para receber o salário
        System.out.println("Loja: Salário de funcionário pago: R$ " + valor);
    }

    public void receberPagamento(double valor) {
        contaLoja.depositar(valor); // Deposita o valor da compra na conta da loja
        System.out.println("Loja: Pagamento recebido: R$ " + valor);
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public void pagarFuncionarios() {
        for (Funcionario funcionario : funcionarios) {
            double salario = 1400; // Salário fixo por hora
            pagarSalario(funcionario, salario);
        }
    }
}
