public class Cliente extends Thread {
    private Conta contaClientes;

    public Cliente(Conta contaClientes) {
        this.contaClientes = contaClientes;
    }

    @Override
    public void run() {
        // Lógica para realizar compras
        while (contaClientes.getSaldo() > 0) {
            // Realiza compras alternando entre R$ 100,00 e R$ 200,00
            double valorCompra = Math.random() < 0.5 ? 100 : 200;
            if (contaClientes.sacar(valorCompra)) {
                System.out.println("Cliente: Compra de R$ " + valorCompra + " realizada. Saldo atual: R$ " + contaClientes.getSaldo());
            } else {
                break; // Se não houver saldo suficiente, interrompe as compras
            }
        }
    }

    // Método para obter a conta do cliente
    public Conta getConta() {
        return contaClientes;
    }
}
