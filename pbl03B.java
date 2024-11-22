class Funcionario {
    private String nome;
    private String cargo;
    private int idade;
    private double salario;
    private String departamento;

    public Funcionario(String nome, int idade, String departamento) {
        this.nome = nome;
        this.cargo = "Assistente";
        this.idade = idade;
        this.salario = 2000.00;
        this.departamento = departamento;
    }

    public Funcionario(String nome, String cargo, int idade, String departamento) {
        this.nome = nome;
        this.cargo = cargo;
        this.idade = idade;
        this.salario = 4000.00;
        this.departamento = departamento;
    }

    public Funcionario(String nome, String cargo, int idade, double salario, String departamento) {
        this.nome = nome;
        this.cargo = cargo;
        this.idade = idade;
        this.departamento = departamento;
    }

    public double getSalario() {
        return salario;
    }

    public void imprimirDados() {
        System.out.println("Nome: " + nome);
        System.out.println("Cargo: " + cargo);
        System.out.println("Idade: " + idade);
        System.out.printf("Salário: R$%.2f\n", salario);
        System.out.println("Departamento: " + departamento);
        System.out.println("--------------------------");
    }
}

public class pbl03B {
    public static void main(String[] args) {
        Funcionario func1 = new Funcionario("Carlos Silva", 25, "Financeiro");
        Funcionario func2 = new Funcionario("Maria Oliveira", "Analista", 30, "RH");
        Funcionario func3 = new Funcionario("Ana Souza", "Gerente", 45, 8000.00, "Vendas");
        Funcionario func4 = new Funcionario("Pedro Santos", 22, "Operações");
        Funcionario func5 = new Funcionario("Fernanda Lima", "Diretora", 50, 15000.00, "Executivo");

        func1.imprimirDados();
        func2.imprimirDados();
        func3.imprimirDados();
        func4.imprimirDados();
        func5.imprimirDados();

        double totalSalarios = func1.getSalario() + func2.getSalario() + func3.getSalario() + func4.getSalario() + func5.getSalario();
        System.out.printf("Total a ser pago pela empresa: R$%.2f\n", totalSalarios);
    }
}