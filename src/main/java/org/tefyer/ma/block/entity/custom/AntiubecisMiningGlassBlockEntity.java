package org.tefyer.ma.block.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.tefyer.ma.block.entity.BlockEntityRegistry;

public class AntiubecisMiningGlassBlockEntity extends BlockEntity {
    public AntiubecisMiningGlassBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityRegistry.ANTIUBECIS_MINING_GLASS_BLOCK_ENTITY.get(), pos, state);
    }
}
