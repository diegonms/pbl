import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

class ExcecaoSeguranca extends Exception {
    public ExcecaoSeguranca(String message) {
        super(message);
    }
}

class ExcecaoAutenticacao extends ExcecaoSeguranca {
    public ExcecaoAutenticacao(String message) {
        super(message);
    }
}

class ExcecaoContaInvalida extends ExcecaoAutenticacao {
    public ExcecaoContaInvalida(String message) {
        super(message);
    }
}

class ExcecaoSenhaInvalida extends ExcecaoAutenticacao {
    public ExcecaoSenhaInvalida(String message) {
        super(message);
    }
}

class ExcecaoSaldoInsuficiente extends Exception {
    public ExcecaoSaldoInsuficiente(String message) {
        super(message);
    }
}

class ExcecaoHorarioInvalido extends Exception {
    public ExcecaoHorarioInvalido(String message) {
        super(message);
    }
}

class ContaCorrente {
    private int numero;
    private String senha;
    private double saldo;

    public ContaCorrente(int numero, String senha, double saldoInicial) {
        this.numero = numero;
        this.senha = senha;
        this.saldo = saldoInicial;
    }

    public int getNumero() {
        return numero;
    }

    public void retirar(double valor, String senha)
            throws ExcecaoSenhaInvalida, ExcecaoSaldoInsuficiente {
        if (!this.senha.equals(senha)) {
            throw new ExcecaoSenhaInvalida("Senha inválida.");
        }
        if (saldo < valor) {
            throw new ExcecaoSaldoInsuficiente("Saldo insuficiente.");
        }
        saldo -= valor;
    }

    public double getSaldo() {
        return saldo;
    }
}

class Banco {
    private String nome;
    private Map<Integer, ContaCorrente> contas = new HashMap<>();

    public Banco(String nome) {
        this.nome = nome;
    }

    public void criar_conta(int numero, String senha, double saldo) {
        contas.put(numero, new ContaCorrente(numero, senha, saldo));
    }

    public void sacar(int numero, String senha, double valor)
            throws ExcecaoContaInvalida, ExcecaoSenhaInvalida, ExcecaoHorarioInvalido, ExcecaoSaldoInsuficiente {
        LocalTime agora = LocalTime.now();
        if (agora.isBefore(LocalTime.of(8, 0)) || agora.isAfter(LocalTime.of(22, 0))) {
            throw new ExcecaoHorarioInvalido("Saque permitido apenas entre 8h e 22h.");
        }
        ContaCorrente conta = contas.get(numero);
        if (conta == null) {
            throw new ExcecaoContaInvalida("Conta inválida.");
        }
        conta.retirar(valor, senha);
    }
}

public class pbl08 {
    public static void main(String[] args) {
        Banco banco = new Banco("Banco Central");

        banco.criar_conta(12345, "senha123", 1000.00);
        banco.criar_conta(67890, "senha456", 500.00);
        banco.criar_conta(11111, "senha789", 1500.00);
        banco.criar_conta(22222, "senha101", 200.00);
        banco.criar_conta(33333, "senha202", 300.00);

        try {
            banco.sacar(12345, "senha123", 200.00);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            banco.sacar(12345, "senha1234", 200.00);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            banco.sacar(67890, "senha456", 600.00);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            banco.sacar(99999, "senha123", 100.00);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            banco.sacar(11111, "senha789", 500.00);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            banco.sacar(12345, "senha123", 900.00);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            banco.sacar(33333, "senha202", 50.00);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
