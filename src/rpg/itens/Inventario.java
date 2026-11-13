package rpg.itens;

import java.util.ArrayList;

// Guarda as poções do herói. (SRP: só guarda, não usa e não imprime)
public class Inventario {
    private ArrayList<Consumivel> itens = new ArrayList<>();

    public void adicionar(Consumivel item) {
        itens.add(item);
    }

    public Consumivel pegar(int posicao) {
        return itens.remove(posicao);
    }

    public int tamanho() {
        return itens.size();
    }

    public String getNome(int posicao) {
        return itens.get(posicao).getNome();
    }

    public boolean estaVazio() {
        return itens.isEmpty();
    }
}
