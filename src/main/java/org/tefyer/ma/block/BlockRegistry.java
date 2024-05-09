package org.tefyer.ma.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GlassBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.tefyer.ma.MekaAddition;
import org.tefyer.ma.block.custom.AntiubecisMiningControler;
import org.tefyer.ma.item.ItemRegistry;

import java.util.function.Supplier;

public class BlockRegistry {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MekaAddition.MODID);


    public static final RegistryObject<Block> ANTIUBECIS_MINING_CASING = registerBlock("antiubecis_mining_casing",
            ()->new Block(BlockBehaviour.Properties.copy(Blocks.SMOOTH_STONE)));
    public static final RegistryObject<Block> ANTIUBECIS_MINING_CONTROLLER = registerBlock("antiubecis_mining_controller",
            ()->new AntiubecisMiningControler());

    public static final RegistryObject<Block> ANTIUBECIS_MINING_GLASS = registerBlock("antiubecis_mining_glass",
            ()->new GlassBlock(BlockBehaviour.Properties.copy(Blocks.SMOOTH_STONE).noOcclusion()));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ItemRegistry.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus bus){
        BLOCKS.register(bus);
    }
}
