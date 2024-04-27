public class Funcionario extends Thread {
    private Conta contaSalario;
    private Conta contaInvestimento;
    private Loja loja;

    public Funcionario(Conta contaSalario, Conta contaInvestimento, Loja loja) {
        this.contaSalario = contaSalario;
        this.contaInvestimento = contaInvestimento;
        this.loja = loja;
    }

    @Override
    public void run() {
        double salario = 1400; // Definindo o valor do salário
        loja.pagarSalario(this, salario); // Chama o método da Loja para pagar o salário
        investirSalario();
    }

    public synchronized void receberSalario(double valor) {
        contaSalario.depositar(valor);
        System.out.println("Funcionário: Salário recebido: R$ " + valor);
    }

    public void investirSalario() {
        synchronized (contaSalario) { // Sincronizar o acesso à conta salarial
            double saldoSalario = contaSalario.getSaldo();
            double valorInvestimento = saldoSalario * 0.2;
            if (valorInvestimento > 0 && saldoSalario >= valorInvestimento) {
                contaSalario.sacar(valorInvestimento);
                contaInvestimento.depositar(valorInvestimento);
                System.out.println("Funcionário: Valor de investimento: R$ " + valorInvestimento);
            } else {
                System.out.println("Funcionário: Saldo insuficiente para investimento.");
            }
        }
    }
}
