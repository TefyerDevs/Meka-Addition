package org.tefyer.ma.item.group;


import mekanism.common.registries.MekanismItems;
import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import org.tefyer.ma.MekaAddition;
import org.tefyer.ma.item.ItemRegistry;
import org.tefyer.ma.utils.TagRegistry;

import java.util.Map;

public class CreativeModTabRegistry {
    public static final DeferredRegister<CreativeModeTab> CREATIVEMODETAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MekaAddition.MODID);
    public static final RegistryObject<CreativeModeTab> plate_tab =
            CREATIVEMODETAB.register(MekaAddition.MODID+"plates",
                    ()-> CreativeModeTab.builder()
                            .title(Component.translatable(MekaAddition.MODID+".plates_tab_name"))
                            .icon(Items.IRON_INGOT::getDefaultInstance)
                            .displayItems((parameters, output) -> {
                                for(ItemRegistry.Tuple<String,String, String, RegistryObject<Item>, RegistryObject<Item>> entry : ItemRegistry.ITEM_ITEMGEN_AUTOGEN){
                                    output.accept(entry.getFourth().get());
                                }
                            })
                            .build());
    public static final RegistryObject<CreativeModeTab> tool_tab =
            CREATIVEMODETAB.register(MekaAddition.MODID+"tools",
                    ()-> CreativeModeTab.builder()
                            .title(Component.translatable(MekaAddition.MODID+".tools_tab_name"))
                            .icon(()-> new ItemStack(MekanismItems.CONFIGURATOR))
                            .displayItems((parameters, output) -> {
                                for(ItemRegistry.Tuple<String,String, String, RegistryObject<Item>, RegistryObject<Item>> entry : ItemRegistry.HAMMER_ITEMGEN_AUTOGEN){
                                    output.accept(entry.Fourth.get());
                                }
                            })
                            .build());

    public static void register(IEventBus bus){
        CREATIVEMODETAB.register(bus);
    }
}
