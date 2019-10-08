package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.samples.entities.ItemRentado;
import java.util.List;


public interface ClienteDAO {

   public void save(Cliente cliente) throws PersistenceException;

   public Cliente load(int documento) throws PersistenceException;

   public Cliente consultarCliente(long docu) throws PersistenceException;

   public List<ItemRentado> consultarItemsCliente(long idcliente) throws PersistenceException;

    public List<Cliente> consultarClientes() throws PersistenceException;

    public void actualizarCliente(long docu, int estado) throws PersistenceException;
   
   

}