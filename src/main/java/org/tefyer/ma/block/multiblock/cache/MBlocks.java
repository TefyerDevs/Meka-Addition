package org.tefyer.ma.block.multiblock.cache;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.RegistryObject;

public class MBlocks {
    BlockPos pos;
    BlockEntityType<?> block;

    public MBlocks(BlockPos pos, BlockEntityType<?> block) {
        this.pos = pos;
        this.block = block;
    }

    public BlockPos getPos() {
        return pos;
    }

    public BlockEntityType<?> getBlock() {
        return block;
    }
}
