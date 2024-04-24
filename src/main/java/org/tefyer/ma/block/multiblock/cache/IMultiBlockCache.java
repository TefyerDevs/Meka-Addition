package org.tefyer.ma.block.multiblock.cache;

import com.ibm.icu.impl.Pair;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.RegistryObject;

import java.util.*;

public interface IMultiBlockCache {
     List<MBlocks> BLOCKS = new ArrayList<>();
     public void addBlock(BlockPos pos, BlockEntityType<?> blockRegistryObject);
}
