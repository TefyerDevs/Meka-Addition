package org.tefyer.ma.item.itemores;

public enum ModdedOres {
    IRON("iron"),
    DIAMOND("diamond"),
    REDSTONE("redstone"),
    LAPIS("lapis"),
    REBONIC("rebonic");

    String m_identifer;

    ModdedOres(String p_identifer){
        this.m_identifer =p_identifer;
    }

    public String getM_identifer() {
        return m_identifer;
    }

    public void setM_identifer(String m_identifer) {
        this.m_identifer = m_identifer;
    }
}
