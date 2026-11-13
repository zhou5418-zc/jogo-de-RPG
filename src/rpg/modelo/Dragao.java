package rpg.modelo;

import rpg.combate.CalculadoraDeDano;

// Chefão: a cada 3 turnos solta Sopro de Fogo, que ignora a defesa.
public class Dragao extends Inimigo {
    private int turno = 0;

    public Dragao() {
        super("Dragão", 260, 21, 9);
    }

    @Override
    public String jogarTurno(Combatente alvo, CalculadoraDeDano calculadora) {
        turno++;
        if (turno % 3 == 0) {
            int dano = calculadora.calcular(getAtaque() * 9 / 5, 0);
            dano = alvo.receberDano(dano);
            return "Dragão usa SOPRO DE FOGO e causa " + dano + " de dano!";
        }
        return ataqueNormal(alvo, calculadora);
    }
}
