public class Cliente extends Thread {
    private Conta contaCliente;
    private Loja lojaA;
    private Loja lojaB;

    public Cliente(Conta contaCliente, Loja lojaA, Loja lojaB) {
        this.contaCliente = contaCliente;
        this.lojaA = lojaA;
        this.lojaB = lojaB;
    }

    @Override
    public void run() {
        int clienteNumber = Integer.parseInt(Thread.currentThread().getName().substring(7));
        while (contaCliente.getSaldo() > 0) {
            double valorCompra = Math.random() < 0.5 ? 100 : 200;
            if (contaCliente.getSaldo() >= valorCompra && contaCliente.sacar(valorCompra)) {
                System.out.println("Cliente " + clienteNumber + ": Compra de R$ " + String.format("%.2f", valorCompra) + " realizada. Saldo atual: R$ " + String.format("%.2f", contaCliente.getSaldo()));
                // Escolha aleatória entre as lojas A e B para realizar a compra
                Loja lojaEscolhida = Math.random() < 0.5 ? lojaA : lojaB;
                lojaEscolhida.receberPagamento(valorCompra);
            } else {
                break; // Encerra o loop quando o saldo do cliente for insuficiente para realizar a compra
            }
        }
        System.out.println("Saldo Final Cliente " + clienteNumber + ": R$ " + String.format("%.2f", contaCliente.getSaldo()));
        // Pagar os funcionários após as operações do cliente
        lojaA.pagarFuncionarios();
        lojaB.pagarFuncionarios();
    }

    // Método para obter a conta do cliente
    public Conta getContaCliente() {
        return contaCliente;
    }
}
