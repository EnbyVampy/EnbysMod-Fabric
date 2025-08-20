package com.projektdeus.enbysmod.race.util;

import net.minecraft.entity.player.PlayerEntity;

public interface RaceLogic {
    void applyRaceEffects(PlayerEntity player);
    void clearRaceEffects(PlayerEntity player);
}

