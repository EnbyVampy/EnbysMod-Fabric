package com.projektdeus.enbysmod.race.util;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Identifier;

public class RaceComponent {
    private String raceId = "human"; // default
    public String getRaceId() {
        return raceId;
    }
    public void setRace(String raceId) {
        this.raceId = raceId;
    }

    /** Retrieves the RaceLogic from the code-based registry */
    public RaceLogic getRaceLogic() {
        return RaceRegistry.getLogic(Identifier.of("enbysmod", raceId));
    }

    /** Save race to player NBT */
    public void saveToNbt(NbtCompound nbt) {
        nbt.putString("Race", raceId);
    }

    /** Load race from player NBT */
    public void loadFromNbt(NbtCompound nbt) {
        if (nbt.contains("Race")) {
            this.raceId = nbt.getString("Race");
        }
    }

    /** Helper to get RaceComponent from a player */
    public static RaceComponent get(PlayerEntity player) {
        return ((RaceHolder) player).getRaceComponent();
    }
}
