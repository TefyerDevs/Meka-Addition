package org.tefyer.ma.generators;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.tefyer.ma.MekaAddition;
import org.tefyer.ma.generators.gens.*;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = MekaAddition.MODID,bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void generateData(GatherDataEvent event){
        DataGenerator generators = event.getGenerator();
        PackOutput packOutput = generators.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();


        generators.addProvider(event.includeServer(), new RecipeGenerator(packOutput));
        generators.addProvider(event.includeServer(), LootTableGenerator.create(packOutput));

        generators.addProvider(event.includeClient(), new BlockStateGenerator(packOutput,existingFileHelper));
        generators.addProvider(event.includeClient(), new ItemModelGenerator(packOutput,existingFileHelper));

        BlockTagGenerator blockTagGenerator = generators.addProvider(event.includeServer(),
                new BlockTagGenerator(packOutput, lookupProvider, existingFileHelper));
        generators.addProvider(event.includeClient(),
                new ItemTagGenerator(packOutput,lookupProvider,blockTagGenerator.contentsGetter(),existingFileHelper));

    }
}
