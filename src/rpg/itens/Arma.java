package rpg.itens;

// Arma: aumenta o ataque.
public class Arma implements Equipavel {
    private String nome;
    private int bonus;

    public Arma(String nome, int bonus) {
        this.nome = nome;
        this.bonus = bonus;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return "+" + bonus + " de ataque";
    }

    public int getBonusAtaque() {
        return bonus;
    }

    public int getBonusDefesa() {
        return 0;
    }
}
