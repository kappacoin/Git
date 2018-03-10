package Domain.Race;

public class Dragonborn extends RaceAbstract {

    public Dragonborn() {
        this.setRaceName("Dragonborn");
        Modifiers.put("Str", 2);
        Modifiers.put("Dex", 0);
        Modifiers.put("Const", 0);
        Modifiers.put("Int", 0);
        Modifiers.put("Wis", 0);
        Modifiers.put("Char", 1);
    }
}

