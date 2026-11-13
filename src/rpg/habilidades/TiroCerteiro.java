package rpg.habilidades;

import rpg.combate.CalculadoraDeDano;
import rpg.modelo.Combatente;

// Flecha: ataque x1.6 que ignora metade da defesa.
public class TiroCerteiro implements Habilidade {
    public String getNome() {
        return "Tiro Certeiro";
    }

    public int getCusto() {
        return 15;
    }

    public String usar(Combatente usuario, Combatente alvo, CalculadoraDeDano calculadora) {
        int dano = calculadora.calcular(usuario.getAtaque() * 8 / 5, alvo.getDefesa() / 2);
        dano = alvo.receberDano(dano);
        return usuario.getNome() + " usa Tiro Certeiro e causa " + dano + " de dano!";
    }
}
