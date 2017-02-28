

import java.util.Collection;


public class BattleEvent extends Event {
	
	private Character enemy;
	private Event acabouLuta;
	private Character player;
        private TipoFase tipo;
        
	public BattleEvent(String description, Collection<Choice> choices, Character enemy, Event event, TipoFase tipo){
		super(description, choices, tipo);
		this.setEnemy(enemy);
		this.setEventoGanhou(event);
	}
	
	@Override
	public void applyHistory(Character character) {
	}
	

	public void applyBattle(Character a){
            this.player = a;
            a.battle(this.getEnemy());

	}

	public Character getEnemy() {
		return enemy;
	}

	private void setEnemy(Character enemy) {
		this.enemy = enemy;
                
	}
	
	public boolean fimDaLuta(){
		if(this.getEnemy().isAlive()){	
			return false;
		}
		else{
			return true;
		}
	}

	public Event getEventoGanhou() {
		return this.acabouLuta;
	}

	private void setEventoGanhou(Event acabouLuta) {
		this.acabouLuta = acabouLuta;
	}
	
    public Character getPlayer() {
        return player;
    }

}
