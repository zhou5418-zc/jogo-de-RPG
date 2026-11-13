package rpg;

import rpg.combate.CalculadoraDanoPadrao;
import rpg.ui.TelaConsole;

import java.util.Random;

// Começo do programa: cria as peças e inicia o jogo.
public class Main {
    public static void main(String[] args) {
        Jogo jogo = new Jogo(new TelaConsole(), new CalculadoraDanoPadrao(new Random()));
        jogo.iniciar();
    }
}
