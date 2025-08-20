package com.projektdeus.enbysmod.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.FloatArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.projektdeus.enbysmod.race.attributes.Player_Scale;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

public class AddRaceScaleCommand {

    public static void register() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            dispatcher.register(
                    CommandManager.literal("addracescale")
                            .requires(src -> src.hasPermissionLevel(2))
                            .then(CommandManager.argument("player", EntityArgumentType.player())
                                    .then(CommandManager.argument("name", StringArgumentType.string())
                                            .then(CommandManager.argument("scale", FloatArgumentType.floatArg())
                                                    .then(CommandManager.argument("seconds", IntegerArgumentType.integer(0))
                                                            .executes(AddRaceScaleCommand::applyScale)
                                                    )
                                            )
                                    )
                            )
            );
        });
    }

    private static int applyScale(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        ServerPlayerEntity player = EntityArgumentType.getPlayer(context, "player");
        String name = StringArgumentType.getString(context, "name");
        float scale = FloatArgumentType.getFloat(context, "scale");
        int seconds = IntegerArgumentType.getInteger(context, "seconds");

        int ticks = seconds > 0 ? seconds * 20 : 0;
        Player_Scale.apply(player, name, scale, ticks);

        context.getSource().sendFeedback(
                () -> Text.literal("Applied scale '" + name + "' " + scale + "x to " + player.getName().getString() +
                        (ticks > 0 ? " for " + seconds + " seconds" : " permanently")),
                true
        );

        return Command.SINGLE_SUCCESS;
    }
}
