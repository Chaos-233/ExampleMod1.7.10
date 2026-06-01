package com.chaos233.tinkerslegacy.events;

import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent;

import com.chaos233.tinkerslegacy.traits.TraitHelper;
import com.chaos233.tinkerslegacy.traits.TraitRegistry;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class TraitEventHandler {

    @SubscribeEvent
    public void onBreak(BlockEvent.BreakEvent event) {
        ItemStack tool = event.getPlayer()
            .getCurrentEquippedItem();

        if (tool == null) return;

        if (TraitHelper.hasTrait(tool, "magnetic")) {
            TraitRegistry.get("magnetic")
                .onBlockBreak(tool, event);
        }
    }
}
