package org.tefyer.ma.item.itemcolours;

import net.minecraft.client.color.item.ItemColor;
import net.minecraft.world.item.ItemStack;

public class ItemColours {
    public static final ItemColor REDSTONE = new REDSTONE_CLASS();
    public static final ItemColor DIAMOND = new DIAMOND_CLASS();
    public static final ItemColor LAPIS = new LAPIS_CLASS();
    public static final ItemColor IRON = new IRON_CLASS();
    public static final ItemColor REBONIC = new REBONIC_CLASS();

    public static class REDSTONE_CLASS implements ItemColor {
        @Override
        public int getColor(ItemStack stack, int data) {
            return 0xff1c1c;
        }

    }
    public static class DIAMOND_CLASS implements ItemColor {
        @Override
        public int getColor(ItemStack stack, int data) {
            return 0x80fffd;
        }
    }
    public static class LAPIS_CLASS implements ItemColor {
        @Override
        public int getColor(ItemStack stack, int data) {
            return 0x3876d1;
        }
    }
    public static class IRON_CLASS implements ItemColor {
        @Override
        public int getColor(ItemStack stack, int data) {
            return 0xd9d9d9;
        }
    }
    public static class REBONIC_CLASS implements ItemColor {
        @Override
        public int getColor(ItemStack stack, int data) {
            return 0x424182;
        }
    }

}
