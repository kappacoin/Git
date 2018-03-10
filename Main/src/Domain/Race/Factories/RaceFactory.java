package Domain.Race.Factories;

import Domain.Race.Race;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class RaceFactory {
    public Race parse(String race) throws
            ClassNotFoundException,
            NoSuchMethodException,
            IllegalAccessException,
            InvocationTargetException,
            InstantiationException {
        race = par("Domain.race"+race);
//        Class<Race> RaceClass = Race.forName(race);
//        Constructor<Race> RaceConstructor = RaceClass.getConstructor(String.class);
//        Race ChosenRace = RaceConstructor.newInstance(race);
        return ChosenRace;
    }

    private static Race par(String s) {
        Class race = null;
        try {
            race = Class.forName(s);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            return (Race) race.getInterfaces();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}