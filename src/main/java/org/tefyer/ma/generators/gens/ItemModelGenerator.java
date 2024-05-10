package org.tefyer.ma.generators.gens;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import org.tefyer.ma.MekaAddition;
import org.tefyer.ma.item.ItemRegistry;

public class ItemModelGenerator extends ItemModelProvider {
    public ItemModelGenerator(PackOutput output,  ExistingFileHelper existingFileHelper) {
        super(output, MekaAddition.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        handheldItem(ItemRegistry.HAMMER);
        huedItem(ItemRegistry.DIAMOND_PLATE,"plate");
        huedItem(ItemRegistry.REDSTONE_PLATE,"plate");
        huedItem(ItemRegistry.LAPIS_PLATE,"plate");
        huedItem(ItemRegistry.IRON_PLATE,"plate");

        huedItem(ItemRegistry.REBONIC_INGOT,"ingot");
        huedItem(ItemRegistry.REBONIC_RAW_INGOT,"raw_ingot");
    }
    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(MekaAddition.MODID,"item/" + item.getId().getPath()));
    }
    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(MekaAddition.MODID,"item/" + item.getId().getPath()));
    }
    private ItemModelBuilder huedItem(RegistryObject<Item> item,String data) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(MekaAddition.MODID,"item/" + data));
    }
}
//MekaAddition.MODID