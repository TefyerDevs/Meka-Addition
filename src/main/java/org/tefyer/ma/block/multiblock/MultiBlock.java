package org.tefyer.ma.block.multiblock;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.RegistryObject;
import org.tefyer.ma.block.entity.BlockEntityRegistry;
import org.tefyer.ma.block.multiblock.cache.MultiBlockCache;

public class MultiBlock extends MultiBlockCache {
    public Level m_level;
    public BlockPos m_pos;

    public MultiBlock(Level p_level, BlockPos p_pos) {
        this.m_level = p_level;
        this.m_pos = p_pos;
    }
    public <T extends BlockEntity> boolean checkMultiBlockFromInteger(RegistryObject<BlockEntityType<T>> blockEntityTypeRegistryObject, int i,Rotation rot){
        return m_level.getBlockEntity(BLOCKS.get(i).getPos()+p_pos.rotate(rot), BLOCKS.get(i).getBlock()).equals((blockEntityTypeRegistryObject.get()));
    }
}
