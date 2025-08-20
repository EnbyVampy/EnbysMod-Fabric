package com.projektdeus.enbysmod.commands;

import com.mojang.brigadier.context.CommandContext;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;

import com.projektdeus.enbysmod.race.attributes.Player_Scale;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ListRaceScaleCommand {

    /** Register the command with Fabric */
    public static void register() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            dispatcher.register(
                    CommandManager.literal("listracescale")
                            .requires(src -> src.hasPermissionLevel(2)) // OP only
                            .executes(ListRaceScaleCommand::execute)
            );
        });
    }

    /** Execute the command */
    private static int execute(CommandContext<ServerCommandSource> context) {
        ServerCommandSource source = context.getSource();

        // Get active scale effects from Player_Scale
        Map<PlayerEntity, List<Player_Scale.ScaleEffect>> activeScales = Player_Scale.getActiveScales();

        if (activeScales.isEmpty()) {
            source.sendFeedback(() -> Text.literal("No active race scale effects."), false);
            return 1;
        }

        source.sendFeedback(() -> Text.literal("Active race scale effects:"), false);

        for (Map.Entry<PlayerEntity, List<Player_Scale.ScaleEffect>> entry : activeScales.entrySet()) {
            PlayerEntity player = entry.getKey();
            List<Player_Scale.ScaleEffect> effects = entry.getValue();

            float currentScale = (float) Objects.requireNonNull(player.getAttributeInstance(EntityAttributes.GENERIC_SCALE)).getValue();
            source.sendFeedback(() -> Text.literal(player.getName().getString() + " -> current scale: " + currentScale), false);

            for (Player_Scale.ScaleEffect effect : effects) {
                String effectName = effect.name != null ? effect.name : "Unnamed"; // Fallback if name is null
                String timerText = effect.ticks > 0 ? (effect.ticks / 20) + "s remaining" : "permanent"; // Show remaining time or permanent

                source.sendFeedback(() -> Text.literal("  - " + effectName + ": " + effect.scale + "x (" + timerText + ")"), false);
            }
        }

        return 1;
    }
}
