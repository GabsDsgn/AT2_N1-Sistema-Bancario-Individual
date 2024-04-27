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
            System.out.println("Transferência de R$ " + valor + " realizada de " + origem + " para " + destino);
        } else {
            System.out.println("Transferência de R$ " + valor + " falhou de " + origem + " para " + destino + ": Saldo insuficiente");
        }
    }
}
