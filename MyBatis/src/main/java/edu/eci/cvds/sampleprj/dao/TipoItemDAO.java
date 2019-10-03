package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.samples.entities.TipoItem;
import java.util.List;
import org.apache.ibatis.exceptions.PersistenceException;

public interface TipoItemDAO {

   public void save(TipoItem tipoItem) throws PersistenceException;

   public List<TipoItem> load(int id) throws PersistenceException;

}