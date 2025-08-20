package com.projektdeus.enbysmod.race.races;
import com.projektdeus.enbysmod.race.attributes.Player_Scale;
import com.projektdeus.enbysmod.race.util.RaceLogic;
import net.minecraft.entity.player.PlayerEntity;
public class Ogre implements RaceLogic {
    @Override
    public void applyRaceEffects(PlayerEntity player) {
        Player_Scale.apply(player, "Ogre_Racial", 1.5f, 0); // 0 ticks = permanent
    }

    @Override
    public void clearRaceEffects(PlayerEntity player) {
        Player_Scale.remove(player, "Ogre_Racial");
    }
}