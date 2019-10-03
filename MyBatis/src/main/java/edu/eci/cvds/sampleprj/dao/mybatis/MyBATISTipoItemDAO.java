package edu.eci.cvds.sampleprj.dao.mybatis;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import edu.eci.cvds.sampleprj.dao.ItemDAO;
import edu.eci.cvds.sampleprj.dao.TipoItemDAO;
import org.apache.ibatis.exceptions.PersistenceException;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ClienteMapper;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ItemMapper;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.TipoItemMapper;
import edu.eci.cvds.samples.entities.TipoItem;
import java.sql.SQLException;
import java.util.List;

public class MyBATISTipoItemDAO implements TipoItemDAO{

  @Inject
  private TipoItemMapper TipoItemMapper;    

  @Override
  public void save(TipoItem tipoItem) throws PersistenceException{
  try{
      TipoItemMapper.insertarTipoItem(tipoItem);
  }
  catch(org.apache.ibatis.exceptions.PersistenceException e){
      throw new PersistenceException("Error al registrar el item "+tipoItem.toString(),e);
  }        

  }

  @Override
  public List<TipoItem> load(int id) throws PersistenceException {
  try{
      return TipoItemMapper.consultarItem(id);
  }
  catch(org.apache.ibatis.exceptions.PersistenceException e){
      throw new PersistenceException("Error al consultar el item "+id,e);
  }


  }

  }