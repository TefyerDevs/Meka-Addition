package org.tefyer.ma.block.colour;

import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import org.tefyer.ma.item.itemcolours.ItemColours;

public class BlockColour {

    public static final BlockColor REDSTONE = new BlockColour.REDSTONE_CLASS();
    public static final BlockColor DIAMOND = new BlockColour.DIAMOND_CLASS();
    public static final BlockColor LAPIS = new BlockColour.LAPIS_CLASS();
    public static final BlockColor IRON = new BlockColour.IRON_CLASS();
    public static final BlockColor REBONIC = new BlockColour.REBONIC_CLASS();

    public static class REDSTONE_CLASS implements BlockColor {
        @Override
        public int getColor(BlockState p_92567_, @Nullable BlockAndTintGetter p_92568_, @Nullable BlockPos p_92569_, int p_92570_) {
            return 0xff1c1c;
        }
    }
    public static class DIAMOND_CLASS implements BlockColor {

        @Override
        public int getColor(BlockState p_92567_, @Nullable BlockAndTintGetter p_92568_, @Nullable BlockPos p_92569_, int p_92570_) {
            return 0x80fffd;
        }
    }
    public static class LAPIS_CLASS implements BlockColor {
        @Override
        public int getColor(BlockState p_92567_, @Nullable BlockAndTintGetter p_92568_, @Nullable BlockPos p_92569_, int p_92570_) {
            return 0x3876d1;
        }
    }
    public static class IRON_CLASS implements BlockColor {
        @Override
        public int getColor(BlockState p_92567_, @Nullable BlockAndTintGetter p_92568_, @Nullable BlockPos p_92569_, int p_92570_) {
            return 0xd9d9d9;
        }
    }
    public static class REBONIC_CLASS implements BlockColor {
        @Override
        public int getColor(BlockState p_92567_, @Nullable BlockAndTintGetter p_92568_, @Nullable BlockPos p_92569_, int p_92570_) {
            return 0x424182;
        }
    }

}
