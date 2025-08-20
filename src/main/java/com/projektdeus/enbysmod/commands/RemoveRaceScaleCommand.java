package com.projektdeus.enbysmod.commands;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.projektdeus.enbysmod.race.attributes.Player_Scale;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
public class RemoveRaceScaleCommand {

    public static void register() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            dispatcher.register(
                    CommandManager.literal("removeracescale")
                            .requires(src -> src.hasPermissionLevel(2)) // OP only
                            .then(CommandManager.argument("player", EntityArgumentType.player())
                                    .then(CommandManager.argument("name", StringArgumentType.string())
                                            .executes(RemoveRaceScaleCommand::removeScale)
                                    )
                            )
            );
        });
    }

    private static int removeScale(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        ServerPlayerEntity player = EntityArgumentType.getPlayer(context, "player");
        String name = StringArgumentType.getString(context, "name");

        Player_Scale.remove(player, name);

        context.getSource().sendFeedback(
                () -> Text.literal("Removed scale '" + name + "' from " + player.getName().getString() + "."),
                true
        );

        return Command.SINGLE_SUCCESS;
    }
}
