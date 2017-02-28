
public enum TipoFase {
    MUSIC(0),LOSE(0),WON(0), NOTHING(0), BATTLE(2), BATTLE2(3), HEAL(3), HEAL2(5), DAMAGE(3), DAMAGE2(0), TRANSITION(0)
    , GANHA_PALHETA(0), GANHA_ACORDAMENTO(0), GANHA_MICROFONE(0);
    
    private final int morePoints;
    
    TipoFase(int morePoints)
    {
        this.morePoints = morePoints;
    }
    
    public int getMorePonits()
    {
        return this.morePoints;
    }
}

