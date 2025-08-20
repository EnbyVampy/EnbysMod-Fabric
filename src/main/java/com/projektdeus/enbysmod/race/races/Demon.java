package com.projektdeus.enbysmod.race.races;

import com.projektdeus.enbysmod.race.util.RaceLogic;
import net.minecraft.entity.player.PlayerEntity;
import com.projektdeus.enbysmod.race.attributes.Player_Scale;

public class Demon implements RaceLogic {

    @Override
    public void applyRaceEffects(PlayerEntity player) {
        Player_Scale.apply(player, "Demon_Racial", 1.25f, 0); // 0 ticks = permanent
    }

    @Override
    public void clearRaceEffects(PlayerEntity player) {
        Player_Scale.remove(player, "Demon_Racial");
    }
}
