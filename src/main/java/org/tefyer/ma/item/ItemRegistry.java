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
    public static Map<String,RegistryObject<Item>> SKREW_DRIVER_AUTOGEN = new HashMap<String, RegistryObject<Item>>();
    public static Map<String,RegistryObject<Item>> FILE_AUTOGEN = new HashMap<String, RegistryObject<Item>>();
    public static Map<String,RegistryObject<Item>> WIRE_CUTTER_AUTOGEN = new HashMap<String, RegistryObject<Item>>();
    public static Map<String,RegistryObject<Item>> WRENCH_AUTOGEN = new HashMap<String, RegistryObject<Item>>();
    public static Map<String,RegistryObject<Item>> MOARTER_AUTOGEN = new HashMap<String, RegistryObject<Item>>();
    public static Map<String,RegistryObject<Item>> SAW_AUTOGEN = new HashMap<String, RegistryObject<Item>>();
    public static Map<String,RegistryObject<Item>> SOFT_HAMMER_AUTOGEN = new HashMap<String, RegistryObject<Item>>();
    public static Map<String,RegistryObject<Item>> KNIFE_AUTOGEN = new HashMap<String, RegistryObject<Item>>();

    public static Map<String,RegistryObject<Item>> ITEM_COLOUR_AUTOGEN = new HashMap<String, RegistryObject<Item>>();
    public static Map<String,RegistryObject<Item>> HAMMER_COLOUR_AUTOGEN = new HashMap<String, RegistryObject<Item>>();

    public static Map<String,RegistryObject<Item>> SKREW_DRIVER_COLOUR_AUTOGEN = new HashMap<String, RegistryObject<Item>>();
    public static Map<String,RegistryObject<Item>> FILE_COLOUR_AUTOGEN = new HashMap<String, RegistryObject<Item>>();
    public static Map<String,RegistryObject<Item>> WIRE_CUTTER_COLOUR_AUTOGEN = new HashMap<String, RegistryObject<Item>>();
    public static Map<String,RegistryObject<Item>> WRENCH_COLOUR_AUTOGEN = new HashMap<String, RegistryObject<Item>>();
    public static Map<String,RegistryObject<Item>> MOARTER_COLOUR_AUTOGEN = new HashMap<String, RegistryObject<Item>>();
    public static Map<String,RegistryObject<Item>> SAW_COLOUR_AUTOGEN = new HashMap<String, RegistryObject<Item>>();
    public static Map<String,RegistryObject<Item>> SOFT_HAMMER_COLOUR_AUTOGEN = new HashMap<String, RegistryObject<Item>>();
    public static Map<String,RegistryObject<Item>> KNIFE_COLOUR_AUTOGEN = new HashMap<String, RegistryObject<Item>>();


    public static List<Tuple<String,String,String,RegistryObject<Item>,RegistryObject<Item>>> ITEM_ITEMGEN_AUTOGEN = new ArrayList<>();
    public static List<Tuple<String,String,String,RegistryObject<Item>,RegistryObject<Item>>> HAMMER_ITEMGEN_AUTOGEN = new ArrayList<>();

    public static List<Tuple<String,String,String,RegistryObject<Item>,RegistryObject<Item>>> SKREW_DRIVER_ITEMGEN_AUTOGEN = new ArrayList<>();
    public static List<Tuple<String,String,String,RegistryObject<Item>,RegistryObject<Item>>> FILE_ITEMGEN_AUTOGEN = new ArrayList<>();
    public static List<Tuple<String,String,String,RegistryObject<Item>,RegistryObject<Item>>> WIRE_CUTTER_ITEMGEN_AUTOGEN = new ArrayList<>();
    public static List<Tuple<String,String,String,RegistryObject<Item>,RegistryObject<Item>>> WRENCH_ITEMGEN_AUTOGEN = new ArrayList<>();
    public static List<Tuple<String,String,String,RegistryObject<Item>,RegistryObject<Item>>> MOARTER_ITEMGEN_AUTOGEN = new ArrayList<>();
    public static List<Tuple<String,String,String,RegistryObject<Item>,RegistryObject<Item>>> SAW_ITEMGEN_AUTOGEN = new ArrayList<>();
    public static List<Tuple<String,String,String,RegistryObject<Item>,RegistryObject<Item>>> SOFT_HAMMER_ITEMGEN_AUTOGEN= new ArrayList<>();
    public static List<Tuple<String,String,String,RegistryObject<Item>,RegistryObject<Item>>> KNIFE_ITEMGEN_AUTOGEN= new ArrayList<>();





    public static void makePlates(){
        for(ModdedOres ore : ModdedOres.values()){
            String identifer_plate = ore.getM_identifer()+"_plate";
            String identifer_raw_ingot = ore.getM_identifer()+"_raw_ingot";
            String identifer_ingot = ore.getM_identifer()+"_ingot";

            String identifer_hammer = ore.getM_identifer()+"_hammer";
            String identifer_screw_driver = ore.getM_identifer()+"_screw_driver";
            String identifer_file = ore.getM_identifer()+"_file";
            String identifer_wire_cutter = ore.getM_identifer()+"_wire_cutter";
            String identifer_wrench = ore.getM_identifer()+"_wrench";
            String identifer_moarter = ore.getM_identifer()+"_moarter";
            String identifer_saw = ore.getM_identifer()+"_saw";
            String identifer_soft_hammer = ore.getM_identifer()+"_soft_hammer";
            String identifer_knife = ore.getM_identifer()+"_knife";

            RegistryObject<Item> plate_item = ITEMS.register(identifer_plate,()->new PlateItem(new Item.Properties()));
            RegistryObject<Item> raw_ingot_item = ITEMS.register(identifer_raw_ingot,()->new Item(new Item.Properties()));
            RegistryObject<Item> ingot_item = ITEMS.register(identifer_ingot,()->new Item(new Item.Properties()));

            RegistryObject<Item> hammer_item = ITEMS.register(identifer_hammer,()->new HammerItem(new Item.Properties()));

            RegistryObject<Item> screw_driver_item = ITEMS.register(identifer_screw_driver,()->new HammerItem(new Item.Properties()));
            RegistryObject<Item> file_item = ITEMS.register(identifer_file,()->new HammerItem(new Item.Properties()));
            RegistryObject<Item> wire_cutter_item = ITEMS.register(identifer_wire_cutter,()->new HammerItem(new Item.Properties()));
            RegistryObject<Item> wrench_item = ITEMS.register(identifer_wrench,()->new HammerItem(new Item.Properties()));
            RegistryObject<Item> moarter_item = ITEMS.register(identifer_moarter,()->new HammerItem(new Item.Properties()));
            RegistryObject<Item> saw_item = ITEMS.register(identifer_saw,()->new HammerItem(new Item.Properties()));
            RegistryObject<Item> soft_hammer_item = ITEMS.register(identifer_soft_hammer,()->new HammerItem(new Item.Properties()));
            RegistryObject<Item> knife_item = ITEMS.register(identifer_knife,()->new HammerItem(new Item.Properties()));


            ITEM_AUTOGEN.put("plate",plate_item);
            ITEM_AUTOGEN.put("raw_ingot",raw_ingot_item);
            ITEM_AUTOGEN.put("ingot",ingot_item);

            HAMMER_AUTOGEN.put("hammer",hammer_item);
            SKREW_DRIVER_AUTOGEN.put("screw_driver",screw_driver_item);
            FILE_AUTOGEN.put("file",file_item);
            WIRE_CUTTER_AUTOGEN.put("wire_cutter",wire_cutter_item);
            WRENCH_AUTOGEN.put("wrench",wrench_item);
            MOARTER_AUTOGEN.put("moarter",moarter_item);
            SAW_AUTOGEN.put("saw",saw_item);
            SOFT_HAMMER_AUTOGEN.put("soft_hammer",soft_hammer_item);
            KNIFE_AUTOGEN.put("knife",knife_item);


            ITEM_COLOUR_AUTOGEN.put(ore.getM_identifer(),plate_item);
            ITEM_COLOUR_AUTOGEN.put(ore.getM_identifer(),raw_ingot_item);
            ITEM_COLOUR_AUTOGEN.put(ore.getM_identifer(),ingot_item);

            HAMMER_COLOUR_AUTOGEN.put(ore.getM_identifer(),hammer_item);
            SKREW_DRIVER_COLOUR_AUTOGEN.put(ore.getM_identifer(),screw_driver_item);
            FILE_COLOUR_AUTOGEN.put(ore.getM_identifer(),file_item);
            WIRE_CUTTER_COLOUR_AUTOGEN.put(ore.getM_identifer(),wire_cutter_item);
            WRENCH_COLOUR_AUTOGEN.put(ore.getM_identifer(),wrench_item);
            MOARTER_COLOUR_AUTOGEN.put(ore.getM_identifer(),moarter_item);
            SAW_COLOUR_AUTOGEN.put(ore.getM_identifer(),saw_item);
            SOFT_HAMMER_COLOUR_AUTOGEN.put(ore.getM_identifer(),soft_hammer_item);
            KNIFE_COLOUR_AUTOGEN.put(ore.getM_identifer(),knife_item);


            ITEM_ITEMGEN_AUTOGEN.add(new Tuple<>(ore.getM_identifer()+"_plate","plate",ore.getM_identifer(),plate_item,null));
            ITEM_ITEMGEN_AUTOGEN.add(new Tuple<>(ore.getM_identifer()+"_raw_ingot","raw_ingot",ore.getM_identifer(),raw_ingot_item,ingot_item));
            ITEM_ITEMGEN_AUTOGEN.add(new Tuple<>(ore.getM_identifer()+"_ingot","ingot",ore.getM_identifer(),ingot_item,null));

            HAMMER_ITEMGEN_AUTOGEN.add(new Tuple<>(ore.getM_identifer()+"_hammer","hammer",ore.getM_identifer(),hammer_item,ingot_item));
            SKREW_DRIVER_ITEMGEN_AUTOGEN.add(new Tuple<>(ore.getM_identifer()+"_screw_driver","screw_driver",ore.getM_identifer(),screw_driver_item,ingot_item));
            FILE_ITEMGEN_AUTOGEN.add(new Tuple<>(ore.getM_identifer()+"_file","file",ore.getM_identifer(),file_item,ingot_item));
            WIRE_CUTTER_ITEMGEN_AUTOGEN.add(new Tuple<>(ore.getM_identifer()+"_wire_cutter","wire_cutter",ore.getM_identifer(),wire_cutter_item,ingot_item));
            WRENCH_ITEMGEN_AUTOGEN.add(new Tuple<>(ore.getM_identifer()+"_wrench","wrench",ore.getM_identifer(),wrench_item,ingot_item));
            MOARTER_ITEMGEN_AUTOGEN.add(new Tuple<>(ore.getM_identifer()+"_moarter","moarter",ore.getM_identifer(),moarter_item,ingot_item));
            SAW_ITEMGEN_AUTOGEN.add(new Tuple<>(ore.getM_identifer()+"_saw","saw",ore.getM_identifer(),saw_item,ingot_item));
            SOFT_HAMMER_ITEMGEN_AUTOGEN.add(new Tuple<>(ore.getM_identifer()+"_soft_hammer","soft_hammer",ore.getM_identifer(),soft_hammer_item,ingot_item));
            KNIFE_ITEMGEN_AUTOGEN.add(new Tuple<>(ore.getM_identifer()+"_knife","knife",ore.getM_identifer(),knife_item,ingot_item));
        }
    }

    public static void register(IEventBus bus){
        makePlates();
        ITEMS.register(bus);
    }
    public static class Tuple<E, F, G,H,N> {
        public E First;
        public F Second;
        public G Third;
        public H Fourth;
        public N Fifth;

        public Tuple(E first, F second, G third,H fourth,N fifth) {
            First = first;
            Second = second;
            Third = third;
            Fourth = fourth;
            Fifth = fifth;
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
        public void put(E e, F f, G g,H h,N n){
            First = e;
            Second = f;
            Third = g;
            Fourth = h;
            Fifth = n;
        }

        public H getFourth() {
            return Fourth;
        }

        public void setFourth(H fourth) {
            Fourth = fourth;
        }

        public N getFifth() {
            return Fifth;
        }

        public void setFifth(N fifth) {
            Fifth = fifth;
        }
    }

}
