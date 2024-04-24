package org.tefyer.ma.block.multiblock.cache;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.RegistryObject;
import com.ibm.icu.impl.Pair;

public class MultiBlockCache implements IMultiBlockCache {

    @Override
    public <T extends BlockEntity> void addBlock(BlockPos pos, BlockEntityType<T> blockRegistryObject) {
        MBlocks mBlocks = new MBlocks(pos,blockRegistryObject);
        BLOCKS.add(mBlocks);
    }
}
