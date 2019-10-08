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
import edu.eci.cvds.samples.entities.ItemRentado;
import edu.eci.cvds.samples.entities.TipoItem;
import java.sql.SQLException;
import java.util.List;

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
    catch(PersistenceException e){
        throw new PersistenceException("Error al consultar el cliente "+documento,e);
    }


  }

    @Override
    public Cliente consultarCliente(long docu) throws PersistenceException {
        try{
            return clienteMapper.consultarClientee(docu);
        }
        catch (PersistenceException e){
            throw new UnsupportedOperationException("Error al consultar el cliente con documento "+docu,e); 
        }
    }

    @Override
    public List<ItemRentado> consultarItemsCliente(long idcliente) throws PersistenceException {
        try{
            return clienteMapper.consultarItemsCliente(idcliente);
        }
        catch (PersistenceException e){
            throw new UnsupportedOperationException("Error al consultar el cliente con documento "+idcliente,e); 
        }
    }

    @Override
    public List<Cliente> consultarClientes() throws edu.eci.cvds.sampleprj.dao.PersistenceException {
        try{
            return clienteMapper.consultarClientes();
        }
        catch (PersistenceException e){
            throw new UnsupportedOperationException("Error al consultar el cliente con documento ",e); 
        }
    }

    @Override
    public void actualizarCliente(long docu, int  estado) throws edu.eci.cvds.sampleprj.dao.PersistenceException {
        try{
            clienteMapper.actualizarCliente(docu, estado);
            
        }
        catch (PersistenceException e){
            throw new UnsupportedOperationException("Error al editar el cliente con documento "+docu,e); 
        }
    }
    

  }