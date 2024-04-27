import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<Conta> contas;

    public Banco() {
        this.contas = new ArrayList<>();
    }

    public synchronized void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public synchronized void transferir(Conta origem, Conta destino, double valor) {
        if (origem.sacar(valor)) {
            destino.depositar(valor);
            System.out.println("Transferência de R$ " + valor + " realizada de " + origem.getNumero() + " para " + destino.getNumero());
        } else {
            System.out.println("Transferência de R$ " + valor + " de " + origem.getNumero() + " para " + destino.getNumero() + " não realizada: saldo insuficiente.");
        }
    }

    public synchronized void depositar(Conta conta, double valor) {
        conta.depositar(valor);
        System.out.println("Depósito de R$ " + valor + " realizado na conta " + conta.getNumero() + ". Novo saldo: R$ " + conta.getSaldo());
    }

    public synchronized void sacar(Conta conta, double valor) {
        if (conta.sacar(valor)) {
            System.out.println("Saque de R$ " + valor + " realizado na conta " + conta.getNumero() + ". Novo saldo: R$ " + conta.getSaldo());
        } else {
            System.out.println("Saque de R$ " + valor + " na conta " + conta.getNumero() + " não realizado: saldo insuficiente.");
        }
    }
}
