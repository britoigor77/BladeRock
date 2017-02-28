
public enum TipoInimigo {
    FUNKEIRO("O funkeiro puxou o celular e botou pta tocar um proibidão."), 
    PAGODEIRO("O pagodeiro puxou um cavaquinho e cantou CARACA MULEKE"),
    EMO("O emo cortou os pulosos e jogou um cd do Restart na sua cara"), 
    CAPANGA("O capanga te deu um soco");
    
    private String nomeHit;
    
    TipoInimigo(String nomeHit)
    {
        this.nomeHit = nomeHit;
    }
    
    public String getHit()
    {
        return this.nomeHit;
    }
}
