public class Funcionario extends Thread {
    private Conta contaSalario;
    private Conta contaInvestimentos;

    public Funcionario(Conta contaSalario, Conta contaInvestimentos) {
        this.contaSalario = contaSalario;
        this.contaInvestimentos = contaInvestimentos;
    }

    @Override
    public void run() {
        // Lógica para receber salário, investir parte dele e outras operações
        receberSalario(1400); // Recebe o salário de R$ 1400
        investirSalario();
    }

    public synchronized void receberSalario(double valor) {
        contaSalario.depositar(valor);
        System.out.println("Funcionário: Recebimento de salário de R$ " + valor + ". Saldo atual da conta de salário: R$ " + contaSalario.getSaldo());
    }

    public void investirSalario() {
        double valorInvestimento = contaSalario.getSaldo() * 0.2; // Calcula 20% do salário para investir
        if (valorInvestimento > 0) {
            contaSalario.sacar(valorInvestimento); // Retira o valor do investimento da conta de salário
            contaInvestimentos.depositar(valorInvestimento); // Deposita o valor do investimento na conta de investimentos
            System.out.println("Funcionário: Investimento de R$ " + valorInvestimento + " realizado. Saldo atual da conta de investimentos: R$ " + contaInvestimentos.getSaldo());
        }
    }
}
