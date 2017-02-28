

import java.util.ArrayList;
import java.util.Collection;


public class Book {
    
    private Event eventActually;
    private Event eventInitial;
    private String description;
    private Character player;
    
    public Book(String description, Event eventInitial, Character player) {
        this.eventInitial = eventInitial;
        this.description = description;
        this.player = player;

        this.resetHistory();
    }

    public void resetHistory() {
        this.eventActually = this.eventInitial;
    }

    public String showHistory() {
        return this.eventActually.history();
    }

    public boolean isTheEnd() {
        return this.eventActually.isEndEvent();
    }

    public String showHistoryBook(){
        return this.description;
    }

    public boolean nextEvent(int number) {
        Choice choice = this.selectChoice(number);
        if(choice != null) {
            choice.executeChoice(player);
            

            if(this.eventActually instanceof BattleEvent)
            {
            		((BattleEvent) this.eventActually).applyBattle(player);
            		
                        
                        
            		if(((BattleEvent) this.eventActually).fimDaLuta()){//SE O HP DO ENEMY ACABAR
            			this.eventActually = ((BattleEvent) this.eventActually).getEventoGanhou();
            			
            		}
            		
            		return true;
            }
         
            else{    
                    if(player.isAlive()) {
                        this.eventActually = choice.getEvent();
                         this.eventActually.applyHistory(player);
                         
                    }
                    
                    else {
                        Event gameOver = new BlankEvent("Game Over", new ArrayList<Choice>(), TipoFase.NOTHING);
                        this.eventActually = gameOver;
                    }
                    return true;
            }
         
        
        }
        return false;
    }

    public Choice selectChoice(int number) {
        return this.eventActually.findChoice(number);
    }

    public Collection<Choice> nextEvents() {
        return this.eventActually.nextEvents();
    }

    public Character getPlayer() {
        return player;
    }

    public Event getEventActually() {
        return eventActually;
    }
    
}
