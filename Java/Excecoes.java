/**
 * Tema: Tratamento de Exceções (try/catch/finally, exceção customizada)
 */

// Exceção personalizada
class SaldoInsuficienteException extends Exception {
    public SaldoInsuficienteException(String mensagem) {
        super(mensagem);
    }
}

class ContaBancaria {
    private double saldo;

    public ContaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public void sacar(double valor) throws SaldoInsuficienteException {
        if (valor > saldo) {
            throw new SaldoInsuficienteException(
                "Saldo insuficiente! Saldo atual: R$" + saldo + ", tentativa de saque: R$" + valor
            );
        }
        saldo -= valor;
        System.out.println("Saque de R$" + valor + " realizado. Novo saldo: R$" + saldo);
    }
}

public class Excecoes {
    public static void main(String[] args) {
        ContaBancaria conta = new ContaBancaria(100.0);

        // Tratando exceção customizada
        try {
            conta.sacar(50);
            conta.sacar(200); // vai gerar exceção
        } catch (SaldoInsuficienteException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            System.out.println("Operação de saque finalizada.\n");
        }

        // Tratando exceções comuns (aritmética e array)
        try {
            int[] numeros = {1, 2, 3};
            System.out.println(numeros[5]); // ArrayIndexOutOfBounds
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Erro: índice fora dos limites do array.");
        }

        try {
            int resultado = 10 / 0; // ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("Erro: divisão por zero não é permitida.");
        }

        // Múltiplos catches com uma exceção genérica ao final
        try {
            String texto = null;
            System.out.println(texto.length()); // NullPointerException
        } catch (NullPointerException e) {
            System.out.println("Erro: tentativa de usar um objeto nulo.");
        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        }
    }
}
