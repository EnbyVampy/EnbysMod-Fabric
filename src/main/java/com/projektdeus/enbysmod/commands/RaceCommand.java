package com.projektdeus.enbysmod.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.projektdeus.enbysmod.race.attributes.Player_Scale;
import com.projektdeus.enbysmod.race.util.RaceComponent;
import com.projektdeus.enbysmod.race.util.RaceLogic;
import com.projektdeus.enbysmod.race.util.RaceRegistry;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import com.mojang.brigadier.suggestion.SuggestionProvider;
import net.minecraft.util.Identifier;

public class RaceCommand {

    // Suggestion provider for all registered race IDs
    private static final SuggestionProvider<ServerCommandSource> RACE_SUGGESTIONS = (context, builder) -> {
        for (var entry : RaceRegistry.all().entrySet()) {
            String id = entry.getKey().getPath(); // get the path from Identifier
            builder.suggest(id);
        }
        return builder.buildFuture();
    };

    public static void register() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {

            dispatcher.register(
                    CommandManager.literal("setrace")
                            .requires(source -> source.hasPermissionLevel(2)) // OP only
                            .then(CommandManager.argument("player", EntityArgumentType.player())
                                    .then(CommandManager.argument("race", StringArgumentType.string())
                                            .suggests(RACE_SUGGESTIONS)
                                            .executes(RaceCommand::setRace)
                                    )
                            )
            );
        });
    }
    @SuppressWarnings("RedundantReturn")
    private static int setRace(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        ServerPlayerEntity player = EntityArgumentType.getPlayer(context, "player");
        String raceId = StringArgumentType.getString(context, "race");

        RaceLogic logic = RaceRegistry.getLogic(Identifier.of("enbysmod", raceId));
        if (logic == null) {
            context.getSource().sendFeedback(() -> Text.literal("Invalid race: " + raceId), false);
            return Command.SINGLE_SUCCESS;
        }

        // Set race in player's RaceComponent
        RaceComponent.get(player).setRace(raceId);

        // Clear any current effects first
        logic.clearRaceEffects(player);
        // apply new effects
        logic.applyRaceEffects(player);

        context.getSource().sendFeedback(() ->
                Text.literal("Set " + player.getName().getString() + "'s race to " + raceId), true
        );
        return Command.SINGLE_SUCCESS;
    }
}
