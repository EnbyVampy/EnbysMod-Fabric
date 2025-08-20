package com.projektdeus.enbysmod.commands;

import com.mojang.brigadier.context.CommandContext;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import com.projektdeus.enbysmod.race.attributes.Player_Scale;

public class ClearRaceScaleCommand {

    public static void register() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            dispatcher.register(
                    CommandManager.literal("clearracescale")
                            .requires(src -> src.hasPermissionLevel(2)) // OP only
                            .then(CommandManager.argument("player", net.minecraft.command.argument.EntityArgumentType.player())
                                    .executes(ClearRaceScaleCommand::clearScale)
                            )
            );
        });
    }

    private static int clearScale(CommandContext<ServerCommandSource> context) {
        try {
            ServerPlayerEntity player = net.minecraft.command.argument.EntityArgumentType.getPlayer(context, "player");

            // Remove all scale effects
            Player_Scale.removeAll(player);

            context.getSource().sendFeedback(
                    () -> Text.literal("All scale effects cleared for " + player.getName().getString() + ". Scale reset to 1.0."),
                    true
            );
        } catch (Exception e) {
            context.getSource().sendError(Text.literal("Error clearing scale: " + e.getMessage()));
        }
        return 1; // command success
    }
}
