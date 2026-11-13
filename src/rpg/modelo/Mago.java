package rpg.modelo;

import rpg.habilidades.BolaDeFogo;

// Mago: vida 105, ataque 14, defesa 6, energia 80. Habilidade: BolaDeFogo.
public class Mago extends Heroi {
    public Mago(String nome) {
        super(nome, 105, 14, 6, 80, new BolaDeFogo());
    }

    @Override
    public String getClasse() {
        return "Mago";
    }
}
