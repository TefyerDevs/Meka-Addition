package org.tefyer.ma.generators.gens;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;
import org.tefyer.ma.MekaAddition;
import org.tefyer.ma.item.ItemRegistry;
import org.tefyer.ma.utils.TagRegistry;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class ItemTagGenerator extends ItemTagsProvider {


    public ItemTagGenerator(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> holderLookup, CompletableFuture<TagLookup<Block>> blockLookup, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, holderLookup, blockLookup, MekaAddition.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        for(Map.Entry<String, RegistryObject<Item>> entry : ItemRegistry.HAMMER_AUTOGEN.entrySet()){
            this.tag(TagRegistry.Items.HAMMERS).add(entry.getValue().get());
        }

    }
}
