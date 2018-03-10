package Domain.Race;

import Domain.Race.Race;

import java.util.Hashtable;

public abstract class RaceAbstract implements Race {

    private String raceName;
    Hashtable Modifiers = new Hashtable();

    @Override
    public String getRaceName() {
        return this.raceName;
    }

    public void setRaceName(String race) {
        this.raceName = race;
    }

    @Override
    public Hashtable getAttributeModifiers() {
        return Modifiers;
    }
}
