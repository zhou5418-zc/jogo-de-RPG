package rpg.combate;

// Interface da regra de dano. (DIP: as outras classes dependem desta interface)
public interface CalculadoraDeDano {
    int calcular(int ataque, int defesa);
}
