package rpg.combate;

import rpg.itens.Consumivel;
import rpg.itens.Inventario;
import rpg.modelo.Heroi;
import rpg.modelo.Inimigo;
import rpg.ui.Tela;

// Controla UM combate em turnos entre o herói e um inimigo.
// SRP: só cuida dos turnos. DIP: recebe a Tela e a Calculadora prontas (interfaces).
public class Batalha {
    private Tela tela;
    private CalculadoraDeDano calculadora;

    public Batalha(Tela tela, CalculadoraDeDano calculadora) {
        this.tela = tela;
        this.calculadora = calculadora;
    }

    // Retorna true se o herói venceu.
    public boolean lutar(Heroi heroi, Inimigo inimigo, Inventario inventario) {
        tela.titulo(inimigo.getNome() + " apareceu!");
        int rodada = 1;

        while (heroi.estaVivo() && inimigo.estaVivo()) {
            tela.mostrar("");
            tela.mostrar("--- Rodada " + rodada + " ---");
            heroi.comecarTurno();
            mostrarStatus(heroi, inimigo);

            boolean jogou = false;
            while (!jogou) {
                jogou = turnoDoHeroi(heroi, inimigo, inventario);
            }

            if (inimigo.estaVivo()) {
                tela.mostrar(inimigo.jogarTurno(heroi, calculadora));
            }
            rodada++;
        }

        if (heroi.estaVivo()) {
            tela.mostrar(">> " + inimigo.getNome() + " foi derrotado!");
            return true;
        }
        tela.mostrar(">> " + heroi.getNome() + " caiu em batalha...");
        return false;
    }

    // Mostra o menu e executa a escolha. Retorna false se o jogador voltou sem agir.
    private boolean turnoDoHeroi(Heroi heroi, Inimigo inimigo, Inventario inventario) {
        tela.mostrar("1) Atacar");
        tela.mostrar("2) " + heroi.getHabilidade().getNome() + " (" + heroi.getHabilidade().getCusto() + " de energia)");
        tela.mostrar("3) Usar poção (" + inventario.tamanho() + ")");
        tela.mostrar("4) Defender");
        int opcao = tela.lerNumero("> ", 1, 4);

        switch (opcao) {
            case 1:
                int dano = calculadora.calcular(heroi.getAtaque(), inimigo.getDefesa());
                dano = inimigo.receberDano(dano);
                tela.mostrar(heroi.getNome() + " ataca e causa " + dano + " de dano.");
                return true;
            case 2:
                if (!heroi.podeUsarHabilidade()) {
                    tela.mostrar("Energia insuficiente!");
                    return false;
                }
                heroi.gastarEnergia(heroi.getHabilidade().getCusto());
                tela.mostrar(heroi.getHabilidade().usar(heroi, inimigo, calculadora));
                return true;
            case 3:
                return usarPocao(heroi, inventario);
            default:
                heroi.defender();
                tela.mostrar(heroi.getNome() + " se defende.");
                return true;
        }
    }

    private boolean usarPocao(Heroi heroi, Inventario inventario) {
        if (inventario.estaVazio()) {
            tela.mostrar("Você não tem poções!");
            return false;
        }
        for (int i = 0; i < inventario.tamanho(); i++) {
            tela.mostrar("  " + (i + 1) + ") " + inventario.getNome(i));
        }
        tela.mostrar("  0) Voltar");
        int escolha = tela.lerNumero("> ", 0, inventario.tamanho());
        if (escolha == 0) {
            return false;
        }
        Consumivel item = inventario.pegar(escolha - 1);
        tela.mostrar(item.usar(heroi));
        return true;
    }

    private void mostrarStatus(Heroi heroi, Inimigo inimigo) {
        tela.mostrar(heroi.getNome() + " (" + heroi.getClasse() + ")  Vida: " + heroi.getVida() + "/" + heroi.getVidaMaxima()
                + "  Energia: " + heroi.getEnergia() + "/" + heroi.getEnergiaMaxima());
        tela.mostrar(inimigo.getNome() + "  Vida: " + inimigo.getVida() + "/" + inimigo.getVidaMaxima());
    }
}
