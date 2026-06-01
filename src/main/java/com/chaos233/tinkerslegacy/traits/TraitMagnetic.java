package com.chaos233.tinkerslegacy.traits;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.event.world.BlockEvent;

public class TraitMagnetic implements IToolTrait {

    @Override
    public String getTraitID() {
        return "magnetic";
    }

    @Override
    public void onBlockBreak(ItemStack tool, BlockEvent.BreakEvent event) {
        event.getPlayer()
            .addChatMessage(new ChatComponentText("Magnetic Triggered"));
    }
}
