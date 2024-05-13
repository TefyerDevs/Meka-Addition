package org.tefyer.ma.client;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegistryObject;
import org.tefyer.ma.block.BlockRegistry;
import org.tefyer.ma.block.colour.BlockColour;
import org.tefyer.ma.item.ItemRegistry;
import org.tefyer.ma.item.itemcolours.ItemColours;

import java.util.Map;
import java.util.Objects;

public class ClientSetup {
    public static void init() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(ClientSetup::clientSetup);
        modEventBus.addListener(ClientSetup::registerItemColors);
        modEventBus.addListener(ClientSetup::registerBlockColors);
    }
    private static void clientSetup(final FMLClientSetupEvent event) {

    }

    public static void registerBlockColors(RegisterColorHandlersEvent.Block event){
        for(BlockRegistry.Tuple<String,String,RegistryObject<Block>> entry: BlockRegistry.ORE_AUTOGEN){
            System.out.println(entry.First);
            if(Objects.equals(entry.First, "iron")){
                event.register(BlockColour.IRON, entry.getThird().get());
            }else if(Objects.equals(entry.First, "diamond")){
                event.register(BlockColour.DIAMOND, entry.getThird().get());
            }else if(Objects.equals(entry.First, "redstone")){
                event.register(BlockColour.REDSTONE, entry.getThird().get());
            }else if(Objects.equals(entry.First, "lapis")){
                event.register(BlockColour.LAPIS, entry.getThird().get());
            }else if(Objects.equals(entry.First, "rebonic")){
                event.register(BlockColour.REBONIC, entry.getThird().get());
            }
        }
        for(BlockRegistry.Tuple<String,String,RegistryObject<Block>> entry: BlockRegistry.DEEPSLATE_ORE_AUTOGEN){
            if(Objects.equals(entry.getFirst(), "iron")){
                System.out.println("iron");
                event.register(BlockColour.IRON, entry.getThird().get());
            }else if(Objects.equals(entry.getFirst(), "diamond")){
                System.out.println("diamond");
                event.register(BlockColour.DIAMOND, entry.getThird().get());
            }else if(Objects.equals(entry.getFirst(), "redstone")){
                System.out.println("redstone");
                event.register(BlockColour.REDSTONE, entry.getThird().get());
            }else if(Objects.equals(entry.getFirst(), "lapis")){
                System.out.println("lapis");
                event.register(BlockColour.LAPIS, entry.getThird().get());
            }else if(Objects.equals(entry.getFirst(), "rebonic")){
                System.out.println("rebonic");
                event.register(BlockColour.REBONIC, entry.getThird().get());
            }
        }

    }
    public static void registerItemColors(RegisterColorHandlersEvent.Item event){

        for (ItemRegistry.Tuple<String, String,String, RegistryObject<Item>,RegistryObject<Item>> entry: ItemRegistry.ITEM_ITEMGEN_AUTOGEN){
            if(Objects.equals(entry.getThird(), "iron")){
                event.register(ItemColours.IRON, entry.getFourth().get());
            }else if(Objects.equals(entry.getThird(), "diamond")){
                event.register(ItemColours.DIAMOND, entry.getFourth().get());
            }else if(Objects.equals(entry.getThird(), "redstone")){
                event.register(ItemColours.REDSTONE, entry.getFourth().get());
            }else if(Objects.equals(entry.getThird(), "lapis")){
                event.register(ItemColours.LAPIS, entry.getFourth().get());
            }else if(Objects.equals(entry.getThird(), "rebonic")){
                event.register(ItemColours.REBONIC, entry.getFourth().get());
            }
        }
        for (ItemRegistry.Tuple<String, String,String, RegistryObject<Item>,RegistryObject<Item>> entry: ItemRegistry.HAMMER_ITEMGEN_AUTOGEN){
            if(Objects.equals(entry.getThird(), "iron")){
                event.register(ItemColours.IRON, entry.getFourth().get());
            }else if(Objects.equals(entry.getThird(), "diamond")){
                event.register(ItemColours.DIAMOND, entry.getFourth().get());
            }else if(Objects.equals(entry.getThird(), "redstone")){
                event.register(ItemColours.REDSTONE, entry.getFourth().get());
            }else if(Objects.equals(entry.getThird(), "lapis")){
                event.register(ItemColours.LAPIS, entry.getFourth().get());
            }else if(Objects.equals(entry.getThird(), "rebonic")){
                event.register(ItemColours.REBONIC, entry.getFourth().get());
            }
        }
        /*for(BlockRegistry.Tuple<String,String,RegistryObject<Block>> entry: BlockRegistry.ORE_AUTOGEN){
            System.out.println(entry.First);
            if(Objects.equals(entry.First, "iron")){
                event.register(ItemColours.IRON, entry.getThird().get());
            }else if(Objects.equals(entry.First, "diamond")){
                event.register(ItemColours.DIAMOND, entry.getThird().get());
            }else if(Objects.equals(entry.First, "redstone")){
                event.register(ItemColours.REDSTONE, entry.getThird().get());
            }else if(Objects.equals(entry.First, "lapis")){
                event.register(ItemColours.LAPIS, entry.getThird().get());
            }else if(Objects.equals(entry.First, "rebonic")){
                event.register(ItemColours.REBONIC, entry.getThird().get());
            }
        }
        for(BlockRegistry.Tuple<String,String,RegistryObject<Block>> entry: BlockRegistry.DEEPSLATE_ORE_AUTOGEN){
            if(Objects.equals(entry.getFirst(), "iron")){
                System.out.println("iron");
                event.register(ItemColours.IRON, entry.getThird().get());
            }else if(Objects.equals(entry.getFirst(), "diamond")){
                System.out.println("diamond");
                event.register(ItemColours.DIAMOND, entry.getThird().get());
            }else if(Objects.equals(entry.getFirst(), "redstone")){
                System.out.println("redstone");
                event.register(ItemColours.REDSTONE, entry.getThird().get());
            }else if(Objects.equals(entry.getFirst(), "lapis")){
                System.out.println("lapis");
                event.register(ItemColours.LAPIS, entry.getThird().get());
            }else if(Objects.equals(entry.getFirst(), "rebonic")){
                System.out.println("rebonic");
                event.register(ItemColours.REBONIC, entry.getThird().get());
            }
        }*/
    }

}
