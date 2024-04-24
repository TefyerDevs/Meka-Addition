package org.tefyer.ma.block.baseblockmodel;



import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.tefyer.ma.MekaAddition;

public class MekanismBlockModelProvider extends BaseBlockModelProvider {

    public MekanismBlockModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MekaAddition.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

    }
}