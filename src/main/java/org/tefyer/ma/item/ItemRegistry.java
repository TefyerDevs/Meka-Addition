package org.tefyer.ma.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.tefyer.ma.MekaAddition;
import org.tefyer.ma.item.custom.HammerItem;
import org.tefyer.ma.item.custom.PlateItem;

public class ItemRegistry {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MekaAddition.MODID);

    public static final RegistryObject<Item> HAMMER = ITEMS.register("hammer",()-> new HammerItem(new Item.Properties()));
    public static final RegistryObject<Item> REDSTONE_PLATE = ITEMS.register("redstone_plate",()-> new PlateItem(new Item.Properties()));
    public static final RegistryObject<Item> DIAMOND_PLATE = ITEMS.register("diamond_plate",()-> new PlateItem(new Item.Properties()));
    public static final RegistryObject<Item> LAPIS_PLATE = ITEMS.register("lapis_plate",()-> new PlateItem(new Item.Properties()));
    public static final RegistryObject<Item> IRON_PLATE = ITEMS.register("iron_plate",()-> new PlateItem(new Item.Properties()));
    public static final RegistryObject<Item> REBONIC_RAW_INGOT = ITEMS.register("rebonic_raw_ingot",()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> REBONIC_INGOT = ITEMS.register("rebonic_ingot",()-> new Item(new Item.Properties()));

    public static void register(IEventBus bus){
        ITEMS.register(bus);
    }
}
