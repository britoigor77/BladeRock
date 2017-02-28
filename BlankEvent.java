
import java.util.Collection;


public class BlankEvent extends Event{
    public BlankEvent(String description, Collection<Choice> choices, TipoFase tipo) {
        super(description, choices, tipo);
    }

    public void applyHistory(Character character) {

    }

    public void applyHistory(java.lang.Character character) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
