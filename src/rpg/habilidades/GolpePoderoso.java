package rpg.habilidades;

import rpg.combate.CalculadoraDeDano;
import rpg.modelo.Combatente;

// Ataque com o dobro da força.
public class GolpePoderoso implements Habilidade {
    public String getNome() {
        return "Golpe Poderoso";
    }

    public int getCusto() {
        return 20;
    }

    public String usar(Combatente usuario, Combatente alvo, CalculadoraDeDano calculadora) {
        int dano = calculadora.calcular(usuario.getAtaque() * 2, alvo.getDefesa());
        dano = alvo.receberDano(dano);
        return usuario.getNome() + " usa Golpe Poderoso e causa " + dano + " de dano!";
    }
}
