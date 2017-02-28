

import java.util.ArrayList;
import java.util.Collection;


public abstract class Event {
    
    private String description;
    private Collection<Choice> choices;
    private TipoFase tipo;
    
    public Event(String description, Collection<Choice> choices, TipoFase tipo) {
        this.description = description;
        this.choices = new ArrayList<>();
        this.tipo = tipo;
        int i = 0;
        for(Choice choice:choices) {
            choice.defineNumber(i);
            this.choices.add(choice);
            i++;
        }

    }

    public String history() {
        return this.description;
    }

    public boolean isEndEvent() {
        if(this.choices.isEmpty()) return true;

        return false;
    }

    public Collection<Choice> nextEvents() {
        return this.choices;
    }

    public Choice findChoice(int number) {
        for(Choice choice:this.choices) {
            if(choice.getNumber() == number) return choice;
        }

        return null;
    }

    public TipoFase getTipo() {
        return tipo;
    }

    public abstract void applyHistory(Character character);


}
