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
import org.tefyer.ma.MekaAddition;
import org.tefyer.ma.block.BlockRegistry;
import org.tefyer.ma.block.custom.AntiubecisMiningControler;
import org.tefyer.ma.block.entity.BlockEntityRegistry;
import org.tefyer.ma.block.multiblock.custom.AntiubecisMultiblock;

public class AntiubecisMiningControlerBlockEntity extends BlockEntity {

    public boolean m_isActive;

    public AntiubecisMiningControlerBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityRegistry.ANTIUBECIS_MINING_CONTROLLER_BLOCK_ENTITY.get(), pos, state);
    }



    @Override
    protected void saveAdditional(CompoundTag nbt) {
        super.saveAdditional(nbt);
        CompoundTag meka_addition_mod_data = nbt.getCompound(MekaAddition.MODID);
        meka_addition_mod_data.putBoolean("active",this.m_isActive);
    }


    @Override
    public void load(@NotNull CompoundTag nbt) {
        super.load(nbt);
        CompoundTag meka_addition_mod_data = nbt.getCompound(MekaAddition.MODID);
        this.m_isActive = meka_addition_mod_data.getBoolean("active");
        nbt.getCompound("");
    }

    public void tick(Level pLevel, BlockPos pPos, BlockState pState) {
        if(!pLevel.isClientSide()){
            AntiubecisMultiblock multiblock = new AntiubecisMultiblock(pPos);
            if (!multiblock.checkMultiBlock(pState.getValue(AntiubecisMiningControler.FACING),pLevel)) {
                if(pState.getValue(AntiubecisMiningControler.ACTIVE)){
                    pLevel.setBlock(pPos,pState.setValue(AntiubecisMiningControler.ACTIVE,false),0);
                }
            }
        }
    }



}
