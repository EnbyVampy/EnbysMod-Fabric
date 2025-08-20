package com.projektdeus.enbysmod.registry;

import com.projektdeus.enbysmod.race.races.*;
import com.projektdeus.enbysmod.race.util.RaceRegistry;
import net.minecraft.util.Identifier;

public class ModRaces {

    // Registers all races
    public static void registerAll() {
        RaceRegistry.register(Identifier.of("enbysmod", "demon"),   new Demon());
        RaceRegistry.register(Identifier.of("enbysmod", "dwarf"),   new Dwarf());
        RaceRegistry.register(Identifier.of("enbysmod", "elf"),     new Elf());
        RaceRegistry.register(Identifier.of("enbysmod", "gnome"),   new Gnome());
        RaceRegistry.register(Identifier.of("enbysmod", "human"),   new Human());
        RaceRegistry.register(Identifier.of("enbysmod", "ogre"),    new Ogre());
        RaceRegistry.register(Identifier.of("enbysmod", "oni"),     new Oni());
//        RaceRegistry.register(Identifier.of("enbysmod", "test4"),   new Human());
//        RaceRegistry.register(Identifier.of("enbysmod", "test5"),   new Human());
//        RaceRegistry.register(Identifier.of("enbysmod", "test6"),   new Human());
//        RaceRegistry.register(Identifier.of("enbysmod", "test7"),   new Human());
//        RaceRegistry.register(Identifier.of("enbysmod", "test8"),   new Human());
//        RaceRegistry.register(Identifier.of("enbysmod", "test9"),   new Human());
//        RaceRegistry.register(Identifier.of("enbysmod", "test10"),  new Human());
    }
}
