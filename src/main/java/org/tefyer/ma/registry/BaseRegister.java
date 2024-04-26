package org.tefyer.ma.registry;


import org.tefyer.ma.block.multiblock.MultiBlock;
import org.tefyer.ma.utils.MultiBLockUtils;

import java.util.List;

class BaseRegister<T extends MultiBlock>{
    List<MultiBLockUtils.IndexStringList> ids;
    private  final String m_modid;
    public BaseRegister(String p_modid){ 
        m_modid = p_modid;
    }
    public void register(String ID, int ident){
        this.ids.add(new MultiBLockUtils.IndexStringList(m_modid+'.'+ID,ident));
    }

}