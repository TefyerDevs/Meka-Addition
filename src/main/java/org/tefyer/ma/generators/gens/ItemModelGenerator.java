package org.tefyer.ma.generators.gens;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Tuple;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import org.tefyer.ma.MekaAddition;
import org.tefyer.ma.item.ItemRegistry;

import java.util.Map;

public class ItemModelGenerator extends ItemModelProvider {
    public ItemModelGenerator(PackOutput output,  ExistingFileHelper existingFileHelper) {
        super(output, MekaAddition.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        for(ItemRegistry.Tuple<String, String,String, RegistryObject<Item>> entry : ItemRegistry.ITEM_ITEMGEN_AUTOGEN){
            huedItem(entry.getFourth(),entry.getSecond());
        }
        for(ItemRegistry.Tuple<String, String,String, RegistryObject<Item>> entry: ItemRegistry.HAMMER_ITEMGEN_AUTOGEN){
            huedhandheldItem(entry.getFourth(),entry.getSecond(),"minecraft:item/stick");
        }
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
                new ResourceLocation("item/generated")).texture("layer1",
                new ResourceLocation(MekaAddition.MODID,"item/" + data));
    }
    private ItemModelBuilder huedhandheldItem(RegistryObject<Item> item,String data,String data2) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer1",
                new ResourceLocation(MekaAddition.MODID,"item/" + data)).texture("layer0",
                new ResourceLocation(data2));
    }

}
//MekaAddition.MODID