import java.util.Scanner;

    public class Main{

            public static void main(String[] args) {

        Scanner teclado =  new Scanner(System.in);

        double y = Main.f(3);
        System.out.println("f(x) = " + y);

        System.out.println("Digite o ponto A: ");
        double a = teclado.nextDouble();

        System.out.println("Digite o ponto b: ");
        double b = teclado.nextDouble();

        if (a <= b) {
            System.out.println("Digite a quantidade de trapezios (n): ");
            int n = teclado.nextInt();
            if (n > 0) {
                double areaTotal = 0;
                double x = a;
                double h = (b - a) / n;
                double y1 = (x);

                for (int i = 0; i < n; i++) {
                    x = x + h;
                    double y2 = f(x);
                    double area_trapezio = ((y1 + y2) / 2) * h;
                    areaTotal = areaTotal + area_trapezio;
                    y1 = y2;
                }
                System.out.println("aproximacao da integral: " + areaTotal);

            } else {
                System.out.println("Erro: o valor de n deve ser maior que zero.");
            }
        } else {
            System.out.println("Erro: o valor de a deve ser menor ou igual ao valor de b.");
        }

    }
        public static double f(double x){
            return 2.0 * Math.sin(x) + Math.cos(x) / 3.0;
        }
}


