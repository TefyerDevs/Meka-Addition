package org.tefyer.ma.block.multiblock.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntityType;
import org.tefyer.ma.block.BlockRegistry;
import org.tefyer.ma.block.custom.AntiubecisMiningControler;
import org.tefyer.ma.block.entity.BlockEntityRegistry;
import org.tefyer.ma.block.multiblock.MultiBlock;

public class AntiubecisMultiblock extends MultiBlock {
    public AntiubecisMultiblock(BlockPos p_pos) {
        super(p_pos);
        addBlocks();
    }
    public boolean checkMultiBlock(Direction dir,Level p_level){
        for(int i =0; i< BLOCKS.size();i++){
            if (checkMultiBlockFromInteger(BlockRegistry.ANTIUBECIS_MINING_CONTROLLER,i,dir,p_level))
                continue;
            else if(checkMultiBlockFromInteger(BlockRegistry.ANTIUBECIS_MINING_CASING,i,dir,p_level))
                continue;
            else if(checkMultiBlockFromInteger(BlockRegistry.ANTIUBECIS_MINING_GLASS,i,dir,p_level))
                continue;
            else
                return false;
        }
        return true;
    }
    public void addBlocks(){
        addBlock(new BlockPos(0,0,0),BlockEntityRegistry.ANTIUBECIS_MINING_CONTROLLER_BLOCK_ENTITY.get());
        addBlock(new BlockPos(0,-1,0),BlockEntityRegistry.ANTIUBECIS_MINING_CASING_BLOCK_ENTITY.get());
        addBlock(new BlockPos(-1,-1,0),BlockEntityRegistry.ANTIUBECIS_MINING_CASING_BLOCK_ENTITY.get());
        addBlock(new BlockPos(1,-1,0),BlockEntityRegistry.ANTIUBECIS_MINING_CASING_BLOCK_ENTITY.get());
        addBlock(new BlockPos(0,-1,-1),BlockEntityRegistry.ANTIUBECIS_MINING_CASING_BLOCK_ENTITY.get());
        addBlock(new BlockPos(0,-1,1),BlockEntityRegistry.ANTIUBECIS_MINING_CASING_BLOCK_ENTITY.get());
    }
}

