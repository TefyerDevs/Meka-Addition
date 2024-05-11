package org.tefyer.ma.item;

import net.minecraft.util.Tuple;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.tefyer.ma.MekaAddition;
import org.tefyer.ma.item.custom.HammerItem;
import org.tefyer.ma.item.custom.PlateItem;
import org.tefyer.ma.item.itemores.ModdedOres;

import java.util.*;

public class ItemRegistry {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MekaAddition.MODID);
    public static Map<String,RegistryObject<Item>> ITEM_AUTOGEN = new HashMap<String, RegistryObject<Item>>();
    public static Map<String,RegistryObject<Item>> HAMMER_AUTOGEN = new HashMap<String, RegistryObject<Item>>();

    public static Map<String,RegistryObject<Item>> ITEM_COLOUR_AUTOGEN = new HashMap<String, RegistryObject<Item>>();
    public static Map<String,RegistryObject<Item>> HAMMER_COLOUR_AUTOGEN = new HashMap<String, RegistryObject<Item>>();

    public static List<Tuple<String,String,String,RegistryObject<Item>>> ITEM_ITEMGEN_AUTOGEN = new ArrayList<>();
    public static List<Tuple<String,String,String,RegistryObject<Item>>> HAMMER_ITEMGEN_AUTOGEN = new ArrayList<>();






    public static void makePlates(){
        for(ModdedOres ore : ModdedOres.values()){
            String identifer_plate = ore.getM_identifer()+"_plate";
            String identifer_hammer = ore.getM_identifer()+"_hammer";
            String identifer_raw_ingot = ore.getM_identifer()+"_raw_ingot";
            String identifer_ingot = ore.getM_identifer()+"_ingot";

            RegistryObject<Item> plate_item = ITEMS.register(identifer_plate,()->new PlateItem(new Item.Properties()));
            RegistryObject<Item> hammer_item = ITEMS.register(identifer_hammer,()->new HammerItem(new Item.Properties()));
            RegistryObject<Item> raw_ingot_item = ITEMS.register(identifer_raw_ingot,()->new Item(new Item.Properties()));
            RegistryObject<Item> ingot_item = ITEMS.register(identifer_ingot,()->new Item(new Item.Properties()));

            HAMMER_AUTOGEN.put("hammer",hammer_item);
            ITEM_AUTOGEN.put("plate",plate_item);
            ITEM_AUTOGEN.put("raw_ingot",raw_ingot_item);
            ITEM_AUTOGEN.put("ingot",ingot_item);

            HAMMER_COLOUR_AUTOGEN.put(ore.getM_identifer(),hammer_item);
            ITEM_COLOUR_AUTOGEN.put(ore.getM_identifer(),plate_item);
            ITEM_COLOUR_AUTOGEN.put(ore.getM_identifer(),raw_ingot_item);
            ITEM_COLOUR_AUTOGEN.put(ore.getM_identifer(),ingot_item);

            HAMMER_ITEMGEN_AUTOGEN.add(new Tuple<>(ore.getM_identifer()+"_hammer","hammer",ore.getM_identifer(),hammer_item));
            ITEM_ITEMGEN_AUTOGEN.add(new Tuple<>(ore.getM_identifer()+"_plate","plate",ore.getM_identifer(),plate_item));
            ITEM_ITEMGEN_AUTOGEN.add(new Tuple<>(ore.getM_identifer()+"_raw_ingot","raw_ingot",ore.getM_identifer(),raw_ingot_item));
            ITEM_ITEMGEN_AUTOGEN.add(new Tuple<>(ore.getM_identifer()+"_ingot","ingot",ore.getM_identifer(),ingot_item));

        }
    }

    public static void register(IEventBus bus){
        makePlates();
        ITEMS.register(bus);
    }
    public static class Tuple<E, F, G,H> {
        public E First;
        public F Second;
        public G Third;
        public H Fourth;

        public Tuple(E first, F second, G third,H fourth) {
            First = first;
            Second = second;
            Third = third;
            this.Fourth = fourth;
        }

        public E getFirst() {
            return First;
        }

        public void setFirst(E first) {
            First = first;
        }

        public F getSecond() {
            return Second;
        }

        public void setSecond(F second) {
            Second = second;
        }

        public G getThird() {
            return Third;
        }

        public void setThird(G third) {
            Third = third;
        }
        public void put(E e, F f, G g,H h){
            First = e;
            Second = f;
            Third = g;
            Fourth = h;
        }

        public H getFourth() {
            return Fourth;
        }

        public void setFourth(H fourth) {
            Fourth = fourth;
        }
    }

}
