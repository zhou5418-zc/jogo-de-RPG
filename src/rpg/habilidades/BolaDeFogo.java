package rpg.habilidades;

import rpg.combate.CalculadoraDeDano;
import rpg.modelo.Combatente;

// Magia: ataque x2.5 que ignora a defesa (defesa = 0).
public class BolaDeFogo implements Habilidade {
    public String getNome() {
        return "Bola de Fogo";
    }

    public int getCusto() {
        return 20;
    }

    public String usar(Combatente usuario, Combatente alvo, CalculadoraDeDano calculadora) {
        int dano = calculadora.calcular(usuario.getAtaque() * 5 / 2, 0);
        dano = alvo.receberDano(dano);
        return usuario.getNome() + " usa Bola de Fogo e causa " + dano + " de dano!";
    }
}
