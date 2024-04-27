// Classe Conta
public class Conta {
    private double saldo;
    private int numero; // Adicionando um número de conta

    // Construtor que aceita o saldo inicial e o número de conta
    public Conta(double saldoInicial, int numero) {
        this.saldo = saldoInicial;
        this.numero = numero;
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

    // Método para obter o número da conta
    public synchronized int getNumero() {
        return numero;
    }
}
