package edu.eci.cvds.sampleprj.dao.mybatis.mappers;


import java.util.List;
import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.TipoItem;

public interface TipoItemMapper {
    
    
    public List<TipoItem> getTiposItems();
    
    public TipoItem getTipoItem(int id);
    
    public void addTipoItem(String des);
    
    public List<TipoItem> consultarItem(@Param("titem")int id);
    
    public void insertarTipoItem(@Param("titem")TipoItem it);

    public TipoItem consultarTipoItem(@Param("titem")int id);

    public List<TipoItem> consultarTiposItem();

}
