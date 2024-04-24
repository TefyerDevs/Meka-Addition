package org.tefyer.ma.block.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.tefyer.ma.block.entity.BlockEntityRegistry;

public class AntiubecisMiningCasingBlockEntity extends BlockEntity {

    public AntiubecisMiningCasingBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityRegistry.ANTIUBECIS_MINING_CASING_BLOCK_ENTITY.get(), pos, state);
    }
}
