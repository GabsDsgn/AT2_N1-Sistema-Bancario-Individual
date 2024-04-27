public class Conta {
    private double saldo;
    private String titular;
    private int numero; // Número da conta

    public Conta(double saldoInicial, int numero, String titular) {
        this.saldo = saldoInicial;
        this.numero = numero;
        this.titular = titular;
    }

    public synchronized void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito de R$ " + String.format("%.2f", valor) + " realizado com sucesso. Novo saldo: R$ " + String.format("%.2f", saldo));
    }

    public synchronized boolean sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de R$ " + String.format("%.2f", valor) + " realizado com sucesso. Novo saldo: R$ " + String.format("%.2f", saldo));
            return true;
        } else {
            System.out.println("Saldo insuficiente para realizar o saque.");
            return false;
        }
    }

    public synchronized double getSaldo() {
        return saldo;
    }

    public synchronized String getTitular() {
        return titular;
    }

    public synchronized int getNumero() {
        return numero;
    }
}

