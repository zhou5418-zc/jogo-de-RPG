package rpg.itens;

// Armadura: aumenta a defesa.
public class Armadura implements Equipavel {
    private String nome;
    private int bonus;

    public Armadura(String nome, int bonus) {
        this.nome = nome;
        this.bonus = bonus;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return "+" + bonus + " de defesa";
    }

    public int getBonusAtaque() {
        return 0;
    }

    public int getBonusDefesa() {
        return bonus;
    }
}
