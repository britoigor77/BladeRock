
public class Player extends Character {

    private ArrayList itens;
    
    
    public Player(int life, int atk) {
        super(life, atk);
        this.itens = new ArrayList(); 
    }

    public ArrayList getItens() {
        return itens;
    }

    public void setItens(ArrayList itens) {
        this.itens = itens;
    }
    
   public void somaAtk(Item i)
   {
       this.setAttack(this.getAttack() + i.getAtk() );
   }
}
