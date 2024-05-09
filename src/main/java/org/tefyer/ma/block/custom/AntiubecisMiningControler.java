package org.tefyer.ma.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.storage.loot.providers.nbt.NbtProvider;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.tefyer.ma.block.entity.BlockEntityRegistry;
import org.tefyer.ma.block.entity.custom.AntiubecisMiningControlerBlockEntity;
import org.tefyer.ma.block.multiblock.custom.AntiubecisMultiblock;
import org.tefyer.ma.item.ItemRegistry;

public class AntiubecisMiningControler extends BaseEntityBlock {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final BooleanProperty ACTIVE =  BooleanProperty.create("active");

    public AntiubecisMiningControler() {
        super(BlockBehaviour.Properties.copy(Blocks.SMOOTH_STONE));
        registerDefaultState(this.defaultBlockState().setValue(FACING, Direction.NORTH).setValue(ACTIVE,false));
    }

    @Override
    public RenderShape getRenderShape(BlockState blockState) {
        return RenderShape.MODEL;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pPos, @NotNull BlockState pState) {
        return new AntiubecisMiningControlerBlockEntity(pPos,pState);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, @NotNull BlockState pState, @NotNull BlockEntityType<T> pType) {
        if(pLevel.isClientSide()){
           return null;
        }
        return createTickerHelper(pType, BlockEntityRegistry.ANTIUBECIS_MINING_CONTROLLER_BLOCK_ENTITY.get(),
                (pLevel1,pPos,pState1,pBlockEntity)->pBlockEntity.tick(pLevel1,pPos,pState1));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(FACING,ACTIVE);
    }

    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    public BlockState mirror(BlockState state, Mirror p_54123_) {
        return state.rotate(p_54123_.getRotation(state.getValue(FACING)));
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        return defaultBlockState().setValue(FACING,ctx.getHorizontalDirection().getOpposite());
    }

    @Override
    public @NotNull InteractionResult use(BlockState pState, @NotNull Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pInterActionHand, BlockHitResult pBlockHitResult) {
        /*new Thread()
        {
            @Override
            public void run()
            {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }


            }
        }.start();*/
        //pPlayer.sendSystemMessage(Component.literal("First Test Ran"));
        if(!pLevel.isClientSide()
                && pInterActionHand == InteractionHand.MAIN_HAND
                && pPlayer.getItemInHand(pInterActionHand).is(ItemRegistry.HAMMER.get())) {
            //pPlayer.sendSystemMessage(Component.literal("First Test True"));
            BlockEntity be = pLevel.getBlockEntity(pPos);
            //pPlayer.sendSystemMessage(Component.literal("Second Test Ran"));
            AntiubecisMultiblock multiblock = new AntiubecisMultiblock(pPos);
            if (multiblock.checkMultiBlock(pState.getValue(AntiubecisMiningControler.FACING),pLevel)) {
                //pPlayer.sendSystemMessage(Component.literal("Second Test True"));
                pLevel.setBlock(pPos,pState.setValue(ACTIVE,true),0);
            }
        }

        return super.use(pState, pLevel, pPos, pPlayer, pInterActionHand, pBlockHitResult);
    }
}
