package com.projektdeus.enbysmod.race.races;
import com.projektdeus.enbysmod.race.attributes.Player_Scale;
import com.projektdeus.enbysmod.race.util.RaceLogic;
import net.minecraft.entity.player.PlayerEntity;
public class Dwarf implements RaceLogic {
    @Override
    public void applyRaceEffects(PlayerEntity player) {
        Player_Scale.apply(player, "Dwarf_Racial", 0.75f, 0); // 0 ticks = permanent
    }

    @Override
    public void clearRaceEffects(PlayerEntity player) {
        Player_Scale.remove(player, "Dwarf_Racial");
    }
}