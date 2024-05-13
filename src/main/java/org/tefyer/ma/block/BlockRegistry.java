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
import org.tefyer.ma.item.itemores.ModdedOres;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class BlockRegistry {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MekaAddition.MODID);

    public static final RegistryObject<Block> ANTIUBECIS_MINING_CASING = registerBlock("antiubecis_mining_casing",
            ()->new Block(BlockBehaviour.Properties.copy(Blocks.SMOOTH_STONE)));
    public static final RegistryObject<Block> ANTIUBECIS_MINING_CONTROLLER = registerBlock("antiubecis_mining_controller",
            AntiubecisMiningControler::new);

    public static final RegistryObject<Block> ANTIUBECIS_MINING_GLASS = registerBlock("antiubecis_mining_glass",
            ()->new GlassBlock(BlockBehaviour.Properties.copy(Blocks.SMOOTH_STONE).noOcclusion()));
    public static final RegistryObject<Block> SUPERMINING_ELEMENT = registerBlock("supermining_element",
            ()->new Block(BlockBehaviour.Properties.copy(Blocks.SMOOTH_STONE).noOcclusion()));

    public static final RegistryObject<Block> SUPERMINER = registerBlock("superminer",
            ()->new Block(BlockBehaviour.Properties.copy(Blocks.SMOOTH_STONE).noOcclusion()));


    public static final List<BlockRegistry.Tuple<String,String,RegistryObject<Block>>> ORE_AUTOGEN = new ArrayList<>();
    public static final List<BlockRegistry.Tuple<String,String,RegistryObject<Block>>> DEEPSLATE_ORE_AUTOGEN  = new ArrayList<>();

    public static void makePlates(){
        for(ModdedOres ore : ModdedOres.values()){
            String identifer_ore = ore.getM_identifer()+"_ore";
            String identifer_deepslate_ore = ore.getM_identifer()+"_deepslate_ore";

            final RegistryObject<Block> ore_block =registerBlock(identifer_ore,()->new Block(BlockBehaviour.Properties.copy(Blocks.IRON_ORE)));
            final RegistryObject<Block> deepslate_ore_block =registerBlock(identifer_deepslate_ore,()->new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_IRON_ORE)));

            ORE_AUTOGEN.add(new BlockRegistry.Tuple<>(ore.getM_identifer(),identifer_ore,ore_block));
            DEEPSLATE_ORE_AUTOGEN.add(new BlockRegistry.Tuple<>(ore.getM_identifer(),identifer_deepslate_ore,deepslate_ore_block));
        }
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ItemRegistry.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus bus){
        makePlates();
        BLOCKS.register(bus);
    }

    public static class Tuple<E, F, G> {
        public E First;
        public F Second;
        public G Third;


        public Tuple(E first, F second, G third) {
            First = first;
            Second = second;
            Third = third;
        }

        public E getFirst() {
            return First;
        }

        public void setFirst(E first) {
            First = first;
        }

        public F getSecond() {
            return Second;
        }

        public void setSecond(F second) {
            Second = second;
        }

        public G getThird() {
            return Third;
        }

        public void setThird(G third) {
            Third = third;
        }
        public void put(E e, F f, G g){
            First = e;
            Second = f;
            Third = g;
        }


    }

}
