package org.tefyer.ma.block.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.tefyer.ma.block.entity.BlockEntityRegistry;
import org.tefyer.ma.block.BlockRegistry;

public class AntiubecisMiningControlerBlockEntity extends BlockEntity {

    private final LazyOptional<Boolean> booleanLazyOptional = LazyOptional.empty();

    public AntiubecisMiningControlerBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityRegistry.ANTIUBECIS_MINING_CONTROLLER_BLOCK_ENTITY.get(), pos, state);
    }



    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        return super.getCapability(cap, side);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        booleanLazyOptional.invalidate();
    }

    @Override
    public void load(@NotNull CompoundTag tag) {
        super.load(tag);
    }

    public void tick(Level pLevel, BlockPos pPos, BlockState pState) {
        AntiubecisMultiblock multiblock = new AntiubecisMultiblock(pLevel,pPos);
        if(multiblock.checkMultiBlock()){
            pLevel.setBlock(pPos,BlockRegistry.ANTIUBECIS_MINING_CONTROLLER.get().defaultBlockState().setValue(AntiubecisMiningControler.ACTIVE,true),1);
        }
    }


}
