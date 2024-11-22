class Cliente {
    private String nome;
    private double saldo;

    public Cliente(String nome, double saldoInicial) {
        this.nome = nome;
        this.saldo = saldoInicial;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public void retirar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente para retirada de R$" + valor);
        }
    }

    public void imprimirDados() {
        System.out.printf("Cliente: %s, Saldo: R$%.2f%n", nome, saldo);
    }
}

public class pbl03A {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Jandira Silva", 2500.00);
        Cliente cliente2 = new Cliente("Sandra Rodrigues", 1800.00);
        Cliente cliente3 = new Cliente("Luciana Teixeira", 5000.00);

        cliente1.imprimirDados();
        cliente2.imprimirDados();
        cliente3.imprimirDados();

        cliente1.retirar(1000.00);
        cliente1.imprimirDados();

        cliente2.retirar(2000.00);
        cliente2.depositar(500.00);
        cliente2.imprimirDados();
        cliente2.retirar(2000.00);
        cliente2.imprimirDados();

        cliente3.depositar(1000.00);
        cliente3.imprimirDados();
    }
}
