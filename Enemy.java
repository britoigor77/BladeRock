

public class Enemy extends Character {

    private String nome;
    public Enemy(int life, int attack, String nome) {
        super(life, attack);
        this.setNome(nome);
    }

}
