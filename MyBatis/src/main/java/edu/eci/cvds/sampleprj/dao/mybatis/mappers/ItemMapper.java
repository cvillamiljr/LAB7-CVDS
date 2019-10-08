package edu.eci.cvds.sampleprj.dao.mybatis.mappers;


import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.Item;

/**
 *
 * @author 2106913
 */
public interface ItemMapper {
    
    
    public List<Item> consultarItems();        
    
    public Item consultarItem(@Param("itid")int id);
    
    public void insertarItem(@Param("item")Item it);

    public int multaxDia(@Param("itid")int id);

    public List<Item> itemsDisponibles();

    //public long consultarCostoAlquiler(@Param("itid")int id);

    public void actualizarTarifaItem(@Param("itid")int id, @Param("valor")long tarifa);

        
}
