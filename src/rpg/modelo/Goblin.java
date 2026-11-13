package rpg.modelo;

import rpg.combate.CalculadoraDeDano;

// Inimigo fraco: só faz ataque normal.
public class Goblin extends Inimigo {
    public Goblin() {
        super("Goblin", 50, 12, 3);
    }

    @Override
    public String jogarTurno(Combatente alvo, CalculadoraDeDano calculadora) {
        return ataqueNormal(alvo, calculadora);
    }
}
