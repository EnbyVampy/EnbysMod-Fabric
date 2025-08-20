package com.projektdeus.enbysmod.race.util;

import net.minecraft.util.Identifier;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class RaceRegistry {
    private static final Map<Identifier, RaceLogic> LOGIC = new HashMap<>();

    public static void register(Identifier id, RaceLogic logic) {
        LOGIC.put(id, logic);
    }

    public static RaceLogic getLogic(Identifier id) {
        return LOGIC.get(id);
    }

    // Return an unmodifiable map of all registered races
    public static Map<Identifier, RaceLogic> all() {
        return Collections.unmodifiableMap(LOGIC);
    }
}
