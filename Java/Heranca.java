/**
 * Tema: Programação Orientada a Objetos - Herança e Polimorfismo
 */

// Classe base (superclasse)
abstract class Animal {
    protected String nome;

    public Animal(String nome) {
        this.nome = nome;
    }

    // Método abstrato: cada subclasse deve implementar do seu jeito
    public abstract String emitirSom();

    public void apresentar() {
        System.out.println(nome + " diz: " + emitirSom());
    }
}

// Subclasse Cachorro
class Cachorro extends Animal {
    public Cachorro(String nome) {
        super(nome);
    }

    @Override
    public String emitirSom() {
        return "Au au!";
    }
}

// Subclasse Gato
class Gato extends Animal {
    public Gato(String nome) {
        super(nome);
    }

    @Override
    public String emitirSom() {
        return "Miau!";
    }
}

// Subclasse Pato
class Pato extends Animal {
    public Pato(String nome) {
        super(nome);
    }

    @Override
    public String emitirSom() {
        return "Quack!";
    }
}

public class OOP_Heranca {
    public static void main(String[] args) {
        // Polimorfismo: tratamos tudo como Animal, mas cada um se comporta diferente
        Animal[] animais = {
            new Cachorro("Rex"),
            new Gato("Mimi"),
            new Pato("Donald")
        };

        for (Animal animal : animais) {
            animal.apresentar();
        }
    }
}
