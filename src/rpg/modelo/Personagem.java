package rpg.modelo;

// Classe abstrata com o que todo personagem tem: nome, vida, ataque e defesa.
// Encapsulamento: os atributos são private e a vida só muda pelos métodos abaixo.
public abstract class Personagem implements Combatente {
    private String nome;
    private int vida;
    private int vidaMaxima;
    private int ataque;
    private int defesa;

    public Personagem(String nome, int vidaMaxima, int ataque, int defesa) {
        this.nome = nome;
        this.vidaMaxima = vidaMaxima;
        this.vida = vidaMaxima;
        this.ataque = ataque;
        this.defesa = defesa;
    }

    public String getNome() {
        return nome;
    }

    public int getVida() {
        return vida;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    // Tira vida, mas nunca deixa ficar negativa. Retorna o dano que realmente tirou.
    public int receberDano(int dano) {
        if (dano < 0) {
            dano = 0;
        }
        if (dano > vida) {
            dano = vida;
        }
        vida = vida - dano;
        return dano;
    }

    // Recupera vida, mas nunca passa da vida máxima. Só as subclasses usam.
    protected int recuperarVida(int quantidade) {
        int falta = vidaMaxima - vida;
        if (quantidade > falta) {
            quantidade = falta;
        }
        vida = vida + quantidade;
        return quantidade;
    }

    public boolean estaVivo() {
        return vida > 0;
    }
}
