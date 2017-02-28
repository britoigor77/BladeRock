
public class Battle_Itens extends Itens{

    private int attack;
    private int qtd_uso;
    
    public Battle_Itens(String nomeItem, int qtd, int atk, int qtd_uso) {
        super(nomeItem, qtd);
        this.attack = atk;
        this.qtd_uso = qtd_uso;
    }

    public int getQtd_uso() {
        return qtd_uso;
    }

    public int getAttack() {
        return attack;
    }

    
    
    @Override
    public void usar(Player p) {
        p.setAttack(p.getAttack() + this.attack);
    }
    
    
    
}
