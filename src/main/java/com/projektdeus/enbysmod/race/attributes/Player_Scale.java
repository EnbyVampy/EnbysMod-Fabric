package com.projektdeus.enbysmod.race.attributes;

import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.util.Identifier;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Player_Scale {

    private static final Identifier SCALE_MODIFIER_ID = Identifier.of("enbysmod", "player_scale_modifier");

    // Store active effects per player
    private static final Map<PlayerEntity, List<ScaleEffect>> activeScales = new ConcurrentHashMap<>();

    // Save
//    public static void saveToNbt(PlayerEntity player) {
//        NbtCompound nbt = new NbtCompound(); // create temporary NBT
//        NbtList effectsList = new NbtList();
//        for (ScaleEffect effect : activeScales.getOrDefault(player, Collections.emptyList())) {
//            NbtCompound effectTag = new NbtCompound();
//            effectTag.putString("name", effect.name);
//            effectTag.putFloat("scale", effect.scale);
//            effectTag.putInt("ticks", effect.ticks);
//            effectsList.add(effectTag);
//        }
//        nbt.put("effects", effectsList);
//        player.getPersistentData().put("PlayerScale", nbt); // you may need a Mixin if getPersistentData() is unavailable
//    }
//
//    // Load
//    public static void loadFromNbt(PlayerEntity player) {
//        if (!player.getPersistentData().contains("PlayerScale")) return;
//        NbtCompound nbt = player.getPersistentData().getCompound("PlayerScale");
//        NbtList list = nbt.getList("effects", 10); // 10 = Compound
//        List<ScaleEffect> effects = new ArrayList<>();
//        for (int i = 0; i < list.size(); i++) {
//            NbtCompound effectTag = list.getCompound(i);
//            effects.add(new ScaleEffect(
//                    effectTag.getString("name"),
//                    effectTag.getFloat("scale"),
//                    effectTag.getInt("ticks")
//            ));
//        }
//        activeScales.put(player, effects);
//        recalcScale(player);
//    }


    // Helper class to track individual scale effects
    public static class ScaleEffect {
        public final String name;
        public final float scale;
        public int ticks;

        public ScaleEffect(String name, float scale, int ticks) {
            this.name = name;
            this.scale = scale;
            this.ticks = ticks;
        }
    }

    /** Apply a new scale effect */
    public static void apply(PlayerEntity player, String name, float scale, int ticks) {
        activeScales.computeIfAbsent(player, p -> new ArrayList<>())
                .add(new ScaleEffect(name, scale, ticks));
        recalcScale(player);
    }

    /** Remove a specific scale effect (optional) */
    public static void remove(PlayerEntity player, String name) {
        List<ScaleEffect> effects = activeScales.get(player);
        if (effects != null) {
            effects.removeIf(e -> e.name.equalsIgnoreCase(name));
            if (effects.isEmpty()) activeScales.remove(player);
            recalcScale(player);
        }
    }

    /** Call this every server tick to decrement timers and remove expired effects */
    public static void tick() {
        Iterator<Map.Entry<PlayerEntity, List<ScaleEffect>>> iterator = activeScales.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<PlayerEntity, List<ScaleEffect>> entry = iterator.next();
            PlayerEntity player = entry.getKey();
            List<ScaleEffect> effects = entry.getValue();

            if (!player.isAlive()) {
                iterator.remove();
                continue;
            }

            boolean changed = false;
            Iterator<ScaleEffect> effectIterator = effects.iterator();
            while (effectIterator.hasNext()) {
                ScaleEffect effect = effectIterator.next();
                if (effect.ticks > 0) {
                    effect.ticks--;
                    if (effect.ticks <= 0) {
                        effectIterator.remove();
                        changed = true;
                    }
                }
            }

            if (changed || !effects.isEmpty()) recalcScale(player);

            if (effects.isEmpty()) iterator.remove();
        }
    }

    /** Returns the player's current total scale including all modifiers */
    public static float getCurrentScale(PlayerEntity player) {
        var attr = player.getAttributeInstance(EntityAttributes.GENERIC_SCALE);
        if (attr == null) return 1.0f;
        return (float) attr.getValue();
    }
    public static Map<PlayerEntity, List<ScaleEffect>> getActiveScales() {
        return activeScales;
    }

    public static void clear(PlayerEntity player) {
        activeScales.remove(player);
        recalcScale(player);
    }

    /** Remove all scale effects from a player and reset to 1.0 */
    public static void removeAll(PlayerEntity player) {
        activeScales.remove(player); // remove all tracked effects

        var scaleAttr = player.getAttributeInstance(EntityAttributes.GENERIC_SCALE);
        if (scaleAttr == null) return;

        // Remove old modifier
        var old = scaleAttr.getModifier(SCALE_MODIFIER_ID);
        if (old != null) scaleAttr.removeModifier(old);

        // Reset to 1.0
        scaleAttr.addPersistentModifier(new EntityAttributeModifier(
                SCALE_MODIFIER_ID,
                0.0,
                EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE
        ));
    }


    /** Recalculate the player's scale based on all active effects */
    private static void recalcScale(PlayerEntity player) {
        EntityAttributeInstance scaleAttr = player.getAttributeInstance(EntityAttributes.GENERIC_SCALE);
        if (scaleAttr == null) return;

        // Remove previous modifier
        EntityAttributeModifier old = scaleAttr.getModifier(SCALE_MODIFIER_ID);
        if (old != null) scaleAttr.removeModifier(old);

        // Calculate combined multiplier
        double combined = activeScales.getOrDefault(player, Collections.emptyList())
                .stream()
                .mapToDouble(e -> e.scale)
                .reduce(1.0, (a, b) -> a * b);

        // Apply new modifier
        if (combined != 1.0) {
            scaleAttr.addPersistentModifier(new EntityAttributeModifier(
                    SCALE_MODIFIER_ID,
                    combined - 1.0,
                    EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE
            ));
        }
    }
}
