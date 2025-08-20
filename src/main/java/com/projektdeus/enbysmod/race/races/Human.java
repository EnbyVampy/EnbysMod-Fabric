package com.projektdeus.enbysmod.race.races;
import com.projektdeus.enbysmod.race.attributes.Player_Scale;
import net.minecraft.entity.player.PlayerEntity;
import com.projektdeus.enbysmod.race.util.RaceLogic;
public class Human implements RaceLogic {
    @Override
    public void applyRaceEffects(PlayerEntity player) {
        Player_Scale.apply(player, "Human_Racial", 1.0f, 0); // 0 ticks = permanent
    }

    @Override
    public void clearRaceEffects(PlayerEntity player) {
        Player_Scale.remove(player, "Human_Racial");
    }
}