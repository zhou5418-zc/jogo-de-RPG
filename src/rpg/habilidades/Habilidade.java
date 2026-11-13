package rpg.habilidades;

import rpg.combate.CalculadoraDeDano;
import rpg.modelo.Combatente;

// Interface das habilidades especiais.
// OCP: para criar uma habilidade nova, basta criar uma classe nova.
public interface Habilidade {
    String getNome();
    int getCusto();
    String usar(Combatente usuario, Combatente alvo, CalculadoraDeDano calculadora);
}
