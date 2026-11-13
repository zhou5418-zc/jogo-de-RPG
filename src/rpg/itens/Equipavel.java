package rpg.itens;

// Item que o herói equipa e que dá bônus (ex.: espada, armadura).
public interface Equipavel extends Item {
    int getBonusAtaque();
    int getBonusDefesa();
}
