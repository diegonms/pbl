import java.util.Scanner;

public class pbl02B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o valor do primeiro termo da PA: ");
        double a1 = scanner.nextDouble();

        System.out.print("Digite a razão da PA: ");
        double r = scanner.nextDouble();

        System.out.print("Digite o número de termos da PA: ");
        int n = scanner.nextInt();

        double an = a1 + (n - 1) * r;
        System.out.println("Último termo da PA: " + an);

        double Sn = (a1 + an) * n / 2;
        System.out.println("Soma de todos os termos da PA: " + Sn);

        scanner.close();
    }
}
