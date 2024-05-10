package org.tefyer.ma.item.group;


import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import org.tefyer.ma.MekaAddition;
import org.tefyer.ma.item.ItemRegistry;

public class CreativeModTabRegistry {
    public static final DeferredRegister<CreativeModeTab> CREATIVEMODETAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MekaAddition.MODID);
    public static final RegistryObject<CreativeModeTab> plate_tab =
            CREATIVEMODETAB.register(MekaAddition.MODID+"plates",
                    ()-> CreativeModeTab.builder()
                            .title(Component.translatable(MekaAddition.MODID+".plates_tab_name"))
                            .icon(()-> new ItemStack(ItemRegistry.IRON_PLATE.get()))
                            .displayItems((parameters, output) -> {
                                output.accept(ItemRegistry.DIAMOND_PLATE.get());
                                output.accept(ItemRegistry.REDSTONE_PLATE.get());
                                output.accept(ItemRegistry.LAPIS_PLATE.get());
                                output.accept(ItemRegistry.IRON_PLATE.get());
                            })
                            .build());
    public static final RegistryObject<CreativeModeTab> tool_tab =
            CREATIVEMODETAB.register(MekaAddition.MODID+"tools",
                    ()-> CreativeModeTab.builder()
                            .title(Component.translatable(MekaAddition.MODID+".tools_tab_name"))
                            .icon(()-> new ItemStack(ItemRegistry.HAMMER.get()))
                            .displayItems((parameters, output) -> {
                                output.accept(ItemRegistry.HAMMER.get());
                            })
                            .build());

    public static void register(IEventBus bus){
        CREATIVEMODETAB.register(bus);
    }
}
