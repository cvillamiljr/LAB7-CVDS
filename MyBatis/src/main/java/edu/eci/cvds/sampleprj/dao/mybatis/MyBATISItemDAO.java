package edu.eci.cvds.sampleprj.dao.mybatis;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import edu.eci.cvds.sampleprj.dao.ItemDAO;
import org.apache.ibatis.exceptions.PersistenceException;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ClienteMapper;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ItemMapper;
import edu.eci.cvds.samples.entities.TipoItem;
import java.sql.SQLException;
import java.util.List;

public class MyBATISItemDAO implements ItemDAO{

  @Inject
  private ItemMapper itemMapper;    

  @Override
  public void save(Item it) throws PersistenceException{
    try{
        itemMapper.insertarItem(it);
    }
    catch(PersistenceException e){
        throw new PersistenceException("Error al registrar el item "+it.toString(),e);
    }        

  }

  @Override
  public Item load(int id) throws PersistenceException {
    try{
        return itemMapper.consultarItem(id);
    }
    catch(PersistenceException e){
        throw new PersistenceException("Error al consultar el item "+id,e);
    }


  }

    @Override
    public int valorMultaRetrasoxDia(int id) throws PersistenceException {
        try{
            return itemMapper.multaxDia(id);
        }
        catch(PersistenceException e){
            throw new PersistenceException("Error al consultar la multa del item :"+id, e); 
        }
    }

    @Override
    public List<Item> consultarItemsDisponibles() throws PersistenceException {
        try{
            return itemMapper.itemsDisponibles();
        }
        catch(PersistenceException e){
            throw new PersistenceException("Error al consultar los items disponibles", e); 
        }
    }

    @Override
    public long consultarCostoAlquiler(int iditem, int numdias) throws edu.eci.cvds.sampleprj.dao.PersistenceException {
        try{
            return numdias*(itemMapper.multaxDia(iditem));
        }
        catch(PersistenceException e){
            throw new PersistenceException("Error al consultar los items disponibles", e); 
        }
    }

    @Override
    public void actualizarTarifaItem(int id, long tarifa) throws edu.eci.cvds.sampleprj.dao.PersistenceException {
        try{
            itemMapper.actualizarTarifaItem(id, tarifa);
        }
        catch(PersistenceException e){
            throw new PersistenceException("Error al actualizar la tarifa del item", e); 
        }
    }
    

  }