package com.projektdeus.enbysmod.registry;
import com.projektdeus.enbysmod.commands.*;

public class ModCommands {
    public static void registerCommands() {
        RaceCommand.register();
        AddRaceScaleCommand.register();
        ListRaceScaleCommand.register();
        ClearRaceScaleCommand.register();
        RemoveRaceScaleCommand.register();
    }
}
