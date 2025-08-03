package com.projektdeus.enbysmod.criteria;

import com.projektdeus.enbysmod.EnbysMod;
import net.minecraft.advancement.criterion.Criteria;

public class ModCriteria {

    public static final PlaceEpicItemInDisplayBlockCriterion PLACE_EPIC_ITEM_ON_DISPLAY = Criteria.register(
            EnbysMod.MOD_ID+":place_epic_item_on_display", new PlaceEpicItemInDisplayBlockCriterion());

    public static final PlaceDisplayBlockOnDisplayCriterion PLACE_DISPLAY_ON_DISPLAY = Criteria.register(
            EnbysMod.MOD_ID+":place_display_on_display", new PlaceDisplayBlockOnDisplayCriterion());

    public static void init(){
        EnbysMod.LOGGER.info("Registering Displays custom criteria!");
    }
}