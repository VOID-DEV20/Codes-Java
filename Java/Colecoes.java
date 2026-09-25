import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Tema: Coleções - HashMap, HashSet e List
 */
public class Colecoes {
    public static void main(String[] args) {
        // HashMap: pares chave-valor
        Map<String, Double> precos = new HashMap<>();
        precos.put("Café", 8.50);
        precos.put("Pão de queijo", 6.00);
        precos.put("Suco natural", 7.50);

        System.out.println("Cardápio:");
        for (Map.Entry<String, Double> item : precos.entrySet()) {
            System.out.printf("- %s: R$%.2f%n", item.getKey(), item.getValue());
        }

        // Buscar valor pela chave
        if (precos.containsKey("Café")) {
            System.out.println("\nPreço do café: R$" + precos.get("Café"));
        }

        // HashSet: coleção sem elementos duplicados
        Set<String> ingredientesUnicos = new HashSet<>();
        ingredientesUnicos.add("Farinha");
        ingredientesUnicos.add("Ovos");
        ingredientesUnicos.add("Leite");
        ingredientesUnicos.add("Farinha"); // duplicado, será ignorado

        System.out.println("\nIngredientes únicos: " + ingredientesUnicos);
        System.out.println("Quantidade: " + ingredientesUnicos.size());

        // List de objetos customizados
        record Produto(String nome, double preco) {}

        List<Produto> produtos = List.of(
            new Produto("Bolo", 30.0),
            new Produto("Torta", 45.0),
            new Produto("Cookie", 5.0)
        );

        double total = 0;
        System.out.println("\nProdutos:");
        for (Produto p : produtos) {
            System.out.println("- " + p.nome() + ": R$" + p.preco());
            total += p.preco();
        }
        System.out.printf("Total: R$%.2f%n", total);
    }
}
