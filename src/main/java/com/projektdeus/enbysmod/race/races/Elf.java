package com.projektdeus.enbysmod.race.races;
import com.projektdeus.enbysmod.race.attributes.Player_Scale;
import com.projektdeus.enbysmod.race.util.RaceLogic;
import net.minecraft.entity.player.PlayerEntity;
public class Elf implements RaceLogic {
    @Override
    public void applyRaceEffects(PlayerEntity player) {
        Player_Scale.apply(player, "Elf_Racial", 1.1f, 0); // 0 ticks = permanent
    }

    @Override
    public void clearRaceEffects(PlayerEntity player) {
        Player_Scale.remove(player, "Elf_Racial");
    }
}