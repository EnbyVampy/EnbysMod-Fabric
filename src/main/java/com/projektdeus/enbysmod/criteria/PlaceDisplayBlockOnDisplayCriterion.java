package com.projektdeus.enbysmod.criteria;

import com.mojang.serialization.Codec;
import com.projektdeus.enbysmod.EnbysMod;
import net.minecraft.advancement.criterion.AbstractCriterion;
import net.minecraft.predicate.entity.LootContextPredicate;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class PlaceDisplayBlockOnDisplayCriterion extends AbstractCriterion<PlaceDisplayBlockOnDisplayCriterion.Conditions> {

    public static final Identifier ID = Identifier.of(EnbysMod.MOD_ID, "place_display_on_display");



    @Override
    public Codec<PlaceDisplayBlockOnDisplayCriterion.Conditions> getConditionsCodec() {
        return PlaceDisplayBlockOnDisplayCriterion.Conditions.CODEC;
    }

    public record Conditions(Optional<LootContextPredicate> playerPredicate) implements AbstractCriterion.Conditions {

        public static Codec<PlaceDisplayBlockOnDisplayCriterion.Conditions> CODEC = LootContextPredicate.CODEC.optionalFieldOf("player")
                .xmap(PlaceDisplayBlockOnDisplayCriterion.Conditions::new, PlaceDisplayBlockOnDisplayCriterion.Conditions::player).codec();

        @Override
        public Optional<LootContextPredicate> player() {
            return playerPredicate;
        }

        public boolean requirementsMet() {
            return true;
        }
    }

    public void trigger(ServerPlayerEntity player) {
        trigger(player, PlaceDisplayBlockOnDisplayCriterion.Conditions::requirementsMet);
    }

}