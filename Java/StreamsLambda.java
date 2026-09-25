import java.util.List;
import java.util.stream.Collectors;

/**
 * Tema: Streams e Expressões Lambda (Java 8+)
 */
public class StreamsLambda {
    record Funcionario(String nome, String cargo, double salario) {}

    public static void main(String[] args) {
        List<Funcionario> funcionarios = List.of(
            new Funcionario("Ana", "Desenvolvedora", 6000),
            new Funcionario("Bruno", "Designer", 4500),
            new Funcionario("Carla", "Desenvolvedora", 7200),
            new Funcionario("Diego", "Gerente", 9000),
            new Funcionario("Elisa", "Designer", 4800)
        );

        // Filtrar: apenas desenvolvedores
        List<String> desenvolvedores = funcionarios.stream()
                .filter(f -> f.cargo().equals("Desenvolvedora"))
                .map(Funcionario::nome)
                .collect(Collectors.toList());
        System.out.println("Desenvolvedores: " + desenvolvedores);

        // Ordenar por salário decrescente
        System.out.println("\nFuncionários por salário (maior para menor):");
        funcionarios.stream()
                .sorted((f1, f2) -> Double.compare(f2.salario(), f1.salario()))
                .forEach(f -> System.out.printf("- %s: R$%.2f%n", f.nome(), f.salario()));

        // Calcular soma total e média com lambda
        double totalSalarios = funcionarios.stream()
                .mapToDouble(Funcionario::salario)
                .sum();
        double mediaSalarios = funcionarios.stream()
                .mapToDouble(Funcionario::salario)
                .average()
                .orElse(0);

        System.out.printf("%nTotal da folha: R$%.2f%n", totalSalarios);
        System.out.printf("Média salarial: R$%.2f%n", mediaSalarios);

        // Agrupar por cargo
        var porCargo = funcionarios.stream()
                .collect(Collectors.groupingBy(Funcionario::cargo));

        System.out.println("\nAgrupado por cargo:");
        porCargo.forEach((cargo, lista) -> {
            System.out.println(cargo + ": " + lista.size() + " pessoa(s)");
        });

        // Expressão lambda simples com interface funcional
        Runnable tarefa = () -> System.out.println("\nExecutando uma tarefa via lambda!");
        tarefa.run();
    }
}
