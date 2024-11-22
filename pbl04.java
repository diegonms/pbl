import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Livro {
    private String codigo;
    private String titulo;
    private boolean emprestado;

    public Livro(String codigo, String titulo) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.emprestado = false;
    }

    public String getCodigo() {
        return codigo;
    }

    public boolean isEmprestado() {
        return emprestado;
    }

    public void emprestar() {
        emprestado = true;
    }

    public void imprimirDetalhes() {
        System.out.printf("Código: %s, Título: %s, Emprestado: %s%n", codigo, titulo, emprestado ? "Sim" : "Não");
    }
}

class Prateleira {
    private List<Livro> livros;

    public Prateleira() {
        this.livros = new ArrayList<>();
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void imprimirLivros() {
        for (Livro livro : livros) {
            livro.imprimirDetalhes();
        }
    }
}

class Biblioteca {
    private String nome;
    private List<Prateleira> prateleiras;

    public Biblioteca(String nome) {
        this.nome = nome;
        this.prateleiras = new ArrayList<>();
    }

    public void adicionarPrateleira(Prateleira prateleira) {
        prateleiras.add(prateleira);
    }

    public List<Prateleira> getPrateleiras() {
        return prateleiras;
    }

    public void imprimirBiblioteca() {
        System.out.println("Biblioteca: " + nome);
        for (Prateleira prateleira : prateleiras) {
            prateleira.imprimirLivros();
        }
    }
}

public class pbl04 {
    public static void main(String[] args) {
        Biblioteca biblioteca1 = new Biblioteca("Biblioteca Central");
        Biblioteca biblioteca2 = new Biblioteca("Biblioteca Comunitária");

        Prateleira prateleira1 = new Prateleira();
        Prateleira prateleira2 = new Prateleira();
        Prateleira prateleira3 = new Prateleira();
        Prateleira prateleira4 = new Prateleira();

        prateleira1.adicionarLivro(new Livro("L1", "Livro A"));
        prateleira1.adicionarLivro(new Livro("L2", "Livro B"));
        prateleira1.adicionarLivro(new Livro("L3", "Livro C"));

        prateleira2.adicionarLivro(new Livro("L4", "Livro D"));
        prateleira2.adicionarLivro(new Livro("L5", "Livro E"));
        prateleira2.adicionarLivro(new Livro("L6", "Livro F"));

        prateleira3.adicionarLivro(new Livro("L7", "Livro G"));
        prateleira3.adicionarLivro(new Livro("L8", "Livro H"));
        prateleira3.adicionarLivro(new Livro("L9", "Livro I"));

        prateleira4.adicionarLivro(new Livro("L10", "Livro J"));
        prateleira4.adicionarLivro(new Livro("L11", "Livro K"));
        prateleira4.adicionarLivro(new Livro("L12", "Livro L"));

        biblioteca1.adicionarPrateleira(prateleira1);
        biblioteca1.adicionarPrateleira(prateleira2);
        biblioteca2.adicionarPrateleira(prateleira3);
        biblioteca2.adicionarPrateleira(prateleira4);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            biblioteca1.imprimirBiblioteca();
            biblioteca2.imprimirBiblioteca();

            System.out.print("Digite o código do livro para emprestar (ou 'sair'): ");
            String codigo = scanner.nextLine();
            if (codigo.equalsIgnoreCase("sair")) break;

            boolean encontrado = false;
            for (Biblioteca biblioteca : List.of(biblioteca1, biblioteca2)) {
                for (Prateleira prateleira : biblioteca.getPrateleiras()) {
                    for (Livro livro : prateleira.getLivros()) {
                        if (livro.getCodigo().equalsIgnoreCase(codigo)) {
                            encontrado = true;
                            if (!livro.isEmprestado()) {
                                System.out.print("Deseja emprestar este livro? [s/n]: ");
                                if (scanner.nextLine().equalsIgnoreCase("s")) {
                                    livro.emprestar();
                                    System.out.println("Livro emprestado!");
                                }
                            } else {
                                System.out.println("Livro já emprestado.");
                            }
                        }
                    }
                }
            }
            if (!encontrado) {
                System.out.println("Livro não encontrado.");
            }
        }
        scanner.close();
    }
}
