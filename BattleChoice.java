
public class BattleChoice extends Choice {
    
     //private Enemy enemy; 
    public BattleChoice(String description, Event event, Enemy enemy) {
        super(description, event);
        //this.enemy = enemy;
    }
    
     public BattleChoice(String description) {
	        super(description, null);
	    }

    public void executeChoice(Character character) {
       // character.battle(this.enemy);
    }
    
}
