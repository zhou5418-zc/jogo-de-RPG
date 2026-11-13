package rpg.modelo;

// Interface: o que todo personagem que luta precisa saber fazer.
// (ISP: só o essencial para lutar)
public interface Combatente {
    String getNome();
    int getVida();
    int getVidaMaxima();
    int getAtaque();
    int getDefesa();
    int receberDano(int dano);
    boolean estaVivo();
}
