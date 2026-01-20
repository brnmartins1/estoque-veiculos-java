import java.util.Scanner;
import java.util.ArrayList;

public class aula2 {

    public static void main(String[] args) {
    Scanner leitor = new Scanner(System.in);

    ArrayList<Integer> numeros = new ArrayList<>();

    int numeroDigitado = 0;
    int maiorNumero = 0;
    int somaTotal = 0;

    System.out.println("======ANALISADOR DE NUMEROS. DIGITE -1 PARA SAIR");

    while (true){
        System.out.print("\nDigite um numero: ");
        numeroDigitado = leitor.nextInt();

        if (numeroDigitado == -1){
            break;
        }
        numeros.add(numeroDigitado);

        if (numeroDigitado > maiorNumero){
            maiorNumero = numeroDigitado;
        }
        somaTotal += numeroDigitado;


    }
    System.out.println("\n================RELATORIO");
    System.out.println("Numeros digitados: " + numeros);
    System.out.println("Maior numero é: " + maiorNumero);
    System.out.println("O tamanho do array é: " + numeros.size());
    System.out.println("A soma de todos os numeros é: " + somaTotal);

    }
}
