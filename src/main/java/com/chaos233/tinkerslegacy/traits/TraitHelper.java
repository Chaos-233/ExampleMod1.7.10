package com.chaos233.tinkerslegacy.traits;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class TraitHelper {

    public static boolean hasTrait(ItemStack stack, String trait) {
        if (stack == null) return false;

        if (!stack.hasTagCompound()) return false;

        NBTTagCompound tag = stack.getTagCompound();

        return tag.getBoolean(trait);
    }

    public static void addTrait(ItemStack stack, String trait) {
        if (!stack.hasTagCompound()) {
            stack.setTagCompound(new NBTTagCompound());
        }

        stack.getTagCompound()
            .setBoolean(trait, true);
    }
}
