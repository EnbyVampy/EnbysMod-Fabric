package com.projektdeus.enbysmod;

import com.projektdeus.enbysmod.block.ModBlocks;
import com.projektdeus.enbysmod.item.ModItemGroups;
import com.projektdeus.enbysmod.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EnbysMod implements ModInitializer {
	public static final String MOD_ID = "enbysmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModItemGroups.registerItemGroups();
		LOGGER.info("Enbys Mod loaded successfully");
	}
}