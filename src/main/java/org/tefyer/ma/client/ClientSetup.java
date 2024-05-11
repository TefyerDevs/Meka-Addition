package org.tefyer.ma.client;

import net.minecraft.world.item.Item;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegistryObject;
import org.tefyer.ma.item.ItemRegistry;
import org.tefyer.ma.item.itemcolours.ItemColours;

import java.util.Map;
import java.util.Objects;

public class ClientSetup {
    public static void init() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(ClientSetup::clientSetup);
        modEventBus.addListener(ClientSetup::registerItemColors);
    }
    private static void clientSetup(final FMLClientSetupEvent event) {

    }

    public static void registerItemColors(RegisterColorHandlersEvent.Item event){

        for (ItemRegistry.Tuple<String, String,String, RegistryObject<Item>> entry: ItemRegistry.ITEM_ITEMGEN_AUTOGEN){
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
        for (ItemRegistry.Tuple<String, String,String, RegistryObject<Item>> entry: ItemRegistry.HAMMER_ITEMGEN_AUTOGEN){
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
    }

}
