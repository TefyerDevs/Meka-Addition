package org.tefyer.ma.registry;

import org.tefyer.ma.multiblock.MultiBlock;
import org.tefyer.ma.utils.MultiBLockUtils;

class BaseRegister<T extends MultiBlock>{
    List<MultiBLockUtils.IndexStringList<T>> ids;
    private final String m_modid;
    public BaseRegister(String p_modid){ 
        m_modid = p_modid;
    }
    public static void register(String ID,int ident,T multiblock){
        ids.add(new MultiBLockUtils.IndexStringList(p_modid+'.'+ID,ident,T));
    }

}