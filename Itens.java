
public abstract class Itens {
    
    private String nomeItem;
    private int qtd;
    public Itens(String nomeItem, int qtd)
    {
        this.setNomeItem(nomeItem);
    }

    public String getNomeItem() {
        return nomeItem;
    }

    public void setNomeItem(String nomeItem) {
        this.nomeItem = nomeItem;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
    
    
    
    public abstract void usar(Player p);
     
}
