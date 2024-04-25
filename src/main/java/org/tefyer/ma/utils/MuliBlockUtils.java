package org.tefyer.ma.utils;

public class MultiBLockUtils{
    public class IndexStringList<T extends ?>{
        public IndexStringList(String p_string,int p_id,T p_thing){
            this.m_string = p_string;
            this.m_id = p_id;
            this.m_thing = p_thing;
        }
        String m_string;
        int m_id;
        T m_thing;
    }
}