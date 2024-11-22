import java.util.ArrayList;
import java.util.Scanner;

class Pessoa {
    protected String nome;
    protected int idade;
    protected String email;

    public Pessoa(String nome, int idade, String email) {
        this.nome = nome;
        this.idade = idade;
        this.email = email;
    }

    public void apresentar() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("E-mail: " + email);
    }
}

class Aluno extends Pessoa {
    private String matricula;
    private String curso;

    public Aluno(String nome, int idade, String email, String matricula, String curso) {
        super(nome, idade, email);
        this.matricula = matricula;
        this.curso = curso;
    }

    @Override
    public void apresentar() {
        super.apresentar();
        System.out.println("Matrícula: " + matricula);
        System.out.println("Curso: " + curso);
    }
}

class Professor extends Pessoa {
    private String disciplina;
    private double salario;

    public Professor(String nome, int idade, String email, String disciplina, double salario) {
        super(nome, idade, email);
        this.disciplina = disciplina;
        this.salario = salario;
    }

    @Override
    public void apresentar() {
        super.apresentar();
        System.out.println("Disciplina: " + disciplina);
    }

    public double calcularBonus() {
        return salario * 0.10;  // Bônus de 10% sobre o salário
    }
}

class Funcionarioo extends Pessoa {
    private String departamento;
    private int horasTrabalhadas;
    private double salarioHora;

    public Funcionarioo(String nome, int idade, String email, String departamento, int horasTrabalhadas, double salarioHora) {
        super(nome, idade, email);
        this.departamento = departamento;
        this.horasTrabalhadas = horasTrabalhadas;
        this.salarioHora = salarioHora;
    }

    public double calcularPagamento() {
        return horasTrabalhadas * salarioHora;  // Pagamento com base nas horas trabalhadas e no salário por hora
    }

    @Override
    public void apresentar() {
        super.apresentar();
        System.out.println("Departamento: " + departamento);
        System.out.println("Horas Trabalhadas: " + horasTrabalhadas);
        System.out.println("Salário por Hora: " + salarioHora);
    }
}

class Monitor extends Aluno {
    private int horasMonitoria;

    public Monitor(String nome, int idade, String email, String matricula, String curso, int horasMonitoria) {
        super(nome, idade, email, matricula, curso);
        this.horasMonitoria = horasMonitoria;
    }

    @Override
    public void apresentar() {
        super.apresentar();
        System.out.println("Horas de Monitoria: " + horasMonitoria);
    }

    public double calcularPagamentoMonitoria() {
        double valorHoraMonitoria = 15.0;  // Valor fixo por hora de monitoria
        return horasMonitoria * valorHoraMonitoria;  // Pagamento pela monitoria
    }
}

public class pbl05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Pessoa> pessoas = new ArrayList<>();

        pessoas.add(new Aluno("Pedro Santos", 22, "pedro@mail.com", "U001", "Física"));
        pessoas.add(new Aluno("Clara Lima", 21, "clara@mail.com", "U002", "Matemática"));
        pessoas.add(new Professor("Fernanda Ribeiro", 45, "fernanda@mail.com", "Física", 5500.0));
        pessoas.add(new Funcionarioo("Paulo Almeida", 35, "paulo@mail.com", "Biblioteca", 200, 20.0));
        pessoas.add(new Monitor("Beatriz Gonçalves", 23, "beatriz@mail.com", "U003", "Matemática", 40));

        while (true) {
            System.out.println("===== MENU DE ADMINISTRAÇÃO =====");
            System.out.println("1. Listar todas as pessoas");
            System.out.println("2. Visualizar detalhes de uma pessoa");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                System.out.println("Lista de pessoas:");
                for (Pessoa pessoa : pessoas) {
                    pessoa.apresentar();
                    System.out.println("=======================");
                }
            } else if (opcao == 2) {
                System.out.print("Digite o nome da pessoa que deseja visualizar: ");
                String nome = scanner.nextLine();

                Pessoa pessoaEncontrada = null;
                for (Pessoa pessoa : pessoas) {
                    if (pessoa.nome.equalsIgnoreCase(nome)) {
                        pessoaEncontrada = pessoa;
                        break;
                    }
                }

                if (pessoaEncontrada == null) {
                    System.out.println("Pessoa não encontrada.");
                } else {
                    System.out.println("Essa é a pessoa que você deseja visualizar?");
                    pessoaEncontrada.apresentar();
                    System.out.print("Digite 'sim' para confirmar ou qualquer outra tecla para cancelar: ");
                    String confirmacao = scanner.nextLine();

                    if (confirmacao.equalsIgnoreCase("sim")) {
                        pessoaEncontrada.apresentar();
                        if (pessoaEncontrada instanceof Professor) {
                            Professor professor = (Professor) pessoaEncontrada;
                            System.out.println("Bônus do Professor: " + professor.calcularBonus());
                        } else if (pessoaEncontrada instanceof Funcionarioo) {
                            Funcionarioo funcionario = (Funcionarioo) pessoaEncontrada;
                            System.out.println("Pagamento do Funcionário: " + funcionario.calcularPagamento());
                        } else if (pessoaEncontrada instanceof Monitor) {
                            Monitor monitor = (Monitor) pessoaEncontrada;
                            System.out.println("Pagamento de Monitoria: " + monitor.calcularPagamentoMonitoria());
                        }
                    } else {
                        System.out.println("Visualização cancelada.");
                    }
                }
            } else if (opcao == 3) {
                System.out.println("Saindo do sistema...");
                break;
            } else {
                System.out.println("Opção inválida! Tente novamente.");
            }
        }

        scanner.close();
    }
}