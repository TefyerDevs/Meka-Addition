package org.tefyer.ma.block.multiblock.cache;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class MultiBlockCache implements IMultiBlockCache {

    @Override
    public void addBlock(BlockPos pos, BlockEntityType<?> blockRegistryObject) {
        MBlocks mBlocks = new MBlocks(pos,blockRegistryObject);
        BLOCKS.add(mBlocks);
    }
}
