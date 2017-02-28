

public enum ItensIniciais {
    
    GUITARRA("Guitarrada no estômago.", "Explosão sônica"), BAIXO("Contra-baixada na cara.", "Enforcamento de cordas"), 
    BAQUETAS("Jogar baqueta nos olhos", "Explosão ritmica");
 
    private final String itemNomeAtk;
    private final String itemNomeAtk2;
    
    ItensIniciais(String itemNomeAtk, String itemNomeAtk2)
    {
        this.itemNomeAtk = itemNomeAtk;
        this.itemNomeAtk2 = itemNomeAtk2;
    }
    
    public String getNomeAtk()
    {
        return this.itemNomeAtk;
    }
}
