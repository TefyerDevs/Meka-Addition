package org.tefyer.ma.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import org.tefyer.ma.block.entity.custom.AntiubecisMiningGlassBlockEntity;

public class AntiubecisMiningGlass extends BaseEntityBlock {
    protected AntiubecisMiningGlass(Properties p_Properties) {
        super(p_Properties);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos p_BlockPos, BlockState p_State) {
        return new AntiubecisMiningGlassBlockEntity(p_BlockPos,p_State);
    }
}
