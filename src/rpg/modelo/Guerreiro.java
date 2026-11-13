package rpg.modelo;

import rpg.habilidades.GolpePoderoso;

// Guerreiro: vida 130, ataque 16, defesa 10, energia 30. Habilidade: GolpePoderoso.
public class Guerreiro extends Heroi {
    public Guerreiro(String nome) {
        super(nome, 130, 16, 10, 30, new GolpePoderoso());
    }

    @Override
    public String getClasse() {
        return "Guerreiro";
    }
}
