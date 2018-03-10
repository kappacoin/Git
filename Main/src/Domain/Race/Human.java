package Domain.Race;

import Domain.Race.RaceAbstract;

public class Human extends RaceAbstract {

    public Human() {
        this.setRaceName("Basic Human");
        Modifiers.put("Str", 1);
        Modifiers.put("Dex", 1);
        Modifiers.put("Const", 1);
        Modifiers.put("Int", 1);
        Modifiers.put("Wis", 1);
        Modifiers.put("Char", 1);
    }
}
