package rpg;

import rpg.combate.Batalha;
import rpg.combate.CalculadoraDeDano;
import rpg.itens.Arma;
import rpg.itens.Armadura;
import rpg.itens.Equipavel;
import rpg.itens.Inventario;
import rpg.itens.PocaoDeCura;
import rpg.modelo.Arqueiro;
import rpg.modelo.Dragao;
import rpg.modelo.Goblin;
import rpg.modelo.Guerreiro;
import rpg.modelo.Heroi;
import rpg.modelo.Inimigo;
import rpg.modelo.Mago;
import rpg.modelo.Orc;
import rpg.ui.Tela;

// Controla a partida: escolher herói, lutar nas 3 salas, recompensas e fim de jogo.
public class Jogo {
    private Tela tela;
    private Batalha batalha;

    public Jogo(Tela tela, CalculadoraDeDano calculadora) {
        this.tela = tela;
        this.batalha = new Batalha(tela, calculadora);
    }

    public void iniciar() {
        tela.titulo("RPG CONSOLE - A MASMORRA DO DRAGÃO");
        Heroi heroi = criarHeroi();

        Inventario inventario = new Inventario();
        inventario.adicionar(new PocaoDeCura(40));
        inventario.adicionar(new PocaoDeCura(40));
        inventario.adicionar(new PocaoDeCura(40));

        Inimigo[] inimigos = { new Goblin(), new Orc(), new Dragao() };
        Equipavel[] recompensas = { new Arma("Espada de Aço", 5), new Armadura("Cota de Malha", 4), null };

        for (int i = 0; i < inimigos.length; i++) {
            tela.mostrar("");
            tela.mostrar("Sala " + (i + 1) + " de " + inimigos.length);
            boolean venceu = batalha.lutar(heroi, inimigos[i], inventario);
            if (!venceu) {
                tela.titulo("GAME OVER");
                return;
            }
            if (recompensas[i] != null) {
                heroi.equipar(recompensas[i]);
                tela.mostrar("Você ganhou: " + recompensas[i].getNome() + " (" + recompensas[i].getDescricao() + ")");
                int cura = heroi.curar(heroi.getVidaMaxima() / 4);
                tela.mostrar(heroi.getNome() + " descansa e recupera " + cura + " de vida.");
            }
        }
        tela.titulo("VITÓRIA! " + heroi.getNome() + " derrotou o Dragão!");
    }

    private Heroi criarHeroi() {
        String nome = tela.lerTexto("Nome do herói (Enter = Aventureiro): ").trim();
        if (nome.isEmpty()) {
            nome = "Aventureiro";
        }
        tela.mostrar("Escolha a classe:");
        tela.mostrar("1) Guerreiro - muita vida e defesa");
        tela.mostrar("2) Mago      - Bola de Fogo ignora defesa");
        tela.mostrar("3) Arqueiro  - ataque alto");
        int opcao = tela.lerNumero("> ", 1, 3);
        if (opcao == 1) {
            return new Guerreiro(nome);
        } else if (opcao == 2) {
            return new Mago(nome);
        } else {
            return new Arqueiro(nome);
        }
    }
}
