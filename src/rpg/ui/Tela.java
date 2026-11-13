package rpg.ui;

// Interface da tela: mostrar textos e ler o que o jogador digita.
// DIP: o jogo usa esta interface, não usa System.out nem Scanner diretamente.
public interface Tela {
    void mostrar(String texto);
    void titulo(String texto);
    int lerNumero(String pergunta, int min, int max);
    String lerTexto(String pergunta);
}
