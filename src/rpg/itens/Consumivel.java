package rpg.itens;

import rpg.modelo.Heroi;

// Item que é usado uma vez e acaba (ex.: poção).
// ISP: separado de Equipavel.
public interface Consumivel extends Item {
    String usar(Heroi heroi);
}
