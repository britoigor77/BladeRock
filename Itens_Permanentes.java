

public class Itens_Permanentes extends Itens{

    private int atk;
    private String nomeAtk;
    public Itens_Permanentes(String nomeItem, int qtd, int atk, String nomeAtk) {
        super(nomeItem, qtd);
        this.atk = atk;
        this.nomeAtk = nomeAtk;
    }

    public int getAtk() {
        return atk;
    }

    public String getNomeAtk() {
        return nomeAtk;
    }
    
    
    @Override
    public void usar(Player p) {
       
    }
    
}
