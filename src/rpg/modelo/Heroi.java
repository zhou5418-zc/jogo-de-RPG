package rpg.modelo;

import rpg.habilidades.Habilidade;
import rpg.itens.Equipavel;

import java.util.ArrayList;

// Herói do jogador. Herda de Personagem e pode ser curado.
// Composição: o herói TEM uma habilidade e uma lista de equipamentos.
public abstract class Heroi extends Personagem implements Curavel {
    private Habilidade habilidade;
    private ArrayList<Equipavel> equipamentos = new ArrayList<>();
    private int energia;
    private int energiaMaxima;
    private boolean defendendo = false;

    public Heroi(String nome, int vida, int ataque, int defesa, int energiaMaxima, Habilidade habilidade) {
        super(nome, vida, ataque, defesa);
        this.energiaMaxima = energiaMaxima;
        this.energia = energiaMaxima;
        this.habilidade = habilidade;
    }

    // Cada classe de herói diz o seu nome (Guerreiro, Mago, Arqueiro).
    public abstract String getClasse();

    // Polimorfismo: o ataque do herói soma o bônus dos equipamentos.
    @Override
    public int getAtaque() {
        int total = super.getAtaque();
        for (Equipavel e : equipamentos) {
            total = total + e.getBonusAtaque();
        }
        return total;
    }

    @Override
    public int getDefesa() {
        int total = super.getDefesa();
        for (Equipavel e : equipamentos) {
            total = total + e.getBonusDefesa();
        }
        return total;
    }

    // Se estiver defendendo, recebe metade do dano. Depois usa a regra da classe mãe (LSP).
    @Override
    public int receberDano(int dano) {
        if (defendendo) {
            dano = dano / 2;
        }
        return super.receberDano(dano);
    }

    public int curar(int quantidade) {
        return recuperarVida(quantidade);
    }

    public void equipar(Equipavel item) {
        equipamentos.add(item);
    }

    public Habilidade getHabilidade() {
        return habilidade;
    }

    public boolean podeUsarHabilidade() {
        return energia >= habilidade.getCusto();
    }

    public void gastarEnergia(int quantidade) {
        energia = energia - quantidade;
        if (energia < 0) {
            energia = 0;
        }
    }

    public void recuperarEnergia(int quantidade) {
        energia = energia + quantidade;
        if (energia > energiaMaxima) {
            energia = energiaMaxima;
        }
    }

    // Chamado no começo de cada turno: perde a defesa e ganha 10 de energia.
    public void comecarTurno() {
        defendendo = false;
        recuperarEnergia(10);
    }

    public void defender() {
        defendendo = true;
    }

    public int getEnergia() {
        return energia;
    }

    public int getEnergiaMaxima() {
        return energiaMaxima;
    }
}
