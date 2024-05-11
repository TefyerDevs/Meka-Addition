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
        for(Map.Entry<String, RegistryObject<Item>> entry : ItemRegistry.ITEM_AUTOGEN.entrySet()){
            if(Objects.equals(entry.getKey(), "plate")){
                craftPlate(entry.getValue().get(),Items.DIAMOND,pWriter);
            }
        }

        for(Map.Entry<String, RegistryObject<Item>> entry : ItemRegistry.HAMMER_AUTOGEN.entrySet()){
            if(Objects.equals(entry.getKey(), "iron")){
                ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS,entry.getValue().get())
                        .pattern(" I ")
                        .pattern(" SI")
                        .pattern("S  ")
                        .define('S',Items.STICK)
                        .define('I',Items.IRON_INGOT)
                        .unlockedBy(getHasName(Items.IRON_INGOT),has(Items.IRON_INGOT))
                        .save(pWriter);
            }else if(Objects.equals(entry.getKey(), "diamond")){
                ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS,entry.getValue().get())
                        .pattern(" I ")
                        .pattern(" SI")
                        .pattern("S  ")
                        .define('S',Items.STICK)
                        .define('I',Items.DIAMOND)
                        .unlockedBy(getHasName(Items.DIAMOND),has(Items.DIAMOND))
                        .save(pWriter);
            }else if(Objects.equals(entry.getKey(), "redstone")){
                ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS,entry.getValue().get())
                        .pattern(" I ")
                        .pattern(" SI")
                        .pattern("S  ")
                        .define('S',Items.STICK)
                        .define('I',Items.REDSTONE)
                        .unlockedBy(getHasName(Items.REDSTONE),has(Items.REDSTONE))
                        .save(pWriter);
            }else if(Objects.equals(entry.getKey(), "lapis")){
                ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS,entry.getValue().get())
                        .pattern(" I ")
                        .pattern(" SI")
                        .pattern("S  ")
                        .define('S',Items.STICK)
                        .define('I',Items.LAPIS_LAZULI)
                        .unlockedBy(getHasName(Items.LAPIS_LAZULI),has(Items.LAPIS_LAZULI))
                        .save(pWriter);
            }else if(Objects.equals(entry.getKey(), "rebonic")){
                ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS,entry.getValue().get())
                        .pattern(" I ")
                        .pattern(" SI")
                        .pattern("S  ")
                        .define('S',Items.STICK)
                        .define('I',entry.getValue().get())
                        .unlockedBy(getHasName(entry.getValue().get()),has(entry.getValue().get()))
                        .save(pWriter);
            }
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
