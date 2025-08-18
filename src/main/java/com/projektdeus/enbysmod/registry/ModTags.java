package com.projektdeus.enbysmod.registry;

import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> POWER_PRODUCERS = create("power_producers");
        public static final TagKey<Block> POWER_CONSUMERS = create("power_consumers");
        public static final TagKey<Block> POWER_TRANSPORTERS = create("power_transporters");
        public static final TagKey<Block> CABLE_CONNECTABLE = create("cable_connectable");

        private static TagKey<Block> create(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of("enbysmod", name));
        }
    }
}
