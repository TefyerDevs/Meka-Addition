package org.tefyer.ma.block.multiblock.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntityType;
import org.tefyer.ma.block.BlockRegistry;
import org.tefyer.ma.block.entity.BlockEntityRegistry;
import org.tefyer.ma.block.multiblock.MultiBlock;

public class AntiubecisMultiblock extends MultiBlock {
    public AntiubecisMultiblock(Level p_level, BlockPos p_pos) {
        super(p_level, p_pos);
    }
    public boolean checkMultiBlock(){

        for(int i =0; i< BLOCKS.size();i++){
            if(!checkMultiBlockFromInteger(BlockEntityRegistry.ANTIUBECIS_MINING_CASING_BLOCK_ENTITY,i)){
                return false;
            }
        }
        return true;
    }
}

