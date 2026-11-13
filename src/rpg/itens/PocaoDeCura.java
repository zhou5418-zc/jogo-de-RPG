package rpg.itens;

import rpg.modelo.Heroi;

// Poção que recupera vida.
public class PocaoDeCura implements Consumivel {
    private int cura;

    public PocaoDeCura(int cura) {
        this.cura = cura;
    }

    public String getNome() {
        return "Poção de Cura";
    }

    public String getDescricao() {
        return "recupera " + cura + " de vida";
    }

    public String usar(Heroi heroi) {
        int recuperado = heroi.curar(cura);
        return heroi.getNome() + " recuperou " + recuperado + " de vida.";
    }
}
