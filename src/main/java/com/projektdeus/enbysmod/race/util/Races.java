package com.projektdeus.enbysmod.race.util;
import java.util.HashMap;
import java.util.Map;
public class Races {
    private static final Map<String, RaceLogic> RACES = new HashMap<>();
    private static final String DEFAULT_RACE = "human";
    public static RaceLogic getOrDefault(String id) {
        return RACES.getOrDefault(id, RACES.get(DEFAULT_RACE));
    }
    public static void register(String id, RaceLogic logic) {
        RACES.put(id, logic);
    }
    public static Iterable<String> getIds() {
        return java.util.Collections.unmodifiableSet(RACES.keySet());
    }
    public static boolean exists(String id) {
        return RACES.containsKey(id);
    }
}
