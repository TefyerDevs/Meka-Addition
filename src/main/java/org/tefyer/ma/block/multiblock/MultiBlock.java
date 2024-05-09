package org.tefyer.ma.block.multiblock;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.RegistryObject;
import org.tefyer.ma.block.entity.BlockEntityRegistry;
import org.tefyer.ma.block.multiblock.cache.MultiBlockCache;

import java.util.Optional;

public class MultiBlock extends MultiBlockCache {
    public BlockPos m_pos;

    public MultiBlock(BlockPos p_pos) {
        this.m_pos = p_pos;
    }
    public <T extends BlockEntity> boolean checkMultiBlockFromInteger(RegistryObject<Block> blockRegistryObject, int i, Direction dir, Level p_level){
        BlockState blockState = p_level.getBlockState(BLOCKS.get(i).getPos().offset(m_pos.getX(),m_pos.getY(),m_pos.getZ()));
        return (blockState.getBlock().equals(blockRegistryObject.get()));
    }
}
