package com.chaos233.tinkerslegacy.traits;

import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent;

public interface IToolTrait {

    String getTraitID();

    void onBlockBreak(ItemStack tool, BlockEvent.BreakEvent event);
}
