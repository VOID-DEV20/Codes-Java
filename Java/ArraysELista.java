import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Tema: Arrays e Listas (ArrayList)
 */
public class ArraysELista {
    public static void main(String[] args) {
        // Array tradicional de tamanho fixo
        int[] numeros = {10, 25, 3, 47, 8};
        System.out.println("Array original: " + Arrays.toString(numeros));

        Arrays.sort(numeros);
        System.out.println("Array ordenado: " + Arrays.toString(numeros));

        int maior = numeros[numeros.length - 1];
        System.out.println("Maior número: " + maior);

        // Matriz (array bidimensional)
        int[][] matriz = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println("\nMatriz:");
        for (int[] linha : matriz) {
            System.out.println(Arrays.toString(linha));
        }

        // ArrayList (lista dinâmica)
        List<String> frutas = new ArrayList<>();
        frutas.add("Maçã");
        frutas.add("Banana");
        frutas.add("Laranja");
        frutas.add("Uva");

        System.out.println("\nLista de frutas: " + frutas);

        frutas.remove("Banana");
        System.out.println("Após remover Banana: " + frutas);

        if (frutas.contains("Uva")) {
            System.out.println("A lista contém Uva!");
        }

        System.out.println("\nPercorrendo a lista:");
        for (String fruta : frutas) {
            System.out.println("- " + fruta);
        }

        System.out.println("\nTotal de frutas: " + frutas.size());
    }
}
