package org.tefyer.ma.generators.gens;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.registries.RegistryObject;
import org.tefyer.ma.MekaAddition;
import org.tefyer.ma.item.ItemRegistry;
import org.tefyer.ma.item.itemcolours.ItemColours;
import org.tefyer.ma.utils.TagRegistry;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;

public class RecipeGenerator extends RecipeProvider implements IConditionBuilder {
    public RecipeGenerator(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        for(ItemRegistry.Tuple<String, String,String, RegistryObject<Item>,RegistryObject<Item>> entry: ItemRegistry.ITEM_ITEMGEN_AUTOGEN){
            if(Objects.equals(entry.getThird(), "plate")){
                craftPlate(entry.getFourth().get(),Items.DIAMOND,pWriter);
            }

        }

        for(ItemRegistry.Tuple<String, String,String, RegistryObject<Item>,RegistryObject<Item>> entry: ItemRegistry.HAMMER_ITEMGEN_AUTOGEN){
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS,entry.getFourth().get())
                    .pattern(" I ")
                    .pattern(" SI")
                    .pattern("S  ")
                    .define('S',Items.STICK)
                    .define('I',entry.getFifth().get())
                    .unlockedBy(getHasName(entry.getFourth().get()),has(entry.getFourth().get()))
                    .save(pWriter);
        }
        for(ItemRegistry.Tuple<String, String,String, RegistryObject<Item>, RegistryObject<Item>> entry: ItemRegistry.SAW_ITEMGEN_AUTOGEN){
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS,entry.getFourth().get())
                    .pattern(" II")
                    .pattern("SI ")
                    .pattern("   ")
                    .define('S',Items.STICK)
                    .define('I',entry.getFifth().get())
                    .unlockedBy(getHasName(entry.getFourth().get()),has(entry.getFourth().get()))
                    .save(pWriter);
        }
        for(ItemRegistry.Tuple<String, String,String, RegistryObject<Item>, RegistryObject<Item>> entry: ItemRegistry.WIRE_CUTTER_ITEMGEN_AUTOGEN){
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS,entry.getFourth().get())
                    .pattern("I I")
                    .pattern("ISI")
                    .pattern("S S")
                    .define('S',Items.STICK)
                    .define('I',entry.getFifth().get())
                    .unlockedBy(getHasName(entry.getFourth().get()),has(entry.getFourth().get()))
                    .save(pWriter);
        }
        for(ItemRegistry.Tuple<String, String,String, RegistryObject<Item>, RegistryObject<Item>> entry: ItemRegistry.MOARTER_ITEMGEN_AUTOGEN){
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS,entry.getFourth().get())
                    .pattern(" I ")
                    .pattern("SIS")
                    .pattern("SSS")
                    .define('S',Items.STONE)
                    .define('I',entry.getFifth().get())
                    .unlockedBy(getHasName(entry.getFourth().get()),has(entry.getFourth().get()))
                    .save(pWriter);
        }
        for(ItemRegistry.Tuple<String, String,String, RegistryObject<Item>, RegistryObject<Item>> entry: ItemRegistry.WRENCH_ITEMGEN_AUTOGEN){
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS,entry.getFourth().get())
                    .pattern("ISI")
                    .pattern("III")
                    .pattern(" I ")
                    .define('S',Items.STICK)
                    .define('I',entry.getFifth().get())
                    .unlockedBy(getHasName(entry.getFourth().get()),has(entry.getFourth().get()))
                    .save(pWriter);
        }
        for(ItemRegistry.Tuple<String, String,String, RegistryObject<Item>, RegistryObject<Item>> entry: ItemRegistry.KNIFE_ITEMGEN_AUTOGEN){
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS,entry.getFourth().get())
                    .pattern(" II")
                    .pattern(" I ")
                    .pattern("S  ")
                    .define('S',Items.STICK)
                    .define('I',entry.getFifth().get())
                    .unlockedBy(getHasName(entry.getFourth().get()),has(entry.getFourth().get()))
                    .save(pWriter);
        }
        for(ItemRegistry.Tuple<String, String,String, RegistryObject<Item>, RegistryObject<Item>> entry: ItemRegistry.SKREW_DRIVER_ITEMGEN_AUTOGEN){
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS,entry.getFourth().get())
                    .pattern("II ")
                    .pattern(" SI")
                    .pattern("S I")
                    .define('S',Items.STICK)
                    .define('I',entry.getFifth().get())
                    .unlockedBy(getHasName(entry.getFourth().get()),has(entry.getFourth().get()))
                    .save(pWriter);
        }
        for(ItemRegistry.Tuple<String, String,String, RegistryObject<Item>, RegistryObject<Item>> entry: ItemRegistry.FILE_ITEMGEN_AUTOGEN){
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS,entry.getFourth().get())
                    .pattern("III")
                    .pattern(" SI")
                    .pattern("S I")
                    .define('S',Items.STICK)
                    .define('I',entry.getFifth().get())
                    .unlockedBy(getHasName(entry.getFourth().get()),has(entry.getFourth().get()))
                    .save(pWriter);
        }
        for(ItemRegistry.Tuple<String, String,String, RegistryObject<Item>, RegistryObject<Item>> entry: ItemRegistry.SOFT_HAMMER_ITEMGEN_AUTOGEN){
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS,entry.getFourth().get())
                    .pattern(" II")
                    .pattern(" SI")
                    .pattern("S I")
                    .define('S',Items.STICK)
                    .define('I',entry.getFifth().get())
                    .unlockedBy(getHasName(entry.getFourth().get()),has(entry.getFourth().get()))
                    .save(pWriter);
        }
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                            pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer,  MekaAddition.MODID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
    protected static void craftPlate(Item exitItem,Item inputItem,Consumer<FinishedRecipe> pWriter){
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS,exitItem)
                .pattern("H")
                .pattern("I")
                .pattern("I")
                .define('H', TagRegistry.Items.HAMMERS)
                .define('I', inputItem)
                .unlockedBy(getHasName(inputItem),has(inputItem))
                .save(pWriter);

    }
}
