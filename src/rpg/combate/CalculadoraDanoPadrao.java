package rpg.combate;

import java.util.Random;

// Fórmula: ataque - defesa/2, com um pouco de sorte (de -20% a +20%).
public class CalculadoraDanoPadrao implements CalculadoraDeDano {
    private Random random;

    public CalculadoraDanoPadrao(Random random) {
        this.random = random;
    }

    public int calcular(int ataque, int defesa) {
        int base = ataque - defesa / 2;
        if (base < 1) {
            base = 1;
        }
        int sorte = random.nextInt(41) - 20; // número de -20 a 20
        int dano = base + base * sorte / 100;
        if (dano < 1) {
            dano = 1;
        }
        return dano;
    }
}
