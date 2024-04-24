package org.tefyer.ma.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.tefyer.ma.MekaAddition;
import org.tefyer.ma.block.BlockRegistry;
import org.tefyer.ma.block.entity.custom.AntiubecisMiningCasingBlockEntity;
import org.tefyer.ma.block.entity.custom.AntiubecisMiningControlerBlockEntity;
import org.tefyer.ma.block.entity.custom.AntiubecisMiningGlassBlockEntity;

public class BlockEntityRegistry {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, MekaAddition.MODID);


    public static final RegistryObject<BlockEntityType<AntiubecisMiningControlerBlockEntity>> ANTIUBECIS_MINING_CONTROLLER_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("antiubecis_mining_controller_block_entity",()->
                    BlockEntityType.Builder.of(AntiubecisMiningControlerBlockEntity::new,
                            BlockRegistry.ANTIUBECIS_MINING_CONTROLLER.get()).build(null));
    public static final RegistryObject<BlockEntityType<AntiubecisMiningCasingBlockEntity>> ANTIUBECIS_MINING_CASING_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("antiubecis_mining_casing_block_entity",()->
                    BlockEntityType.Builder.of(AntiubecisMiningCasingBlockEntity::new,
                            BlockRegistry.ANTIUBECIS_MINING_CASING.get()).build(null));
    public static final RegistryObject<BlockEntityType<AntiubecisMiningGlassBlockEntity>> ANTIUBECIS_MINING_GLASS_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("antiubecis_mining_glass_block_entity",()->
                    BlockEntityType.Builder.of(AntiubecisMiningGlassBlockEntity::new,
                            BlockRegistry.ANTIUBECIS_MINING_GLASS.get()).build(null));

    public static void register(IEventBus bus){
        BLOCK_ENTITIES.register(bus);
    }
}
