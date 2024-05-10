package org.tefyer.ma.client;

import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.tefyer.ma.item.ItemRegistry;
import org.tefyer.ma.item.itemcolours.ItemColours;

public class ClientSetup {
    public static void init() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(ClientSetup::clientSetup);
        modEventBus.addListener(ClientSetup::registerItemColors);
    }
    private static void clientSetup(final FMLClientSetupEvent event) {

    }

    public static void registerItemColors(RegisterColorHandlersEvent.Item event){
        event.register(ItemColours.REDSTONE, ItemRegistry.REDSTONE_PLATE.get());
        event.register(ItemColours.DIAMOND, ItemRegistry.DIAMOND_PLATE.get());
        event.register(ItemColours.LAPIS, ItemRegistry.LAPIS_PLATE.get());
        event.register(ItemColours.IRON, ItemRegistry.IRON_PLATE.get());

        event.register(ItemColours.REBONIC, ItemRegistry.REBONIC_INGOT.get());
        event.register(ItemColours.REBONIC, ItemRegistry.REBONIC_RAW_INGOT.get());
    }

}
