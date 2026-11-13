package rpg.modelo;

import rpg.combate.CalculadoraDeDano;

// Inimigo controlado pelo computador.
// Polimorfismo: cada inimigo escreve o seu próprio turno.
public abstract class Inimigo extends Personagem {

    public Inimigo(String nome, int vida, int ataque, int defesa) {
        super(nome, vida, ataque, defesa);
    }

    // Faz a ação do turno e devolve um texto dizendo o que aconteceu.
    public abstract String jogarTurno(Combatente alvo, CalculadoraDeDano calculadora);

    // Ataque normal, usado por todos os inimigos.
    protected String ataqueNormal(Combatente alvo, CalculadoraDeDano calculadora) {
        int dano = calculadora.calcular(getAtaque(), alvo.getDefesa());
        dano = alvo.receberDano(dano);
        return getNome() + " ataca e causa " + dano + " de dano.";
    }
}
