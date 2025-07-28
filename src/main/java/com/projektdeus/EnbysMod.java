package com.projektdeus;

import com.projektdeus.block.ModBlocks;
import com.projektdeus.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EnbysMod implements ModInitializer {
	public static final String MOD_ID = "enbys-mod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		LOGGER.info("Enbys Mod loaded successfully");
	}
}