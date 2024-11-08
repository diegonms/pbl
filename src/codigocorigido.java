import java.util.Scanner;

public class codigocorigido {
    public static void main(String[] args) {
        // Cria o scanner dentro do método main
        Scanner teclado = new Scanner(System.in);

        // Calcula e imprime o valor da função para x = 3
        double y = f(3);
        System.out.println("f(x) = " + y);

        System.out.println("Digite o ponto A: ");
        double a = teclado.nextDouble();

        System.out.println("Digite o ponto B: ");
        double b = teclado.nextDouble();

        if (a <= b) {
            System.out.println("Digite a quantidade de trapézios (n): ");
            int n = teclado.nextInt();
            if (n > 0) {
                double areaTotal = 0;
                double x = a;
                double h = (b - a) / n;
                double y1 = f(x);

                for (int i = 0; i < n; i++) {
                    x = x + h;
                    double y2 = f(x);
                    double areaTrapezio = ((y1 + y2) / 2) * h; // Corrigido para incluir a altura
                    areaTotal = areaTotal + areaTrapezio;
                    y1 = y2;
                }

                System.out.println("Aproximaçãooo da integral: " + areaTotal);
            } else {
                System.out.println("Erro: o valor de n deve ser maior que zero.");
            }
        } else {
            System.out.println("Erro: o valor de a deve ser menor ou igual ao valor de b.");
        }

        teclado.close(); // Fechar o scanner
    }

    public static double f(double x) {
        return 2.0 * Math.sin(x) + Math.cos(x) / 3.0;
    }
}
