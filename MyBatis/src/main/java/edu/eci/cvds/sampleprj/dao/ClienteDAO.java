package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.Item;
import org.apache.ibatis.exceptions.PersistenceException;

public interface ClienteDAO {

   public void save(Cliente cliente) throws PersistenceException;

   public Cliente load(int documento) throws PersistenceException;

}