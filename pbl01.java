import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class pbl01{
    public static void main(String[] args){
        List<String> listaVazia = new ArrayList<>();
        Random random = new Random();
        int numeroAleatorio = random.nextInt(0, 100);
        System.out.println("tamanho da lista: ");
        Scanner sc = new Scanner(System.in);
        int tamanho= sc.nextInt();
        for(int i=0; i < tamanho; i=i+1){
            int numeroAleatorio2 = random.nextInt(0, 100);
            if(numeroAleatorio2 %2 ==0){
                System.out.println("numero " + numeroAleatorio2 + " e par");}
            else if(numeroAleatorio2 % 3 ==0){
                System.out.println("numero " + numeroAleatorio2 + " e múltiplo de 3");
            }
            else{
                System.out.println("numero "+numeroAleatorio2 + " e impar");
            }
        }
    }
}