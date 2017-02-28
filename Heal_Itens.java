

public class Heal_Itens extends Itens{

    private int heal;
    private String nomeItem;
    public Heal_Itens(String nomeItem, int heal, int qtd) {
        super(nomeItem, qtd);
        this.heal = heal;
        this.nomeItem = nomeItem;
    }

    public int getHeal() {
        return heal;
    }
    

    @Override
    public void usar(Player p) {
       p.setLive(p.getLife() + this.heal);
    }
    
    
    
}
