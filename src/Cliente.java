import java.util.Random;

public class Cliente extends Thread {
    private Conta contaClientes;

    public Cliente(Conta contaClientes) {
        this.contaClientes = contaClientes;
    }

    public Conta getContaClientes() {
        return contaClientes;
    }

    @Override
    public void run() {
        Random random = new Random();

        while (true) {
            // Realiza uma compra de R$ 100 ou R$ 200 de forma aleatória
            double valorCompra = random.nextInt(2) == 0 ? 100 : 200;

            // Tenta sacar o valor da conta
            synchronized (contaClientes) {
                boolean sucesso = contaClientes.sacar(valorCompra);
                if (!sucesso) {
                    break; // Encerra o loop se não houver saldo suficiente na conta
                }
            }

            // Simula um tempo de espera entre as compras
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
