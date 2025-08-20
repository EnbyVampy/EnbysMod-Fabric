package com.projektdeus.enbysmod.mixin;

import com.projektdeus.enbysmod.race.util.RaceComponent;
import com.projektdeus.enbysmod.race.util.RaceHolder;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin implements RaceHolder {
    private final RaceComponent raceComponent = new RaceComponent();

    @Override
    public RaceComponent getRaceComponent() {
        return raceComponent;
    }

    @Inject(method = "writeCustomDataToNbt", at = @At("RETURN"))
    private void saveRace(NbtCompound nbt, CallbackInfo ci) {
        raceComponent.saveToNbt(nbt);
    }

    @Inject(method = "readCustomDataFromNbt", at = @At("RETURN"))
    private void loadRace(NbtCompound nbt, CallbackInfo ci) {
        raceComponent.loadFromNbt(nbt);
    }
}