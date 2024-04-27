// Classe Conta
public class Conta {
    private double saldo;

    public Conta(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    // Método para depositar dinheiro na conta
    public synchronized void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito de R$ " + valor + " realizado com sucesso. Novo saldo: R$ " + saldo);
    }

    // Método para sacar dinheiro da conta
    public synchronized boolean sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de R$ " + valor + " realizado com sucesso. Novo saldo: R$ " + saldo);
            return true;
        } else {
            System.out.println("Saldo insuficiente para realizar o saque.");
            return false;
        }
    }

    // Método para obter o saldo atual da conta
    public synchronized double getSaldo() {
        return saldo;
    }
}
