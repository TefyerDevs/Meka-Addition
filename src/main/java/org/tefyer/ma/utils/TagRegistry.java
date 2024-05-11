package org.tefyer.ma.utils;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import org.tefyer.ma.MekaAddition;

public class TagRegistry {
    public static class Blocks {
        private  static TagKey<Block> tag(String name){
            return BlockTags.create(new ResourceLocation(MekaAddition.MODID,name));
        }
    }
    public static class Items {
        public static final TagKey<Item> HAMMERS = tag(MekaAddition.MODID+"hammer");
        public static final TagKey<Item> PLATES = tag(MekaAddition.MODID+"plate");

        private  static TagKey<Item> tag(String name){
            return ItemTags.create(new ResourceLocation(MekaAddition.MODID,name));
        }
    }
}
