package rpg.modelo;

// Interface separada: só quem pode ser curado implementa (os heróis).
// (ISP: os inimigos não são obrigados a ter o método curar)
public interface Curavel {
    int curar(int quantidade);
}
