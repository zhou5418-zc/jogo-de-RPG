package rpg.modelo;

import rpg.combate.CalculadoraDeDano;

// Inimigo forte: a cada 3 turnos dá uma Pancada Brutal.
public class Orc extends Inimigo {
    private int turno = 0;

    public Orc() {
        super("Orc", 80, 15, 6);
    }

    @Override
    public String jogarTurno(Combatente alvo, CalculadoraDeDano calculadora) {
        turno++;
        if (turno % 3 == 0) {
            int dano = calculadora.calcular(getAtaque() * 3 / 2, alvo.getDefesa());
            dano = alvo.receberDano(dano);
            return "Orc usa PANCADA BRUTAL e causa " + dano + " de dano!";
        }
        return ataqueNormal(alvo, calculadora);
    }
}
