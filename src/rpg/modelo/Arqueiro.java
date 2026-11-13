package rpg.modelo;

import rpg.habilidades.TiroCerteiro;

// Arqueiro: vida 125, ataque 18, defesa 7, energia 45. Habilidade: TiroCerteiro.
public class Arqueiro extends Heroi {
    public Arqueiro(String nome) {
        super(nome, 125, 18, 7, 45, new TiroCerteiro());
    }

    @Override
    public String getClasse() {
        return "Arqueiro";
    }
}
