package edu.eci.cvds.sampleprj.dao.mybatis;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import edu.eci.cvds.sampleprj.dao.ClienteDAO;
import edu.eci.cvds.sampleprj.dao.ItemDAO;
import org.apache.ibatis.exceptions.PersistenceException;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ClienteMapper;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ItemMapper;
import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.TipoItem;
import java.sql.SQLException;

public class MyBATISClienteDAO implements ClienteDAO{

  @Inject
  private ClienteMapper clienteMapper;    

  @Override
  public void save(Cliente cliente ) throws PersistenceException{
  try{
      clienteMapper.insertarCliente(cliente);
  }
  catch(org.apache.ibatis.exceptions.PersistenceException e){
      throw new PersistenceException("Error al registrar el cliente "+ cliente.toString(),e);
  }        

  }

  @Override
  public Cliente load(int documento) throws PersistenceException {
  try{
      return clienteMapper.consultarCliente(documento);
  }
  catch(org.apache.ibatis.exceptions.PersistenceException e){
      throw new PersistenceException("Error al consultar el cliente "+documento,e);
  }


  }

  }