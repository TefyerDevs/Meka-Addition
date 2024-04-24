package org.tefyer.ma.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.tefyer.ma.MekaAddition;
import org.tefyer.ma.item.custom.HammerItem;

public class ItemRegistry {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MekaAddition.MODID);

    public static final RegistryObject<Item> HAMMER = ITEMS.register("hammer",()-> new HammerItem(new Item.Properties()));
    public static void register(IEventBus bus){
        ITEMS.register(bus);
    }
}
