package com.projektdeus.enbysmod;
import com.projektdeus.enbysmod.race.attributes.Player_Scale;
import com.projektdeus.enbysmod.registry.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.server.MinecraftServer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class EnbysMod implements ModInitializer {
	public static final String MOD_ID = "enbysmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModBlockEntities.registerAllBlockEntities();
		ModItems.registerModItems(); // Register Mod Items
		ModBlocks.registerModBlocks(); // Register Mod Blocks
		ModItemGroups.registerItemGroups(); // Register Item Groups
		ModCommands.registerCommands();
		ModEffects.registerEffects(); // Register Mod Effects
		ModRaces.registerAll();

		LOGGER.info("Enbys Mod loaded successfully");
		ServerTickEvents.END_SERVER_TICK.register(server -> tickScales(server));
		ServerPlayerEvents.AFTER_RESPAWN.register((oldPlayer, newPlayer, alive) -> {
//			Player_Scale.loadFromNbt(newPlayer);
		});

		ServerPlayerEvents.COPY_FROM.register((oldPlayer, newPlayer, alive) -> {
//			Player_Scale.saveToNbt(oldPlayer);
		});

	}
	private void tickScales(MinecraftServer server) {
		Player_Scale.tick();
	}
}