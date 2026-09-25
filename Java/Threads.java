/**
 * Tema: Threads e Concorrência
 */
public class Threads {

    // Recurso compartilhado entre threads
    static class Contador {
        private int valor = 0;

        // synchronized evita condição de corrida (race condition)
        public synchronized void incrementar() {
            valor++;
        }

        public int getValor() {
            return valor;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Contador contador = new Contador();

        // Criando uma thread com Runnable (lambda)
        Runnable tarefaIncrementar = () -> {
            for (int i = 0; i < 1000; i++) {
                contador.incrementar();
            }
        };

        Thread t1 = new Thread(tarefaIncrementar, "Thread-1");
        Thread t2 = new Thread(tarefaIncrementar, "Thread-2");
        Thread t3 = new Thread(tarefaIncrementar, "Thread-3");

        System.out.println("Iniciando threads...");
        t1.start();
        t2.start();
        t3.start();

        // join() espera as threads terminarem antes de continuar
        t1.join();
        t2.join();
        t3.join();

        System.out.println("Todas as threads terminaram.");
        System.out.println("Valor final do contador (esperado 3000): " + contador.getValor());

        // Exemplo de thread simples exibindo seu próprio nome
        Thread threadNomeada = new Thread(() -> {
            System.out.println("\nOlá da " + Thread.currentThread().getName());
        }, "ThreadPersonalizada");
        threadNomeada.start();
        threadNomeada.join();
    }
}
